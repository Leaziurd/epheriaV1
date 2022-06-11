package org.theplaceholder.epheria.utils;

import com.destroystokyo.paper.event.entity.EntityTeleportEndGatewayEvent;
import com.destroystokyo.paper.event.player.PlayerTeleportEndGatewayEvent;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.WorldCreator;
import org.bukkit.entity.Entity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class dims implements Listener {
    public static World world = Bukkit.getWorld("world");
    public static World tardeuse;

    public static void getTardeuse(){
        WorldCreator wc = new WorldCreator("tardeuse");
        wc.generator(new voidWorld());

        tardeuse = wc.createWorld();
    }

    @EventHandler
    public void tpTardeuse(PlayerTeleportEndGatewayEvent event){
        tpToTardis(event.getPlayer(), event.getGateway().getLocation());
        tpToWorld(event.getPlayer(), event.getGateway().getLocation());
        event.setCancelled(true);
    }

    @EventHandler
    public void endGatewayEvent(EntityTeleportEndGatewayEvent event){
        tpToTardis(event.getEntity(), event.getGateway().getLocation());
        tpToWorld(event.getEntity(), event.getGateway().getLocation());
        event.setCancelled(true);
    }

    public static void tpToTardis(Entity entity, Location in){
        if(in.getBlockX() == -321 && in.getBlockZ() == 75)
            entity.teleport(new Location(tardeuse, 0.5, 1, -0.5, 180,0));
        else if(in.getBlockX() == -771 && in.getBlockZ() == -1563)
            entity.teleport(new Location(tardeuse, 8, 1, -4, 90, 0));
    }

    public static void tpToWorld(Entity entity, Location in){
        if(in.getBlockX() == 0 && in.getBlockZ() == 0)
            entity.teleport(new Location(world, -320.5, 111, 72.5, 180, 0));
        else if(in.getBlockX() == 9 && in.getBlockZ() == -4)
            entity.teleport(new Location(world, -771, 71, -1565, 0, 0));
    }
}
