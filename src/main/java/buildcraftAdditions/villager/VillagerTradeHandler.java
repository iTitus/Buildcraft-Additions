package buildcraftAdditions.villager;

/**
 * Copyright (c) 2014-2015, AEnterprise
 * http://buildcraftadditions.wordpress.com/
 * Buildcraft Additions is distributed under the terms of GNU GPL v3.0
 * Please check the contents of the license located in
 * http://buildcraftadditions.wordpress.com/wiki/licensing-stuff/
 */

import java.util.Random;

import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.village.MerchantRecipe;
import net.minecraft.village.MerchantRecipeList;

import cpw.mods.fml.common.registry.VillagerRegistry.IVillageTradeHandler;

import buildcraftAdditions.reference.ItemLoader;


public class VillagerTradeHandler implements IVillageTradeHandler {

	public void manipulateTradesForVillager(EntityVillager villager, MerchantRecipeList recipeList, Random random) {
		//canisters
		recipeList.add(new MerchantRecipe(new ItemStack(Items.emerald), null, new ItemStack(ItemLoader.ironCanister)));
		recipeList.add(new MerchantRecipe(new ItemStack(ItemLoader.ironCanister), new ItemStack(Items.emerald, 2), new ItemStack(ItemLoader.goldCanister)));
		recipeList.add(new MerchantRecipe(new ItemStack(ItemLoader.goldCanister), new ItemStack(Items.emerald, 4), new ItemStack(ItemLoader.diamondCanister)));

		//kinetic capsules
		recipeList.add(new MerchantRecipe(new ItemStack(Items.emerald, 2), null, new ItemStack(ItemLoader.powerCapsuleTier1)));
		recipeList.add(new MerchantRecipe(new ItemStack(ItemLoader.powerCapsuleTier1), new ItemStack(Items.emerald, 3), new ItemStack(ItemLoader.powerCapsuleTier2)));
		recipeList.add(new MerchantRecipe(new ItemStack(ItemLoader.powerCapsuleTier2), new ItemStack(Items.emerald, 10), new ItemStack(ItemLoader.powerCapsuleTier3)));

		//emerald stick
		recipeList.add(new MerchantRecipe(new ItemStack(Items.emerald, 15), null, new ItemStack(ItemLoader.emeraldStick)));
	}

}