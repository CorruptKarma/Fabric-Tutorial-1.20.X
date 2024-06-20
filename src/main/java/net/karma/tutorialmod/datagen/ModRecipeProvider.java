package net.karma.tutorialmod.datagen;


import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.karma.tutorialmod.block.ModBlock;
import net.karma.tutorialmod.item.ModItems;
import net.karma.tutorialmod.potion.ModPotions;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.data.server.recipe.RecipeProvider;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.util.Identifier;
import org.apache.http.cookie.SM;

import java.util.List;
import java.util.function.Consumer;

public class ModRecipeProvider extends FabricRecipeProvider {

    public static final List<ItemConvertible> SMELTABLES = List.of(ModItems.Void_Amethyst);
    public static final List<ItemConvertible> VOID_SMELTABLES = List.of(ModBlock.Void_Ore);

    public ModRecipeProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generate(RecipeExporter exporter) {
        offerSmelting(exporter, SMELTABLES, RecipeCategory.MISC, ModItems.Void_infused_Pearl,
                1.5f, 100,"void_crystal");
        offerSmelting(exporter, VOID_SMELTABLES, RecipeCategory.MISC, ModItems.Void_Crystal,
                7.5f, 1600,"void_crystal");
        offerBlasting(exporter, VOID_SMELTABLES, RecipeCategory.MISC, ModItems.Void_Crystal,
                6.5f, 400,"void_crystal");

        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS, ModItems.Void_Crystal, RecipeCategory.DECORATIONS,
                ModBlock.VoidCrystal_BLOCK);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.Void_Amethyst, 1)
                .pattern(" A ")
                .pattern("AVA")
                .pattern(" A ")
                .input('A', Items.AMETHYST_SHARD)
                .input('V', ModItems.Void_Crystal)
                .criterion(hasItem(Items.AMETHYST_SHARD), conditionsFromItem(Items.AMETHYST_SHARD))
                .criterion(hasItem(ModItems.Void_Crystal), conditionsFromItem(ModItems.Void_Crystal))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.Void_Amethyst)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.Iron_Cassing, 1)
                .pattern(" A ")
                .pattern("A A")
                .pattern("AAA")
                .input('A', Items.IRON_INGOT)
                .criterion(hasItem(Items.IRON_INGOT), conditionsFromItem(Items.IRON_INGOT))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.Iron_Cassing)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.VCrystal_Detector, 1)
                .pattern("ARI")
                .pattern("RDR")
                .pattern("CRA")
                .input('A', Items.IRON_INGOT)
                .input('R', Items.REDSTONE)
                .input('C', Items.COMPASS)
                .input('D', Items.DIAMOND)
                .input('I', ModItems.Void_infused_Pearl)
                .criterion(hasItem(ModItems.Void_infused_Pearl), conditionsFromItem(ModItems.Void_infused_Pearl))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.VCrystal_Detector)));


    }
}
