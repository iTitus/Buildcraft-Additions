package buildcraftAdditions.core.achievement;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent;

import net.minecraftforge.common.AchievementPage;
import net.minecraftforge.common.MinecraftForge;

import buildcraftAdditions.reference.ItemsAndBlocks;
import buildcraftAdditions.reference.Variables;

/**
 * Copyright (c) 2014-2015, AEnterprise
 * http://buildcraftadditions.wordpress.com/
 * Buildcraft Additions is distributed under the terms of GNU GPL v3.0
 * Please check the contents of the license located in
 * http://buildcraftadditions.wordpress.com/wiki/licensing-stuff/
 */
public class BCAAchievements {

	public static AchievementPage achievementPage = new AchievementPage(Variables.MOD.NAME);
	public static AchievementBCA
			ironCanisterCrafting,
			goldCanisterCrafting,
			diamondCanisterCrafting,
			powerCapsuleTier1Crafting,
			powerCapsuleTier2Crafting,
			powerCapsuleTier3Crafting,
			heatedFurnaceCrafting,
			basicCoilCrafting,
			lavaCoilCrafting,
			kineticCoilCrafting,
			basicDusterCrafting,
			semiAutomaticDusterCrafting,
			mechanicalDusterCrafting,
			kineticDusterCrafting,
			kebT1Crafting,
			kebT2Crafting,
			kebT3Crafting,
			ironStickPickup,
			goldStickPickup,
			diamondStickPickup,
			emeraldStickTrading,
			netherStarStickPickup,
			quartzStickPickup,
			enderStickPickup,
			redstoneStickPickup,
			glowstoneStickPickup,
			slimeStickPickup,
			blazeStickPickup,
			fluidicCompressorCrafting,
			chargingStationCrafting,
			itemSorterCrafting,
			backpackStandCrafting,
			machineConfiguratorCrafting,
			dustPickup,
			kineticMultiToolPickup,
			pipeColoringToolCrafting,
			portableLaserPickup;
	//TODO: Tool Core + Upgrades
	//TODO: Machine Upgrades


	public static void init() {
		AchievementPage.registerAchievementPage(achievementPage);

		ironCanisterCrafting = new AchievementBCA("ironCanisterCrafting", -2, -2, ItemsAndBlocks.ironCanister);
		goldCanisterCrafting = new AchievementBCA("goldCanisterCrafting", 0, -2, ItemsAndBlocks.goldCanister, ironCanisterCrafting);
		diamondCanisterCrafting = new AchievementBCA("diamondCanisterCrafting", 2, -2, ItemsAndBlocks.diamondCanister, goldCanisterCrafting);

		powerCapsuleTier1Crafting = new AchievementBCA("powerCapsuleTier1Crafting", -2, -1, ItemsAndBlocks.powerCapsuleTier1);
		powerCapsuleTier2Crafting = new AchievementBCA("powerCapsuleTier2Crafting", 0, -1, ItemsAndBlocks.powerCapsuleTier2, powerCapsuleTier1Crafting);
		powerCapsuleTier3Crafting = new AchievementBCA("powerCapsuleTier3Crafting", 2, -1, ItemsAndBlocks.powerCapsuleTier3, powerCapsuleTier2Crafting);

		heatedFurnaceCrafting = new AchievementBCA("heatedFurnaceCrafting", -4, 0, ItemsAndBlocks.heatedFurnaceBlock);
		basicCoilCrafting = new AchievementBCA("basicCoilCrafting", -2, 0, ItemsAndBlocks.basicCoilBlock, heatedFurnaceCrafting);
		lavaCoilCrafting = new AchievementBCA("lavaCoilCrafting", 0, 0, ItemsAndBlocks.lavaCoilBlock, basicCoilCrafting);
		kineticCoilCrafting = new AchievementBCA("kineticCoilCrafting", 2, 0, ItemsAndBlocks.kineticCoil, lavaCoilCrafting);

		basicDusterCrafting = new AchievementBCA("basicDusterCrafting", -4, 1, ItemsAndBlocks.basicDusterBlock);
		semiAutomaticDusterCrafting = new AchievementBCA("semiAutomaticDusterCrafting", -2, 1, ItemsAndBlocks.semiAutomaticDusterBlock, basicDusterCrafting);
		mechanicalDusterCrafting = new AchievementBCA("mechanicalDusterCrafting", 0, 1, ItemsAndBlocks.mechanicalDusterBlock, semiAutomaticDusterCrafting);
		kineticDusterCrafting = new AchievementBCA("kineticDusterCrafting", 2, 1, ItemsAndBlocks.kineticDusterBlock, mechanicalDusterCrafting);

		kebT1Crafting = new AchievementBCA("kebT1Crafting", -2, -3, ItemsAndBlocks.kebT1);
		kebT2Crafting = new AchievementBCA("kebT2Crafting", 0, -3, ItemsAndBlocks.kebT2, kebT1Crafting);
		kebT3Crafting = new AchievementBCA("kebT3Crafting", 2, -3, ItemsAndBlocks.kebT3Core, kebT2Crafting);

		goldStickPickup = new AchievementBCA("goldStickPickup", 3, -1, ItemsAndBlocks.goldStick);
		diamondStickPickup = new AchievementBCA("diamondStickPickup", 3, -3, ItemsAndBlocks.diamondStick, goldStickPickup);
		enderStickPickup = new AchievementBCA("enderStickPickup", 3, 1, ItemsAndBlocks.enderStick, goldStickPickup);

		emeraldStickTrading = new AchievementBCA("emeraldStickTrading", -4, 2, ItemsAndBlocks.emeraldStick).setSpecial();
		netherStarStickPickup = new AchievementBCA("netherStarStickPickup", -2, 2, ItemsAndBlocks.netherStarStick, emeraldStickTrading).setSpecial();

		ironStickPickup = new AchievementBCA("ironStickPickup", 4, 2, ItemsAndBlocks.ironStick);
		quartzStickPickup = new AchievementBCA("quartzStickPickup", 4, 0, ItemsAndBlocks.quartzStick, ironStickPickup);
		redstoneStickPickup = new AchievementBCA("redstoneStickPickup", 6, 2, ItemsAndBlocks.redstoneStick, ironStickPickup);
		glowstoneStickPickup = new AchievementBCA("glowstoneStickPickup", 2, 2, ItemsAndBlocks.glowstoneStick, ironStickPickup);
		slimeStickPickup = new AchievementBCA("slimeStickPickup", 4, 4, ItemsAndBlocks.slimeStick, ironStickPickup);
		blazeStickPickup = new AchievementBCA("blazeStickPickup", 0, 2, ItemsAndBlocks.blazeStick, quartzStickPickup);

		fluidicCompressorCrafting = new AchievementBCA("fluidicCompressorCrafting", -3, -2, ItemsAndBlocks.fluidicCompressorBlock);

		chargingStationCrafting = new AchievementBCA("chargingStationCrafting", -3, -1, ItemsAndBlocks.chargingStationBlock);

		BCAAchievementEventHandler eventHandler = new BCAAchievementEventHandler();
		FMLCommonHandler.instance().bus().register(eventHandler);
		MinecraftForge.EVENT_BUS.register(eventHandler);
	}

