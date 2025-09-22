package com.mrbysco.woolytrees.handler;

import com.mrbysco.woolytrees.config.WoolyConfig;
import com.mrbysco.woolytrees.registry.WoolyRegistry;
import com.mrbysco.woolytrees.registry.WoolyTags;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.animal.Sheep;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;

public class InteractionHandler {
	@SubscribeEvent
	public void onWorldTick(PlayerInteractEvent.EntityInteract event) {
		if (event.getSide().isServer() && WoolyConfig.SERVER.saplingFromSheep.get() && event.getTarget() instanceof Sheep sheep) {
			Player player = event.getEntity();
			if (event.getLevel().random.nextDouble() <= WoolyConfig.SERVER.saplingPercentage.get() && !sheep.isSheared() && event.getItemStack().is(WoolyTags.CONVERTING_SAPLING)) {
				if (!player.getAbilities().instabuild) {
					ItemStack interactStack = event.getItemStack();
					interactStack.shrink(1);
				}
				ItemStack woolySapling = new ItemStack(WoolyRegistry.WOOLY_SAPLING_ITEM.get());
				if (sheep.getDisplayName().getString().equals("jeb_")) {
					woolySapling = new ItemStack(WoolyRegistry.JEB_SAPLING.get());
				}
				//Drop item
				sheep.spawnAtLocation((ServerLevel) event.getLevel(), woolySapling, 0.5F);

				sheep.setSheared(true);
				sheep.playSound(SoundEvents.SHEEP_SHEAR, 1.0F, 1.0F);
			} else {
				player.swing(event.getHand());
			}
		}
	}
}
