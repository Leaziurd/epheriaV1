package org.theplaceholder.epheria.cBIC.cBlock;

import org.bukkit.Instrument;

import org.bukkit.Material;
import org.bukkit.Note;
import org.bukkit.block.Block;
import org.bukkit.block.data.BlockData;
import org.bukkit.block.data.type.NoteBlock;
import org.theplaceholder.epheria.cBIC.cSoundGroup;

import java.util.Objects;

public class cBlock{
    private final int note;
    private final Instrument instrument;
    private final boolean powered;

    public final cSoundGroup cSoundGroup;

    public cBlock(int note, Instrument instrument, boolean powered, cSoundGroup csg){
        this.note = note;
        this.instrument = instrument;
        this.powered = powered;
        this.cSoundGroup = csg;
    }

    public cBlock fromBlock(Block block){
        NoteBlock nb = (NoteBlock) block.getBlockData();
        return new cBlock(nb.getNote().hashCode(), nb.getInstrument(), nb.isPowered(), cSoundGroup);
    }

    public BlockData getBlockData(){
        NoteBlock nb = (NoteBlock) Material.NOTE_BLOCK.createBlockData();
        nb.setNote(new Note(note));
        nb.setInstrument(instrument);
        nb.setPowered(powered);

        return nb;
    }

    public boolean isBlock(Block block){
        NoteBlock blockData = (NoteBlock) block.getBlockData();

        Note n = blockData.getNote();
        Instrument i = blockData.getInstrument();
        boolean p = blockData.isPowered();

        return Objects.equals(n, new Note(this.note)) && i == this.instrument && p == this.powered;
    }
}
