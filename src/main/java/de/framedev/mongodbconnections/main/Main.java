package de.framedev.mongodbconnections.main;
/*
 * =============================================
 * = This Plugin was Created by FrameDev       =
 * = Copyrighted by FrameDev                   =
 * = Please don't Change anything              =
 * =============================================
 * This Class was made at 10.12.2019, 22:51
 */

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    private static Main plugin;
    private MongoManager mongoManager;
    private BackendManager backendManager;

    @Override
    public void onEnable() {
        plugin = this;

        this.getConfig().options().copyDefaults(true);
        saveConfig();

        if (getConfig().getBoolean("MongoDB.LocalHost")) {
            this.mongoManager = new MongoManager();
            this.mongoManager.connectLocalHost();
            this.backendManager = new BackendManager(Main.getInstance());
        }
        if (getConfig().getBoolean("MongoDB.Boolean")) {
            this.mongoManager = new MongoManager();
            this.mongoManager.connect();
            this.backendManager = new BackendManager(Main.getInstance());
        }

        Bukkit.getConsoleSender().sendMessage("§6[" + getDescription().getName() + "§6] §c>> §aEnabled!");
    }

    public MongoManager getMongoManager() {
        return mongoManager;
    }

    public BackendManager getBackendManager() {
        return backendManager;
    }

    public static Main getInstance() {
        return plugin;
    }
}
