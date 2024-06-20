package net.karma.tutorialmod.mixin;

import net.karma.tutorialmod.item.ModItems;
import net.minecraft.block.*;
import net.minecraft.block.enums.Instrument;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.Slice;

@Mixin(Blocks.class)
public abstract class BlocksMixin {
    @Redirect(
            method = "<clinit>",
            slice = @Slice(from = @At(value = "CONSTANT", args = "stringValue=bedrock")),
            at = @At(value = "NEW", target = "(Lnet/minecraft/block/AbstractBlock$Settings;)Lnet/minecraft/block/Block;", ordinal = 0)
    )
    private static Block nemuelch$redirectBedrockBlockRegistration(AbstractBlock.Settings settings) {
        return new Block(AbstractBlock.Settings.create()
                .mapColor(MapColor.STONE_GRAY)
                .instrument(Instrument.BASEDRUM)
                .strength(100f, 2400.0F)
                .allowsSpawning(Blocks::never)) {
            @Override
            public void onBreak(World world, BlockPos pos, BlockState state, PlayerEntity player) {
                if (player != null) {
                    ItemStack mainHandStack = player.getMainHandStack();
                    if (mainHandStack.getItem() == ModItems.VOID_PICKAXE) {
                        int fortuneLevel = EnchantmentHelper.getLevel(Enchantments.FORTUNE, mainHandStack);
                        int dropCount = 1 + world.random.nextInt(fortuneLevel + 1);
                        for (int i = 0; i < dropCount; i++) {
                            dropStack(world, pos, new ItemStack(ModItems.BEDROCK_DUST));
                        }
                    }
                }
                super.onBreak(world, pos, state, player);
        }
    };
  }
}
