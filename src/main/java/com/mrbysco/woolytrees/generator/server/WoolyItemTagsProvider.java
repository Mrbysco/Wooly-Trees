package com.mrbysco.woolytrees.generator.server;

import com.mrbysco.woolytrees.Reference;
import com.mrbysco.woolytrees.registry.WoolyTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.world.item.Items;
import net.neoforged.neoforge.common.data.ItemTagsProvider;

import java.util.concurrent.CompletableFuture;

public class WoolyItemTagsProvider extends ItemTagsProvider {
	public WoolyItemTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider) {
		super(output, lookupProvider, Reference.MOD_ID);
	}

	@Override
	protected void addTags(HolderLookup.Provider provider) {
		this.tag(WoolyTags.CONVERTING_SAPLING).add(Items.OAK_SAPLING);
	}
}
