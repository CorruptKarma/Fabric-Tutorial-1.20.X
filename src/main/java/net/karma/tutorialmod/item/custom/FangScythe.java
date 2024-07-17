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
        super(ModToolMaterial.VOID, 17, -3f, settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity player, Hand hand) {
        if (!world.isClient) {
            Vec3d playerPos = player.getPos();

            spawnRing1(playerPos, player, world);

            new DelayedTask(() -> spawnRing2(playerPos, player, world), 800).start();

            new DelayedTask(() -> spawnRing3(playerPos, player, world), 1600).start();
        }
        return TypedActionResult.success(player.getStackInHand(hand));
    }

    private static class DelayedTask extends Thread {
        private final Runnable task;
        private final long delayl;

        public DelayedTask(Runnable task, long delay) {
            this.task = task;
            this.delayl = delay;
        }

        @Override
        public void run() {
            try {
                Thread.sleep(delayl);
            } catch (InterruptedException e) {
                // Handle interruption if needed
            }
            task.run();
        }
    }

    private void spawnRing1(Vec3d playerPos, PlayerEntity player, World world) {
        int numFangs = 10;
        float angleIncrement = 360.0f / numFangs;
        float ringDistance = 1f;

        for (int i = 0; i < numFangs; i++) {
            float angle = i * angleIncrement;
            double radians = Math.toRadians(angle);
            Vec3d spawnPos = playerPos.add(Math.sin(radians) * ringDistance, 0, Math.cos(radians) * ringDistance);

            EvokerFangsEntity fang = new EvokerFangsEntity(ModEntities.SHADOW_JAW, world);
            fang.refreshPositionAndAngles(spawnPos.x, spawnPos.y, spawnPos.z, player.getYaw(), player.getPitch());
            fang.setOwner(player);
            world.spawnEntity(fang);
        }
    }



    private void spawnRing2(Vec3d playerPos, PlayerEntity player, World world) {
        int numFangs = 20;
        float angleIncrement = 360.0f / numFangs;
        float ringDistance = 2f;

        for (int i = 0; i < numFangs; i++) {
            float angle = i * angleIncrement;
            double radians = Math.toRadians(angle);
            Vec3d spawnPos = playerPos.add(Math.sin(radians) * ringDistance, 0, Math.cos(radians) * ringDistance);

            EvokerFangsEntity fang = new EvokerFangsEntity(ModEntities.SHADOW_JAW, world);
            fang.refreshPositionAndAngles(spawnPos.x, spawnPos.y, spawnPos.z, player.getYaw(), player.getPitch());
            fang.setOwner(player);
            world.spawnEntity(fang);
        }
    }

    private void spawnRing3(Vec3d playerPos, PlayerEntity player, World world) {
        int numFangs = 30;
        float angleIncrement = 360.0f / numFangs;
        float ringDistance = 3f;

        for (int i = 0; i < numFangs; i++) {
            float angle = i * angleIncrement;
            double radians = Math.toRadians(angle);
            Vec3d spawnPos = playerPos.add(Math.sin(radians) * ringDistance, 0, Math.cos(radians) * ringDistance);

            EvokerFangsEntity fang = new EvokerFangsEntity(ModEntities.SHADOW_JAW, world);
            fang.refreshPositionAndAngles(spawnPos.x, spawnPos.y, spawnPos.z, player.getYaw(), player.getPitch());
            fang.setOwner(player);
            world.spawnEntity(fang);
        }
    }
}

