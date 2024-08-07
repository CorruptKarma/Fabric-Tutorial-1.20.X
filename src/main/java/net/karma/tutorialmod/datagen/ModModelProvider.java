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
        blockStateModelGenerator.registerSimpleCubeAll(ModBlock.VOID_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlock.VoidCrystal_BLOCK);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
            itemModelGenerator.register(ModItems.VOID_CRYSTAL, Models.GENERATED);
            itemModelGenerator.register(ModItems.VOID_AMETHYST, Models.GENERATED);
            itemModelGenerator.register(ModItems.VOID_INFUSED_PEARL, Models.GENERATED);
            itemModelGenerator.register(ModItems.VOID_INGOT, Models.GENERATED);
            itemModelGenerator.register(ModItems.VCRYSTAL_DETECTOR, Models.GENERATED);
            itemModelGenerator.register(ModItems.IRON_CASSING, Models.GENERATED);
            itemModelGenerator.register(ModItems.VOID_PICKAXE, Models.HANDHELD);
            itemModelGenerator.register(ModItems.BEDROCK_DUST, Models.GENERATED);

            itemModelGenerator.registerArmor(((ArmorItem) ModItems.KARMIC_HELMET));
            itemModelGenerator.registerArmor(((ArmorItem) ModItems.KARMIC_CHESTPLATE));
            itemModelGenerator.registerArmor(((ArmorItem) ModItems.KARMIC_LEGGINGS));
            itemModelGenerator.registerArmor(((ArmorItem) ModItems.KARMIC_BOOTS));
    }
}