	public static AchievementBCA registerAchievement(AchievementBCA achievement) {
		if (achievement != null && achievement.isValid() && !achievementPage.getAchievements().contains(achievement)) {
			achievement.registerStat();
			achievementPage.getAchievements().add(achievement);
		}
		return achievement;
	}

	public static class BCAAchievementEventHandler {

		@SubscribeEvent
		public void onItemCrafted(PlayerEvent.ItemCraftedEvent event) {
			if (event.player != null && event.crafting != null && event.crafting.getItem() != null) {
				if (event.crafting.getItem() instanceof ICraftingAchievement) {
					AchievementBCA achievementBCA = ((ICraftingAchievement) event.crafting.getItem()).getAchievement(event.player, event.crafting, event.craftMatrix);
					if (achievementBCA != null)
						achievementBCA.trigger(event.player);
				} else if (event.crafting.getItem() instanceof ItemBlock) {
					Block block = ((ItemBlock) event.crafting.getItem()).field_150939_a;
					if (block instanceof ICraftingAchievement) {
						AchievementBCA achievementBCA = ((ICraftingAchievement) block).getAchievement(event.player, event.crafting, event.craftMatrix);
						if (achievementBCA != null)
							achievementBCA.trigger(event.player);
					}
				}
			}
		}

		@SubscribeEvent
		public void onItemPickup(PlayerEvent.ItemPickupEvent event) {
			if (event.player != null && event.pickedUp != null && event.pickedUp.getEntityItem() != null && event.pickedUp.getEntityItem().getItem() != null) {
				if (event.pickedUp.getEntityItem().getItem() instanceof IPickupAchievement) {
					AchievementBCA achievementBCA = ((IPickupAchievement) event.pickedUp.getEntityItem().getItem()).getAchievement(event.player, event.pickedUp);
					if (achievementBCA != null)
						achievementBCA.trigger(event.player);
				} else if (event.pickedUp.getEntityItem().getItem() instanceof ItemBlock) {
					Block block = ((ItemBlock) event.pickedUp.getEntityItem().getItem()).field_150939_a;
					if (block instanceof IPickupAchievement) {
						AchievementBCA achievementBCA = ((IPickupAchievement) block).getAchievement(event.player, event.pickedUp);
						if (achievementBCA != null)
							achievementBCA.trigger(event.player);
					}
				}
			}
		}

	}

}
