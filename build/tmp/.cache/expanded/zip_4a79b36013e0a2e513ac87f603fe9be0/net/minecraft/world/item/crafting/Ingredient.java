package net.minecraft.world.item.crafting;

import com.google.common.collect.Lists;
import com.mojang.datafixers.util.Either;
import com.mojang.serialization.Codec;
import com.mojang.serialization.DataResult;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import com.mojang.serialization.codecs.RecordCodecBuilder.Instance;
import it.unimi.dsi.fastutil.ints.IntArrayList;
import it.unimi.dsi.fastutil.ints.IntComparators;
import it.unimi.dsi.fastutil.ints.IntList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;
import javax.annotation.Nullable;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.player.StackedContents;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;

public class Ingredient implements Predicate<ItemStack> {
    //Because Mojang caches things... we need to invalidate them.. so... here we go..
    private static final java.util.concurrent.atomic.AtomicInteger INVALIDATION_COUNTER = new java.util.concurrent.atomic.AtomicInteger();
    public static void invalidateAll() {
        INVALIDATION_COUNTER.incrementAndGet();
    }
    public static final Ingredient EMPTY = new Ingredient(Stream.empty());
    public static final StreamCodec<RegistryFriendlyByteBuf, Ingredient> CONTENTS_STREAM_CODEC = net.minecraftforge.common.ForgeHooks.ingredientStreamCodec();
    private final Ingredient.Value[] values;
    @Nullable
    private ItemStack[] itemStacks;
    @Nullable
    private IntList stackingIds;
    /** The vanilla codec that doesn't support custom Ingredient types. */
    public static final Codec<Ingredient> VANILLA_CODEC = codec(true);
    public static final com.mojang.serialization.MapCodec<Ingredient> VANILLA_MAP_CODEC = com.mojang.serialization.MapCodec.assumeMapUnsafe(VANILLA_CODEC);
    public static final Codec<Ingredient> CODEC = net.minecraftforge.common.ForgeHooks.enhanceIngredientCodec(VANILLA_CODEC);
    private static final Codec<Ingredient> VANILLA_CODEC_NONEMPTY = codec(false);
    public static final Codec<Ingredient> CODEC_NONEMPTY = net.minecraftforge.common.ForgeHooks.enhanceIngredientCodec(VANILLA_CODEC_NONEMPTY);
    private int invalidationCounter;

    protected Ingredient(Stream<? extends Ingredient.Value> p_43907_) {
        this.values = p_43907_.toArray(Ingredient.Value[]::new);
    }

    private Ingredient(Ingredient.Value[] p_301101_) {
        this.values = p_301101_;
    }

    public ItemStack[] getItems() {
        if (this.itemStacks == null || checkInvalidation()) {
            this.itemStacks = Arrays.stream(this.values).flatMap(p_43916_ -> p_43916_.getItems().stream()).distinct().toArray(ItemStack[]::new);
        }

        return this.itemStacks;
    }

    public boolean test(@Nullable ItemStack p_43914_) {
        if (p_43914_ == null) {
            return false;
        } else if (this.isEmpty()) {
            return p_43914_.isEmpty();
        } else {
            for (ItemStack itemstack : this.getItems()) {
                if (itemstack.is(p_43914_.getItem())) {
                    return true;
                }
            }

            return false;
        }
    }

    public IntList getStackingIds() {
        if (this.stackingIds == null || checkInvalidation()) {
            this.markValid();
            ItemStack[] aitemstack = this.getItems();
            this.stackingIds = new IntArrayList(aitemstack.length);

            for (ItemStack itemstack : aitemstack) {
                this.stackingIds.add(StackedContents.getStackingIndex(itemstack));
            }

            this.stackingIds.sort(IntComparators.NATURAL_COMPARATOR);
        }

        return this.stackingIds;
    }

    public boolean isEmpty() {
        return this.values.length == 0;
    }

    @Override
    public boolean equals(Object p_300457_) {
        return p_300457_ instanceof Ingredient ingredient ? Arrays.equals((Object[])this.values, (Object[])ingredient.values) : false;
    }

    public static Ingredient fromValues(Stream<? extends Ingredient.Value> p_43939_) {
        Ingredient ingredient = new Ingredient(p_43939_);
        return ingredient.isEmpty() ? EMPTY : ingredient;
    }

    public static Ingredient of() {
        return EMPTY;
    }

    public static Ingredient of(ItemLike... p_43930_) {
        return of(Arrays.stream(p_43930_).map(ItemStack::new));
    }

    public static Ingredient of(ItemStack... p_43928_) {
        return of(Arrays.stream(p_43928_));
    }

    public static Ingredient of(Stream<ItemStack> p_43922_) {
        return fromValues(p_43922_.filter(p_43944_ -> !p_43944_.isEmpty()).map(Ingredient.ItemValue::new));
    }

    public static Ingredient of(TagKey<Item> p_204133_) {
        return fromValues(Stream.of(new Ingredient.TagValue(p_204133_)));
    }

    public final boolean checkInvalidation() {
        int currentInvalidationCounter = INVALIDATION_COUNTER.get();
        if (this.invalidationCounter != currentInvalidationCounter) {
            invalidate();
            return true;
        }
        return false;
    }

