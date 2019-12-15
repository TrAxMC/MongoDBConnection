package de.framedev.mongodbconnections.main;
/*
 * =============================================
 * = This Plugin was Created by FrameDev       =
 * = Copyrighted by FrameDev                   =
 * = Please don't Change anything              =
 * =============================================
 * This Class was made at 10.12.2019, 22:51
 */

import com.google.gson.Gson;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
    private static Main plugin;
    private MongoManager mongoManager;
    @Override
    public void onEnable() {
        plugin = this;
        this.getConfig().options().copyDefaults(true);
        saveConfig();
        if (Main.getInstance().getConfig().getBoolean("MongoDB.LocalHost")) {
            this.mongoManager = new MongoManager();
            this.mongoManager.connectLocalHost();
        }
        if (Main.getInstance().getConfig().getBoolean("MongoDB.Boolean")) {
            this.mongoManager = new MongoManager();
            this.mongoManager.connect();
        }
    }

    public static Main getInstance() {
        return plugin;
    }
}
