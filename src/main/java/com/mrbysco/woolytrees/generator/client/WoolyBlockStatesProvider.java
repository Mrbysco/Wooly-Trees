package com.mrbysco.woolytrees.generator.client;

import com.mrbysco.woolytrees.Reference;
import com.mrbysco.woolytrees.registry.WoolyRegistry;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.BeehiveBlock;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.client.model.generators.ConfiguredModel;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredHolder;

public class WoolyBlockStatesProvider extends BlockStateProvider {

	public WoolyBlockStatesProvider(PackOutput packOutput, ExistingFileHelper helper) {
		super(packOutput, Reference.MOD_ID, helper);
	}

	@Override
	protected void registerStatesAndModels() {
		makeLeaves(WoolyRegistry.WHITE_WOOL_LEAVES, mcLoc("block/white_wool"));
		makeLeaves(WoolyRegistry.ORANGE_WOOL_LEAVES, mcLoc("block/orange_wool"));
		makeLeaves(WoolyRegistry.MAGENTA_WOOL_LEAVES, mcLoc("block/magenta_wool"));
		makeLeaves(WoolyRegistry.LIGHT_BLUE_WOOL_LEAVES, mcLoc("block/light_blue_wool"));
		makeLeaves(WoolyRegistry.YELLOW_WOOL_LEAVES, mcLoc("block/yellow_wool"));
		makeLeaves(WoolyRegistry.LIME_WOOL_LEAVES, mcLoc("block/lime_wool"));
		makeLeaves(WoolyRegistry.PINK_WOOL_LEAVES, mcLoc("block/pink_wool"));
		makeLeaves(WoolyRegistry.GRAY_WOOL_LEAVES, mcLoc("block/gray_wool"));
		makeLeaves(WoolyRegistry.LIGHT_GRAY_WOOL_LEAVES, mcLoc("block/light_gray_wool"));
		makeLeaves(WoolyRegistry.CYAN_WOOL_LEAVES, mcLoc("block/cyan_wool"));
		makeLeaves(WoolyRegistry.PURPLE_WOOL_LEAVES, mcLoc("block/purple_wool"));
		makeLeaves(WoolyRegistry.BLUE_WOOL_LEAVES, mcLoc("block/blue_wool"));
		makeLeaves(WoolyRegistry.BROWN_WOOL_LEAVES, mcLoc("block/brown_wool"));
		makeLeaves(WoolyRegistry.GREEN_WOOL_LEAVES, mcLoc("block/green_wool"));
		makeLeaves(WoolyRegistry.RED_WOOL_LEAVES, mcLoc("block/red_wool"));
		makeLeaves(WoolyRegistry.BLACK_WOOL_LEAVES, mcLoc("block/black_wool"));

		makeNest(WoolyRegistry.WOOLY_BEE_NEST);

		makeSapling(WoolyRegistry.WOOLY_SAPLING, modLoc("block/wooly_sapling"));
		makeSapling(WoolyRegistry.JEB_SAPLING, modLoc("block/jeb_sapling"));
	}

	private void makeLeaves(DeferredHolder<Block, ? extends Block> blockHolder, ResourceLocation original) {
		ModelFile model = models().getBuilder(blockHolder.getId().getPath())
				.parent(models().getExistingFile(original));
		getVariantBuilder(blockHolder.get())
				.forAllStates(state -> ConfiguredModel.builder()
						.modelFile(model).build());
	}

	private void makeNest(DeferredHolder<Block, ? extends Block> blockHolder) {
		String path = blockHolder.getId().getPath();
		ModelFile model = models().getBuilder(path)
				.parent(models().getExistingFile(mcLoc("block/bee_nest")))
				.texture("particle", "block/" + path + "_side")
				.texture("bottom", "block/" + path + "_bottom")
				.texture("top", "block/" + path + "_top")
				.texture("front", "block/" + path + "_front")
				.texture("side", "block/" + path + "_side");
		ModelFile model2 = models().getBuilder(path + "_honey")
				.parent(models().getExistingFile(modLoc("block/wooly_bee_nest")))
				.texture("front", "block/" + path + "_front_honey");
		getVariantBuilder(blockHolder.get())
				.forAllStates(state -> {
					boolean fullOfHoney = state.getValue(BeehiveBlock.HONEY_LEVEL) == 5;
					return ConfiguredModel.builder()
							.modelFile(fullOfHoney ? model2 : model).build();
				});
	}

	private void makeSapling(DeferredHolder<Block, ? extends Block> blockHolder, ResourceLocation texture) {

		ModelFile model = models().getBuilder(blockHolder.getId().getPath())
				.parent(models().getExistingFile(mcLoc("block/cross"))).renderType("minecraft:cutout")
				.texture("cross", texture);
		getVariantBuilder(blockHolder.get())
				.forAllStates(state -> ConfiguredModel.builder()
						.modelFile(model).build());
	}
}
