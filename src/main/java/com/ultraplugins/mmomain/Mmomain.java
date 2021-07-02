package com.ultraplugins.mmomain;

import org.bukkit.ChatColor;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

@SuppressWarnings("deprecation")
public final class Mmomain extends JavaPlugin {

    @Override
    public void onEnable() {
        getServer().broadcastMessage(format("&eMmo plugin was &a&lENABLED"));
        getCommand("resource").setExecutor(new resourcecommand());
        getCommand("weapon").setExecutor(new weaponCommand());
        PluginManager pm = getServer().getPluginManager();
        pm.registerEvents(new events(), this);
    }

    @Override
    public void onDisable() {
        getServer().broadcastMessage(format("&eMmo plugin was &c&lDISABLED"));
    }
    public String format(String text) { return ChatColor.translateAlternateColorCodes('&', text); }
}
