package net.karma.tutorialmod.entity.client;

import net.karma.tutorialmod.TutorialMod;
import net.karma.tutorialmod.entity.custom.ShadowJawsEntity;
import net.minecraft.client.model.ModelPart;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import org.joml.AxisAngle4d;
import org.joml.Quaternionf;
import org.joml.Vector3f;

public class ShadowJawsRenderer extends EntityRenderer<ShadowJawsEntity> {

    private static final Identifier TEXTURE = new Identifier(TutorialMod.MOD_ID, "textures/entity/shadowjaw.png");
    private final ModelPart model;

    public ShadowJawsRenderer(EntityRendererFactory.Context context, EntityModelLayer shadowjaw) {
        super(context);
        this.model = context.getPart(ModModelLayers.SHADOWJAW);
    }

    @Override
    public void render(ShadowJawsEntity shadowJawsEntity, float f, float g, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i) {
        matrixStack.push();
        this.model.render(matrixStack, vertexConsumerProvider.getBuffer(RenderLayer.getEntityCutout(this.getTexture(shadowJawsEntity))), i, OverlayTexture.DEFAULT_UV);
        matrixStack.pop();
        super.render(shadowJawsEntity, f, g, matrixStack, vertexConsumerProvider, i);
    }

    @Override
    public Identifier getTexture(ShadowJawsEntity shadowJawsEntity) {
        return TEXTURE;
    }
}