package com.mrbysco.woolytrees.generator.server;

import com.mrbysco.woolytrees.registry.WoolyRegistry;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.data.loot.LootTableProvider;
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
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraft.world.level.storage.loot.predicates.BonusLevelTableCondition;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;

import java.util.List;
import java.util.Set;
import java.util.concurrent.CompletableFuture;

public class WoolyLootProvider extends LootTableProvider {
	public WoolyLootProvider(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> lookupProvider) {
		super(packOutput, Set.of(), List.of(
						new SubProviderEntry(WoolyBlockLootTables::new, LootContextParamSets.BLOCK))
				, lookupProvider);
	}

	private static class WoolyBlockLootTables extends BlockLootSubProvider {
		protected WoolyBlockLootTables(HolderLookup.Provider provider) {
			super(Set.of(), FeatureFlags.REGISTRY.allFlags(), provider);
		}

		private final float[] DEFAULT_SAPLING_DROP_RATES = new float[]{0.05F, 0.0625F, 0.083333336F, 0.1F};

		@Override
		protected void generate() {
			this.add(WoolyRegistry.WHITE_WOOL_LEAVES.get(), dropWoolWithStringAndChance(Blocks.WHITE_WOOL, WoolyRegistry.WOOLY_SAPLING.get(), DEFAULT_SAPLING_DROP_RATES));
			this.add(WoolyRegistry.ORANGE_WOOL_LEAVES.get(), dropWoolWithStringAndChance(Blocks.ORANGE_WOOL, WoolyRegistry.WOOLY_SAPLING.get(), DEFAULT_SAPLING_DROP_RATES));
			this.add(WoolyRegistry.MAGENTA_WOOL_LEAVES.get(), dropWoolWithStringAndChance(Blocks.MAGENTA_WOOL, WoolyRegistry.WOOLY_SAPLING.get(), DEFAULT_SAPLING_DROP_RATES));
			this.add(WoolyRegistry.LIGHT_BLUE_WOOL_LEAVES.get(), dropWoolWithStringAndChance(Blocks.LIGHT_BLUE_WOOL, WoolyRegistry.WOOLY_SAPLING.get(), DEFAULT_SAPLING_DROP_RATES));
			this.add(WoolyRegistry.YELLOW_WOOL_LEAVES.get(), dropWoolWithStringAndChance(Blocks.YELLOW_WOOL, WoolyRegistry.WOOLY_SAPLING.get(), DEFAULT_SAPLING_DROP_RATES));
			this.add(WoolyRegistry.LIME_WOOL_LEAVES.get(), dropWoolWithStringAndChance(Blocks.LIME_WOOL, WoolyRegistry.WOOLY_SAPLING.get(), DEFAULT_SAPLING_DROP_RATES));
			this.add(WoolyRegistry.PINK_WOOL_LEAVES.get(), dropWoolWithStringAndChance(Blocks.PINK_WOOL, WoolyRegistry.WOOLY_SAPLING.get(), DEFAULT_SAPLING_DROP_RATES));
			this.add(WoolyRegistry.GRAY_WOOL_LEAVES.get(), dropWoolWithStringAndChance(Blocks.GRAY_WOOL, WoolyRegistry.WOOLY_SAPLING.get(), DEFAULT_SAPLING_DROP_RATES));
			this.add(WoolyRegistry.LIGHT_GRAY_WOOL_LEAVES.get(), dropWoolWithStringAndChance(Blocks.LIGHT_GRAY_WOOL, WoolyRegistry.WOOLY_SAPLING.get(), DEFAULT_SAPLING_DROP_RATES));
			this.add(WoolyRegistry.CYAN_WOOL_LEAVES.get(), dropWoolWithStringAndChance(Blocks.CYAN_WOOL, WoolyRegistry.WOOLY_SAPLING.get(), DEFAULT_SAPLING_DROP_RATES));
			this.add(WoolyRegistry.PURPLE_WOOL_LEAVES.get(), dropWoolWithStringAndChance(Blocks.PURPLE_WOOL, WoolyRegistry.WOOLY_SAPLING.get(), DEFAULT_SAPLING_DROP_RATES));
			this.add(WoolyRegistry.BLUE_WOOL_LEAVES.get(), dropWoolWithStringAndChance(Blocks.BLUE_WOOL, WoolyRegistry.WOOLY_SAPLING.get(), DEFAULT_SAPLING_DROP_RATES));
			this.add(WoolyRegistry.BROWN_WOOL_LEAVES.get(), dropWoolWithStringAndChance(Blocks.BROWN_WOOL, WoolyRegistry.WOOLY_SAPLING.get(), DEFAULT_SAPLING_DROP_RATES));
			this.add(WoolyRegistry.GREEN_WOOL_LEAVES.get(), dropWoolWithStringAndChance(Blocks.GREEN_WOOL, WoolyRegistry.WOOLY_SAPLING.get(), DEFAULT_SAPLING_DROP_RATES));
			this.add(WoolyRegistry.RED_WOOL_LEAVES.get(), dropWoolWithStringAndChance(Blocks.RED_WOOL, WoolyRegistry.WOOLY_SAPLING.get(), DEFAULT_SAPLING_DROP_RATES));
			this.add(WoolyRegistry.BLACK_WOOL_LEAVES.get(), dropWoolWithStringAndChance(Blocks.BLACK_WOOL, WoolyRegistry.WOOLY_SAPLING.get(), DEFAULT_SAPLING_DROP_RATES));

			this.add(WoolyRegistry.WOOLY_BEE_NEST.get(), this::createBeeNestDrop);

			this.dropSelf(WoolyRegistry.WOOLY_SAPLING.get());
			this.dropSelf(WoolyRegistry.JEB_SAPLING.get());
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
			return (Iterable<Block>) WoolyRegistry.BLOCKS.getEntries().stream().map(holder -> (Block) holder.get())::iterator;
		}
	}
}
