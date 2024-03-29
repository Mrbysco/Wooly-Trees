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
		return WoolyFeatureConfig.STRAIGHT_FANCY_TRUNK_PLACER;
	}

	@Override
	public boolean makeLimb(LevelSimulatedReader simulatedReader, BiConsumer<BlockPos, BlockState> stateBiConsumer, RandomSource random, BlockPos pos, BlockPos pos1, boolean p_161821_, TreeConfiguration treeConfiguration) {
		if (p_161821_ || !Objects.equals(pos, pos1)) {
			BlockPos blockpos = pos1.offset(-pos.getX(), -pos.getY(), -pos.getZ());
			int i = this.getSteps(blockpos);
			float f = (float) blockpos.getX() / (float) i;
			float f1 = (float) blockpos.getY() / (float) i;
			float f2 = (float) blockpos.getZ() / (float) i;

			for (int j = 0; j <= i; ++j) {
				BlockPos offset = pos.offset(Mth.floor(0.5F + (float)j * f), Mth.floor(0.5F + (float)j * f1), Mth.floor(0.5F + (float)j * f2));
				if (p_161821_) {
					this.placeLog(simulatedReader, stateBiConsumer, random, offset, treeConfiguration, (state) -> {
						return state;
					});
				} else if (!this.isFree(simulatedReader, offset)) {
					return false;
				}
			}

		}
		return true;
	}
}