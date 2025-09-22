package com.mrbysco.woolytrees.registry;

import com.mrbysco.woolytrees.Reference;
import com.mrbysco.woolytrees.trees.features.FancyWoolPlacer;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.RandomSource;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.BlobFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FancyFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.SimpleStateProvider;
import net.minecraft.world.level.levelgen.feature.treedecorators.BeehiveDecorator;
import net.minecraft.world.level.levelgen.feature.trunkplacers.FancyTrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.StraightTrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacerType;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.List;
import java.util.OptionalInt;

public class WoolyFeatureConfig {
	public static final DeferredRegister<TrunkPlacerType<?>> TRUNK_PLACER = DeferredRegister.create(Registries.TRUNK_PLACER_TYPE, Reference.MOD_ID);

	public static final DeferredHolder<TrunkPlacerType<?>, TrunkPlacerType<FancyTrunkPlacer>> STRAIGHT_FANCY_TRUNK_PLACER = TRUNK_PLACER.register("straight_fancy_trunk_placer", () ->
			new TrunkPlacerType<>(FancyTrunkPlacer.CODEC));

	public static final RandomSource rand = RandomSource.create();

	public static final ResourceKey<ConfiguredFeature<?, ?>> FANCY_WOOL = createConfiguredKey("fancy_wool");
	public static final ResourceKey<ConfiguredFeature<?, ?>> FANCY_WOOL_BEES_005 = createConfiguredKey("fancy_wool_with_bees_005");

	public static final ResourceKey<ConfiguredFeature<?, ?>> WOOL = createConfiguredKey("wool");
	public static final ResourceKey<ConfiguredFeature<?, ?>> WOOL_BEES_005 = createConfiguredKey("wool_with_bees_005");

	public static ResourceKey<ConfiguredFeature<?, ?>> createConfiguredKey(String name) {
		return ResourceKey.create(Registries.CONFIGURED_FEATURE, Reference.modLoc(name));
	}

	public static Holder<ConfiguredFeature<?, ?>> createJebHolder(TreeConfiguration configuration) {
		return Holder.direct(new ConfiguredFeature<>(WoolyRegistry.JEB_TREE.get(), configuration));
	}

	private static TreeConfiguration.TreeConfigurationBuilder createFancyWool() {
		return (new TreeConfiguration.TreeConfigurationBuilder(SimpleStateProvider.simple(Blocks.WHITE_WOOL.defaultBlockState()), new FancyWoolPlacer(3, 11, 0), SimpleStateProvider.simple(WoolyRegistry.GREEN_WOOL_LEAVES.get().defaultBlockState()), new FancyFoliagePlacer(ConstantInt.of(2), ConstantInt.of(4), 4), new TwoLayersFeatureSize(0, 0, 0, OptionalInt.of(4)))).ignoreVines();
	}

	private static TreeConfiguration.TreeConfigurationBuilder createWool() {
		return (new TreeConfiguration.TreeConfigurationBuilder(SimpleStateProvider.simple(Blocks.WHITE_WOOL.defaultBlockState()), new StraightTrunkPlacer(4, 2, 0), SimpleStateProvider.simple(WoolyRegistry.GREEN_WOOL_LEAVES.get().defaultBlockState()), new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 3), new TwoLayersFeatureSize(1, 0, 1))).ignoreVines();
	}


	public static TreeConfiguration.TreeConfigurationBuilder getFancyJeb() {
		return (new TreeConfiguration.TreeConfigurationBuilder(SimpleStateProvider.simple(getRandomLog()), new FancyWoolPlacer(3, 11, 0), SimpleStateProvider.simple(getRandomLeaves()), new FancyFoliagePlacer(ConstantInt.of(2), ConstantInt.of(4), 4), new TwoLayersFeatureSize(0, 0, 0, OptionalInt.of(4)))).ignoreVines();
	}

	public static TreeConfiguration getFancyJebConfiguration() {
		return getFancyJeb().build();
	}

	public static TreeConfiguration getFancyJebWithBeehives() {
		return getFancyJeb().decorators(List.of(new BeehiveDecorator(0.05F))).build();
	}

	public static TreeConfiguration getJebConfiguration() {
		return getJeb().build();
	}

	public static TreeConfiguration getJebWithBeehives() {
		return getJeb().decorators(List.of(new BeehiveDecorator(0.05F))).build();
	}

	public static TreeConfiguration.TreeConfigurationBuilder getJeb() {
		return (new TreeConfiguration.TreeConfigurationBuilder(SimpleStateProvider.simple(getRandomLog()), new StraightTrunkPlacer(4, 2, 0), SimpleStateProvider.simple(getRandomLeaves()), new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 3), new TwoLayersFeatureSize(1, 0, 1))).ignoreVines();
	}

	public static BlockState getRandomLeaves() {
		BlockState randomState = WoolyRegistry.GREEN_WOOL_LEAVES.get().defaultBlockState();

		var tag = BuiltInRegistries.BLOCK.get(WoolyTags.WOOLY_LEAVES);
		if (tag.isPresent() && tag.get().size() > 0) {
			var randomBlock = tag.get().getRandomElement(rand);
			if (randomBlock.isPresent()) {
				randomState = randomBlock.get().value().defaultBlockState();
			}
		}
		return randomState;
	}

	public static BlockState getRandomLog() {
		BlockState randomState = Blocks.WHITE_WOOL.defaultBlockState();
		var tag = BuiltInRegistries.BLOCK.get(WoolyTags.WOOLY_LOGS);
		if (tag.isPresent() && tag.get().size() > 0) {
			var randomBlock = tag.get().getRandomElement(rand);
			if (randomBlock.isPresent()) {
				randomState = randomBlock.get().value().defaultBlockState();
			}
		}
		return randomState;
	}

	public static void bootstrap(BootstrapContext<ConfiguredFeature<?, ?>> context) {
		BeehiveDecorator BEEHIVE_005 = new BeehiveDecorator(0.05F);

		FeatureUtils.register(context, FANCY_WOOL, WoolyRegistry.WOOLY_TREE.get(), createFancyWool().build());
		FeatureUtils.register(context, FANCY_WOOL_BEES_005, WoolyRegistry.WOOLY_TREE.get(), createFancyWool().decorators(List.of(BEEHIVE_005)).build());
		FeatureUtils.register(context, WOOL, WoolyRegistry.WOOLY_TREE.get(), createWool().build());
		FeatureUtils.register(context, WOOL_BEES_005, WoolyRegistry.WOOLY_TREE.get(), createWool().decorators(List.of(BEEHIVE_005)).build());
	}
}