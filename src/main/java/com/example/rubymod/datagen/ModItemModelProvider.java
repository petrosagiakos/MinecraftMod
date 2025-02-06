package com.example.rubymod.datagen;

import com.example.rubymod.RubyMod;
import com.example.rubymod.items.ModItems;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;
import net.minecraft.world.item.Item;

public class ModItemModelProvider extends ItemModelProvider{
    //this class creates the json files for the items
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, RubyMod.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        basicItem(ModItems.RUBY.get());
        
        handheldItem(ModItems.RUBY_SWORD);
        handheldItem(ModItems.RUBY_PICKAXE);
        handheldItem(ModItems.RUBY_AXE);
        handheldItem(ModItems.RUBY_SHOVEL);
        handheldItem(ModItems.RUBY_HOE);
        basicItem(ModItems.RUBY_HELMET.get());
        basicItem(ModItems.RUBY_CHESTPLATE.get());
        basicItem(ModItems.RUBY_LEGGINGS.get());
        basicItem(ModItems.RUBY_BOOTS.get());

        handheldItem(ModItems.EMERALD_SWORD);
        handheldItem(ModItems.EMERALD_PICKAXE);
        handheldItem(ModItems.EMERALD_AXE);
        handheldItem(ModItems.EMERALD_SHOVEL);
        handheldItem(ModItems.EMERALD_HOE);
        basicItem(ModItems.EMERALD_HELMET.get());
        basicItem(ModItems.EMERALD_CHESTPLATE.get());
        basicItem(ModItems.EMERALD_LEGGINGS.get());
        basicItem(ModItems.EMERALD_BOOTS.get());

        handheldItem(ModItems.COPPER_SWORD);
        handheldItem(ModItems.COPPER_PICKAXE);
        handheldItem(ModItems.COPPER_AXE);
        handheldItem(ModItems.COPPER_SHOVEL);
        handheldItem(ModItems.COPPER_HOE);
        basicItem(ModItems.COPPER_HELMET.get());
        basicItem(ModItems.COPPER_CHESTPLATE.get());
        basicItem(ModItems.COPPER_LEGGINGS.get());
        basicItem(ModItems.COPPER_BOOTS.get());

        basicItem(ModItems.PITOGYRO.get());
        basicItem(ModItems.MAGIC_BLADE.get());
        basicItem(ModItems.HEALER.get());
        handheldItem(ModItems.SPEAR);
        handheldItem(ModItems.FIRE_SWORD);
        withExistingParent(ModItems.ELEPHANT_SPAWN_EGG.getId().getPath(), mcLoc("item/template_spawn_egg"));
        handheldItem(ModItems.GUN);
        basicItem(ModItems.BULLET_ITEM.get());
        

    }
     private ItemModelBuilder handheldItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                ResourceLocation.parse("item/handheld")).texture("layer0",
                ResourceLocation.fromNamespaceAndPath(RubyMod.MODID,"item/" + item.getId().getPath()));
    }
}
