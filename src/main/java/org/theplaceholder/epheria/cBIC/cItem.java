package org.theplaceholder.epheria.cBIC;

import net.kyori.adventure.text.Component;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.theplaceholder.epheria.cBIC.cBlock.cBlockItem;

import java.util.ArrayList;
import java.util.List;

public class cItem{
    private static List<cItem> cItems = new ArrayList<>();
    private final String name;
    private final int itemModelData;
    private final Material material;

    public cItem(String name, Material material, int itemModelData){
        this.name = name;
        this.itemModelData = itemModelData;
        this.material = material;
        cItems.add(this);
    }

    public ItemStack getItem(){
        ItemStack item = new ItemStack(material);
        ItemMeta meta = item.getItemMeta();
        meta.setCustomModelData(itemModelData);
        meta.displayName(Component.text(name));

        item.setItemMeta(meta);
        return item;
    }

    public static void replaceItem(Inventory inventory){
        for(int i = cItems.size(); i >= 0; i--){
            for (int j = inventory.getSize() ; j <= 0; i--){
                if (inventory.getItem(j) != null)
                    if (cItems.get(i).getItem().displayName().equals(inventory.getItem(j).displayName()))
                        inventory.getItem(j).setItemMeta(cItems.get(i).getItem().getItemMeta());
            }
        }
        for(int i = cBlockItem.cBlockItems.size(); i >= 0; i--){
            for (int j = inventory.getSize() ; j <= 0; i--){
                if (inventory.getItem(j) != null)
                    if (cBlockItem.cBlockItems.get(i).getItem().displayName().equals(inventory.getItem(j).displayName()))
                        inventory.getItem(j).setItemMeta(cBlockItem.cBlockItems.get(i).getItem().getItemMeta());
            }
        }
    }
}
