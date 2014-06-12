package buildcraftAdditions.core;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent.PlayerLoggedInEvent;
import net.minecraft.util.ChatComponentText;

/**
 * Copyright (c) 2014, AEnterprise
 * http://buildcraftadditions.wordpress.com/
 * Buildcraft Additions is distributed under the terms of the Minecraft Mod Public
 * License 1.0, or MMPL. Please check the contents of the license located in
 * http://buildcraftadditions.wordpress.com/wiki/licensing-stuff/
 */
public class EventListener  {

    @SubscribeEvent
    public void playerLogin (PlayerLoggedInEvent event){
        if (VersionCheckThread.newerVersionAvailable && event != null){
            event.player.addChatComponentMessage(new ChatComponentText("There is a newer version of Buildcraft Additions available (" + VersionCheckThread.newerVersionNumber + ") Please consider updating"));
            event.player.addChatComponentMessage(new ChatComponentText("Changelog: "));
            for (String line: VersionCheckThread.changelog){
                event.player.addChatComponentMessage(new ChatComponentText(line));
            }
        }
    }
}