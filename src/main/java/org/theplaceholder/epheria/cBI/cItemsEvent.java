package org.theplaceholder.epheria.cBI;

import org.bukkit.Location;
import org.bukkit.entity.Item;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityCombustByBlockEvent;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.Vector;

import static org.theplaceholder.epheria.cBI.cItems.*;

public class cItemsEvent implements Listener {
    @EventHandler
    public void consumeEvent(PlayerItemConsumeEvent event){
        if(event.getItem().isSimilar(banana.getItem())){
            event.getPlayer().getWorld().dropItem(event.getPlayer().getLocation(), bananaSkin.getItem());
        }
    }

    @EventHandler
    public void placeEvent(BlockPlaceEvent event){
        if (event.getItemInHand().isSimilar(bananHat.getItem())){
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void burnEvent(EntityCombustByBlockEvent event){
        if(event.getEntity() instanceof Item){
            Item item = (Item) event.getEntity();
            if(item.getItemStack().isSimilar(banana.getItem())){
                event.setCancelled(true);
                Location loc = item.getLocation();
                loc.setY(item.getLocation().getBlockY() + 2);
                item.teleport(loc);

                ItemStack itemStack = flamedBanana.getItem();
                itemStack.setAmount(item.getItemStack().getAmount());

                item.setItemStack(itemStack);
                item.setVelocity(new Vector(0.1, 0.1, 0.1));
            }
        }
    }
}
