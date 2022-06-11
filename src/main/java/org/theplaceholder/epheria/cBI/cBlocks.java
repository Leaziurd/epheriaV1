package org.theplaceholder.epheria.cBI;

import net.kyori.adventure.key.Key;
import net.kyori.adventure.sound.Sound;
import org.bukkit.ChatColor;
import org.bukkit.Instrument;
import org.bukkit.Material;
import org.theplaceholder.epheria.cBIC.cBlock.cBlock;
import org.theplaceholder.epheria.cBIC.cBlock.cBlockItem;
import org.theplaceholder.epheria.cBIC.cSoundGroup;

public class cBlocks {
    public static cBlock rubyOre;
    public static cBlockItem rubyOreItem;
    public static cSoundGroup stone = new cSoundGroup(Sound.sound(Key.key("block.stone.step"), Sound.Source.BLOCK, 1, 1),Sound.sound(Key.key("block.stone.break"), Sound.Source.BLOCK, 1, 1), Sound.sound(Key.key("block.stone.place"), Sound.Source.BLOCK, 1, 1), Sound.sound(Key.key("block.stone.hit"), Sound.Source.BLOCK, 1, 0.8f));
    public static void register(){
        rubyOre = new cBlock(0, Instrument.BANJO, true, stone);
        rubyOreItem = new cBlockItem(rubyOre, ChatColor.RED + "Ruby Ore", 101, Material.CLAY_BALL);
    }
}