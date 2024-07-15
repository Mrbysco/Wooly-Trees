package com.mrbysco.woolytrees.registry;

import com.mrbysco.woolytrees.Reference;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class WoolyTags {
	public static final TagKey<Block> WOOLY_LEAVES = BlockTags.create(Reference.modLoc("wooly_leaves"));
	public static final TagKey<Block> WOOLY_LOGS = BlockTags.create(Reference.modLoc("wooly_logs"));
	public static final TagKey<Item> CONVERTING_SAPLING = ItemTags.create(Reference.modLoc("converting_saplings"));
}
