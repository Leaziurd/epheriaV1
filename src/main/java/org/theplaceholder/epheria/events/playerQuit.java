package org.theplaceholder.epheria.events;

import net.kyori.adventure.text.Component;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;
import org.theplaceholder.epheria.utils.prefix;

public class playerQuit implements Listener{

    @EventHandler
    public void onQuit(PlayerQuitEvent event)
    {
        Player player = event.getPlayer();
        Component message = Component.text(ChatColor.WHITE + "[" + ChatColor.RED + "-" + ChatColor.WHITE + "] " + prefix.name(player));
        event.quitMessage(message);
    }
}
