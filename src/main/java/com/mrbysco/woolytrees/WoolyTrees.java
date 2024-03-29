package com.mrbysco.woolytrees;

import com.mojang.logging.LogUtils;
import com.mrbysco.woolytrees.config.WoolyConfig;
import com.mrbysco.woolytrees.handler.InteractionHandler;
import com.mrbysco.woolytrees.registry.WoolyFeatureConfig;
import com.mrbysco.woolytrees.registry.WoolyRegistry;
import com.mrbysco.woolytrees.registry.WoolyTags;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

@Mod(Reference.MOD_ID)
public class WoolyTrees {
	public static final Logger LOGGER = LogUtils.getLogger();

	public WoolyTrees() {
		IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();
		ModLoadingContext.get().registerConfig(ModConfig.Type.SERVER, WoolyConfig.serverSpec);
		eventBus.register(WoolyConfig.class);

		eventBus.addListener(this::setup);

		WoolyRegistry.BLOCKS.register(eventBus);
		WoolyRegistry.ITEMS.register(eventBus);
		WoolyRegistry.CREATIVE_MODE_TABS.register(eventBus);
		WoolyRegistry.FEATURES.register(eventBus);

		MinecraftForge.EVENT_BUS.register(new InteractionHandler());
	}

	private void setup(final FMLCommonSetupEvent event) {
		WoolyTags.initialize();
		WoolyFeatureConfig.initialize();
	}
}
