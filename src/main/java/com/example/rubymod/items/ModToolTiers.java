package com.example.rubymod.items;

import com.example.rubymod.util.*;
import com.example.rubymod.RubyMod;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;


public class ModToolTiers {
    //Ruby Tier
    public static final Tier RUBY = new ForgeTier(10000,6,16f,20,ModTags.Blocks.NEEDS_RUBY_TOOL
    , () -> Ingredient.of(ModItems.RUBY.get()), ModTags.Blocks.INCORRECT_FOR_RUBY_TOOL);
    //Emerald Tier
    public static final Tier EMERALD = new ForgeTier(100000,6,24f,27,ModTags.Blocks.NEEDS_RUBY_TOOL
    , () -> Ingredient.of(Items.EMERALD), ModTags.Blocks.INCORRECT_FOR_RUBY_TOOL);
    //copper Tier
    public static final Tier COPPER = new ForgeTier(5000,3,4f,30,ModTags.Blocks.NEEDS_COPPER_TOOL, 
    () -> Ingredient.of(Items.COPPER_INGOT), ModTags.Blocks.INCORRECT_FOR_COPPER_TOOL);
    public static final Tier FIRE = new ForgeTier(1000, 6, 15f, 30, ModTags.Blocks.NEEDS_COPPER_TOOL,
     ()-> Ingredient.of(Items.BLAZE_POWDER),ModTags.Blocks.INCORRECT_FOR_COPPER_TOOL); 
}
