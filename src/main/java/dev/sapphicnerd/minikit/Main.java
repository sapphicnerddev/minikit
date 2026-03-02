package dev.sapphicnerd.minikit;

import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

// Made this a wildcard out of pure laziness..
import dev.sapphicnerd.minikit.commands.*;

public class Main extends JavaPlugin implements Listener {
    @Override
    public void onEnable() {
        Bukkit.getPluginManager().registerEvents(this, this);
        
        getCommand("smite").setExecutor(new SmiteCommand());
        getCommand("fish").setExecutor(new FishCommand());
        getCommand("creeper").setExecutor(new CreeperCommand());
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        event.getPlayer().sendMessage(Component.text("Hello, " + event.getPlayer().getName() + "!"));
    }
}