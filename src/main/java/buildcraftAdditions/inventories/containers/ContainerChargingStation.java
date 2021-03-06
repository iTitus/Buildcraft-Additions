package buildcraftAdditions.inventories.containers;


import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

import cofh.api.energy.IEnergyContainerItem;

import buildcraftAdditions.tileEntities.TileChargingStation;

/**
 * Copyright (c) 2014-2015, AEnterprise
 * http://buildcraftadditions.wordpress.com/
 * Buildcraft Additions is distributed under the terms of GNU GPL v3.0
 * Please check the contents of the license located in
 * http://buildcraftadditions.wordpress.com/wiki/licensing-stuff/
 */
public class ContainerChargingStation extends ContainerBase<TileChargingStation> {

	public ContainerChargingStation(InventoryPlayer inventoryPlayer, TileChargingStation tile) {
		super(inventoryPlayer, tile);
		addSlotToContainer(new Slot(tile, 0, 80, 30) {

			@Override
			public int getSlotStackLimit() {
				return 1;
			}

			@Override
			public boolean isItemValid(ItemStack stack) {
				return stack != null && stack.getItem() != null && stack.getItem() instanceof IEnergyContainerItem;
			}

		});
		addPlayerInventory(8, 71);
	}

}
