package com.mrbysco.woolytrees.generator;

import com.mrbysco.woolytrees.Reference;
import com.mrbysco.woolytrees.generator.client.WoolyBlockStatesProvider;
import com.mrbysco.woolytrees.generator.client.WoolyItemModelsProvider;
import com.mrbysco.woolytrees.generator.client.WoolyLanguageProvider;
import com.mrbysco.woolytrees.generator.server.WoolyBlockTagsProvider;
import com.mrbysco.woolytrees.generator.server.WoolyDatapackProvider;
import com.mrbysco.woolytrees.generator.server.WoolyItemTagsProvider;
import com.mrbysco.woolytrees.generator.server.WoolyLootProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.data.event.GatherDataEvent;

import java.util.Set;
import java.util.concurrent.CompletableFuture;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public class WoolyGenerator {
	@SubscribeEvent
	public static void gatherData(GatherDataEvent event) {
		DataGenerator generator = event.getGenerator();
		PackOutput packOutput = generator.getPackOutput();
		CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();
		ExistingFileHelper helper = event.getExistingFileHelper();

		generator.addProvider(true, new WoolyDatapackProvider(
				packOutput,
				event.getLookupProvider(),
				Set.of(Reference.MOD_ID)
		));

		if (event.includeServer()) {
			generator.addProvider(event.includeServer(), new WoolyLootProvider(packOutput, lookupProvider));
			WoolyBlockTagsProvider blockTags = new WoolyBlockTagsProvider(packOutput, lookupProvider, helper);
			generator.addProvider(event.includeServer(), blockTags);
			generator.addProvider(event.includeServer(), new WoolyItemTagsProvider(packOutput, lookupProvider, blockTags.contentsGetter(), helper));
		}
		if (event.includeClient()) {
			generator.addProvider(event.includeServer(), new WoolyLanguageProvider(packOutput));
			generator.addProvider(event.includeServer(), new WoolyBlockStatesProvider(packOutput, helper));
			generator.addProvider(event.includeServer(), new WoolyItemModelsProvider(packOutput, helper));
		}
	}
}
