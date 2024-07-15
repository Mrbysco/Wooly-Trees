package com.mrbysco.woolytrees.generator;

import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.entries.LootPoolEntryContainer;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.BonusLevelTableCondition;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;

import java.util.Set;

import static com.mrbysco.woolytrees.registry.WoolyRegistry.BLACK_WOOL_LEAVES;
import static com.mrbysco.woolytrees.registry.WoolyRegistry.BLOCKS;
import static com.mrbysco.woolytrees.registry.WoolyRegistry.BLUE_WOOL_LEAVES;
import static com.mrbysco.woolytrees.registry.WoolyRegistry.BROWN_WOOL_LEAVES;
import static com.mrbysco.woolytrees.registry.WoolyRegistry.CYAN_WOOL_LEAVES;
import static com.mrbysco.woolytrees.registry.WoolyRegistry.GRAY_WOOL_LEAVES;
import static com.mrbysco.woolytrees.registry.WoolyRegistry.GREEN_WOOL_LEAVES;
import static com.mrbysco.woolytrees.registry.WoolyRegistry.JEB_SAPLING;
import static com.mrbysco.woolytrees.registry.WoolyRegistry.LIGHT_BLUE_WOOL_LEAVES;
import static com.mrbysco.woolytrees.registry.WoolyRegistry.LIGHT_GRAY_WOOL_LEAVES;
import static com.mrbysco.woolytrees.registry.WoolyRegistry.LIME_WOOL_LEAVES;
import static com.mrbysco.woolytrees.registry.WoolyRegistry.MAGENTA_WOOL_LEAVES;
import static com.mrbysco.woolytrees.registry.WoolyRegistry.ORANGE_WOOL_LEAVES;
import static com.mrbysco.woolytrees.registry.WoolyRegistry.PINK_WOOL_LEAVES;
import static com.mrbysco.woolytrees.registry.WoolyRegistry.PURPLE_WOOL_LEAVES;
import static com.mrbysco.woolytrees.registry.WoolyRegistry.RED_WOOL_LEAVES;
import static com.mrbysco.woolytrees.registry.WoolyRegistry.WHITE_WOOL_LEAVES;
import static com.mrbysco.woolytrees.registry.WoolyRegistry.WOOLY_BEE_NEST;
import static com.mrbysco.woolytrees.registry.WoolyRegistry.WOOLY_SAPLING;
import static com.mrbysco.woolytrees.registry.WoolyRegistry.YELLOW_WOOL_LEAVES;

public class WoolyBlockLootTables extends BlockLootSubProvider {

	protected WoolyBlockLootTables(HolderLookup.Provider provider) {
		super(Set.of(), FeatureFlags.REGISTRY.allFlags(), provider);
	}

	private final float[] DEFAULT_SAPLING_DROP_RATES = new float[]{0.05F, 0.0625F, 0.083333336F, 0.1F};

