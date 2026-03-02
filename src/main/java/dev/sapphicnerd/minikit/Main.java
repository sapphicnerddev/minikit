package dev.sapphicnerd.minikit;

import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

// Made this a wildcard out of pure laziness...
import dev.sapphicnerd.minikit.commands.*;

public class Main extends JavaPlugin implements Listener {

    private void register(String name, org.bukkit.command.CommandExecutor exec) {
        var cmd = getCommand(name);
        if (cmd == null) {
            getLogger().severe("Command '" + name + "' is missing from plugin.yml!");
            return;
        }
        cmd.setExecutor(exec);
    }

    @Override
    public void onEnable() {
        Bukkit.getPluginManager().registerEvents(this, this);

        register("smite", new SmiteCommand());
        register("fish", new FishCommand());
        register("creeper", new CreeperCommand());
        register("sstats", new StatsCommand());
        register("jail", new JailCommand(this));
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        event.getPlayer().sendMessage(Component.text("Hello, " + event.getPlayer().getName() + "!"));
    }
}