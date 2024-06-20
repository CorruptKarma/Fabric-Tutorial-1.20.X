// Made with Blockbench 4.10.3
// Exported for Minecraft version 1.17+ for Yarn
// Paste this class into your mod and generate all required imports

package net.karma.tutorialmod.entity.client;

import net.karma.tutorialmod.entity.custom.ShadowJawsEntity;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.util.math.MatrixStack;

import javax.swing.text.html.parser.Entity;

public class ShadowJaw<T extends ShadowJawsEntity> extends EntityModel<T>{
	private final ModelPart jaw;
	private final ModelPart jaw2;
	private final ModelPart pentagram;
	public ShadowJaw(ModelPart root) {
		this.jaw = root.getChild("jaw");
		this.jaw2 = root.getChild("jaw2");
		this.pentagram = root.getChild("pentagram");
	}
	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();
		ModelPartData jaw = modelPartData.addChild("jaw", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 38.0F, 0.625F));

		ModelPartData cube_r1 = jaw.addChild("cube_r1", ModelPartBuilder.create().uv(0, 0).cuboid(-4.0F, -14.0F, -2.0F, 8.0F, 14.0F, 4.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, -2.7053F, 0.0F, 3.1416F));

		ModelPartData jaw2 = modelPartData.addChild("jaw2", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 38.0F, 0.625F));

		ModelPartData cube_r2 = jaw2.addChild("cube_r2", ModelPartBuilder.create().uv(0, 0).cuboid(-4.0F, -14.0F, -2.0F, 8.0F, 14.0F, 4.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, -1.025F, 0.4363F, 0.0F, 0.0F));

		ModelPartData pentagram = modelPartData.addChild("pentagram", ModelPartBuilder.create().uv(-13, 18).cuboid(-7.0F, -14.0F, -7.625F, 14.0F, 0.0F, 14.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 38.0F, 0.625F));
		return TexturedModelData.of(modelData, 32, 32);
	}
	@Override
	public void setAngles(ShadowJawsEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
	}
	@Override
	public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
		jaw.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
		jaw2.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
		pentagram.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
	}
}