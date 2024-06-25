package net.karma.tutorialmod;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.karma.tutorialmod.entity.ModEntities;
import net.karma.tutorialmod.entity.client.ModModelLayers;
import net.karma.tutorialmod.entity.client.ShadowJawModel;
import net.karma.tutorialmod.entity.client.ShadowJawsRenderer;

public class TutorialModClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        EntityRendererRegistry.register(ModEntities.SHADOW_JAW, ShadowJawsRenderer::new);

        EntityModelLayerRegistry.registerModelLayer(ModModelLayers.SHADOW_JAW, ShadowJawModel::getTexturedModelData);
    }
}
