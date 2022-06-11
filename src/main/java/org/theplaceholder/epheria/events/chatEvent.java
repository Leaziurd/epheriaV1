package org.theplaceholder.epheria.events;

import io.papermc.paper.event.player.AsyncChatEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.theplaceholder.epheria.utils.chat;

public class chatEvent implements Listener {
    @EventHandler
    public void onChat(AsyncChatEvent event){
        event.setCancelled(true);
        chat.gen(event);
    }
}
