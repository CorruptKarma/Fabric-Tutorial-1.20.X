package net.karma.tutorialmod.entity.client;

import net.karma.tutorialmod.TutorialMod;
import net.karma.tutorialmod.entity.custom.ShadowJawsEntity;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.RotationAxis;


public class ShadowJawsRenderer extends EntityRenderer<ShadowJawsEntity> {

    private static final Identifier TEXTURE = new Identifier(TutorialMod.MOD_ID, "textures/entity/shadowjaw.png");
    private final ShadowJawModel model;

    public ShadowJawsRenderer(EntityRendererFactory.Context context) {
        super(context);
        this.model = new ShadowJawModel(context.getPart(ModModelLayers.SHADOW_JAW));
        if (this.model == null) {
            throw new IllegalStateException("ShadowJawModel is not initialized properly!");
        }
    }

    public void render(ShadowJawsEntity entity, float f, float g, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i) {
        float animationProgress = entity.getAnimationProgress(g);
        if (animationProgress == 0.0f) {
            return;
        }
        float scale = 2.0f;
        if (animationProgress > 0.9f) {
            scale *= (1.0f - animationProgress) / 0.1f;
        }

        matrixStack.push();
        matrixStack.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(90.0f - entity.getYaw()));
        matrixStack.scale(-scale, -scale, scale);
        matrixStack.translate(0.0, -0.626, 0.0);
        matrixStack.scale(0.5f, 0.5f, 0.5f);
        this.model.setAngles(entity, animationProgress, 0.0f, 0.0f, entity.getYaw(), entity.getPitch());

        VertexConsumer vertexConsumer = vertexConsumerProvider.getBuffer(this.model.getLayer(TEXTURE));
        if (vertexConsumer == null) {
            throw new IllegalStateException("VertexConsumer is not initialized properly!");
        }

        this.model.render(matrixStack, vertexConsumer, i, OverlayTexture.DEFAULT_UV, 1.0f, 1.0f, 1.0f, 1.0f);
        matrixStack.pop();
        super.render(entity, f, g, matrixStack, vertexConsumerProvider, i);
    }

    @Override
    public Identifier getTexture(ShadowJawsEntity entity) {
        return TEXTURE;
    }
}