package com.example.rubymod.datagen;

import com.example.rubymod.RubyMod;
import com.example.rubymod.util.ModTags;
import com.example.rubymod.blocks.ModBlocks;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends BlockTagsProvider {
    public ModBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, RubyMod.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.RUBY_BLOCK.get())
                .add(ModBlocks.RUBY_ORE.get());
                

        tag(BlockTags.NEEDS_IRON_TOOL)
        .add(ModBlocks.RUBY_BLOCK.get())
        .add(ModBlocks.RUBY_ORE.get());

      


        tag(ModTags.Blocks.NEEDS_COPPER_TOOL)
                .addTag(BlockTags.NEEDS_STONE_TOOL).add(Blocks.GOLD_ORE).add(Blocks.GOLD_BLOCK);

        tag(ModTags.Blocks.INCORRECT_FOR_COPPER_TOOL)
                .addTag(BlockTags.INCORRECT_FOR_STONE_TOOL)
                .remove(ModTags.Blocks.NEEDS_COPPER_TOOL);

     
                tag(ModTags.Blocks.NEEDS_RUBY_TOOL)
                        .add(ModBlocks.RUBY_BLOCK.get())
                        .addTag(BlockTags.NEEDS_DIAMOND_TOOL);
        
                tag(ModTags.Blocks.INCORRECT_FOR_RUBY_TOOL)
                        .addTag(BlockTags.INCORRECT_FOR_DIAMOND_TOOL);

    }
}