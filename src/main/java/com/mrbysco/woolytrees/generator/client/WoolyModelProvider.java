package com.mrbysco.woolytrees.generator.client;

import com.mrbysco.woolytrees.Reference;
import com.mrbysco.woolytrees.registry.WoolyRegistry;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.ModelProvider;
import net.minecraft.client.data.models.blockstates.MultiVariantGenerator;
import net.minecraft.client.data.models.model.ItemModelUtils;
import net.minecraft.client.data.models.model.ModelTemplate;
import net.minecraft.client.data.models.model.ModelTemplates;
import net.minecraft.client.data.models.model.TextureMapping;
import net.minecraft.client.data.models.model.TextureSlot;
import net.minecraft.client.resources.model.sprite.Material;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.Identifier;
import net.minecraft.world.level.block.BeehiveBlock;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.registries.DeferredBlock;

import java.util.Map;

public class WoolyModelProvider extends ModelProvider {
	public WoolyModelProvider(PackOutput packOutput) {
		super(packOutput, Reference.MOD_ID);
	}

	@Override
	protected void registerModels(BlockModelGenerators blockModels, ItemModelGenerators itemModels) {
		makeLeaves(blockModels, WoolyRegistry.WHITE_WOOL_LEAVES, mcLocation("block/white_wool"));
		makeLeaves(blockModels, WoolyRegistry.ORANGE_WOOL_LEAVES, mcLocation("block/orange_wool"));
		makeLeaves(blockModels, WoolyRegistry.MAGENTA_WOOL_LEAVES, mcLocation("block/magenta_wool"));
		makeLeaves(blockModels, WoolyRegistry.LIGHT_BLUE_WOOL_LEAVES, mcLocation("block/light_blue_wool"));
		makeLeaves(blockModels, WoolyRegistry.YELLOW_WOOL_LEAVES, mcLocation("block/yellow_wool"));
		makeLeaves(blockModels, WoolyRegistry.LIME_WOOL_LEAVES, mcLocation("block/lime_wool"));
		makeLeaves(blockModels, WoolyRegistry.PINK_WOOL_LEAVES, mcLocation("block/pink_wool"));
		makeLeaves(blockModels, WoolyRegistry.GRAY_WOOL_LEAVES, mcLocation("block/gray_wool"));
		makeLeaves(blockModels, WoolyRegistry.LIGHT_GRAY_WOOL_LEAVES, mcLocation("block/light_gray_wool"));
		makeLeaves(blockModels, WoolyRegistry.CYAN_WOOL_LEAVES, mcLocation("block/cyan_wool"));
		makeLeaves(blockModels, WoolyRegistry.PURPLE_WOOL_LEAVES, mcLocation("block/purple_wool"));
		makeLeaves(blockModels, WoolyRegistry.BLUE_WOOL_LEAVES, mcLocation("block/blue_wool"));
		makeLeaves(blockModels, WoolyRegistry.BROWN_WOOL_LEAVES, mcLocation("block/brown_wool"));
		makeLeaves(blockModels, WoolyRegistry.GREEN_WOOL_LEAVES, mcLocation("block/green_wool"));
		makeLeaves(blockModels, WoolyRegistry.RED_WOOL_LEAVES, mcLocation("block/red_wool"));
		makeLeaves(blockModels, WoolyRegistry.BLACK_WOOL_LEAVES, mcLocation("block/black_wool"));

		makeNest(blockModels, WoolyRegistry.WOOLY_BEE_NEST);

		makeSapling(blockModels, WoolyRegistry.WOOLY_SAPLING, modLocation("block/wooly_sapling"));
		makeSapling(blockModels, WoolyRegistry.JEB_SAPLING, modLocation("block/jeb_sapling"));
	}

	private void makeLeaves(BlockModelGenerators blockModels, DeferredBlock<? extends Block> deferredBlock, Identifier original) {
		String path = original.getNamespace() + ":" + original.getPath().replace("block/", "");
		Identifier model = ModelTemplates.create(path).create(deferredBlock.get(), new TextureMapping(), blockModels.modelOutput);
		blockModels.blockStateOutput.accept(
				BlockModelGenerators.createSimpleBlock(deferredBlock.get(), BlockModelGenerators.plainVariant(model)));
	}

	public static final ModelTemplate BEE_NEST = ModelTemplates.create("bee_nest_empty", TextureSlot.PARTICLE, TextureSlot.FRONT, TextureSlot.BOTTOM, TextureSlot.TOP, TextureSlot.FRONT, TextureSlot.SIDE);
	public static final ModelTemplate BEE_NEST_HONEY = ModelTemplates.create("bee_nest_honey", TextureSlot.PARTICLE, TextureSlot.FRONT, TextureSlot.BOTTOM, TextureSlot.TOP, TextureSlot.FRONT, TextureSlot.SIDE);

	private void makeNest(BlockModelGenerators blockModels, DeferredBlock<? extends Block> deferredBlock) {
		String path = deferredBlock.getId().getPath();
		TextureMapping mapping = TextureMapping.particle(new Material(modLocation("block/" + path + "_side")))
				.put(TextureSlot.BOTTOM, new Material(modLocation("block/" + path + "_bottom")))
				.put(TextureSlot.TOP, new Material(modLocation("block/" + path + "_top")))
				.put(TextureSlot.FRONT, new Material(modLocation("block/" + path + "_front")))
				.put(TextureSlot.SIDE, new Material(modLocation("block/" + path + "_side")));
		Identifier model = BEE_NEST.create(deferredBlock.get(), mapping, blockModels.modelOutput);
		Identifier model2 = BEE_NEST_HONEY.createWithSuffix(deferredBlock.get(), "_honey",
				mapping.copyAndUpdate(TextureSlot.FRONT, new Material(modLocation("block/" + path + "_front_honey"))),
				blockModels.modelOutput);

		blockModels.itemModelOutput
				.accept(
						deferredBlock.asItem(),
						ItemModelUtils.selectBlockItemProperty(
								BeehiveBlock.HONEY_LEVEL, ItemModelUtils.plainModel(model), Map.of(5, ItemModelUtils.plainModel(model2))
						)
				);
		blockModels.blockStateOutput
				.accept(
						MultiVariantGenerator.dispatch(deferredBlock.get())
								.with(BlockModelGenerators.createEmptyOrFullDispatch(BeehiveBlock.HONEY_LEVEL, 5, BlockModelGenerators.plainVariant(model2), BlockModelGenerators.plainVariant(model)))
								.with(BlockModelGenerators.ROTATION_HORIZONTAL_FACING));
	}

	private void makeSapling(BlockModelGenerators blockModels, DeferredBlock<? extends Block> deferredBlock, Identifier texture) {
		blockModels.blockStateOutput.accept(
				BlockModelGenerators.createSimpleBlock(deferredBlock.get(),
						BlockModelGenerators.plainVariant(
								ModelTemplates.CROSS.create(deferredBlock.get(), TextureMapping.cross(new Material(texture)), blockModels.modelOutput)
						)
				)
		);
		blockModels.registerSimpleItemModel(deferredBlock.asItem(), blockModels.createFlatItemModelWithBlockTexture(deferredBlock.asItem(), deferredBlock.get()));
	}
}
