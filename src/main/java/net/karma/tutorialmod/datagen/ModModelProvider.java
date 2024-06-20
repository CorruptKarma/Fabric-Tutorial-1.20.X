package net.karma.tutorialmod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.karma.tutorialmod.block.ModBlock;
import net.karma.tutorialmod.item.ModItems;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;
import net.minecraft.item.ArmorItem;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerSimpleCubeAll(ModBlock.Void_Ore);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlock.VoidCrystal_BLOCK);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
            itemModelGenerator.register(ModItems.Void_Crystal, Models.GENERATED);
            itemModelGenerator.register(ModItems.Void_Amethyst, Models.GENERATED);
            itemModelGenerator.register(ModItems.Void_infused_Pearl, Models.GENERATED);
            itemModelGenerator.register(ModItems.VOID_INGOT, Models.GENERATED);
            itemModelGenerator.register(ModItems.VCrystal_Detector, Models.GENERATED);
            itemModelGenerator.register(ModItems.Iron_Cassing, Models.GENERATED);
            itemModelGenerator.register(ModItems.VOID_PICKAXE, Models.HANDHELD);
            itemModelGenerator.register(ModItems.BEDROCK_DUST, Models.GENERATED);

            itemModelGenerator.registerArmor(((ArmorItem) ModItems.KARMIC_HELMET));
            itemModelGenerator.registerArmor(((ArmorItem) ModItems.KARMIC_CHESTPLATE));
            itemModelGenerator.registerArmor(((ArmorItem) ModItems.KARMIC_LEGGINGS));
            itemModelGenerator.registerArmor(((ArmorItem) ModItems.KARMIC_BOOTS));
    }
}
