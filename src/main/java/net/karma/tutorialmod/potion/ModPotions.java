package net.karma.tutorialmod.potion;

import net.karma.tutorialmod.TutorialMod;
import net.karma.tutorialmod.item.ModItems;
import net.karma.tutorialmod.mixin.BrewingRecipeRegistryMixin;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.potion.Potion;
import net.minecraft.potion.Potions;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModPotions {

    public static Potion VOID_POTION;

    public static Potion registerPotion(String name, Potion potion) {
        return Registry.register(Registries.POTION, new Identifier(TutorialMod.MOD_ID, name), potion);
    }

    public static void registerPotions() {
        VOID_POTION = registerPotion("void_potion", new Potion(
                new StatusEffectInstance(StatusEffects.DARKNESS, 1200, 5),
                new StatusEffectInstance(StatusEffects.BLINDNESS, 1200, 1),
                new StatusEffectInstance(StatusEffects.GLOWING, 3600, 3),
                new StatusEffectInstance(StatusEffects.NAUSEA, 1200, 3)
        ));
        registerPotionRecipes();
    }

    private static void registerPotionRecipes() {
        BrewingRecipeRegistryMixin.invokeRegisterPotionRecipe(Potions.WATER, ModItems.VoidCrystal,
                ModPotions.VOID_POTION);
    }
}