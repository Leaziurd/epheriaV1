package org.theplaceholder.epheria.utils;

import io.papermc.paper.event.player.AsyncChatEvent;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.serializer.plain.PlainTextComponentSerializer;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import static org.theplaceholder.epheria.utils.sounds.*;

public class chat {
    public static void gen(AsyncChatEvent event){
        Player player = event.getPlayer();
        String msg = PlainTextComponentSerializer.plainText().serialize(event.message());

        msg = emojify(msg);
        msg = addNicknames(msg, player);

        Bukkit.broadcast(Component.text(msg));
    }

    public static String emojify(String msg){
        if(msg.contains(":siuuu:")) playSoundG(siuuu);
        if(msg.contains(":exterminate:")) playSoundG(exterminate);

        msg = msg.replace(":siuuu:", "\uE000");
        msg = msg.replace(":exterminate:", "\uE001");
        return msg;
    }

    public static String addNicknames(String msg, Player player){
        msg = prefix.name(player) + ChatColor.WHITE + " : " + msg;
        return msg;
    }
}