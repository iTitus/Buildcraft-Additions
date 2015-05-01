package buildcraftAdditions.blocks;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import buildcraft.api.power.ILaserTargetBlock;

import buildcraftAdditions.core.achievement.AchievementBCA;
import buildcraftAdditions.core.achievement.BCAAchievements;
import buildcraftAdditions.tileEntities.TileKineticCoil;

/**
 * Copyright (c) 2014-2015, AEnterprise
 * http://buildcraftadditions.wordpress.com/
 * Buildcraft Additions is distributed under the terms of GNU GPL v3.0
 * Please check the contents of the license located in
 * http://buildcraftadditions.wordpress.com/wiki/licensing-stuff/
 */
public class BlockKineticCoil extends BlockCoilBase implements ILaserTargetBlock {

	public BlockKineticCoil() {
		super("Kinetic");
	}

	@Override
	public TileEntity createNewTileEntity(World world, int meta) {
		return new TileKineticCoil();
	}

	@Override
	public AchievementBCA getAchievement(EntityPlayer player, ItemStack crafting, IInventory craftMatrix) {
		return BCAAchievements.kineticCoilCrafting;
	}
}
