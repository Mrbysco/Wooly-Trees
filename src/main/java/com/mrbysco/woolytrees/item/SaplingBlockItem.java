package com.mrbysco.woolytrees.item;

import com.mrbysco.woolytrees.registry.WoolyRegistry;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import org.jetbrains.annotations.Nullable;

public class SaplingBlockItem extends BlockItem {
	public SaplingBlockItem(Block blockIn, Properties builder) {
		super(blockIn, builder);
	}

	@Override
	public void inventoryTick(ItemStack stack, ServerLevel level, Entity entity, @Nullable EquipmentSlot slot) {
		if (entity instanceof Player player && stack.getHoverName().getString().equals("jeb_")) {
			ItemStack copyStack = stack.copy();
			ItemStack newStack = new ItemStack(WoolyRegistry.JEB_SAPLING_ITEM, copyStack.getCount(), copyStack.getComponentsPatch());
			player.addItem(newStack);
			stack.shrink(stack.getCount());
		}
		super.inventoryTick(stack, level, entity, slot);
	}
}
