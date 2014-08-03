package buildcraftAdditions.tileEntities.Bases;

import net.minecraft.inventory.IInventory;
import net.minecraft.tileentity.TileEntity;

/**
 * Copyright (c) 2014, AEnterprise
 * http://buildcraftAdditions.wordpress.com/
 * Buildcraft Additions is distributed under the terms of the Minecraft Mod Public
 * License 1.0, or MMPL. Please check the contents of the license located in
 * http://buildcraftAdditions.wordpress.com/wiki/licensing-stuff/
 */
public abstract class TileBase extends TileEntity implements IInventory {

    @Override
    public abstract void updateEntity();

}
