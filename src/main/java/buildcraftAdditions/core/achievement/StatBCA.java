package buildcraftAdditions.core.achievement;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.stats.StatBasic;
import net.minecraft.util.ChatComponentTranslation;

/**
 * Copyright (c) 2014-2015, AEnterprise
 * http://buildcraftadditions.wordpress.com/
 * Buildcraft Additions is distributed under the terms of GNU GPL v3.0
 * Please check the contents of the license located in
 * http://buildcraftadditions.wordpress.com/wiki/licensing-stuff/
 */
public class StatBCA extends StatBasic {

	public StatBCA(String name) {
		super("stat.bca." + name, new ChatComponentTranslation("stat.bca." + name));
		registerStat();
	}

	public void addStat(EntityPlayer player) {
		addStat(player, 1);
	}

	public void addStat(EntityPlayer player, int count) {
		if (player != null) {
			player.addStat(this, count);
		}
	}

}
