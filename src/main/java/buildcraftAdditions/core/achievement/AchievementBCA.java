package buildcraftAdditions.core.achievement;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.Achievement;

/**
 * Copyright (c) 2014-2015, AEnterprise
 * http://buildcraftadditions.wordpress.com/
 * Buildcraft Additions is distributed under the terms of GNU GPL v3.0
 * Please check the contents of the license located in
 * http://buildcraftadditions.wordpress.com/wiki/licensing-stuff/
 */
public class AchievementBCA extends Achievement {

	public AchievementBCA(String name, int x, int y, ItemStack icon) {
		this(name, x, y, icon, null);
	}

	public AchievementBCA(String name, int x, int y, ItemStack icon, Achievement parent) {
		super("bca." + name, "bca." + name, x, y, icon, parent);
		BCAAchievements.registerAchievement(this);
	}

	public AchievementBCA(String name, int x, int y, Item icon) {
		this(name, x, y, icon, null);
	}

	public AchievementBCA(String name, int x, int y, Item icon, Achievement parent) {
		this(name, x, y, new ItemStack(icon), parent);
	}

	public AchievementBCA(String name, int x, int y, Block icon) {
		this(name, x, y, icon, null);
	}

	public AchievementBCA(String name, int x, int y, Block icon, Achievement parent) {
		this(name, x, y, new ItemStack(icon), parent);
	}

	public boolean isValid() {
		return theItemStack != null && theItemStack.getItem() != null;
	}
}
