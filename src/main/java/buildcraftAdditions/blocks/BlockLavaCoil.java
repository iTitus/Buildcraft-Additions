package buildcraftAdditions.blocks;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.world.World;

import buildcraftAdditions.core.achievement.AchievementBCA;
import buildcraftAdditions.core.achievement.BCAAchievements;
import buildcraftAdditions.tileEntities.TileLavaCoil;
import buildcraftAdditions.utils.Utils;

/**
 * Copyright (c) 2014-2015, AEnterprise
 * http://buildcraftadditions.wordpress.com/
 * Buildcraft Additions is distributed under the terms of GNU GPL v3.0
 * Please check the contents of the license located in
 * http://buildcraftadditions.wordpress.com/wiki/licensing-stuff/
 */
public class BlockLavaCoil extends BlockCoilBase {

	public BlockLavaCoil() {
		super("Lava");
	}

	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ) {
		if (player.isSneaking())
			return false;

		if (!world.isRemote) {
			TileEntity tile = world.getTileEntity(x, y, z);
			if (tile instanceof TileLavaCoil) {
				TileLavaCoil coil = (TileLavaCoil) tile;
				player.addChatComponentMessage(new ChatComponentTranslation("lavaCoil.info", Utils.localizeFormatted("fluids.info", coil.getLavaAmount(), coil.getLavaCapacity())));
			}
		}

		return true;
	}

	@Override
	public TileEntity createNewTileEntity(World world, int meta) {
		return new TileLavaCoil();
	}

	@Override
	public AchievementBCA getAchievement(EntityPlayer player, ItemStack crafting, IInventory craftMatrix) {
		return BCAAchievements.lavaCoilCrafting;
	}
}
