package net.karma.tutorialmod.entity.client;

import net.karma.tutorialmod.TutorialMod;
import net.karma.tutorialmod.entity.custom.ShadowJawsEntity;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.util.Identifier;

public class ShadowJawsRenderer extends EntityRenderer<ShadowJawsEntity> {
    public static final Identifier TEXTURE = new Identifier(TutorialMod.MOD_ID, "textures/entity/shadowjaw.png");

    public ShadowJawsRenderer(EntityRendererFactory.Context ctx) {
        super(ctx);
    }

    @Override
    public Identifier getTexture(ShadowJawsEntity entity) {
        return TEXTURE;
    }

}