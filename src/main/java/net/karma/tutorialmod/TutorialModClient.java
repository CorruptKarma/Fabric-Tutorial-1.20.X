package net.karma.tutorialmod;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.karma.tutorialmod.entity.ModEntities;
import net.karma.tutorialmod.entity.client.ShadowJawModel;
import net.karma.tutorialmod.entity.client.ShadowJawsRenderer;
import net.karma.tutorialmod.entity.client.ModModelLayers;

public class TutorialModClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        // Ensure ModEntities.SHADOW_JAW is not null
        if (ModEntities.SHADOW_JAW != null) {
            EntityRendererRegistry.register(ModEntities.SHADOW_JAW, ShadowJawsRenderer::new);
        } else {
            throw new IllegalStateException("SHADOW_JAW entity is not registered correctly!");
        }

        // Ensure ModModelLayers.SHADOW_JAW is not null
        if (ModModelLayers.SHADOW_JAW != null) {
            EntityModelLayerRegistry.registerModelLayer(ModModelLayers.SHADOW_JAW, ShadowJawModel::getTexturedModelData);
        } else {
            throw new IllegalStateException("SHADOW_JAW model layer is not registered correctly!");
        }
    }
}
