package com.example.rubymod.entity.client;

import com.example.rubymod.RubyMod;
import com.example.rubymod.entity.custom.SpearEntity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;

import net.minecraft.client.model.EntityModel;
import net.minecraft.world.entity.Entity;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.resources.ResourceLocation;

public class SpearModel<T extends SpearEntity> extends HierarchicalModel<T>{
    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath(RubyMod.MODID, "spear"), "main");
    private final ModelPart bb_main;

	public SpearModel(ModelPart root) {
		this.bb_main = root.getChild("bb_main");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition bb_main = partdefinition.addOrReplaceChild("bb_main", CubeListBuilder.create().texOffs(0, 0).addBox(0.0F, -41.0F, -1.0F, 1.0F, 41.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(4, 6).addBox(-1.0F, -41.0F, -2.0F, 3.0F, 1.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(4, 0).addBox(-2.0F, -42.0F, -3.0F, 5.0F, 1.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(4, 10).addBox(-1.0F, -43.0F, -2.0F, 3.0F, 1.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(16, 6).addBox(0.0F, -45.0F, -1.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(4, 14).addBox(-1.0F, -44.0F, -2.0F, 3.0F, 1.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(16, 8).addBox(0.0F, -46.0F, -1.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}
   
	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, int color) {
		bb_main.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
	}
    @Override
    public ModelPart root() {
        return this.bb_main;
    }
}
