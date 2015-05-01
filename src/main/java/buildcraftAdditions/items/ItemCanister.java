package buildcraftAdditions.items;

/**
 * Copyright (c) 2014-2015, AEnterprise
 * http://buildcraftadditions.wordpress.com/
 * Buildcraft Additions is distributed under the terms of GNU GPL v3.0
 * Please check the contents of the license located in
 * http://buildcraftadditions.wordpress.com/wiki/licensing-stuff/
 */

import java.util.List;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.ItemFluidContainer;

import buildcraftAdditions.BuildcraftAdditions;
import buildcraftAdditions.core.achievement.AchievementBCA;
import buildcraftAdditions.core.achievement.BCAAchievements;
import buildcraftAdditions.core.achievement.ICraftingAchievement;
import buildcraftAdditions.reference.ItemsAndBlocks;
import buildcraftAdditions.utils.RenderUtils;
import buildcraftAdditions.utils.Utils;

public class ItemCanister extends ItemFluidContainer implements ICraftingAchievement {

	@SideOnly(Side.CLIENT)
	private IIcon overlay;

	public ItemCanister(String name, int canisterCapacity) {
		super(0);
		setMaxStackSize(1);
		setCreativeTab(BuildcraftAdditions.bcaCannisters);
		setUnlocalizedName(name);
		setCapacity(canisterCapacity);
		setTextureName("bcadditions:" + name);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack itemStack, EntityPlayer player, List list, boolean visible) {
		FluidStack fStack = Utils.getFluidStackFromItemStack(itemStack);
		if (fStack == null)
			list.add(String.format(Utils.localize("tooltip.FluidCapacity"), capacity / 1000));
		else
			list.add(String.format(Utils.localize("tooltip.storedFluid"), fStack.getFluid().getLocalizedName(fStack), fStack.amount));
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister register) {
		super.registerIcons(register);
		overlay = RenderUtils.registerIcon(register, "fluidOverlay");
	}

	public ItemStack getFilledItemStack(FluidStack fluidStack) {
		ItemStack itemStack = new ItemStack(this);
		itemStack.stackTagCompound = new NBTTagCompound();
		NBTTagCompound fluidTag = fluidStack.writeToNBT(new NBTTagCompound());

		if (fluidStack.amount > capacity)
			fluidTag.setInteger("Amount", capacity);

		itemStack.getTagCompound().setTag("Fluid", fluidTag);

		return itemStack;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void getSubItems(Item item, CreativeTabs tab, List list) {
		super.getSubItems(item, tab, list);
		for (Fluid fluid : FluidRegistry.getRegisteredFluids().values())
			if (fluid != null)
				list.add(getFilledItemStack(new FluidStack(fluid, capacity)));
	}

	@SideOnly(Side.CLIENT)
	public IIcon getOverlay() {
		return overlay;
	}

	@Override
	public AchievementBCA getAchievement(EntityPlayer player, ItemStack crafting, IInventory craftMatrix) {
		if (crafting.getItem() == ItemsAndBlocks.ironCanister)
			return BCAAchievements.ironCanisterCrafting;
		else if (crafting.getItem() == ItemsAndBlocks.goldCanister)
			return BCAAchievements.goldCanisterCrafting;
		else if (crafting.getItem() == ItemsAndBlocks.diamondCanister)
			return BCAAchievements.diamondCanisterCrafting;
		return null;
	}

	@Override
	public void onCreated(ItemStack stack, World world, EntityPlayer player) {
		if (stack == null || stack.getItem() == null)
			return;
		if (stack.getItem() == ItemsAndBlocks.ironCanister)
			BCAAchievements.ironCanisterCrafting.trigger(player);
		else if (stack.getItem() == ItemsAndBlocks.goldCanister)
			BCAAchievements.goldCanisterCrafting.trigger(player);
		else if (stack.getItem() == ItemsAndBlocks.diamondCanister)
			BCAAchievements.diamondCanisterCrafting.trigger(player);
	}
}
