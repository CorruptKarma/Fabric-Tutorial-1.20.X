package net.karma.tutorialmod.item.custom;

import net.karma.tutorialmod.entity.ModEntities;
import net.karma.tutorialmod.item.ModToolMaterial;
import net.minecraft.entity.mob.EvokerFangsEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class FangScythe extends SwordItem {
    public FangScythe(Settings settings) {
        super(ModToolMaterial.VOID, 14, -1f, settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity player, Hand hand) {
        if (!world.isClient) {
            Vec3d playerPos = player.getPos();
            int numFangs = 21;
            float angleIncrement = 360.1f / numFangs;

            for (int i = 0; i < numFangs; i++) {
                float angle = i * angleIncrement;
                double radians = Math.toRadians(angle);
                Vec3d spawnPos = playerPos.add(Math.sin(radians) * 2, 0, Math.cos(radians) * 2);

                EvokerFangsEntity fang = new EvokerFangsEntity(ModEntities.SHADOW_JAW, world);
                fang.refreshPositionAndAngles(spawnPos.x, spawnPos.y, spawnPos.z, player.getYaw(), player.getPitch());
                fang.setOwner(player);
                world.spawnEntity(fang);
            }
        }

        return TypedActionResult.success(player.getStackInHand(hand));
    }
}

