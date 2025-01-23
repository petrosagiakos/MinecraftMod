package com.example.rubymod.blocks;

import com.example.rubymod.RubyMod;
import com.example.rubymod.items.ModItems;
import com.example.rubymod.RubyMod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.RegistryObject;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import java.util.function.Supplier;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS = 
        DeferredRegister.create(ForgeRegistries.BLOCKS, RubyMod.MODID);
    
    public static final RegistryObject<Block> RUBY_BLOCK =
        registerBlock("ruby_block",()->new Block(BlockBehaviour.Properties.of()
            .strength(4f).requiresCorrectToolForDrops().sound(SoundType.AMETHYST)));
    public static final RegistryObject<Block> RUBY_ORE =
        registerBlock("ruby_ore",() -> new DropExperienceBlock(UniformInt.of(2,4), 
        BlockBehaviour.Properties.of().strength(4f).requiresCorrectToolForDrops()));
    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block){
        RegistryObject<T> RObject=BLOCKS.register(name,block);
        registerBlockItem(name, RObject);
        return RObject;
    }

    private static <T extends Block> void registerBlockItem(String name, RegistryObject<T> block){
        ModItems.ITEMS.register(name,()-> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus){
        BLOCKS.register(eventBus);
    }

}
