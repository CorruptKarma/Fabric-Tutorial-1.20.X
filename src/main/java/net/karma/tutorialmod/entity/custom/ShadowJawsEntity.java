package net.karma.tutorialmod.entity.custom;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.entity.mob.EvokerFangsEntity;
import net.minecraft.world.World;


public class ShadowJawsEntity extends EvokerFangsEntity {
    public static final EntityType<ShadowJawsEntity> TYPE = EntityType.Builder.create(ShadowJawsEntity::new, SpawnGroup.MISC).setDimensions(0.5f, 0.8f).build("shadowjaws");

    public ShadowJawsEntity(EntityType<? extends EvokerFangsEntity> type, World world) {
        super(type, world);
    }




}

