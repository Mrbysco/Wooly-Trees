package com.mrbysco.woolytrees.config;

import com.mrbysco.woolytrees.WoolyTrees;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.event.config.ModConfigEvent;
import net.neoforged.neoforge.common.ModConfigSpec;
import net.neoforged.neoforge.common.ModConfigSpec.BooleanValue;
import net.neoforged.neoforge.common.ModConfigSpec.DoubleValue;
import org.apache.commons.lang3.tuple.Pair;

public class WoolyConfig {
	public static class Server {
		public final BooleanValue saplingFromSheep;
		public final DoubleValue saplingPercentage;

		Server(ModConfigSpec.Builder builder) {
			builder.comment("Server settings")
					.push("Server");

			saplingFromSheep = builder
					.comment("When enabled you get the Wooly sapling from right-clicking a sheep (default: true)")
					.define("saplingFromSheep", true);

			saplingPercentage = builder
					.comment("The percentage in which you get the sapling [0.1 = 10%] (default: 0.1)")
					.defineInRange("saplingPercentage", 0.1D, 0.0D, 1.0D);

			builder.pop();
		}
	}

	public static final ModConfigSpec serverSpec;
	public static final Server SERVER;

	static {
		final Pair<Server, ModConfigSpec> specPair = new ModConfigSpec.Builder().configure(Server::new);
		serverSpec = specPair.getRight();
		SERVER = specPair.getLeft();
	}

	@SubscribeEvent
	public static void onLoad(final ModConfigEvent.Loading configEvent) {
		WoolyTrees.LOGGER.debug("Loaded Wooly Trees' config file {}", configEvent.getConfig().getFileName());
	}

	@SubscribeEvent
	public static void onFileChange(final ModConfigEvent.Reloading configEvent) {
		WoolyTrees.LOGGER.debug("Wooly Trees' config just got changed on the file system!");
	}
}
