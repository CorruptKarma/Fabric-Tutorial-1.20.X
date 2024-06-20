package net.karma.tutorialmod.entity;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.karma.tutorialmod.TutorialMod;
import net.karma.tutorialmod.entity.custom.ShadowJawsEntity;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModEntities {
    public static final EntityType<ShadowJawsEntity> SHADOWJAW = Registry.register(Registries.ENTITY_TYPE,
            new Identifier(TutorialMod.MOD_ID, "shadowjaw"),
            FabricEntityTypeBuilder.create(EntityType.EVOKER_FANGS.getSpawnGroup(),
                    ShadowJawsEntity::new).dimensions(EntityDimensions.fixed(0.8f, 0.8f)).build());
}
