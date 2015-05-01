package buildcraftAdditions.blocks;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import buildcraftAdditions.BuildcraftAdditions;
import buildcraftAdditions.core.achievement.AchievementBCA;
import buildcraftAdditions.core.achievement.BCAAchievements;
import buildcraftAdditions.reference.Variables;
import buildcraftAdditions.tileEntities.TileBasicCoil;

/**
 * Copyright (c) 2014-2015, AEnterprise
 * http://buildcraftadditions.wordpress.com/
 * Buildcraft Additions is distributed under the terms of GNU GPL v3.0
 * Please check the contents of the license located in
 * http://buildcraftadditions.wordpress.com/wiki/licensing-stuff/
 */
public class BlockBasicCoil extends BlockCoilBase {

	public BlockBasicCoil() {
		super("Basic");
	}

	@Override
	public TileEntity createNewTileEntity(World var1, int var2) {
		return new TileBasicCoil();
	}

	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ) {
		// Drop through if the player is sneaking
		if (player.isSneaking())
			return false;

		if (!world.isRemote)
			player.openGui(BuildcraftAdditions.instance, Variables.Gui.BASIC_COIL.ordinal(), world, x, y, z);

		return true;
	}

	@Override
	public AchievementBCA getAchievement(EntityPlayer player, ItemStack crafting, IInventory craftMatrix) {
		return BCAAchievements.basicCoilCrafting;
	}
}
