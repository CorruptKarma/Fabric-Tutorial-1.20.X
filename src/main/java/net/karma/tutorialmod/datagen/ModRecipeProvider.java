package net.karma.tutorialmod.datagen;


import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.karma.tutorialmod.block.ModBlock;
import net.karma.tutorialmod.item.ModItems;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.util.Identifier;

import java.util.List;

public class ModRecipeProvider extends FabricRecipeProvider {

    public static final List<ItemConvertible> SMELTABLES = List.of(ModItems.VOID_AMETHYST);
    public static final List<ItemConvertible> VOID_SMELTABLES = List.of(ModBlock.VOID_ORE);

    public ModRecipeProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generate(RecipeExporter exporter) {
        offerSmelting(exporter, SMELTABLES, RecipeCategory.MISC, ModItems.VOID_INFUSED_PEARL,
                1.5f, 100,"void_crystal");
        offerSmelting(exporter, VOID_SMELTABLES, RecipeCategory.MISC, ModItems.VOID_CRYSTAL,
                7.5f, 1600,"void_crystal");
        offerBlasting(exporter, VOID_SMELTABLES, RecipeCategory.MISC, ModItems.VOID_CRYSTAL,
                6.5f, 400,"void_crystal");

        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS, ModItems.VOID_CRYSTAL, RecipeCategory.DECORATIONS,
                ModBlock.VoidCrystal_BLOCK);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.VOID_AMETHYST, 1)
                .pattern(" A ")
                .pattern("AVA")
                .pattern(" A ")
                .input('A', Items.AMETHYST_SHARD)
                .input('V', ModItems.VOID_CRYSTAL)
                .criterion(hasItem(Items.AMETHYST_SHARD), conditionsFromItem(Items.AMETHYST_SHARD))
                .criterion(hasItem(ModItems.VOID_CRYSTAL), conditionsFromItem(ModItems.VOID_CRYSTAL))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.VOID_AMETHYST)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.IRON_CASSING, 1)
                .pattern(" A ")
                .pattern("A A")
                .pattern("AAA")
                .input('A', Items.IRON_INGOT)
                .criterion(hasItem(Items.IRON_INGOT), conditionsFromItem(Items.IRON_INGOT))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.IRON_CASSING)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.VCRYSTAL_DETECTOR, 1)
                .pattern("ARI")
                .pattern("RDR")
                .pattern("CRA")
                .input('A', Items.IRON_INGOT)
                .input('R', Items.REDSTONE)
                .input('C', Items.COMPASS)
                .input('D', Items.DIAMOND)
                .input('I', ModItems.VOID_INFUSED_PEARL)
                .criterion(hasItem(ModItems.VOID_INFUSED_PEARL), conditionsFromItem(ModItems.VOID_INFUSED_PEARL))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.VCRYSTAL_DETECTOR)));


    }
}
