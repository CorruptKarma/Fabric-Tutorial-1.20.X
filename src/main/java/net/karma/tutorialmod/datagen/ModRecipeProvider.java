package net.karma.tutorialmod.datagen;


import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.karma.tutorialmod.block.ModBlock;
import net.karma.tutorialmod.item.ModItems;
import net.karma.tutorialmod.potion.ModPotions;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.data.server.recipe.RecipeProvider;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.book.RecipeCategory;
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
    public void generate(Consumer<RecipeJsonProvider> exporter) {
        offerSmelting(exporter, SMELTABLES, RecipeCategory.MISC, ModItems.Void_infused_Pearl,
                1.5f, 100,"void_crystal");
        offerSmelting(exporter, VOID_SMELTABLES, RecipeCategory.MISC, ModItems.Void_Crystal,
                7.5f, 1600,"void_crystal");
        offerBlasting(exporter, VOID_SMELTABLES, RecipeCategory.MISC, ModItems.Void_Crystal,
                6.5f, 400,"void_crystal");

        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS, ModItems.Void_Crystal, RecipeCategory.DECORATIONS,
                ModBlock.Void_Ore);


    }
}
