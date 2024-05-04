package net.karma.tutorialmod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.karma.tutorialmod.block.ModBlock;
import net.karma.tutorialmod.item.ModItems;

public class ModLootTableProvider extends FabricBlockLootTableProvider {
    protected ModLootTableProvider(FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    @Override
    public void generate() {
        addDrop(ModBlock.VoidCrystal_BLOCK);

        addDrop(ModBlock.Void_Ore, oreDrops(ModBlock.Void_Ore, ModItems.VoidCrystal));

    }
}
