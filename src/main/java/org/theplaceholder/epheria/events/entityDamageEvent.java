package org.theplaceholder.epheria.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.theplaceholder.epheria.commands.fly;

public class entityDamageEvent implements Listener {

    @EventHandler
    public void onEntityDamage(EntityDamageEvent event){
        fly.cFall(event);
    }
}
