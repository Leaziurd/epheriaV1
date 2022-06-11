package org.theplaceholder.epheria.cBI;

import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.Material;
import org.theplaceholder.epheria.cBIC.cArmor;
import org.theplaceholder.epheria.cBIC.cItem;

public class cItems {
    public static cItem banana;
    public static cItem bananaSkin;
    public static cItem bananHat;
    public static cItem goldenBanana;
    public static cItem flamedBanana;


    public static cItem ruby;
    public static cArmor rubyHelmet;
    public static cArmor rubyChestplate;
    public static cArmor rubyLeggings;
    public static cArmor rubyBoots;
    public static Color rubyColor = Color.fromRGB(222, 161, 151);

    public static void register(){
        banana = new cItem(ChatColor.YELLOW + "Banana", Material.APPLE, 100);
        bananaSkin = new cItem(ChatColor.YELLOW + "Banana Skin", Material.POISONOUS_POTATO, 100);
        bananHat = new cItem(ChatColor.YELLOW + "BananHat", Material.CARVED_PUMPKIN, 100);
        goldenBanana = new cItem(ChatColor.YELLOW + "Golden Banana", Material.GOLDEN_APPLE, 100);
        flamedBanana = new cItem(ChatColor.YELLOW + "Flamed Banana", Material.BAKED_POTATO, 100);

        ruby = new cItem(ChatColor.RED + "Ruby", Material.CLAY_BALL, 100);
        rubyHelmet = new cArmor(ChatColor.RED + "Ruby Helmet", 0, 100 ,rubyColor);
        rubyChestplate = new cArmor(ChatColor.RED + "Ruby Chestplate", 1, 100 , rubyColor);
        rubyLeggings = new cArmor(ChatColor.RED + "Ruby Leggings", 2, 100 , rubyColor);
        rubyBoots = new cArmor(ChatColor.RED + "Ruby Boots", 3, 100 , rubyColor);
        }
}
