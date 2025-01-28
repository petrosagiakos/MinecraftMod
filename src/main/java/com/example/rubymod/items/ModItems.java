package com.example.rubymod.items;

import com.example.rubymod.RubyMod;
import com.example.rubymod.items.custom_items.MagicBlade;
import com.example.rubymod.items.custom_items.HealItem;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.TridentItem;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.ShovelItem;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.HoeItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems{
    public static final DeferredRegister<Item> ITEMS= DeferredRegister.create(ForgeRegistries.ITEMS, RubyMod.MODID);
    public static final RegistryObject<Item> RUBY = ITEMS.register("ruby",() -> new Item(new Item.Properties()));
    
    public static final RegistryObject<Item> RUBY_SWORD = ITEMS.register("ruby_sword", () -> new SwordItem(ModToolTiers.RUBY, new Item.Properties()
    .attributes(SwordItem.createAttributes(ModToolTiers.RUBY, 8, -2.4f))));
    
    public static final RegistryObject<Item> RUBY_PICKAXE = ITEMS.register("ruby_pickaxe", () -> new PickaxeItem(ModToolTiers.RUBY, new Item.Properties()
    .attributes(PickaxeItem.createAttributes(ModToolTiers.RUBY, 3, -2.5f))));
    
    public static final RegistryObject<Item> RUBY_AXE = ITEMS.register("ruby_axe", () -> new AxeItem(ModToolTiers.RUBY, new Item.Properties()
    .attributes(AxeItem.createAttributes(ModToolTiers.RUBY, 7, -2.6f))));

    public static final RegistryObject<Item> RUBY_SHOVEL = ITEMS.register("ruby_shovel", () -> new ShovelItem(ModToolTiers.RUBY, new Item.Properties()
    .attributes(ShovelItem.createAttributes(ModToolTiers.RUBY, 3, -2.4f))));

    public static final RegistryObject<Item> RUBY_HOE = ITEMS.register("ruby_hoe", () -> new HoeItem(ModToolTiers.RUBY, new Item.Properties()
    .attributes(HoeItem.createAttributes(ModToolTiers.RUBY, 3, -2.7f))));

    public static final RegistryObject<Item> RUBY_HELMET = ITEMS.register("ruby_helmet",()-> new ArmorItem(ModArmorMaterials.RUBY_ARMOR_MATERIAL, ArmorItem.Type.HELMET, new Item.Properties().durability(40)));
    public static final RegistryObject<Item> RUBY_CHESTPLATE = ITEMS.register("ruby_chestplate",()-> new ArmorItem(ModArmorMaterials.RUBY_ARMOR_MATERIAL, ArmorItem.Type.CHESTPLATE, new Item.Properties().durability(40)));
    public static final RegistryObject<Item> RUBY_LEGGINGS = ITEMS.register("ruby_leggings",()-> new ArmorItem(ModArmorMaterials.RUBY_ARMOR_MATERIAL, ArmorItem.Type.LEGGINGS, new Item.Properties().durability(40)));
    public static final RegistryObject<Item> RUBY_BOOTS = ITEMS.register("ruby_boots",()-> new ArmorItem(ModArmorMaterials.RUBY_ARMOR_MATERIAL, ArmorItem.Type.BOOTS, new Item.Properties().durability(40)));

    //emerald tools and armor
    public static final RegistryObject<Item> EMERALD_SWORD = ITEMS.register("emerald_sword", () -> new SwordItem(ModToolTiers.EMERALD, new Item.Properties()
    .attributes(SwordItem.createAttributes(ModToolTiers.EMERALD, 23, -1.4f))));
    
    public static final RegistryObject<Item> EMERALD_PICKAXE = ITEMS.register("emerald_pickaxe", () -> new PickaxeItem(ModToolTiers.EMERALD, new Item.Properties()
    .attributes(PickaxeItem.createAttributes(ModToolTiers.EMERALD, 3, -2.5f))));
    
    public static final RegistryObject<Item> EMERALD_AXE = ITEMS.register("emerald_axe", () -> new AxeItem(ModToolTiers.EMERALD, new Item.Properties()
    .attributes(AxeItem.createAttributes(ModToolTiers.EMERALD, 30, -2.6f))));

    public static final RegistryObject<Item> EMERALD_SHOVEL = ITEMS.register("emerald_shovel", () -> new ShovelItem(ModToolTiers.EMERALD, new Item.Properties()
    .attributes(ShovelItem.createAttributes(ModToolTiers.EMERALD, 3, -2.4f))));

    public static final RegistryObject<Item> EMERALD_HOE = ITEMS.register("emerald_hoe", () -> new HoeItem(ModToolTiers.EMERALD, new Item.Properties()
    .attributes(HoeItem.createAttributes(ModToolTiers.EMERALD, 3, -2.7f))));

    public static final RegistryObject<Item> EMERALD_HELMET = ITEMS.register("emerald_helmet",()-> new ArmorItem(ModArmorMaterials.EMERALD_ARMOR_MATERIAL, ArmorItem.Type.HELMET, new Item.Properties().durability(40)));
    public static final RegistryObject<Item> EMERALD_CHESTPLATE = ITEMS.register("emerald_chestplate",()-> new ArmorItem(ModArmorMaterials.EMERALD_ARMOR_MATERIAL, ArmorItem.Type.CHESTPLATE, new Item.Properties().durability(40)));
    public static final RegistryObject<Item> EMERALD_LEGGINGS = ITEMS.register("emerald_leggings",()-> new ArmorItem(ModArmorMaterials.EMERALD_ARMOR_MATERIAL, ArmorItem.Type.LEGGINGS, new Item.Properties().durability(40)));
    public static final RegistryObject<Item> EMERALD_BOOTS = ITEMS.register("emerald_boots",()-> new ArmorItem(ModArmorMaterials.EMERALD_ARMOR_MATERIAL, ArmorItem.Type.BOOTS, new Item.Properties().durability(40)));


    public static final RegistryObject<Item> PITOGYRO = ITEMS.register("pitogyro",() -> new Item(new Item.Properties().food(new FoodProperties.Builder()
            .alwaysEdible().nutrition(8).saturationModifier(2f).build())));
    public static final RegistryObject<Item> MAGIC_BLADE=ITEMS.register("magic_blade",()-> new MagicBlade(new Item.Properties().durability(257)));
    public static final RegistryObject<Item> HEALER=ITEMS.register("healer", () -> new HealItem(new Item.Properties().durability(150)));
    //copper items
    public static final RegistryObject<Item> COPPER_SWORD = ITEMS.register("copper_sword", ()->new SwordItem(ModToolTiers.COPPER, new Item.Properties().attributes(SwordItem.createAttributes(ModToolTiers.COPPER, 3, -0.7f))));
    public static final RegistryObject<Item> COPPER_PICKAXE = ITEMS.register("copper_pickaxe", ()->new PickaxeItem(ModToolTiers.COPPER, new Item.Properties().attributes(PickaxeItem.createAttributes(ModToolTiers.COPPER, 3, -0.7f))));
    public static final RegistryObject<Item> COPPER_AXE = ITEMS.register("copper_axe", ()->new AxeItem(ModToolTiers.COPPER, new Item.Properties().attributes(AxeItem.createAttributes(ModToolTiers.COPPER, 4, -1.1f))));
    public static final RegistryObject<Item> COPPER_SHOVEL = ITEMS.register("copper_shovel", ()->new ShovelItem(ModToolTiers.COPPER, new Item.Properties().attributes(ShovelItem.createAttributes(ModToolTiers.COPPER, 2, -1.7f))));
    public static final RegistryObject<Item> COPPER_HOE = ITEMS.register("copper_hoe", ()->new HoeItem(ModToolTiers.COPPER, new Item.Properties().attributes(HoeItem.createAttributes(ModToolTiers.COPPER, 1, -0.7f))));
    
    public static final RegistryObject<Item> COPPER_HELMET = ITEMS.register("copper_helmet",()-> new ArmorItem(ModArmorMaterials.COPPER_ARMOR_MATERIAL, ArmorItem.Type.HELMET, new Item.Properties().durability(70)));
    public static final RegistryObject<Item> COPPER_CHESTPLATE = ITEMS.register("copper_chestplate",()-> new ArmorItem(ModArmorMaterials.COPPER_ARMOR_MATERIAL, ArmorItem.Type.CHESTPLATE, new Item.Properties().durability(70)));
    public static final RegistryObject<Item> COPPER_LEGGINGS = ITEMS.register("copper_leggings",()-> new ArmorItem(ModArmorMaterials.COPPER_ARMOR_MATERIAL, ArmorItem.Type.LEGGINGS, new Item.Properties().durability(80)));
    public static final RegistryObject<Item> COPPER_BOOTS = ITEMS.register("copper_boots",()-> new ArmorItem(ModArmorMaterials.COPPER_ARMOR_MATERIAL, ArmorItem.Type.BOOTS, new Item.Properties().durability(65)));


    //spear item
    public static final RegistryObject<Item> SPEAR = ITEMS.register("spear",()->new TridentItem(new Item.Properties().stacksTo(64).durability(250)));

    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}