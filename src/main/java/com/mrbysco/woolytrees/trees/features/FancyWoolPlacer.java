package com.mrbysco.woolytrees.trees.features;

import com.mrbysco.woolytrees.registry.WoolyFeatureConfig;
import net.minecraft.core.BlockPos;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.trunkplacers.FancyTrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacerType;

import java.util.Objects;
import java.util.function.BiConsumer;

public class FancyWoolPlacer extends FancyTrunkPlacer {
	public FancyWoolPlacer(int baseHeight, int heightRandA, int heightRandB) {
		super(baseHeight, heightRandA, heightRandB);
	}

	protected TrunkPlacerType<?> type() {
		return WoolyFeatureConfig.STRAIGHT_FANCY_TRUNK_PLACER.get();
	}

	@Override
	public boolean makeLimb(WorldGenLevel level, BiConsumer<BlockPos, BlockState> trunkSetter, RandomSource random,
	                        BlockPos startPos, BlockPos endPos, boolean doPlace, TreeConfiguration config) {
		if (doPlace || !Objects.equals(startPos, endPos)) {
			BlockPos blockpos = endPos.offset(-startPos.getX(), -startPos.getY(), -startPos.getZ());
			int i = this.getSteps(blockpos);
			float f = (float) blockpos.getX() / (float) i;
			float f1 = (float) blockpos.getY() / (float) i;
			float f2 = (float) blockpos.getZ() / (float) i;

			for (int j = 0; j <= i; ++j) {
				BlockPos offset = startPos.offset(Mth.floor(0.5F + (float) j * f), Mth.floor(0.5F + (float) j * f1), Mth.floor(0.5F + (float) j * f2));
				if (doPlace) {
					this.placeLog(level, trunkSetter, random, offset, config, (state) -> state);
				} else if (!this.isFree(level, offset)) {
					return false;
				}
			}

		}
		return true;
	}
}