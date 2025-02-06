package com.example.rubymod.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.example.rubymod.entity.custom.ElephantEntity;
import com.example.rubymod.RubyMod;

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
import net.minecraft.util.Mth;

public class ElephantModel<T extends ElephantEntity> extends HierarchicalModel<T> {
    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath(RubyMod.MODID, "elephant"), "main");
	private final ModelPart root;
	private final ModelPart body;
	private final ModelPart head;
	private final ModelPart ears;
	private final ModelPart nose;
	private final ModelPart horns;
	private final ModelPart f1;
	private final ModelPart f2;
	private final ModelPart f3;
	private final ModelPart f4;

	public ElephantModel(ModelPart root) {
        this.root=root;
		this.body = root.getChild("body");
		this.head = this.body.getChild("head");
		this.ears = this.head.getChild("ears");
		this.nose = this.head.getChild("nose");
		this.horns = this.head.getChild("horns");
		this.f1 = this.body.getChild("f1");
		this.f2 = this.body.getChild("f2");
		this.f3 = this.body.getChild("f3");
		this.f4 = this.body.getChild("f4");
        
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 0).addBox(-21.0F, -34.0F, -1.0F, 23.0F, 26.0F, 32.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 15.0F, -10.0F));

		PartDefinition head = body.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 58).addBox(-4.0F, -35.0F, 4.0F, 12.0F, 14.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-8.0F, 1.0F, 3.0F, 0.0F, 3.1416F, 0.0F));

		PartDefinition ears = head.addOrReplaceChild("ears", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition earright_r1 = ears.addOrReplaceChild("earright_r1", CubeListBuilder.create().texOffs(94, 58).addBox(-8.0F, -19.0F, 2.0F, 9.0F, 11.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0F, -16.0F, 8.0F, 0.0F, -0.4363F, 0.0F));

		PartDefinition earleft_r1 = ears.addOrReplaceChild("earleft_r1", CubeListBuilder.create().texOffs(92, 87).addBox(-8.0F, -19.0F, 2.0F, 9.0F, 11.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(12.0F, -16.0F, 6.0F, 0.0F, 0.4363F, 0.0F));

		PartDefinition nose = head.addOrReplaceChild("nose", CubeListBuilder.create(), PartPose.offset(-2.0F, 0.0F, 0.0F));

		PartDefinition n3_r1 = nose.addOrReplaceChild("n3_r1", CubeListBuilder.create().texOffs(68, 98).addBox(-2.0F, -13.0961F, 5.694F, 3.0F, 8.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.0F, -16.0F, 13.0F, 0.48F, 0.0F, 0.0F));

		PartDefinition n3_r2 = nose.addOrReplaceChild("n3_r2", CubeListBuilder.create().texOffs(48, 98).addBox(-2.2405F, -13.9943F, 2.1819F, 3.0F, 11.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.0F, -2.0F, 14.0F, 0.0244F, 0.0562F, 0.0301F));

		PartDefinition n2_r1 = nose.addOrReplaceChild("n2_r1", CubeListBuilder.create().texOffs(94, 70).addBox(-2.2405F, -13.9943F, 2.1819F, 3.0F, 11.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.0F, -8.0F, 14.0F, 0.0244F, 0.0562F, 0.0301F));

		PartDefinition n1_r1 = nose.addOrReplaceChild("n1_r1", CubeListBuilder.create().texOffs(58, 98).addBox(-2.0F, -13.9696F, 2.6972F, 3.0F, 8.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.0F, -12.0F, 14.0F, 0.0873F, 0.0F, 0.0F));

		PartDefinition horns = head.addOrReplaceChild("horns", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition hr_r1 = horns.addOrReplaceChild("hr_r1", CubeListBuilder.create().texOffs(70, 87).addBox(0.0F, -1.0F, -1.0F, 1.0F, 1.0F, 10.0F, new CubeDeformation(0.0F))
		.texOffs(48, 87).addBox(-9.0F, -1.0F, -1.0F, 1.0F, 1.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.0F, -23.0F, 14.0F, -0.6981F, 0.0F, 0.0F));

		PartDefinition f1 = body.addOrReplaceChild("f1", CubeListBuilder.create().texOffs(46, 58).addBox(-21.0F, -14.0F, 0.0F, 6.0F, 23.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition f2 = body.addOrReplaceChild("f2", CubeListBuilder.create().texOffs(24, 87).addBox(-4.0F, -14.0F, 0.0F, 6.0F, 23.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition f3 = body.addOrReplaceChild("f3", CubeListBuilder.create().texOffs(0, 83).addBox(-2.0F, -15.0F, -1.0F, 6.0F, 23.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.0F, 1.0F, 25.0F));

		PartDefinition f4 = body.addOrReplaceChild("f4", CubeListBuilder.create().texOffs(70, 58).addBox(-21.0F, -14.0F, 24.0F, 6.0F, 23.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        //this.animateWalk(ElephantAnimations.WALKING, limbSwing, limbSwingAmount, 2f, 2.5f);
		
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, int color) {
		this.root.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
	}
    @Override
    public ModelPart root() {
        return this.root;
    }
}
