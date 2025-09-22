package com.mrbysco.woolytrees.generator.client;

import com.mrbysco.woolytrees.Reference;
import com.mrbysco.woolytrees.registry.WoolyRegistry;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class WoolyItemModelsProvider extends ItemModelProvider {
	public WoolyItemModelsProvider(PackOutput packOutput, ExistingFileHelper helper) {
		super(packOutput, Reference.MOD_ID, helper);
	}

	@Override
	protected void registerModels() {
		makeLeaves(WoolyRegistry.WHITE_WOOL_LEAVES.getId(), "white_wool");
		makeLeaves(WoolyRegistry.ORANGE_WOOL_LEAVES.getId(), "orange_wool");
		makeLeaves(WoolyRegistry.MAGENTA_WOOL_LEAVES.getId(), "magenta_wool");
		makeLeaves(WoolyRegistry.LIGHT_BLUE_WOOL_LEAVES.getId(), "light_blue_wool");
		makeLeaves(WoolyRegistry.YELLOW_WOOL_LEAVES.getId(), "yellow_wool");
		makeLeaves(WoolyRegistry.LIME_WOOL_LEAVES.getId(), "lime_wool");
		makeLeaves(WoolyRegistry.PINK_WOOL_LEAVES.getId(), "pink_wool");
		makeLeaves(WoolyRegistry.GRAY_WOOL_LEAVES.getId(), "gray_wool");
		makeLeaves(WoolyRegistry.LIGHT_GRAY_WOOL_LEAVES.getId(), "light_gray_wool");
		makeLeaves(WoolyRegistry.CYAN_WOOL_LEAVES.getId(), "cyan_wool");
		makeLeaves(WoolyRegistry.PURPLE_WOOL_LEAVES.getId(), "purple_wool");
		makeLeaves(WoolyRegistry.BLUE_WOOL_LEAVES.getId(), "blue_wool");
		makeLeaves(WoolyRegistry.BROWN_WOOL_LEAVES.getId(), "brown_wool");
		makeLeaves(WoolyRegistry.GREEN_WOOL_LEAVES.getId(), "green_wool");
		makeLeaves(WoolyRegistry.RED_WOOL_LEAVES.getId(), "red_wool");
		makeLeaves(WoolyRegistry.BLACK_WOOL_LEAVES.getId(), "black_wool");

		makeBlock(WoolyRegistry.WOOLY_BEE_NEST.getId());

		makeSapling(WoolyRegistry.WOOLY_SAPLING.getId());
		makeSapling(WoolyRegistry.JEB_SAPLING.getId());
	}

	private void makeLeaves(ResourceLocation location, String originalBlock) {
		getBuilder(location.getPath())
				.parent(new ModelFile.UncheckedModelFile(mcLoc("block/" + originalBlock)));
	}

	private void makeBlock(ResourceLocation location) {
		String path = location.getPath();
		getBuilder(path)
				.parent(new ModelFile.UncheckedModelFile(modLoc("block/" + path)));
	}

	private void makeSapling(ResourceLocation location) {
		String path = location.getPath();
		getBuilder(path)
				.parent(new ModelFile.UncheckedModelFile(mcLoc("item/generated")))
				.texture("layer0", modLoc("block/" + path));
	}

	@Override
	public String getName() {
		return "Item Models";
	}
}
