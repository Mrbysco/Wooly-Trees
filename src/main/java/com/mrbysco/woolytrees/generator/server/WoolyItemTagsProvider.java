package com.mrbysco.woolytrees.generator.server;

import com.mrbysco.woolytrees.Reference;
import com.mrbysco.woolytrees.registry.WoolyTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.data.tags.TagsProvider;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class WoolyItemTagsProvider extends ItemTagsProvider {
	public WoolyItemTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider,
	                             CompletableFuture<TagsProvider.TagLookup<Block>> tagLookup, @Nullable ExistingFileHelper existingFileHelper) {
		super(output, lookupProvider, tagLookup, Reference.MOD_ID, existingFileHelper);
	}

	@Override
	protected void addTags(HolderLookup.Provider provider) {
		this.tag(WoolyTags.CONVERTING_SAPLING).add(Items.OAK_SAPLING);
	}
}