	@Override
	protected void generate() {
		this.add(WHITE_WOOL_LEAVES.get(), dropWoolWithStringAndChance(Blocks.WHITE_WOOL, WOOLY_SAPLING.get(), DEFAULT_SAPLING_DROP_RATES));
		this.add(ORANGE_WOOL_LEAVES.get(), dropWoolWithStringAndChance(Blocks.ORANGE_WOOL, WOOLY_SAPLING.get(), DEFAULT_SAPLING_DROP_RATES));
		this.add(MAGENTA_WOOL_LEAVES.get(), dropWoolWithStringAndChance(Blocks.MAGENTA_WOOL, WOOLY_SAPLING.get(), DEFAULT_SAPLING_DROP_RATES));
		this.add(LIGHT_BLUE_WOOL_LEAVES.get(), dropWoolWithStringAndChance(Blocks.LIGHT_BLUE_WOOL, WOOLY_SAPLING.get(), DEFAULT_SAPLING_DROP_RATES));
		this.add(YELLOW_WOOL_LEAVES.get(), dropWoolWithStringAndChance(Blocks.YELLOW_WOOL, WOOLY_SAPLING.get(), DEFAULT_SAPLING_DROP_RATES));
		this.add(LIME_WOOL_LEAVES.get(), dropWoolWithStringAndChance(Blocks.LIME_WOOL, WOOLY_SAPLING.get(), DEFAULT_SAPLING_DROP_RATES));
		this.add(PINK_WOOL_LEAVES.get(), dropWoolWithStringAndChance(Blocks.PINK_WOOL, WOOLY_SAPLING.get(), DEFAULT_SAPLING_DROP_RATES));
		this.add(GRAY_WOOL_LEAVES.get(), dropWoolWithStringAndChance(Blocks.GRAY_WOOL, WOOLY_SAPLING.get(), DEFAULT_SAPLING_DROP_RATES));
		this.add(LIGHT_GRAY_WOOL_LEAVES.get(), dropWoolWithStringAndChance(Blocks.LIGHT_GRAY_WOOL, WOOLY_SAPLING.get(), DEFAULT_SAPLING_DROP_RATES));
		this.add(CYAN_WOOL_LEAVES.get(), dropWoolWithStringAndChance(Blocks.CYAN_WOOL, WOOLY_SAPLING.get(), DEFAULT_SAPLING_DROP_RATES));
		this.add(PURPLE_WOOL_LEAVES.get(), dropWoolWithStringAndChance(Blocks.PURPLE_WOOL, WOOLY_SAPLING.get(), DEFAULT_SAPLING_DROP_RATES));
		this.add(BLUE_WOOL_LEAVES.get(), dropWoolWithStringAndChance(Blocks.BLUE_WOOL, WOOLY_SAPLING.get(), DEFAULT_SAPLING_DROP_RATES));
		this.add(BROWN_WOOL_LEAVES.get(), dropWoolWithStringAndChance(Blocks.BROWN_WOOL, WOOLY_SAPLING.get(), DEFAULT_SAPLING_DROP_RATES));
		this.add(GREEN_WOOL_LEAVES.get(), dropWoolWithStringAndChance(Blocks.GREEN_WOOL, WOOLY_SAPLING.get(), DEFAULT_SAPLING_DROP_RATES));
		this.add(RED_WOOL_LEAVES.get(), dropWoolWithStringAndChance(Blocks.RED_WOOL, WOOLY_SAPLING.get(), DEFAULT_SAPLING_DROP_RATES));
		this.add(BLACK_WOOL_LEAVES.get(), dropWoolWithStringAndChance(Blocks.BLACK_WOOL, WOOLY_SAPLING.get(), DEFAULT_SAPLING_DROP_RATES));

		this.add(WOOLY_BEE_NEST.get(), this::createBeeNestDrop);

		this.dropSelf(WOOLY_SAPLING.get());
		this.dropSelf(JEB_SAPLING.get());
	}

	protected LootTable.Builder createSilkTouchOrShearsDispatchTable(Block block, LootPoolEntryContainer.Builder<?> builder) {
		return createSelfDropDispatchTable(block, HAS_SHEARS.or(hasSilkTouch()), builder);
	}

	protected LootTable.Builder dropWoolWithStringAndChance(Block wool, Block sapling, float... values) {
		HolderLookup.RegistryLookup<Enchantment> registrylookup = this.registries.lookupOrThrow(Registries.ENCHANTMENT);
		return createSilkTouchOrShearsDispatchTable(wool, applyExplosionCondition(wool, LootItem.lootTableItem(sapling))
				.when(BonusLevelTableCondition.bonusLevelFlatChance(registrylookup.getOrThrow(Enchantments.FORTUNE), values))).withPool(LootPool.lootPool()
				.setRolls(ConstantValue.exactly(1)).when(HAS_SHEARS.or(this.hasSilkTouch()).invert()).add(applyExplosionDecay(wool, LootItem.lootTableItem(Items.STRING)
						.apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 2.0F))))
						.when(BonusLevelTableCondition.bonusLevelFlatChance(registrylookup.getOrThrow(Enchantments.FORTUNE), 0.02F, 0.022222223F, 0.025F, 0.033333335F, 0.1F))));
	}

	@Override
	protected Iterable<Block> getKnownBlocks() {
		return (Iterable<Block>) BLOCKS.getEntries().stream().map(holder -> (Block) holder.get())::iterator;
	}
}
