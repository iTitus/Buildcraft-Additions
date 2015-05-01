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
			semiAutomaticDusterCafting,
			mechanicalDusterCrafting,
			kineticDusterCafting,
			kebT1Crafting,
			kebT2Crafting,
			kebT3Cafting;


	public static void init() {
		AchievementPage.registerAchievementPage(achievementPage);

		ironCanisterCrafting = new AchievementBCA("ironCanisterCrafting", 0, -2, ItemsAndBlocks.ironCanister);
		goldCanisterCrafting = new AchievementBCA("goldCanisterCrafting", 2, -2, ItemsAndBlocks.goldCanister, ironCanisterCrafting);
		diamondCanisterCrafting = new AchievementBCA("diamondCanisterCrafting", 4, -2, ItemsAndBlocks.diamondCanister, goldCanisterCrafting);
		powerCapsuleTier1Crafting = new AchievementBCA("powerCapsuleTier1Crafting", 0, -1, ItemsAndBlocks.powerCapsuleTier1);
		powerCapsuleTier2Crafting = new AchievementBCA("powerCapsuleTier2Crafting", 2, -1, ItemsAndBlocks.powerCapsuleTier2, powerCapsuleTier1Crafting);
		powerCapsuleTier3Crafting = new AchievementBCA("powerCapsuleTier3Crafting", 4, -1, ItemsAndBlocks.powerCapsuleTier3, powerCapsuleTier2Crafting);


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
			if (event.player != null && event.crafting != null && event.crafting.getItem() != null && event.crafting.stackSize > 0) {
				if (event.crafting.getItem() instanceof ICraftingAchievement) {
					AchievementBCA achievementBCA = ((ICraftingAchievement) event.crafting.getItem()).getAchievement(event.player, event.crafting, event.craftMatrix);
					if (achievementBCA != null)
						event.player.addStat(achievementBCA, 1);
				} else if (event.crafting.getItem() instanceof ItemBlock) {
					Block block = ((ItemBlock) event.crafting.getItem()).field_150939_a;
					if (block instanceof ICraftingAchievement) {
						AchievementBCA achievementBCA = ((ICraftingAchievement) block).getAchievement(event.player, event.crafting, event.craftMatrix);
						if (achievementBCA != null)
							event.player.addStat(achievementBCA, 1);
					}
				}
			}
		}

		@SubscribeEvent
		public void onItemPickup(PlayerEvent.ItemPickupEvent event) {
			if (event.player != null && event.pickedUp != null && event.pickedUp.getEntityItem() != null && event.pickedUp.getEntityItem().getItem() != null && event.pickedUp.getEntityItem().stackSize > 0) {
				if (event.pickedUp.getEntityItem().getItem() instanceof IPickupAchievement) {
					AchievementBCA achievementBCA = ((IPickupAchievement) event.pickedUp.getEntityItem().getItem()).getAchievement(event.player, event.pickedUp);
					if (achievementBCA != null)
						event.player.addStat(achievementBCA, 1);
				} else if (event.pickedUp.getEntityItem().getItem() instanceof ItemBlock) {
					Block block = ((ItemBlock) event.pickedUp.getEntityItem().getItem()).field_150939_a;
					if (block instanceof IPickupAchievement) {
						AchievementBCA achievementBCA = ((IPickupAchievement) block).getAchievement(event.player, event.pickedUp);
						if (achievementBCA != null)
							event.player.addStat(achievementBCA, 1);
					}
				}
			}
		}

	}

}
