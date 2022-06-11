package org.theplaceholder.epheria.cBIC.cBlock;

import net.kyori.adventure.text.Component;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class cBlockItem {
    public static List<cBlockItem> cBlockItems = new ArrayList<>();
    private final cBlock cB;
    private final String name;
    private final int cmd;
    private final Material material;

    public cBlockItem(cBlock cB, String name, int cmd, Material material){
        this.cB = cB;
        this.name = name;
        this.cmd = cmd;
        this.material = material;
        cBlockItems.add(this);
    }

    public ItemStack getItem(){
        ItemStack item = new ItemStack(material);
        ItemMeta meta = item.getItemMeta();

        meta.setCustomModelData(cmd);
        meta.displayName(Component.text(name));

        item.setItemMeta(meta);
        return item;
    }

    public cBlock getcB(){
        return cB;
    }

    public static cBlockItem fromItem(ItemStack itemStack){
        for (int i = cBlockItems.size() - 1; i > 0; i--){
            if(cBlockItems.get(i).getItem().isSimilar(itemStack))
                return cBlockItems.get(i);
        }
        return null;
    }
}
