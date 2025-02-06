package com.example.rubymod.entity.client;

import com.example.rubymod.RubyMod;
import com.example.rubymod.entity.custom.ElephantEntity;
import com.mojang.blaze3d.vertex.PoseStack;

import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class ElephantRenderer extends MobRenderer<ElephantEntity, ElephantModel<ElephantEntity>>{
     public ElephantRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new ElephantModel<>(pContext.bakeLayer(ElephantModel.LAYER_LOCATION)), 0.85f);
    }

    @Override
    public ResourceLocation getTextureLocation(ElephantEntity pEntity) {
        return ResourceLocation.fromNamespaceAndPath(RubyMod.MODID, "textures/entity/elephant/elephant_gray.png");
    }

    @Override
    public void render(ElephantEntity pEntity, float pEntityYaw, float pPartialTicks, PoseStack pPoseStack,
                       MultiBufferSource pBuffer, int pPackedLight) {
        if(pEntity.isBaby()) {
            pPoseStack.scale(0.5f, 0.5f, 0.5f);
        } else {
            pPoseStack.scale(1f, 1f, 1f);
        }

        super.render(pEntity, pEntityYaw, pPartialTicks, pPoseStack, pBuffer, pPackedLight);
    }
}