    protected final void markValid() {
        this.invalidationCounter = INVALIDATION_COUNTER.get();
    }

    protected void invalidate() {
        this.itemStacks = null;
        this.stackingIds = null;
    }

    public boolean isSimple() {
        return true;
    }

    private final boolean isVanilla = this.getClass() == Ingredient.class;
    public final boolean isVanilla() {
        return isVanilla;
    }

    public net.minecraftforge.common.crafting.ingredients.IIngredientSerializer<? extends Ingredient> serializer() {
        if (!isVanilla()) throw new IllegalStateException("Modders must implement Ingredient.codec in their custom Ingredients: " + getClass());
        return net.minecraftforge.common.crafting.ingredients.IIngredientSerializer.VANILLA;
    }

    @Override
    public String toString() {
        var buf = new StringBuilder();
        buf.append("Ingredient[");
        for (int x = 0; x < values.length; x++) {
            if (x != 0)
                buf.append(", ");
            if (values[x] instanceof TagValue tag)
                buf.append('#').append(tag.tag().location());
            else if (values[x] instanceof ItemValue item)
                buf.append(item.item());
            else
                buf.append(values[x]);
        }
        buf.append(']');
        return buf.toString();
     }

    private static Codec<Ingredient> codec(boolean p_298496_) {
        Codec<Ingredient.Value[]> codec = Codec.list(Ingredient.Value.CODEC)
            .comapFlatMap(
                p_296902_ -> !p_298496_ && p_296902_.size() < 1
                        ? DataResult.error(() -> "Item array cannot be empty, at least one item must be defined")
                        : DataResult.success(p_296902_.toArray(new Ingredient.Value[0])),
                List::of
            );
        return Codec.either(codec, Ingredient.Value.CODEC)
            .flatComapMap(
                p_296900_ -> p_296900_.map(Ingredient::new, p_296903_ -> new Ingredient(new Ingredient.Value[]{p_296903_})),
                p_296899_ -> {
                    if (p_296899_.values.length == 1) {
                        return DataResult.success(Either.right(p_296899_.values[0]));
                    } else {
                        return p_296899_.values.length == 0 && !p_298496_
                            ? DataResult.error(() -> "Item array cannot be empty, at least one item must be defined")
                            : DataResult.success(Either.left(p_296899_.values));
                    }
                }
            );
    }

    public static record ItemValue(ItemStack item) implements Ingredient.Value {
        static final Codec<Ingredient.ItemValue> CODEC = RecordCodecBuilder.create(
            p_327194_ -> p_327194_.group(ItemStack.SIMPLE_ITEM_CODEC.fieldOf("item").forGetter(p_299657_ -> p_299657_.item))
                    .apply(p_327194_, Ingredient.ItemValue::new)
        );

        @Override
        public boolean equals(Object p_300135_) {
            return !(p_300135_ instanceof Ingredient.ItemValue ingredient$itemvalue)
                ? false
                : ingredient$itemvalue.item.getItem().equals(this.item.getItem())
                    && ingredient$itemvalue.item.getCount() == this.item.getCount();
        }

        @Override
        public Collection<ItemStack> getItems() {
            return Collections.singleton(this.item);
        }
    }

    public static record TagValue(TagKey<Item> tag) implements Ingredient.Value {
        static final Codec<Ingredient.TagValue> CODEC = RecordCodecBuilder.create(
            p_300241_ -> p_300241_.group(TagKey.codec(Registries.ITEM).fieldOf("tag").forGetter(p_301340_ -> p_301340_.tag))
                    .apply(p_300241_, Ingredient.TagValue::new)
        );

        @Override
        public boolean equals(Object p_298268_) {
            return p_298268_ instanceof Ingredient.TagValue ingredient$tagvalue
                ? ingredient$tagvalue.tag.location().equals(this.tag.location())
                : false;
        }

        @Override
        public Collection<ItemStack> getItems() {
            List<ItemStack> list = Lists.newArrayList();

            for (Holder<Item> holder : BuiltInRegistries.ITEM.getTagOrEmpty(this.tag)) {
                list.add(new ItemStack(holder));
            }

            if (list.size() == 0) {
                 var marker = new ItemStack(net.minecraft.world.level.block.Blocks.BARRIER);
                 marker.set(net.minecraft.core.component.DataComponents.CUSTOM_NAME,
                     net.minecraft.network.chat.Component.literal("Empty Tag: " + this.tag.location()));
                 list.add(marker);
            }

            return list;
        }
    }

    public interface Value {
        Codec<Ingredient.Value> CODEC = Codec.xor(Ingredient.ItemValue.CODEC, Ingredient.TagValue.CODEC)
            .xmap(p_300070_ -> p_300070_.map(p_301348_ -> p_301348_, p_298354_ -> p_298354_), p_299608_ -> {
                if (p_299608_ instanceof Ingredient.TagValue ingredient$tagvalue) {
                    return Either.right(ingredient$tagvalue);
                } else if (p_299608_ instanceof Ingredient.ItemValue ingredient$itemvalue) {
                    return Either.left(ingredient$itemvalue);
                } else {
                    throw new UnsupportedOperationException("This is neither an item value nor a tag value.");
                }
            });

        Collection<ItemStack> getItems();
    }
}
