package net.karma.tutorialmod.entity.client;

import net.karma.tutorialmod.TutorialMod;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.util.Identifier;

public class ModModelLayers {
    public static final EntityModelLayer SHADOWJAW =
            new EntityModelLayer(new Identifier(TutorialMod.MOD_ID, "shadowjaw"), "main");
}
