package org.theplaceholder.epheria.events;

import com.nametagedit.plugin.NametagEdit;
import net.kyori.adventure.text.Component;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.theplaceholder.epheria.cBIC.cItem;
import org.theplaceholder.epheria.utils.playerRepeating;
import org.theplaceholder.epheria.utils.prefix;
import org.theplaceholder.epheria.utils.resourcePack;

public class playerJoin implements Listener {
    @EventHandler
    public void onJoin(PlayerJoinEvent event)
    {
        Player player = event.getPlayer();
        String pref = prefix.get(player);
        String name = prefix.name(player);

        NametagEdit.getApi().setPrefix(player, pref);
        player.playerListName(Component.text(name));
        event.joinMessage(Component.text(ChatColor.WHITE + "[" + ChatColor.GREEN + "+" + ChatColor.WHITE + "] " + name));
        playerRepeating.run(player);
        resourcePack.load(player);
        cItem.replaceItem(player.getInventory());
    }
}
