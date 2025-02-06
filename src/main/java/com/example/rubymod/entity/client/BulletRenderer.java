package com.example.rubymod.entity.client;

import com.example.rubymod.RubyMod;
import com.example.rubymod.entity.custom.BulletEntity;


import net.minecraft.client.renderer.entity.ArrowRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;

public class BulletRenderer extends ArrowRenderer<BulletEntity> {

   
    public BulletRenderer(EntityRendererProvider.Context context) {
        super(context);
    }
  
    @Override
    public ResourceLocation getTextureLocation(BulletEntity entity) {
        return ResourceLocation.fromNamespaceAndPath(RubyMod.MODID, "textures/entity/bullet/bullet.png");
    }
}
