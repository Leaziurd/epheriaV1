package org.theplaceholder.epheria.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.theplaceholder.epheria.cBIC.cItem;

public class inventoryOpenEvent implements Listener {
    @EventHandler
    public void onOpen(InventoryOpenEvent event){
        cItem.replaceItem(event.getInventory());
    }
}
