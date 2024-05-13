package net.karma.tutorialmod.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.karma.tutorialmod.TutorialMod;
import net.karma.tutorialmod.block.ModBlock;

import net.karma.tutorialmod.potion.ModPotions;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.potion.PotionUtil;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemsGroups {

    public static final ItemGroup VoidCrystal_GROUP = Registry.register(Registries.ITEM_GROUP,
            new Identifier(TutorialMod.MOD_ID, "voidcrystal"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.voidcrystal"))
                    .icon(() -> new ItemStack(ModItems.Void_Crystal)).entries((displayContext, entries) -> {
                        entries.add(ModItems.Void_Crystal);
                        entries.add(ModItems.Void_Amethyst);
                        entries.add(ModItems.Void_infused_Pearl);
                        entries.add(ModItems.Iron_Cassing);
                        entries.add(ModItems.VCrystal_Detector);
                        entries.add(ModItems.VOID_INGOT);

                        entries.add(PotionUtil.setPotion(new ItemStack(Items.POTION), ModPotions.VOID_POTION));
                        entries.add(PotionUtil.setPotion(new ItemStack(Items.SPLASH_POTION), ModPotions.VOID_POTION));
                        entries.add(PotionUtil.setPotion(new ItemStack(Items.LINGERING_POTION), ModPotions.VOID_POTION));

                        entries.add(ModBlock.VoidCrystal_BLOCK);
                        entries.add(ModBlock.Void_Ore);


                    }).build());
    public static void registerItemGroups() {
        TutorialMod.LOGGER.info("Registering Item Groups for" +TutorialMod.MOD_ID);
    }
}
