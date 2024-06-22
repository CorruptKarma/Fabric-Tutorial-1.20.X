package net.karma.tutorialmod.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.karma.tutorialmod.TutorialMod;
import net.karma.tutorialmod.item.custom.FangScythe;
import net.karma.tutorialmod.item.custom.VCrystal_DetectorItem;
import net.karma.tutorialmod.item.custom.cassingItem;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {

    public static final Item VOID_CRYSTAL = registerItem("void_crystal", new Item(new FabricItemSettings()));
    public static final Item VOID_AMETHYST = registerItem("void_amethyst", new Item(new FabricItemSettings()));
    public static final Item VOID_INFUSED_PEARL = registerItem("void_infused_pearl", new Item(new FabricItemSettings()));
    public static final Item VOID_INGOT = registerItem("void_ingot", new Item(new FabricItemSettings()));
    public static final Item BEDROCK_DUST = registerItem("bedrock_dust", new Item(new FabricItemSettings()));

    public static final Item IRON_CASSING =  registerItem("iron_cassing", new cassingItem(new FabricItemSettings().maxDamage(100)));

    public static final Item VCRYSTAL_DETECTOR = registerItem("vcrystal_detector",
            new VCrystal_DetectorItem(new FabricItemSettings().maxDamage(200)));

    public static final Item KARMA_SCYTHE= registerItem("karma_scythe",
            new FangScythe(new FabricItemSettings()));
    public static final Item VOID_PICKAXE = registerItem("void_pickaxe",
            new PickaxeItem(ModToolMaterial.VOID, 5, 3.5f ,new FabricItemSettings()));

    public static final Item KARMIC_HELMET = registerItem("karmic_helmet",
            new ArmorItem(ModArmorMaterials.KARMIC, ArmorItem.Type.HELMET,new FabricItemSettings()));
    public static final Item KARMIC_CHESTPLATE = registerItem("karmic_chestplate",
            new ArmorItem(ModArmorMaterials.KARMIC, ArmorItem.Type.CHESTPLATE,new FabricItemSettings()));
    public static final Item KARMIC_LEGGINGS = registerItem("karmic_leggings",
            new ArmorItem(ModArmorMaterials.KARMIC, ArmorItem.Type.LEGGINGS,new FabricItemSettings()));
    public static final Item KARMIC_BOOTS = registerItem("karmic_boots",
            new ArmorItem(ModArmorMaterials.KARMIC, ArmorItem.Type.BOOTS,new FabricItemSettings()));

    private static void addItemsToIngredientsItemGroup(FabricItemGroupEntries entries){

    }

    private static Item registerItem(String name, Item item){
        return Registry.register(Registries.ITEM, new Identifier(TutorialMod.MOD_ID, name), item);
    }
    public static void registerModItems() {
        TutorialMod.LOGGER.info("Registering Mod for " + TutorialMod.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModItems::addItemsToIngredientsItemGroup);
    }
}
