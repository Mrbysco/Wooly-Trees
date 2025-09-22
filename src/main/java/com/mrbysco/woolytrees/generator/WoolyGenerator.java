package com.mrbysco.woolytrees.generator;

import com.mrbysco.woolytrees.Reference;
import com.mrbysco.woolytrees.generator.client.WoolyLanguageProvider;
import com.mrbysco.woolytrees.generator.client.WoolyModelProvider;
import com.mrbysco.woolytrees.generator.server.WoolyBlockTagsProvider;
import com.mrbysco.woolytrees.generator.server.WoolyDatapackProvider;
import com.mrbysco.woolytrees.generator.server.WoolyItemTagsProvider;
import com.mrbysco.woolytrees.generator.server.WoolyLootProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.data.event.GatherDataEvent;

import java.util.Set;
import java.util.concurrent.CompletableFuture;

@EventBusSubscriber
public class WoolyGenerator {
	@SubscribeEvent
	public static void gatherData(GatherDataEvent.Client event) {
		DataGenerator generator = event.getGenerator();
		PackOutput packOutput = generator.getPackOutput();
		CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();

		generator.addProvider(true, new WoolyDatapackProvider(
				packOutput,
				event.getLookupProvider(),
				Set.of(Reference.MOD_ID)
		));

		generator.addProvider(true, new WoolyLootProvider(packOutput, lookupProvider));
		generator.addProvider(true, new WoolyBlockTagsProvider(packOutput, lookupProvider));
		generator.addProvider(true, new WoolyItemTagsProvider(packOutput, lookupProvider));

		generator.addProvider(true, new WoolyLanguageProvider(packOutput));
		generator.addProvider(true, new WoolyModelProvider(packOutput));

	}
}
