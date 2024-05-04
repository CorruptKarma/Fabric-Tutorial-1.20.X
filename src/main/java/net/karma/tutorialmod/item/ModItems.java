package net.karma.tutorialmod.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.karma.tutorialmod.TutorialMod;
import net.karma.tutorialmod.item.custom.VCrystal_DetectorItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {

    public static final Item VoidCrystal = registerItem("voidcrystal", new Item(new FabricItemSettings()));
    public static final Item VoidAmethyst = registerItem("voidamethyst", new Item(new FabricItemSettings()));
    public static final Item Void_infused_Pearl = registerItem("void_infused_pearl", new Item(new FabricItemSettings()));
    public static final Item VOID_INGOT = registerItem("void_ingot", new Item(new FabricItemSettings()));

    public static final Item Iron_Cassing = registerItem("iron_cassing", new Item
            (new FabricItemSettings()));


    public static final Item VCrystal_Detector = registerItem("vcrystal_detector",
            new VCrystal_DetectorItem(new FabricItemSettings().maxDamage(200)));
    private static void addItemsToIngredientsItemGroup(FabricItemGroupEntries entries){
        entries.add(VoidCrystal);
        entries.add(VoidAmethyst);
    }

    private static Item registerItem(String name, Item item){
        return Registry.register(Registries.ITEM, new Identifier(TutorialMod.MOD_ID, name), item);
    }
    public static void registerModItems() {
        TutorialMod.LOGGER.info("Registering Mod for " + TutorialMod.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModItems::addItemsToIngredientsItemGroup);
    }
}
