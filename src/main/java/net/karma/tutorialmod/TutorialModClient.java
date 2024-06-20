package net.karma.tutorialmod;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.karma.tutorialmod.entity.client.ModModelLayers;
import net.karma.tutorialmod.entity.client.ShadowJaw;

public class TutorialModClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {

        EntityModelLayerRegistry.registerModelLayer(ModModelLayers.SHADOWJAW, ShadowJaw::getTexturedModelData);
    }
}
