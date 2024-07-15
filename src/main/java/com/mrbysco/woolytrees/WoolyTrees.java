package com.mrbysco.woolytrees;

import com.mojang.logging.LogUtils;
import com.mrbysco.woolytrees.config.WoolyConfig;
import com.mrbysco.woolytrees.handler.InteractionHandler;
import com.mrbysco.woolytrees.handler.TreeHandler;
import com.mrbysco.woolytrees.registry.WoolyFeatureConfig;
import com.mrbysco.woolytrees.registry.WoolyRegistry;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.neoforge.common.NeoForge;
import org.slf4j.Logger;

@Mod(Reference.MOD_ID)
public class WoolyTrees {
	public static final Logger LOGGER = LogUtils.getLogger();

	public WoolyTrees(IEventBus eventBus, Dist dist, ModContainer container) {
		container.registerConfig(ModConfig.Type.SERVER, WoolyConfig.serverSpec);
		eventBus.register(WoolyConfig.class);

		WoolyRegistry.BLOCKS.register(eventBus);
		WoolyRegistry.ITEMS.register(eventBus);
		WoolyRegistry.CREATIVE_MODE_TABS.register(eventBus);
		WoolyFeatureConfig.TRUNK_PLACER.register(eventBus);
		WoolyRegistry.FEATURES.register(eventBus);

		NeoForge.EVENT_BUS.register(new InteractionHandler());
		NeoForge.EVENT_BUS.register(new TreeHandler());
	}
}
