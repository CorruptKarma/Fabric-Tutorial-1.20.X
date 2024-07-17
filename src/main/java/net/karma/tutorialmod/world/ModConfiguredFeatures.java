package net.karma.tutorialmod.world;

import net.karma.tutorialmod.TutorialMod;
import net.karma.tutorialmod.block.ModBlock;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.structure.rule.RuleTest;
import net.minecraft.structure.rule.TagMatchRuleTest;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.FeatureConfig;
import net.minecraft.world.gen.feature.OreFeatureConfig;

import java.util.List;

public class ModConfiguredFeatures {

    public static final RegistryKey<ConfiguredFeature<?, ?>> VOID_ORE_KEY = registerKey("void_ore");
    public static final RegistryKey<ConfiguredFeature<?, ?>> NETHER_VOID_ORE_KEY = registerKey("void_ore");

    public static void boostrap(Registerable<ConfiguredFeature<?, ?>> context){
        RuleTest bedrockReplacables = new TagMatchRuleTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);
        RuleTest netherBReplaceables = new TagMatchRuleTest(BlockTags.BASE_STONE_NETHER);

        List<OreFeatureConfig.Target> overworldVoidOre =
                List.of(OreFeatureConfig.createTarget(bedrockReplacables, ModBlock.VOID_ORE.getDefaultState()));

        List<OreFeatureConfig.Target> netherVoidOre =
                List.of(OreFeatureConfig.createTarget(netherBReplaceables, ModBlock.VOID_ORE.getDefaultState()));

        register(context, VOID_ORE_KEY, Feature.ORE, new OreFeatureConfig(overworldVoidOre, 1));
        register(context, NETHER_VOID_ORE_KEY, Feature.ORE, new OreFeatureConfig(netherVoidOre, 3));

    }


    public static RegistryKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, new Identifier(TutorialMod.MOD_ID, name));
    }

    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<ConfiguredFeature<?, ?>> context,
                                                                                   RegistryKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }

}
