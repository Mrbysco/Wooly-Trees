package com.mrbysco.woolytrees.blocks;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.LeavesBlock;
import net.minecraft.world.level.block.state.BlockState;

public class WoolyLeavesBlock extends LeavesBlock {
	public static final MapCodec<WoolyLeavesBlock> CODEC = simpleCodec(WoolyLeavesBlock::new);

	public WoolyLeavesBlock(Properties properties) {
		super(0.0F, properties.noOcclusion().isValidSpawn(WoolyLeavesBlock::ocelotOrParrot).isViewBlocking(WoolyLeavesBlock::never));
	}

	private static Boolean ocelotOrParrot(BlockState state, BlockGetter getter, BlockPos pos, EntityType<?> entityType) {
		return entityType == EntityType.OCELOT || entityType == EntityType.PARROT;
	}

	private static boolean never(BlockState state, BlockGetter getter, BlockPos pos) {
		return false;
	}

	@Override
	public MapCodec<? extends LeavesBlock> codec() {
		return CODEC;
	}

	@Override
	public void tick(BlockState state, ServerLevel level, BlockPos pos, RandomSource rand) {
		level.setBlock(pos, updateDistance(state, level, pos), 3);
	}

	private static BlockState updateDistance(BlockState state, LevelAccessor level, BlockPos pos) {
		int i = 7;
		BlockPos.MutableBlockPos blockpos$mutable = new BlockPos.MutableBlockPos();

		for (Direction direction : Direction.values()) {
			blockpos$mutable.setWithOffset(pos, direction);
			i = Math.min(i, getDistance(level.getBlockState(blockpos$mutable)) + 1);
			if (i == 1) {
				break;
			}
		}

		return state.setValue(DISTANCE, i);
	}

	private static int getDistance(BlockState neighbor) {
		if (neighbor.is(BlockTags.WOOL)) {
			return 0;
		} else {
			return neighbor.getBlock() instanceof WoolyLeavesBlock ? neighbor.getValue(DISTANCE) : 7;
		}
	}

	@Override
	public BlockState getStateForPlacement(BlockPlaceContext context) {
		return updateDistance(this.defaultBlockState().setValue(PERSISTENT, Boolean.TRUE), context.getLevel(), context.getClickedPos());
	}

	@Override
	protected void spawnFallingLeavesParticle(Level level, BlockPos blockPos, RandomSource randomSource) {

	}
}
