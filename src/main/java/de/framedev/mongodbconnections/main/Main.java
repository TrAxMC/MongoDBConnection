package de.framedev.mongodbconnections.main;
/*
 * =============================================
 * = This Plugin was Created by FrameDev       =
 * = Copyrighted by FrameDev                   =
 * = Please don't Change anything              =
 * =============================================
 * This Class was made at 10.12.2019, 22:51
 */

import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    private static Main plugin;
    
    @Override
    public void onEnable() {
        plugin = this;
        this.getConfig().options().copyDefaults(true);
        saveConfig();
    }

    public static Main getInstance() {
        return plugin;
    }
}
