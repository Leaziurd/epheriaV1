package org.theplaceholder.epheria.cBIC;

import net.kyori.adventure.sound.Sound;

import javax.swing.*;

public class cSoundGroup {
    public final Sound walking;
    public final Sound breaking;
    public final Sound place;
    public final Sound hit;

    public cSoundGroup(Sound walking, Sound breaking, Sound place, Sound hit){
        this.walking = walking;
        this.breaking = breaking;
        this.place = place;
        this.hit = hit;
    }


}
