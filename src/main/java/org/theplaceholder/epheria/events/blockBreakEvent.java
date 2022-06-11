package org.theplaceholder.epheria.events;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;
import org.theplaceholder.epheria.utils.random;

import static org.theplaceholder.epheria.cBI.cBlocks.*;
import static org.theplaceholder.epheria.cBI.cItems.*;

public class blockBreakEvent implements Listener {
    @EventHandler
    public void onBreak(BlockBreakEvent event){

        if (!event.getPlayer().getPlayer().getInventory().getItemInMainHand().containsEnchantment(Enchantment.SILK_TOUCH)) {
            cBlockBreak(event);

            Block block = event.getBlock();
            if (block.getType() == Material.JUNGLE_LEAVES && random.chance(15))
                block.getWorld().dropItem(block.getLocation(), banana.getItem());

        } else cBlockBreakST(event);
    }

    public void cBlockBreak(BlockBreakEvent event){
        Block block = event.getBlock();
        ItemStack item = event.getPlayer().getPlayer().getInventory().getItemInMainHand();
        if (block.getType() == Material.NOTE_BLOCK && (item.getType() == Material.IRON_PICKAXE || item.getType() == Material.DIAMOND_PICKAXE || item.getType() == Material.NETHERITE_PICKAXE)) {
            event.setDropItems(false);

            if (rubyOre.isBlock(block)) blockDrop(block, ruby.getItem());
        }
    }

    public void cBlockBreakST(BlockBreakEvent event){
        Block block = event.getBlock();
        ItemStack item = event.getPlayer().getPlayer().getInventory().getItemInMainHand();
        if (block.getType() == Material.NOTE_BLOCK && (item.getType() == Material.IRON_PICKAXE || item.getType() == Material.DIAMOND_PICKAXE || item.getType() == Material.NETHERITE_PICKAXE)) {
            event.setDropItems(false);

            if (rubyOre.isBlock(block)) blockDrop(block, rubyOreItem.getItem());
        }
    }

    public void blockDrop(Block block, ItemStack item){
        block.getWorld().dropItem(block.getLocation(), item);
    }
}
