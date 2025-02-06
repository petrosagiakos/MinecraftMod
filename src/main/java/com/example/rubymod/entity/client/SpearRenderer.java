package com.example.rubymod.entity.client;

import com.example.rubymod.RubyMod;
import com.example.rubymod.entity.custom.SpearEntity;


import net.minecraft.client.renderer.entity.ArrowRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;

public class SpearRenderer extends ArrowRenderer<SpearEntity> {

   
    public SpearRenderer(EntityRendererProvider.Context context) {
        super(context);
    }
  
    @Override
    public ResourceLocation getTextureLocation(SpearEntity entity) {
        return ResourceLocation.fromNamespaceAndPath(RubyMod.MODID, "textures/entity/spear/spear.png");
    }
}