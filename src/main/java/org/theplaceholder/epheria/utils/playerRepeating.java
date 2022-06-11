package org.theplaceholder.epheria.utils;

import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.theplaceholder.epheria.EPH;

public class playerRepeating
{
    public static void run(Player player)
    {
        String playerName = player.getName();
        String pf = prefix.get(player);

        Bukkit.getScheduler().scheduleSyncRepeatingTask(EPH.getInstance(), () -> {
            player.sendPlayerListHeader(Component.text(" ⏳ | " + pf + playerName + ChatColor.RESET +" | " + Bukkit.getServer().getOnlinePlayers().size() + "/" + Bukkit.getServer().getMaxPlayers() +" | " + Math.round(Bukkit.getTPS()[0]) + " TPS | ⏳ "));
        }, 0L, 40L);
    }
}
