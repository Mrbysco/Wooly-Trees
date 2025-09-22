package com.mrbysco.woolytrees.generator.server;

import com.mrbysco.woolytrees.Reference;
import com.mrbysco.woolytrees.registry.WoolyRegistry;
import com.mrbysco.woolytrees.registry.WoolyTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

import javax.annotation.Nullable;
import java.util.concurrent.CompletableFuture;

public class WoolyBlockTagsProvider extends BlockTagsProvider {
	public WoolyBlockTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
		super(output, lookupProvider, Reference.MOD_ID, existingFileHelper);
	}

	@Override
	protected void addTags(HolderLookup.Provider provider) {
		this.tag(WoolyTags.WOOLY_LEAVES).add(WoolyRegistry.WHITE_WOOL_LEAVES.get(), WoolyRegistry.ORANGE_WOOL_LEAVES.get(), WoolyRegistry.MAGENTA_WOOL_LEAVES.get(),
				WoolyRegistry.LIGHT_BLUE_WOOL_LEAVES.get(), WoolyRegistry.YELLOW_WOOL_LEAVES.get(), WoolyRegistry.LIME_WOOL_LEAVES.get(), WoolyRegistry.PINK_WOOL_LEAVES.get(),
				WoolyRegistry.GRAY_WOOL_LEAVES.get(), WoolyRegistry.LIGHT_GRAY_WOOL_LEAVES.get(), WoolyRegistry.CYAN_WOOL_LEAVES.get(), WoolyRegistry.PURPLE_WOOL_LEAVES.get(),
				WoolyRegistry.BLUE_WOOL_LEAVES.get(), WoolyRegistry.BROWN_WOOL_LEAVES.get(), WoolyRegistry.GREEN_WOOL_LEAVES.get(), WoolyRegistry.RED_WOOL_LEAVES.get(),
				WoolyRegistry.BLACK_WOOL_LEAVES.get());

		this.tag(WoolyTags.WOOLY_LOGS).addTag(BlockTags.WOOL);

		this.tag(BlockTags.LEAVES).addTag(WoolyTags.WOOLY_LEAVES);
	}
}
