package buildcraftAdditions.items;

import java.util.List;

import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import net.minecraftforge.oredict.OreDictionary;

import buildcraftAdditions.core.achievement.AchievementBCA;
import buildcraftAdditions.core.achievement.BCAAchievements;
import buildcraftAdditions.core.achievement.IPickupAchievement;
import buildcraftAdditions.reference.ItemsAndBlocks;
import buildcraftAdditions.utils.Utils;

/**
 * Copyright (c) 2014-2015, AEnterprise
 * http://buildcraftadditions.wordpress.com/
 * Buildcraft Additions is distributed under the terms of GNU GPL v3.0
 * Please check the contents of the license located in
 * http://buildcraftadditions.wordpress.com/wiki/licensing-stuff/
 */
public class ItemStickBCA extends ItemBase implements IPickupAchievement {

	public ItemStickBCA(String name) {
		super("stick" + name);
		OreDictionary.registerOre(getName(), new ItemStack(this));
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean advancedItemTooltips) {
		if (!getName().endsWith("Iron")) {
			list.add(Utils.localize("tooltip.forKineticMultiTool"));
			list.add(Utils.localizeAllFormatted("tooltip.stick.0", "tooltip." + getName() + ".chipset"));
			list.add(Utils.localizeAllFormatted("tooltip.stick.1", "tooltip." + getName() + ".stick"));
		}
	}

	@Override
	public AchievementBCA getAchievement(EntityPlayer player, EntityItem pickedUp) {
		if (pickedUp.getEntityItem().getItem() == ItemsAndBlocks.ironStick)
			return BCAAchievements.ironStickPickup;
		else if (pickedUp.getEntityItem().getItem() == ItemsAndBlocks.goldStick)
			return BCAAchievements.goldStickPickup;
		else if (pickedUp.getEntityItem().getItem() == ItemsAndBlocks.diamondStick)
			return BCAAchievements.diamondStickPickup;
		else if (pickedUp.getEntityItem().getItem() == ItemsAndBlocks.netherStarStick)
			return BCAAchievements.netherStarStickPickup;
		else if (pickedUp.getEntityItem().getItem() == ItemsAndBlocks.quartzStick)
			return BCAAchievements.quartzStickPickup;
		else if (pickedUp.getEntityItem().getItem() == ItemsAndBlocks.enderStick)
			return BCAAchievements.enderStickPickup;
		else if (pickedUp.getEntityItem().getItem() == ItemsAndBlocks.redstoneStick)
			return BCAAchievements.redstoneStickPickup;
		else if (pickedUp.getEntityItem().getItem() == ItemsAndBlocks.glowstoneStick)
			return BCAAchievements.glowstoneStickPickup;
		else if (pickedUp.getEntityItem().getItem() == ItemsAndBlocks.slimeStick)
			return BCAAchievements.slimeStickPickup;
		else if (pickedUp.getEntityItem().getItem() == ItemsAndBlocks.blazeStick)
			return BCAAchievements.blazeStickPickup;
		return null;
	}

	@Override
	public void onCreated(ItemStack stack, World world, EntityPlayer player) {
		System.out.println("stack = [" + stack + "], world = [" + world + "], player = [" + player + "]");
		if (stack != null && stack.getItem() == ItemsAndBlocks.emeraldStick)
			BCAAchievements.emeraldStickTrading.trigger(player);
	}
}
