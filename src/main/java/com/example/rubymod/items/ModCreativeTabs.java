package com.example.rubymod.items;

import java.rmi.registry.Registry;

import com.example.rubymod.RubyMod;
import com.example.rubymod.blocks.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraft.world.item.ItemStack;
public class ModCreativeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
        DeferredRegister.create(Registries.CREATIVE_MODE_TAB, RubyMod.MODID);
    //this is the creative tab which is used to add items from the ModItems.java 
    public static final RegistryObject<CreativeModeTab> RUBY_ITEMS_TAB=CREATIVE_MODE_TABS.register("ruby_items_tab",
        () -> CreativeModeTab.builder().icon(()->new ItemStack(ModItems.RUBY.get()))
            .title(Component.translatable("creativetab.rubymod.ruby_items"))
            .displayItems((itemDisplayParameters, output)->{
                //ruby items registering
                output.accept(ModItems.RUBY.get());
                output.accept(ModItems.RUBY_SWORD.get());
                output.accept(ModItems.RUBY_PICKAXE.get());
                output.accept(ModItems.RUBY_SHOVEL.get());
                output.accept(ModItems.RUBY_AXE.get());
                output.accept(ModItems.RUBY_HOE.get());
                output.accept(ModItems.RUBY_HELMET.get());
                output.accept(ModItems.RUBY_CHESTPLATE.get());
                output.accept(ModItems.RUBY_LEGGINGS.get());
                output.accept(ModItems.RUBY_BOOTS.get());
                //emerald items registering
                output.accept(ModItems.EMERALD_SWORD.get());
                output.accept(ModItems.EMERALD_PICKAXE.get());
                output.accept(ModItems.EMERALD_SHOVEL.get());
                output.accept(ModItems.EMERALD_AXE.get());
                output.accept(ModItems.EMERALD_HOE.get());
                output.accept(ModItems.EMERALD_HELMET.get());
                output.accept(ModItems.EMERALD_CHESTPLATE.get());
                output.accept(ModItems.EMERALD_LEGGINGS.get());
                output.accept(ModItems.EMERALD_BOOTS.get());
                //extra items registering
                output.accept(ModItems.MAGIC_BLADE.get());
                output.accept(ModItems.HEALER.get());

                output.accept(ModItems.COPPER_SWORD.get());
                output.accept(ModItems.COPPER_PICKAXE.get());
                output.accept(ModItems.COPPER_SHOVEL.get());
                output.accept(ModItems.COPPER_AXE.get());
                output.accept(ModItems.COPPER_HOE.get());
                output.accept(ModItems.COPPER_HELMET.get());
                output.accept(ModItems.COPPER_CHESTPLATE.get());
                output.accept(ModItems.COPPER_LEGGINGS.get());
                output.accept(ModItems.COPPER_BOOTS.get());
                output.accept(ModItems.FIRE_SWORD.get());
                output.accept(ModItems.ELEPHANT_SPAWN_EGG.get());
                output.accept(ModItems.GUN.get());
                output.accept(ModItems.BULLET_ITEM.get());
            }).build());
            //Block Tab
    public static final RegistryObject<CreativeModeTab> RUBY_BLOCKS_TAB=CREATIVE_MODE_TABS.register("ruby_blocks_tab",
        () -> CreativeModeTab.builder().icon(()->new ItemStack(ModBlocks.RUBY_BLOCK.get()))
            .withTabsBefore(RUBY_ITEMS_TAB.getId())
            .title(Component.translatable("creativetab.rubymod.ruby_block"))
            .displayItems((itemDisplayParameters, output)->{
                output.accept(ModBlocks.RUBY_BLOCK.get());
                output.accept(ModBlocks.RUBY_ORE.get());
            }).build());

    public static void register(IEventBus eventBus){
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
