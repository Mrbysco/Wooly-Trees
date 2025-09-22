package com.mrbysco.woolytrees.generator.client;

import com.mrbysco.woolytrees.Reference;
import com.mrbysco.woolytrees.registry.WoolyRegistry;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.LanguageProvider;

public class WoolyLanguageProvider extends LanguageProvider {
	public WoolyLanguageProvider(PackOutput output) {
		super(output, Reference.MOD_ID, "en_us");
	}

	@Override
	protected void addTranslations() {
		add("itemGroup.woolytrees.tab", "Wooly Trees");

		add(WoolyRegistry.WHITE_WOOL_LEAVES.get(), "White Wool Leaves");
		add(WoolyRegistry.ORANGE_WOOL_LEAVES.get(), "Orange Wool Leaves");
		add(WoolyRegistry.MAGENTA_WOOL_LEAVES.get(), "Magenta Wool Leaves");
		add(WoolyRegistry.LIGHT_BLUE_WOOL_LEAVES.get(), "Light Blue Wool Leaves");
		add(WoolyRegistry.YELLOW_WOOL_LEAVES.get(), "Yellow Wool Leaves");
		add(WoolyRegistry.LIME_WOOL_LEAVES.get(), "Lime Wool Leaves");
		add(WoolyRegistry.PINK_WOOL_LEAVES.get(), "Pink Wool Leaves");
		add(WoolyRegistry.GRAY_WOOL_LEAVES.get(), "Gray Wool Leaves");
		add(WoolyRegistry.LIGHT_GRAY_WOOL_LEAVES.get(), "Light Gray Wool Leaves");
		add(WoolyRegistry.CYAN_WOOL_LEAVES.get(), "Cyan Wool Leaves");
		add(WoolyRegistry.PURPLE_WOOL_LEAVES.get(), "Purple Wool Leaves");
		add(WoolyRegistry.BLUE_WOOL_LEAVES.get(), "Blue Wool Leaves");
		add(WoolyRegistry.BROWN_WOOL_LEAVES.get(), "Brown Wool Leaves");
		add(WoolyRegistry.GREEN_WOOL_LEAVES.get(), "Green Wool Leaves");
		add(WoolyRegistry.RED_WOOL_LEAVES.get(), "Red Wool Leaves");
		add(WoolyRegistry.BLACK_WOOL_LEAVES.get(), "Black Wool Leaves");

		add(WoolyRegistry.WOOLY_BEE_NEST.get(), "Wooly Bee Nest");

		add(WoolyRegistry.WOOLY_SAPLING.get(), "Wooly Sapling");
		add(WoolyRegistry.JEB_SAPLING.get(), "Jeb_ Sapling");
	}
}
