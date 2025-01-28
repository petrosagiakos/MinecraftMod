package com.example.rubymod.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import com.example.rubymod.blocks.ModBlocks;
import com.example.rubymod.items.ModItems;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public ModRecipeProvider(PackOutput pOutput, CompletableFuture<HolderLookup.Provider> pRegistries) {
        super(pOutput, pRegistries);
    }

    @Override
    protected void buildRecipes(RecipeOutput pRecipeOutput) {
        

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.RUBY_BLOCK.get())
                .pattern("AAA")
                .pattern("AAA")
                .pattern("AAA")
                .define('A', ModItems.RUBY.get())
                .unlockedBy(getHasName(ModItems.RUBY.get()), has(ModItems.RUBY.get())).save(pRecipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.RUBY.get(), 9)
                .requires(ModBlocks.RUBY_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.RUBY_BLOCK.get()), has(ModBlocks.RUBY_BLOCK.get())).save(pRecipeOutput);
            //ruby tools
            ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.RUBY_SWORD.get())
                .pattern(" A ")
                .pattern(" A ")
                .pattern(" B ")
                .define('A', ModItems.RUBY.get())
                .define('B',Items.STICK)
                .unlockedBy(getHasName(ModItems.RUBY.get()), has(ModItems.RUBY.get())).save(pRecipeOutput);

            ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.RUBY_PICKAXE.get())
                .pattern("AAA")
                .pattern(" B ")
                .pattern(" B ")
                .define('A', ModItems.RUBY.get())
                .define('B',Items.STICK)
                .unlockedBy(getHasName(ModItems.RUBY.get()), has(ModItems.RUBY.get())).save(pRecipeOutput);

            ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.RUBY_AXE.get())
                .pattern("AA ")
                .pattern("AB ")
                .pattern(" B ")
                .define('A', ModItems.RUBY.get())
                .define('B',Items.STICK)
                .unlockedBy(getHasName(ModItems.RUBY.get()), has(ModItems.RUBY.get())).save(pRecipeOutput);

            ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.RUBY_SHOVEL.get())
                .pattern(" A ")
                .pattern(" B ")
                .pattern(" B ")
                .define('A', ModItems.RUBY.get())
                .define('B',Items.STICK)
                .unlockedBy(getHasName(ModItems.RUBY.get()), has(ModItems.RUBY.get())).save(pRecipeOutput);

            ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.RUBY_HOE.get())
                .pattern("AA ")
                .pattern(" B ")
                .pattern(" B ")
                .define('A', ModItems.RUBY.get())
                .define('B',Items.STICK)
                .unlockedBy(getHasName(ModItems.RUBY.get()), has(ModItems.RUBY.get())).save(pRecipeOutput);

                //ruby armor
            ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.RUBY_HELMET.get())
                .pattern("AAA")
                .pattern("A A")
                .pattern("   ")
                .define('A', ModItems.RUBY.get())
                .unlockedBy(getHasName(ModItems.RUBY.get()), has(ModItems.RUBY.get())).save(pRecipeOutput);

            ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.RUBY_CHESTPLATE.get())
                .pattern("A A")
                .pattern("AAA")
                .pattern("AAA")
                .define('A', ModItems.RUBY.get())
                .unlockedBy(getHasName(ModItems.RUBY.get()), has(ModItems.RUBY.get())).save(pRecipeOutput);

            ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.RUBY_LEGGINGS.get())
                .pattern("AAA")
                .pattern("A A")
                .pattern("A A")
                .define('A', ModItems.RUBY.get())
                .unlockedBy(getHasName(ModItems.RUBY.get()), has(ModItems.RUBY.get())).save(pRecipeOutput);

            ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.RUBY_BOOTS.get())
                .pattern("   ")
                .pattern("A A")
                .pattern("A A")
                .define('A', ModItems.RUBY.get())
                .unlockedBy(getHasName(ModItems.RUBY.get()), has(ModItems.RUBY.get())).save(pRecipeOutput);

                //emerald items
                //emerald tools
                ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.EMERALD_SWORD.get())
                .pattern(" A ")
                .pattern(" A ")
                .pattern(" B ")
                .define('A', Items.EMERALD)
                .define('B',Items.STICK)
                .unlockedBy(getHasName(Items.EMERALD), has(Items.EMERALD)).save(pRecipeOutput);

            ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.EMERALD_PICKAXE.get())
                .pattern("AAA")
                .pattern(" B ")
                .pattern(" B ")
                .define('A', Items.EMERALD)
                .define('B',Items.STICK)
                .unlockedBy(getHasName(Items.EMERALD), has(Items.EMERALD)).save(pRecipeOutput);

            ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.EMERALD_AXE.get())
                .pattern("AA ")
                .pattern("AB ")
                .pattern(" B ")
                .define('A', Items.EMERALD)
                .define('B',Items.STICK)
                .unlockedBy(getHasName(Items.EMERALD), has(Items.EMERALD)).save(pRecipeOutput);

            ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.EMERALD_SHOVEL.get())
                .pattern(" A ")
                .pattern(" B ")
                .pattern(" B ")
                .define('A', Items.EMERALD)
                .define('B',Items.STICK)
                .unlockedBy(getHasName(Items.EMERALD), has(Items.EMERALD)).save(pRecipeOutput);

            ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.EMERALD_HOE.get())
                .pattern("AA ")
                .pattern(" B ")
                .pattern(" B ")
                .define('A', Items.EMERALD)
                .define('B',Items.STICK)
                .unlockedBy(getHasName(Items.EMERALD), has(Items.EMERALD)).save(pRecipeOutput);

            //emerald armor
            ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.EMERALD_HELMET.get())
                .pattern("AAA")
                .pattern("A A")
                .pattern("   ")
                .define('A', Items.EMERALD)
                .unlockedBy(getHasName(Items.EMERALD), has(Items.EMERALD)).save(pRecipeOutput);

            ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.EMERALD_CHESTPLATE.get())
                .pattern("A A")
                .pattern("AAA")
                .pattern("AAA")
                .define('A', Items.EMERALD)
                .unlockedBy(getHasName(Items.EMERALD), has(Items.EMERALD)).save(pRecipeOutput);

            ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.EMERALD_LEGGINGS.get())
                .pattern("AAA")
                .pattern("A A")
                .pattern("A A")
                .define('A', Items.EMERALD)
                .unlockedBy(getHasName(Items.EMERALD), has(Items.EMERALD)).save(pRecipeOutput);

            ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.EMERALD_BOOTS.get())
                .pattern("   ")
                .pattern("A A")
                .pattern("A A")
                .define('A', Items.EMERALD)
                .unlockedBy(getHasName(Items.EMERALD), has(Items.EMERALD)).save(pRecipeOutput);

            //custom items
            ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.MAGIC_BLADE.get())
                .pattern("  A")
                .pattern(" B ")
                .pattern("B  ")
                .define('A', Items.DIAMOND)
                .define('B',Items.STICK)
                .unlockedBy(getHasName(Items.DIAMOND), has(Items.DIAMOND)).save(pRecipeOutput);

            ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.HEALER.get())
                .pattern("A  ")
                .pattern(" B ")
                .pattern("  B")
                .define('A', ModItems.RUBY.get())
                .define('B',Items.STICK)
                .unlockedBy(getHasName(ModItems.RUBY.get()), has(ModItems.RUBY.get())).save(pRecipeOutput);
            // foods
            ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.PITOGYRO.get())
            .pattern(" A ")
            .pattern(" B ")
            .pattern(" C ")
            .define('A', Items.POTATO)
            .define('B', Items.PORKCHOP)
            .define('C', Items.BREAD)
            .unlockedBy(getHasName(Items.BREAD), has(Items.BREAD)).save(pRecipeOutput);

            //copper tools
            ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.COPPER_SWORD.get())
                .pattern(" A ")
                .pattern(" A ")
                .pattern(" B ")
                .define('A', Items.COPPER_INGOT)
                .define('B',Items.STICK)
                .unlockedBy(getHasName(Items.COPPER_INGOT), has(Items.COPPER_INGOT)).save(pRecipeOutput);

            ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.COPPER_PICKAXE.get())
                .pattern("AAA")
                .pattern(" B ")
                .pattern(" B ")
                .define('A', Items.COPPER_INGOT)
                .define('B',Items.STICK)
                .unlockedBy(getHasName(Items.COPPER_INGOT), has(Items.COPPER_INGOT)).save(pRecipeOutput);

                ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.COPPER_AXE.get())
                .pattern("AA ")
                .pattern("AB ")
                .pattern(" B ")
                .define('A', Items.COPPER_INGOT)
                .define('B',Items.STICK)
                .unlockedBy(getHasName(Items.COPPER_INGOT), has(Items.COPPER_INGOT)).save(pRecipeOutput);

            ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.COPPER_SHOVEL.get())
                .pattern(" A ")
                .pattern(" B ")
                .pattern(" B ")
                .define('A', Items.COPPER_INGOT)
                .define('B',Items.STICK)
                .unlockedBy(getHasName(Items.COPPER_INGOT), has(Items.COPPER_INGOT)).save(pRecipeOutput);

            ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.COPPER_HOE.get())
                .pattern("AA ")
                .pattern(" B ")
                .pattern(" B ")
                .define('A', Items.COPPER_INGOT)
                .define('B',Items.STICK)
                .unlockedBy(getHasName(Items.COPPER_INGOT), has(Items.COPPER_INGOT)).save(pRecipeOutput);

            //emerald armor
            ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.COPPER_HELMET.get())
                .pattern("AAA")
                .pattern("A A")
                .pattern("   ")
                .define('A', Items.COPPER_INGOT)
                .unlockedBy(getHasName(Items.COPPER_INGOT), has(Items.COPPER_INGOT)).save(pRecipeOutput);

            ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.COPPER_CHESTPLATE.get())
                .pattern("A A")
                .pattern("AAA")
                .pattern("AAA")
                .define('A', Items.COPPER_INGOT)
                .unlockedBy(getHasName(Items.COPPER_INGOT), has(Items.COPPER_INGOT)).save(pRecipeOutput);

            ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.COPPER_LEGGINGS.get())
                .pattern("AAA")
                .pattern("A A")
                .pattern("A A")
                .define('A', Items.COPPER_INGOT)
                .unlockedBy(getHasName(Items.COPPER_INGOT), has(Items.COPPER_INGOT)).save(pRecipeOutput);

            ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.COPPER_BOOTS.get())
                .pattern("   ")
                .pattern("A A")
                .pattern("A A")
                .define('A', Items.COPPER_INGOT)
                .unlockedBy(getHasName(Items.COPPER_INGOT), has(Items.COPPER_INGOT)).save(pRecipeOutput);

            //spear recipe
            ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.SPEAR.get())
                .pattern(" A ")
                .pattern(" B ")
                .pattern(" B ")
                .define('A', Items.IRON_NUGGET)
                .define('B',Items.STICK)
                .unlockedBy(getHasName(Items.IRON_NUGGET), has(Items.IRON_NUGGET)).save(pRecipeOutput);
    }
}
