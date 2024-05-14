package net.karma.tutorialmod.item.custom;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class cassingItem extends Item {
    public cassingItem(Settings settings) {
        super(settings);
    }

    @Override
    public ItemStack getRecipeRemainder(ItemStack stack) {
        ItemStack newStack = stack.copy();
        if (newStack.damage(1, Random.create(), null)) {
            newStack.decrement(1);
            newStack.setDamage(0);
        }
        return newStack;
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(Text.translatable("tooltip.tutorialmod.cassingItem.tooltip"));
        super.appendTooltip(stack, world, tooltip, context);
    }
}
