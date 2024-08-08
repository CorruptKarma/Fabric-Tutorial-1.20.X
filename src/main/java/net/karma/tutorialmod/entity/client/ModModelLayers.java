package net.karma.tutorialmod.entity.client;

import net.karma.tutorialmod.TutorialMod;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.util.Identifier;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

@Environment(EnvType.CLIENT)
public class ModModelLayers {
    public static final EntityModelLayer SHADOW_JAW =
            new EntityModelLayer(new Identifier(TutorialMod.MOD_ID, "shadow_jaw"), "main");

    public static void registerModModelLayers() {
        TutorialMod.LOGGER.info("Registering Model layer for" + TutorialMod.MOD_ID);
    }
}
