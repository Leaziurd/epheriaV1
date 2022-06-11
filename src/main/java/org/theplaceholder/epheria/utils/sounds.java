package org.theplaceholder.epheria.utils;

import net.kyori.adventure.sound.Sound;
import org.bukkit.Location;
import org.bukkit.NamespacedKey;
import org.theplaceholder.epheria.EPH;

public class sounds {
    public static Sound siuuu;
    public static Sound exterminate;

    public static void register(){
        exterminate = newSound("exterminate");
        siuuu = newSound("siuuu");
    }

    public static Sound newSound(String name){return Sound.sound(new NamespacedKey(NamespacedKey.MINECRAFT, name), Sound.Source.MASTER, 1, 1);}

    public static void playSoundG(Sound sound){EPH.getInstance().getServer().playSound(sound);}

    public static void playSoundLoc( Sound sound, Location location){location.getWorld().playSound(sound, location.getX(), location.getY(), location.getZ());}
    public static void playSoundLoc(org.bukkit.Sound sound, Location location){playSoundLoc(Sound.sound(sound.getKey(), Sound.Source.BLOCK, 1, 1), location);}
}