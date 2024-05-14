package net.karma.tutorialmod.datagen;


import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.karma.tutorialmod.block.ModBlock;
import net.karma.tutorialmod.item.ModItems;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;

import java.util.List;
import java.util.function.Consumer;

public class ModRecipeProvider extends FabricRecipeProvider {

    public static final List<ItemConvertible> SMELTABLES = List.of(ModItems.Void_Amethyst);
    public static final List<ItemConvertible> VOID_SMELTABLES = List.of(ModBlock.Void_Ore);

    public ModRecipeProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generate(Consumer<RecipeJsonProvider> exporter) {
        offerSmelting(exporter, SMELTABLES, RecipeCategory.MISC, ModItems.Void_infused_Pearl,
                1.5f, 100,"void_crystal");
        offerSmelting(exporter, VOID_SMELTABLES, RecipeCategory.MISC, ModItems.Void_Crystal,
                7.5f, 1600,"void_crystal");
        offerBlasting(exporter, VOID_SMELTABLES, RecipeCategory.MISC, ModItems.Void_Crystal,
                6.5f, 400,"void_crystal");

        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS, ModItems.Void_Crystal, RecipeCategory.DECORATIONS,
                ModBlock.VoidCrystal_BLOCK);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.VOID_INGOT, 1)
                .pattern("SSS")
                .pattern("SRS")
                .pattern("SSS")
                .input('S', ModItems.Void_infused_Pearl)
                .input('R', ModItems.Iron_Cassing)
                .criterion(hasItem(ModItems.Iron_Cassing), conditionsFromItem(ModItems.Iron_Cassing))
                .criterion(hasItem(ModItems.Void_infused_Pearl), conditionsFromItem(ModItems.Void_infused_Pearl))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.Void_Amethyst, 2)
                .pattern(" S ")
                .pattern("SRS")
                .pattern(" S ")
                .input('S', Items.AMETHYST_SHARD)
                .input('R', ModItems.Void_Crystal)
                .criterion(hasItem(Items.AMETHYST_SHARD), conditionsFromItem(Items.AMETHYST_SHARD))
                .criterion(hasItem(ModItems.Void_Crystal), conditionsFromItem(ModItems.Void_Crystal))
                .offerTo(exporter);
    }
}
