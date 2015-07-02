package buildcraftAdditions.core.achievement;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent;

import net.minecraftforge.common.AchievementPage;
import net.minecraftforge.common.MinecraftForge;

import buildcraftAdditions.api.item.BCAItemManager;
import buildcraftAdditions.api.item.dust.IDust;
import buildcraftAdditions.reference.BlockLoader;
import buildcraftAdditions.reference.ItemLoader;
import buildcraftAdditions.reference.Variables;

/**
 * Copyright (c) 2014-2015, AEnterprise
 * http://buildcraftadditions.wordpress.com/
 * Buildcraft Additions is distributed under the terms of GNU GPL v3.0
 * Please check the contents of the license located in
 * http://buildcraftadditions.wordpress.com/wiki/licensing-stuff/
 */
public class BCAAchievements {

	public static StatBCA dustsDusted;
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
	//TODO: Tool Core + Tool Upgrades
	//TODO: Machine Upgrades
	//TODO: Grinding Wheel as a duster crafting component
	//TODO: Wires (Iron, Gold, Diamond)
	//TODO: Heat plating as a refinery/cooling tower component
	//TODO: Refinery + Cooling Tower
	//TODO: Kinetic Backpack in conjunction with the backpack stand
	//TODO: Gilded Red Metal + Conductive Plating (^)
	//TODO: Rocket Pants

	//TODO: Special achievements


	public static void init() {

		dustsDusted = new StatBCA("dustsDusted");

		AchievementPage.registerAchievementPage(achievementPage);

		ironCanisterCrafting = new AchievementBCA("ironCanisterCrafting", -2, -2, ItemLoader.ironCanister);
		goldCanisterCrafting = new AchievementBCA("goldCanisterCrafting", 0, -2, ItemLoader.goldCanister, ironCanisterCrafting);
		diamondCanisterCrafting = new AchievementBCA("diamondCanisterCrafting", 2, -2, ItemLoader.diamondCanister, goldCanisterCrafting);

		powerCapsuleTier1Crafting = new AchievementBCA("powerCapsuleTier1Crafting", -2, -1, ItemLoader.powerCapsuleTier1);
		powerCapsuleTier2Crafting = new AchievementBCA("powerCapsuleTier2Crafting", 0, -1, ItemLoader.powerCapsuleTier2, powerCapsuleTier1Crafting);
		powerCapsuleTier3Crafting = new AchievementBCA("powerCapsuleTier3Crafting", 2, -1, ItemLoader.powerCapsuleTier3, powerCapsuleTier2Crafting);

		heatedFurnaceCrafting = new AchievementBCA("heatedFurnaceCrafting", -4, 0, BlockLoader.heatedFurnaceBlock);
		basicCoilCrafting = new AchievementBCA("basicCoilCrafting", -2, 0, BlockLoader.basicCoilBlock, heatedFurnaceCrafting);
		lavaCoilCrafting = new AchievementBCA("lavaCoilCrafting", 0, 0, BlockLoader.lavaCoilBlock, basicCoilCrafting);
		kineticCoilCrafting = new AchievementBCA("kineticCoilCrafting", 2, 0, BlockLoader.kineticCoil, lavaCoilCrafting);

		basicDusterCrafting = new AchievementBCA("basicDusterCrafting", -4, 1, BlockLoader.basicDusterBlock);
		semiAutomaticDusterCrafting = new AchievementBCA("semiAutomaticDusterCrafting", -2, 1, BlockLoader.semiAutomaticDusterBlock, basicDusterCrafting);
		mechanicalDusterCrafting = new AchievementBCA("mechanicalDusterCrafting", 0, 1, BlockLoader.mechanicalDusterBlock, semiAutomaticDusterCrafting);
		kineticDusterCrafting = new AchievementBCA("kineticDusterCrafting", 2, 1, BlockLoader.kineticDusterBlock, mechanicalDusterCrafting);

		kebT1Crafting = new AchievementBCA("kebT1Crafting", -2, -3, BlockLoader.kebT1);
		kebT2Crafting = new AchievementBCA("kebT2Crafting", 0, -3, BlockLoader.kebT2, kebT1Crafting);
		kebT3Crafting = new AchievementBCA("kebT3Crafting", 2, -3, BlockLoader.kebT3Core, kebT2Crafting);

		goldStickPickup = new AchievementBCA("goldStickPickup", 3, -1, ItemLoader.goldStick);
		diamondStickPickup = new AchievementBCA("diamondStickPickup", 3, -3, ItemLoader.diamondStick, goldStickPickup);
		enderStickPickup = new AchievementBCA("enderStickPickup", 3, 1, ItemLoader.enderStick, goldStickPickup);

		emeraldStickTrading = new AchievementBCA("emeraldStickTrading", -4, 2, ItemLoader.emeraldStick).setSpecial();
		netherStarStickPickup = new AchievementBCA("netherStarStickPickup", -2, 2, ItemLoader.netherStarStick, emeraldStickTrading).setSpecial();

		ironStickPickup = new AchievementBCA("ironStickPickup", 4, 2, ItemLoader.ironStick);
		quartzStickPickup = new AchievementBCA("quartzStickPickup", 4, 0, ItemLoader.quartzStick, ironStickPickup);
		redstoneStickPickup = new AchievementBCA("redstoneStickPickup", 6, 2, ItemLoader.redstoneStick, ironStickPickup);
		glowstoneStickPickup = new AchievementBCA("glowstoneStickPickup", 2, 2, ItemLoader.glowstoneStick, ironStickPickup);
		slimeStickPickup = new AchievementBCA("slimeStickPickup", 4, 4, ItemLoader.slimeStick, ironStickPickup);
		blazeStickPickup = new AchievementBCA("blazeStickPickup", 0, 2, ItemLoader.blazeStick, quartzStickPickup);

		fluidicCompressorCrafting = new AchievementBCA("fluidicCompressorCrafting", -3, -2, BlockLoader.fluidicCompressorBlock);

		chargingStationCrafting = new AchievementBCA("chargingStationCrafting", -3, -1, BlockLoader.chargingStationBlock);

		itemSorterCrafting = new AchievementBCA("itemSorterCrafting", -4, 3, BlockLoader.itemSorter);

		backpackStandCrafting = new AchievementBCA("backpackStandCrafting", -3, 3, BlockLoader.backpackStand);

		machineConfiguratorCrafting = new AchievementBCA("machineConfiguratorCrafting", -2, 3, ItemLoader.machineConfigurator);

		IDust dust = BCAItemManager.dusts.getDust("Diamond");
		dustPickup = new AchievementBCA("dustPickup", -1, 3, dust != null ? dust.getDustStack() : null);

		kineticMultiToolPickup = new AchievementBCA("kineticMultiToolPickup", 0, 3, ItemLoader.kineticMultiTool);

		pipeColoringToolCrafting = new AchievementBCA("pipeColoringToolCrafting", 1, 3, ItemLoader.pipeColoringTool);

		portableLaserPickup = new AchievementBCA("portableLaserPickup", 2, 3, ItemLoader.portableLaser);

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
