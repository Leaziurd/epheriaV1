package org.theplaceholder.epheria.cBIC.cBlock;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.*;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.theplaceholder.epheria.utils.sounds;

public class cBlockUpdate implements Listener {
    @EventHandler
    public void onNote(NotePlayEvent event){event.setCancelled(true);}

    @EventHandler(priority = EventPriority.HIGHEST, ignoreCancelled = true)
    public void onBlockPhysics(BlockPhysicsEvent event) {
        Block aboveBlock = event.getBlock().getLocation().add(0, 1, 0).getBlock();
        if (aboveBlock.getType() == Material.NOTE_BLOCK) {
            updateAndCheck(event.getBlock().getLocation());
            event.setCancelled(true);
        }
        if (event.getBlock().getType() == Material.NOTE_BLOCK)
            event.setCancelled(true);
        if (event.getBlock().getType().toString().toLowerCase().contains("sign"))
            return;
        event.getBlock().getState().update(true, false);
    }

    @EventHandler
    public void onInteract(PlayerInteractEvent event){
        if(event.getClickedBlock() == null) return;
        if(event.getClickedBlock().getType() == Material.NOTE_BLOCK && event.getAction() == Action.RIGHT_CLICK_BLOCK)
            event.setCancelled(true);
        if(event.getItem() == null) return;
        if(event.getPlayer().getLocation().distance(event.getClickedBlock().getRelative(event.getBlockFace()).getLocation()) > 1)
        {
            if (event.getItem().getType() == Material.NOTE_BLOCK || event.getItem().getType() == Material.CLAY_BALL) {
                Block block = event.getClickedBlock().getRelative(event.getBlockFace());
                block.setType(cBlockItem.fromItem(event.getItem()).getcB().getBlockData().getMaterial());
                block.setBlockData(cBlockItem.fromItem(event.getItem()).getcB().getBlockData());
                sounds.playSoundLoc(cBlockItem.fromItem(event.getItem()).getcB().cSoundGroup.place, block.getLocation());
            }
            if (event.getItem().getType().isBlock() && event.getAction() == Action.RIGHT_CLICK_BLOCK && event.getClickedBlock().getType() == Material.NOTE_BLOCK) {
                Block block = event.getClickedBlock().getRelative(event.getBlockFace());
                block.setType(event.getItem().getType());
                block.setBlockData(event.getItem().getType().createBlockData());
                if (!event.getPlayer().isSneaking())
                    sounds.playSoundLoc(block.getBlockSoundGroup().getPlaceSound(), block.getLocation());
            }
        }
    }

    @EventHandler
    public void onRedstone(BlockRedstoneEvent event){
        if(event.getBlock().getType() == Material.NOTE_BLOCK) event.setNewCurrent(event.getOldCurrent());
    }
    public void updateAndCheck(Location loc){
        Block b = loc.add(0, 1, 0).getBlock();
        if (b.getType() == Material.NOTE_BLOCK)
            b.getState().update(true, true);
        Location nextBlock = b.getLocation().add(0, 1, 0);
        if (nextBlock.getBlock().getType() == Material.NOTE_BLOCK)
            updateAndCheck(b.getLocation());
    }

    @EventHandler
    public void onWalk(PlayerMoveEvent event){
        if(event.getTo().getBlock().getRelative(BlockFace.DOWN).getType() == Material.NOTE_BLOCK){
        }
    }
}