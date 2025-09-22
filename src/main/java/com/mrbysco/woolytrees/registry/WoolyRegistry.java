package com.mrbysco.woolytrees.registry;

import com.mrbysco.woolytrees.Reference;
import com.mrbysco.woolytrees.blocks.WoolyLeavesBlock;
import com.mrbysco.woolytrees.blocks.WoolySaplingBlock;
import com.mrbysco.woolytrees.item.SaplingBlockItem;
import com.mrbysco.woolytrees.trees.WoolTree;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.BeehiveBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.TreeFeature;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.material.MapColor;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.List;
import java.util.function.Supplier;

public class WoolyRegistry {
	public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(Reference.MOD_ID);
	public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(Reference.MOD_ID);
	public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Reference.MOD_ID);
	public static final DeferredRegister<Feature<?>> FEATURES = DeferredRegister.create(Registries.FEATURE, Reference.MOD_ID);

	public static final DeferredHolder<Feature<?>, Feature<TreeConfiguration>> WOOLY_TREE = FEATURES.register("fancy_wooly_tree", () -> new TreeFeature(TreeConfiguration.CODEC));
	public static final DeferredHolder<Feature<?>, Feature<TreeConfiguration>> JEB_TREE = FEATURES.register("fancy_jeb_tree", () -> new TreeFeature(TreeConfiguration.CODEC));

	public static final DeferredBlock<WoolyLeavesBlock> WHITE_WOOL_LEAVES = BLOCKS.registerBlock("white_wool_leaves", WoolyLeavesBlock::new, Block.Properties.ofFullCopy(Blocks.WHITE_WOOL).strength(0.8F).randomTicks().sound(SoundType.WOOL).noOcclusion());
	public static final DeferredBlock<WoolyLeavesBlock> ORANGE_WOOL_LEAVES = BLOCKS.registerBlock("orange_wool_leaves", WoolyLeavesBlock::new, Block.Properties.ofFullCopy(Blocks.ORANGE_WOOL).strength(0.8F).randomTicks().sound(SoundType.WOOL).noOcclusion());
	public static final DeferredBlock<WoolyLeavesBlock> MAGENTA_WOOL_LEAVES = BLOCKS.registerBlock("magenta_wool_leaves", WoolyLeavesBlock::new, Block.Properties.ofFullCopy(Blocks.MAGENTA_WOOL).strength(0.8F).randomTicks().sound(SoundType.WOOL).noOcclusion());
	public static final DeferredBlock<WoolyLeavesBlock> LIGHT_BLUE_WOOL_LEAVES = BLOCKS.registerBlock("light_blue_wool_leaves", WoolyLeavesBlock::new, Block.Properties.ofFullCopy(Blocks.LIGHT_BLUE_WOOL).strength(0.8F).randomTicks().sound(SoundType.WOOL).noOcclusion());
	public static final DeferredBlock<WoolyLeavesBlock> YELLOW_WOOL_LEAVES = BLOCKS.registerBlock("yellow_wool_leaves", WoolyLeavesBlock::new, Block.Properties.ofFullCopy(Blocks.YELLOW_WOOL).strength(0.8F).randomTicks().sound(SoundType.WOOL).noOcclusion());
	public static final DeferredBlock<WoolyLeavesBlock> LIME_WOOL_LEAVES = BLOCKS.registerBlock("lime_wool_leaves", WoolyLeavesBlock::new, Block.Properties.ofFullCopy(Blocks.LIME_WOOL).strength(0.8F).randomTicks().sound(SoundType.WOOL).noOcclusion());
	public static final DeferredBlock<WoolyLeavesBlock> PINK_WOOL_LEAVES = BLOCKS.registerBlock("pink_wool_leaves", WoolyLeavesBlock::new, Block.Properties.ofFullCopy(Blocks.PINK_WOOL).strength(0.8F).randomTicks().sound(SoundType.WOOL).noOcclusion());
	public static final DeferredBlock<WoolyLeavesBlock> GRAY_WOOL_LEAVES = BLOCKS.registerBlock("gray_wool_leaves", WoolyLeavesBlock::new, Block.Properties.ofFullCopy(Blocks.GRAY_WOOL).strength(0.8F).randomTicks().sound(SoundType.WOOL).noOcclusion());
	public static final DeferredBlock<WoolyLeavesBlock> LIGHT_GRAY_WOOL_LEAVES = BLOCKS.registerBlock("light_gray_wool_leaves", WoolyLeavesBlock::new, Block.Properties.ofFullCopy(Blocks.LIGHT_GRAY_WOOL).strength(0.8F).randomTicks().sound(SoundType.WOOL).noOcclusion());
	public static final DeferredBlock<WoolyLeavesBlock> CYAN_WOOL_LEAVES = BLOCKS.registerBlock("cyan_wool_leaves", WoolyLeavesBlock::new, Block.Properties.ofFullCopy(Blocks.CYAN_WOOL).strength(0.8F).randomTicks().sound(SoundType.WOOL).noOcclusion());
	public static final DeferredBlock<WoolyLeavesBlock> PURPLE_WOOL_LEAVES = BLOCKS.registerBlock("purple_wool_leaves", WoolyLeavesBlock::new, Block.Properties.ofFullCopy(Blocks.PURPLE_WOOL).strength(0.8F).randomTicks().sound(SoundType.WOOL).noOcclusion());
	public static final DeferredBlock<WoolyLeavesBlock> BLUE_WOOL_LEAVES = BLOCKS.registerBlock("blue_wool_leaves", WoolyLeavesBlock::new, Block.Properties.ofFullCopy(Blocks.BLUE_WOOL).strength(0.8F).randomTicks().sound(SoundType.WOOL).noOcclusion());
	public static final DeferredBlock<WoolyLeavesBlock> BROWN_WOOL_LEAVES = BLOCKS.registerBlock("brown_wool_leaves", WoolyLeavesBlock::new, Block.Properties.ofFullCopy(Blocks.BROWN_WOOL).strength(0.8F).randomTicks().sound(SoundType.WOOL).noOcclusion());
	public static final DeferredBlock<WoolyLeavesBlock> GREEN_WOOL_LEAVES = BLOCKS.registerBlock("green_wool_leaves", WoolyLeavesBlock::new, Block.Properties.ofFullCopy(Blocks.GREEN_WOOL).strength(0.8F).randomTicks().sound(SoundType.WOOL).noOcclusion());
	public static final DeferredBlock<WoolyLeavesBlock> RED_WOOL_LEAVES = BLOCKS.registerBlock("red_wool_leaves", WoolyLeavesBlock::new, Block.Properties.ofFullCopy(Blocks.RED_WOOL).strength(0.8F).randomTicks().sound(SoundType.WOOL).noOcclusion());
	public static final DeferredBlock<WoolyLeavesBlock> BLACK_WOOL_LEAVES = BLOCKS.registerBlock("black_wool_leaves", WoolyLeavesBlock::new, Block.Properties.ofFullCopy(Blocks.BLACK_WOOL).strength(0.8F).randomTicks().sound(SoundType.WOOL).noOcclusion());

	public static final DeferredBlock<BeehiveBlock> WOOLY_BEE_NEST = BLOCKS.registerBlock("wooly_bee_nest", BeehiveBlock::new, Block.Properties.ofFullCopy(Blocks.ORANGE_WOOL).strength(0.8F).sound(SoundType.WOOL));

	public static final DeferredBlock<WoolySaplingBlock> WOOLY_SAPLING = BLOCKS.registerBlock("wooly_sapling", (properties) -> new WoolySaplingBlock(WoolTree.WOOL, properties), Block.Properties.ofFullCopy(Blocks.OAK_SAPLING).mapColor(MapColor.SNOW).noCollission().randomTicks().strength(0.0F).sound(SoundType.GRASS));
	public static final DeferredBlock<WoolySaplingBlock> JEB_SAPLING = BLOCKS.registerBlock("jeb_sapling", (properties) -> new WoolySaplingBlock(WoolTree.WOOL, properties), Block.Properties.ofFullCopy(Blocks.OAK_SAPLING).mapColor(MapColor.SNOW).noCollission().randomTicks().strength(0.0F).sound(SoundType.GRASS));

	// Items
	public static final DeferredItem<BlockItem> WHITE_WOOL_LEAVES_ITEM = ITEMS.registerSimpleBlockItem(WHITE_WOOL_LEAVES);
	public static final DeferredItem<BlockItem> ORANGE_WOOL_LEAVES_ITEM = ITEMS.registerSimpleBlockItem(ORANGE_WOOL_LEAVES);
	public static final DeferredItem<BlockItem> MAGENTA_WOOL_LEAVES_ITEM = ITEMS.registerSimpleBlockItem(MAGENTA_WOOL_LEAVES);
	public static final DeferredItem<BlockItem> LIGHT_BLUE_WOOL_LEAVES_ITEM = ITEMS.registerSimpleBlockItem(LIGHT_BLUE_WOOL_LEAVES);
	public static final DeferredItem<BlockItem> YELLOW_WOOL_LEAVES_ITEM = ITEMS.registerSimpleBlockItem(YELLOW_WOOL_LEAVES);
	public static final DeferredItem<BlockItem> LIME_WOOL_LEAVES_ITEM = ITEMS.registerSimpleBlockItem(LIME_WOOL_LEAVES);
	public static final DeferredItem<BlockItem> PINK_WOOL_LEAVES_ITEM = ITEMS.registerSimpleBlockItem(PINK_WOOL_LEAVES);
	public static final DeferredItem<BlockItem> GRAY_WOOL_LEAVES_ITEM = ITEMS.registerSimpleBlockItem(GRAY_WOOL_LEAVES);
	public static final DeferredItem<BlockItem> LIGHT_GRAY_WOOL_LEAVES_ITEM = ITEMS.registerSimpleBlockItem(LIGHT_GRAY_WOOL_LEAVES);
	public static final DeferredItem<BlockItem> CYAN_WOOL_LEAVES_ITEM = ITEMS.registerSimpleBlockItem(CYAN_WOOL_LEAVES);
	public static final DeferredItem<BlockItem> PURPLE_WOOL_LEAVES_ITEM = ITEMS.registerSimpleBlockItem(PURPLE_WOOL_LEAVES);
	public static final DeferredItem<BlockItem> BLUE_WOOL_LEAVES_ITEM = ITEMS.registerSimpleBlockItem(BLUE_WOOL_LEAVES);
	public static final DeferredItem<BlockItem> BROWN_WOOL_LEAVES_ITEM = ITEMS.registerSimpleBlockItem(BROWN_WOOL_LEAVES);
	public static final DeferredItem<BlockItem> GREEN_WOOL_LEAVES_ITEM = ITEMS.registerSimpleBlockItem(GREEN_WOOL_LEAVES);
	public static final DeferredItem<BlockItem> RED_WOOL_LEAVES_ITEM = ITEMS.registerSimpleBlockItem(RED_WOOL_LEAVES);
	public static final DeferredItem<BlockItem> BLACK_WOOL_LEAVES_ITEM = ITEMS.registerSimpleBlockItem(BLACK_WOOL_LEAVES);

	public static final DeferredItem<BlockItem> WOOLY_BEE_NEST_ITEM = ITEMS.registerSimpleBlockItem(WOOLY_BEE_NEST);

	public static final DeferredItem<SaplingBlockItem> WOOLY_SAPLING_ITEM = ITEMS.registerItem("wooly_sapling", (properties) -> new SaplingBlockItem(WOOLY_SAPLING.get(), properties));
	public static final DeferredItem<BlockItem> JEB_SAPLING_ITEM = ITEMS.registerSimpleBlockItem(JEB_SAPLING);


	public static final Supplier<CreativeModeTab> WOOLY_TAB = CREATIVE_MODE_TABS.register("tab", () -> CreativeModeTab.builder()
			.icon(() -> new ItemStack(Blocks.WHITE_WOOL))
			.withTabsBefore(CreativeModeTabs.SPAWN_EGGS)
			.title(Component.translatable("itemGroup.woolytrees.tab"))
			.displayItems((displayParameters, output) -> {
				List<ItemStack> stacks = WoolyRegistry.ITEMS.getEntries().stream().map(reg -> new ItemStack(reg.get())).toList();
				output.acceptAll(stacks);
			}).build());
}
