package net.karma.tutorialmod.entity.client;

import net.karma.tutorialmod.TutorialMod;
import net.karma.tutorialmod.entity.custom.ShadowJawsEntity;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

public class ShadowJawsRenderer extends EntityRenderer<ShadowJawsEntity> {

    private static final Identifier TEXTURE = new Identifier(TutorialMod.MOD_ID, "textures/entity/shadowjaw.png");
    private final ShadowJawModel model;

    public ShadowJawsRenderer(EntityRendererFactory.Context context) {
        super(context);
        this.model = new ShadowJawModel(context.getPart(ModModelLayers.SHADOW_JAW));
    }

    @Override
    public void render(ShadowJawsEntity entity, float yaw, float tickDelta, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light) {
        matrices.push();
        float scale = 1.0f;
        matrices.scale(scale, scale, scale);
        model.setAngles(entity, 0, 0, entity.age + tickDelta, 0, 0);
        VertexConsumer vertexConsumer = vertexConsumers.getBuffer(RenderLayer.getEntityCutoutNoCull(TEXTURE));
        model.render(matrices, vertexConsumer, light, OverlayTexture.DEFAULT_UV, 1.0f, 1.0f, 1.0f, 1.0f);
        matrices.pop();
        super.render(entity, yaw, tickDelta, matrices, vertexConsumers, light);
    }

    @Override
    public Identifier getTexture(ShadowJawsEntity entity) {

        return TEXTURE;
    }
}