package org.theplaceholder.epheria.utils;

import net.kyori.adventure.text.Component;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerResourcePackStatusEvent;

public class resourcePack implements Listener {
    public static void load(Player player){
        player.setResourcePack("https://www.dropbox.com/s/kor3tr9cteq2hw1/epheria.zip?dl=1", "0a4bbbdcf1d71d0594b86514890c6760c280dc58");
    }
    @EventHandler
    public void onR(PlayerResourcePackStatusEvent event){
        boolean a = event.getStatus().equals(PlayerResourcePackStatusEvent.Status.DECLINED);
        boolean b = event.getStatus().equals(PlayerResourcePackStatusEvent.Status.FAILED_DOWNLOAD);
        if(a || b){
            event.getPlayer().kick(Component.text(ChatColor.RED + "RESOURCE PACK REQUIRED"));
        }
    }
}
