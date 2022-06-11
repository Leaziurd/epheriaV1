package org.theplaceholder.epheria.utils;

import org.bukkit.command.CommandExecutor;
import org.bukkit.event.Listener;
import org.theplaceholder.epheria.*;
import org.theplaceholder.epheria.cBI.*;
import org.theplaceholder.epheria.cBIC.cBlock.cBlockUpdate;
import org.theplaceholder.epheria.commands.fly;
import org.theplaceholder.epheria.events.*;

import static org.bukkit.Bukkit.getServer;

public class register {
    public static void start(){
        events();
        commands();
        sounds.register();
        cBlocks.register();
        cItems.register();
        dims.getTardeuse();
        cCrafts.register();
    }

    private static void events(){
        registerEvent(new chatEvent());
        registerEvent(new chunkPopulateEvent());
        registerEvent(new entityDamageEvent());
        registerEvent(new playerJoin());
        registerEvent(new playerQuit());
        registerEvent(new cBlockUpdate());
        registerEvent(new dims());
        registerEvent(new cItemsEvent());
        registerEvent(new blockBreakEvent());
        registerEvent(new resourcePack());
        registerEvent(new inventoryOpenEvent());
    }

    private static void commands(){
        registerCommand("fly", new fly());
    }

    private static void registerEvent(Listener listener){getServer().getPluginManager().registerEvents(listener, EPH.getInstance());}

    private static void registerCommand(String name, CommandExecutor commandExecutor){EPH.getInstance().getCommand(name).setExecutor(commandExecutor);}
}
