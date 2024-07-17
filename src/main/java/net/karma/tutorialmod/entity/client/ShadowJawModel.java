// Made with Blockbench 4.10.3
// Exported for Minecraft version 1.17+ for Yarn
// Paste this class into your mod and generate all required imports

package net.karma.tutorialmod.entity.client;

import net.minecraft.client.model.*;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;

public class ShadowJawModel<T extends Entity>  extends SinglePartEntityModel<T> {
	private static final String BASE = "base";

	private static final String UPPER_JAW = "upper_jaw";

	private static final String LOWER_JAW = "lower_jaw";

	private final ModelPart root;
	private final ModelPart base;
	private final ModelPart upper_jaw;
	private final ModelPart lower_jaw;
	public ShadowJawModel(ModelPart root) {
		this.root = root;
		this.base = root.getChild(BASE);
		this.upper_jaw = root.getChild(UPPER_JAW);
		this.lower_jaw = root.getChild(LOWER_JAW);
	}
	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();
		modelPartData.addChild(BASE, ModelPartBuilder.create().uv(10, 0).cuboid(-9.0F, -16.0F, -9.0F, 18.0F, 0.0F, 18.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		modelPartData.addChild(UPPER_JAW, ModelPartBuilder.create().uv(0, 0).cuboid(-2.0F, 0F, -3.0F, 4.0F, 14.0F, 8.0F, new Dilation(0.0F)), ModelTransform.pivot(1.0F, -7.0F, -1.0F));

		modelPartData.addChild(LOWER_JAW, ModelPartBuilder.create().uv(0, 0).mirrored().cuboid(-3.0F, 0.0F, 1.0F, 4.0F, 14.0F, 8.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.pivot(0.0F, 7.0F, -5.0F));
		return TexturedModelData.of(modelData, 64, 64);
	}

	@Override
	public void setAngles(T entity, float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch) {
		float f = limbAngle * 2.0f;
		if (f > 1.0f) {
			f = 1.0f;
		}
		f = 1.0f - f * f * f;
		this.upper_jaw.roll = (float)Math.PI - f * 0.35f * (float)Math.PI;
		this.lower_jaw.roll = (float)Math.PI + f * 0.35f * (float)Math.PI;
		float g = (limbAngle + MathHelper.sin(limbAngle * 2.7f)) * 0.6f * 12.0f;
		this.lower_jaw.pivotY = this.upper_jaw.pivotY = 24.0f - g;
		this.base.pivotY = this.upper_jaw.pivotY;
	}

	@Override
	public ModelPart getPart() {
		return this.root;
	}
}