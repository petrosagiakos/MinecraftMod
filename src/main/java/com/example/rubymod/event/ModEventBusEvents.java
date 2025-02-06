package com.example.rubymod.event;



import com.example.rubymod.RubyMod;
import com.example.rubymod.entity.ModEntities;
import com.example.rubymod.entity.client.ElephantModel;

import com.example.rubymod.entity.client.SpearModel;

import com.example.rubymod.entity.client.BulletModel;
import com.example.rubymod.entity.custom.BulletEntity;
import com.example.rubymod.entity.custom.ElephantEntity;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = RubyMod.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEventBusEvents {
    @SubscribeEvent
    public static void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(ElephantModel.LAYER_LOCATION, ElephantModel::createBodyLayer);
        event.registerLayerDefinition(BulletModel.LAYER_LOCATION, BulletModel::createBodyLayer);
        event.registerLayerDefinition(SpearModel.LAYER_LOCATION, SpearModel::createBodyLayer);
    }

    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event) {
        event.put(ModEntities.ELEPHANT.get(), ElephantEntity.createAttributes().build());

    }
    
}