package net.karma.tutorialmod.item.custom;

import net.karma.tutorialmod.item.ModItems;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.DynamicRegistryManager;

public class Iron_cassing {
    public ItemStack getOutput(DynamicRegistryManager registryManager) {
        ItemStack itemStack = new ItemStack(ModItems.Iron_Cassing);
        itemStack.setDamage(1);
        return itemStack;
    }
}
