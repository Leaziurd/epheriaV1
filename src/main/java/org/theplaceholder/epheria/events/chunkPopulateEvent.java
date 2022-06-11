package org.theplaceholder.epheria.events;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.world.ChunkPopulateEvent;
import org.theplaceholder.epheria.cBI.cBlocks;
import org.theplaceholder.epheria.utils.random;

public class chunkPopulateEvent implements Listener {
    @EventHandler
    public void chunkGenerate(ChunkPopulateEvent event){
        addRubyOre(event);
    }

    public void addRubyOre(ChunkPopulateEvent event){
        for (int i = 0; i < 16; i++) {
            Block block = event.getChunk().getBlock(random.number(15), random.number(100), random.number(15));
            if (block.getType() == Material.STONE) {
                block.setType(Material.NOTE_BLOCK);
                block.setBlockData(cBlocks.rubyOre.getBlockData());
            }
        }
    }
}
