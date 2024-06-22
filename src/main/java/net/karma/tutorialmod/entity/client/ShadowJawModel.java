package net.karma.tutorialmod.entity.client;

import net.karma.tutorialmod.entity.ModEntities;
import net.karma.tutorialmod.entity.animation.ModAnimations;
import net.karma.tutorialmod.entity.custom.ShadowJawsEntity;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.Entity;


public class ShadowJawModel<T extends ShadowJawsEntity> extends EntityModel<Entity> {
	private ModelPart jaws;
	private ModelPart jaws2;
	private ModelPart jaws1;
	private ModelPart pentagram;
	public void ShadowJaw(ModelPart root) {
		this.jaws = root.getChild("jaws");
		this.jaws2 = root.getChild("jaws2");
		this.jaws1 = root.getChild("jaws1");
		this.pentagram = root.getChild("pentagram");
	}

    public ShadowJawModel(ModelPart jaws, ModelPart jaws2, ModelPart jaws1, ModelPart pentagram) {
        this.jaws = jaws;
        this.jaws2 = jaws2;
        this.jaws1 = jaws1;
        this.pentagram = pentagram;
    }

    public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();
		ModelPartData jaws = modelPartData.addChild("jaws", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 38.0F, -0.375F));

		ModelPartData jaws2 = jaws.addChild("jaws2", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.975F));

		ModelPartData cube_r1 = jaws2.addChild("cube_r1", ModelPartBuilder.create().uv(0, 0).cuboid(-4.0F, -14.0F, -2.0F, 8.0F, 14.0F, 4.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.5236F, 3.1416F, 0.0F));

		ModelPartData jaws1 = jaws.addChild("jaws1", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.975F));

		ModelPartData cube_r2 = jaws1.addChild("cube_r2", ModelPartBuilder.create().uv(0, 0).cuboid(-4.0F, -14.0F, -2.975F, 8.0F, 14.0F, 4.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.5236F, 0.0F, 0.0F));

		ModelPartData pentagram = modelPartData.addChild("pentagram", ModelPartBuilder.create().uv(-13, 18).cuboid(-7.0F, 0.0F, -7.0F, 14.0F, 0.0F, 14.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 24.0F, 0.0F));
		return TexturedModelData.of(modelData, 32, 32);
	}
	@Override
	public void setAngles(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

	}
	@Override
	public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
		jaws.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
		pentagram.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
	}
}