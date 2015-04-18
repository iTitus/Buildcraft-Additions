package buildcraftAdditions.core.achievement;

import java.util.List;

import net.minecraft.stats.Achievement;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent;

import net.minecraftforge.common.AchievementPage;
import net.minecraftforge.common.MinecraftForge;

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

	static {
		init();
	}

	public static void init() {
		AchievementPage.registerAchievementPage(achievementPage);

		BCAAchievementEventHandler eventHandler = new BCAAchievementEventHandler();
		FMLCommonHandler.instance().bus().register(eventHandler);
		MinecraftForge.EVENT_BUS.register(eventHandler);
	}

	public static AchievementBCA registerAchievement(AchievementBCA achievement) {
		achievementPage.getAchievements().add(achievement);
		return achievement;
	}

	public static List<Achievement> getAchievements() {
		return achievementPage.getAchievements();
	}

	public static class BCAAchievementEventHandler {

		@SubscribeEvent
		public void onItemCrafted(PlayerEvent.ItemCraftedEvent event) {
			if (event.player != null && event.crafting != null && event.crafting.getItem() != null && event.crafting.stackSize > 0) {
				if (event.crafting.getItem() instanceof ICraftingAchievement) {
					AchievementBCA achievementBCA = ((ICraftingAchievement) event.crafting.getItem()).getAchievement(event.player, event.crafting, event.craftMatrix);
					if (achievementBCA != null)
						event.player.addStat(achievementBCA, 1);
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
				}
			}
		}

	}

}
