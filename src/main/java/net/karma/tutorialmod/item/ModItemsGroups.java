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
            new Identifier(TutorialMod.MOD_ID, "void_crystal"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.void_crystal"))
                    .icon(() -> new ItemStack(ModItems.VOID_CRYSTAL)).entries((displayContext, entries) -> {
                        entries.add(ModItems.VOID_CRYSTAL);
                        entries.add(ModItems.VOID_AMETHYST);
                        entries.add(ModItems.VOID_INFUSED_PEARL);
                        entries.add(ModItems.IRON_CASSING);
                        entries.add(ModItems.VCRYSTAL_DETECTOR);
                        entries.add(ModItems.VOID_INGOT);
                        entries.add(ModItems.VOID_PICKAXE);
                        entries.add(ModItems.BEDROCK_DUST);
                        entries.add(ModItems.KARMA_SCYTHE);

                        entries.add(ModItems.KARMIC_HELMET);
                        entries.add(ModItems.KARMIC_CHESTPLATE);
                        entries.add(ModItems.KARMIC_LEGGINGS);
                        entries.add(ModItems.KARMIC_BOOTS);

                        entries.add(PotionUtil.setPotion(new ItemStack(Items.POTION), ModPotions.VOID_POTION));
                        entries.add(PotionUtil.setPotion(new ItemStack(Items.SPLASH_POTION), ModPotions.VOID_POTION));
                        entries.add(PotionUtil.setPotion(new ItemStack(Items.LINGERING_POTION), ModPotions.VOID_POTION));

                        entries.add(ModBlock.VoidCrystal_BLOCK);
                        entries.add(ModBlock.VOID_ORE);


                    }).build());
    public static void registerItemGroups() {
        TutorialMod.LOGGER.info("Registering Item Groups for" +TutorialMod.MOD_ID);
    }
}
