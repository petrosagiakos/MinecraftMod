package com.example.rubymod.util;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import com.example.rubymod.RubyMod;

public class ModTags {
    public static class Blocks{
        //this is 2 tags which are not currently used but their use is 
        //if I want to add some blocks that can or cannot be mined with 
        //the tiers that have this tags 
        public static final TagKey<Block> NEEDS_RUBY_TOOL = createTag("needs_ruby_tool");
        public static final TagKey<Block> INCORRECT_FOR_RUBY_TOOL = createTag("incorrect_for_ruby_tool");

        public static final TagKey<Block> NEEDS_COPPER_TOOL = createTag("needs_copper_tool");
        public static final TagKey<Block> INCORRECT_FOR_COPPER_TOOL = createTag("incorrect_for_copper_tool");

        private static TagKey<Block> createTag(String name){
            return BlockTags.create(ResourceLocation.fromNamespaceAndPath(RubyMod.MODID,name));
        }
    }

    public static class Items{
        public static final TagKey<Item> TOOL_TAG = createTag("tool_tag");

        private static TagKey<Item> createTag(String name){
            return ItemTags.create(ResourceLocation.fromNamespaceAndPath(RubyMod.MODID,name));
        }
    }
}
