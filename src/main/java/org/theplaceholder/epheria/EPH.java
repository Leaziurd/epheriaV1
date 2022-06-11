package org.theplaceholder.epheria;

import org.bukkit.plugin.java.JavaPlugin;
import org.theplaceholder.epheria.utils.register;

public final class EPH extends JavaPlugin {

    public static EPH instance;

    @Override
    public void onEnable() {
        instance = this;

        register.start();
    }

    @Override
    public void onDisable() {

    }

    public static EPH getInstance(){return instance;}
}
// -4647455011400532360
// https://forms.gle/8Rdp3aNJAQsQCBJ2A