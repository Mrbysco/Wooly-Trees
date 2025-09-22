package com.mrbysco.woolytrees.trees.features;

import com.mrbysco.woolytrees.registry.WoolyFeatureConfig;
import net.minecraft.core.BlockPos;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.LevelSimulatedReader;
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
	public boolean makeLimb(LevelSimulatedReader level, BiConsumer<BlockPos, BlockState> blockSetter,
	                        RandomSource random, BlockPos basePos, BlockPos offsetPos, boolean modifyWorld,
	                        TreeConfiguration config) {
		if (modifyWorld || !Objects.equals(basePos, offsetPos)) {
			BlockPos blockpos = offsetPos.offset(-basePos.getX(), -basePos.getY(), -basePos.getZ());
			int i = this.getSteps(blockpos);
			float f = (float) blockpos.getX() / (float) i;
			float f1 = (float) blockpos.getY() / (float) i;
			float f2 = (float) blockpos.getZ() / (float) i;

			for (int j = 0; j <= i; ++j) {
				BlockPos offset = basePos.offset(Mth.floor(0.5F + (float) j * f), Mth.floor(0.5F + (float) j * f1), Mth.floor(0.5F + (float) j * f2));
				if (modifyWorld) {
					this.placeLog(level, blockSetter, random, offset, config, (state) -> {
						return state;
					});
				} else if (!this.isFree(level, offset)) {
					return false;
				}
			}

		}
		return true;
	}
}