package org.theplaceholder.epheria.cBIC;

import net.kyori.adventure.text.Component;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.LeatherArmorMeta;

public class cArmor {

    private final String name;
    private final int itemModelData;
    private final Material material;
    private final Color color;

    public cArmor(String name, int materialID, int itemModelData, Color color){
        this.name = name;
        this.itemModelData = itemModelData;
        this.color = color;

        Material material = null;
        if(materialID == 0) material = Material.LEATHER_HELMET;
        if(materialID == 1) material = Material.LEATHER_CHESTPLATE;
        if(materialID == 2) material = Material.LEATHER_LEGGINGS;
        if(materialID == 3) material = Material.LEATHER_BOOTS;
        this.material = material;
    }

    public ItemStack getItem(){
        ItemStack item = new ItemStack(material);
        LeatherArmorMeta meta = (LeatherArmorMeta) item.getItemMeta();

        meta.displayName(Component.text(name));
        meta.setCustomModelData(itemModelData);
        meta.setColor(color);

        item.setItemMeta(meta);
        return item;
    }
}
