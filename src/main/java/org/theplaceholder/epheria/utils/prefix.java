package org.theplaceholder.epheria.utils;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class prefix {
    public static String get(Player player){
        if(player.hasPermission("epheria.op")) return( ChatColor.RED + "[OP] ");
        if(player.hasPermission("epheria.youtuber")) return (ChatColor.RED + "[YOU" + ChatColor.WHITE + "TU" + ChatColor.RED + "BER] ");
        if(player.hasPermission("epheria.belgian")) return (ChatColor.BLACK + "[BE" + ChatColor.YELLOW + "LGI" + ChatColor.RED + "AN] " + ChatColor.YELLOW);
        if(player.hasPermission("epheria.breton")) return (ChatColor.WHITE + "[BR" + ChatColor.BLACK + "ET" + ChatColor.WHITE + "ON] ");
        if(player.hasPermission("epheria.deuleuke")) return (ChatColor.GOLD + "[DEULEUKE] ");

        return ChatColor.WHITE + "[MEMBER] ";
    }

    public static String name(Player player){
        return get(player) + player.getName();
    }
}
