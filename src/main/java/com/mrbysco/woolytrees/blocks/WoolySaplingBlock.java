package com.mrbysco.woolytrees.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.BushBlock;
import net.minecraft.world.level.block.grower.TreeGrower;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class WoolySaplingBlock extends BushBlock implements BonemealableBlock {
	public static final IntegerProperty STAGE = BlockStateProperties.STAGE;
	protected static final VoxelShape SHAPE = Block.box(2.0D, 0.0D, 2.0D, 14.0D, 12.0D, 14.0D);
	private final TreeGrower tree;

	public WoolySaplingBlock(TreeGrower treeGrower, Block.Properties properties) {
		super(properties);
		this.tree = treeGrower;
		this.registerDefaultState(this.stateDefinition.any().setValue(STAGE, 0));
	}

	public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
		return SHAPE;
	}

	public void tick(BlockState state, ServerLevel serverLevel, BlockPos pos, RandomSource rand) {
		if (!serverLevel.isAreaLoaded(pos, 1))
			return; // Forge: prevent loading unloaded chunks when checking neighbor's light
		if (serverLevel.getMaxLocalRawBrightness(pos.above()) >= 9 && rand.nextInt(7) == 0) {
			this.placeTree(serverLevel, pos, state, rand);
		}

	}

	public void placeTree(ServerLevel serverLevel, BlockPos pos, BlockState state, RandomSource random) {
		if (state.getValue(STAGE) == 0) {
			serverLevel.setBlock(pos, state.cycle(STAGE), 4);
		} else {
			tree.growTree(serverLevel, serverLevel.getChunkSource().getGenerator(), pos, state, random);
		}
	}

	/**
	 * Whether this IGrowable can grow
	 */
	@Override
	public boolean isValidBonemealTarget(LevelReader level, BlockPos pos, BlockState state) {
		return true;
	}

	public boolean isBonemealSuccess(Level level, RandomSource rand, BlockPos pos, BlockState state) {
		return (double) level.getRandom().nextFloat() < 0.45D;
	}

	public void performBonemeal(ServerLevel level, RandomSource rand, BlockPos pos, BlockState state) {
		this.placeTree(level, pos, state, rand);
	}

	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
		builder.add(STAGE);
	}
}
