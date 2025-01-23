package com.example.rubymod.items;

import com.example.rubymod.util.*;
import com.example.rubymod.RubyMod;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;


public class ModToolTiers {
    //Ruby Tier
    public static final Tier RUBY = new ForgeTier(10000,6,16f,20,ModTags.Blocks.NEEDS_RUBY_TOOL
    , () -> Ingredient.of(ModItems.RUBY.get()), ModTags.Blocks.INCORRECT_FOR_RUBY_TOOL);
    //Emerald Tier
    public static final Tier EMERALD = new ForgeTier(100000,6,24f,27,ModTags.Blocks.NEEDS_RUBY_TOOL
    , () -> Ingredient.of(ModItems.EMERALD.get()), ModTags.Blocks.INCORRECT_FOR_RUBY_TOOL);
}
