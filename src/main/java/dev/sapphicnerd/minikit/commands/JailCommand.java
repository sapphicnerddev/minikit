package dev.sapphicnerd.minikit.commands;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.Location;
import org.bukkit.Material;

import java.util.ArrayList;
import java.util.List;

public class JailCommand implements CommandExecutor {
    private final JavaPlugin plugin;

    public JailCommand(JavaPlugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length < 2) {
            sender.sendMessage("Usage: /jail <target> <seconds>");
            return true;
        }

        Player target = Bukkit.getPlayer(args[0]);
        if (target == null) {
            sender.sendMessage("Player not found!");
            return true;
        }

        int seconds;

        try {
            seconds = Integer.parseInt(args[1]);
        } catch (NumberFormatException e) {
            sender.sendMessage("Duration must be a number!");
            return true;
        }

        Location loc = target.getLocation();
        List<Location> placedBlocks = new ArrayList<>();

        // This might just be the worst method I've ever written...
        for (int x = -1; x <= 1; x++) {
            for (int y = 0; y <= 2; y++) {
                for (int z = -1; z <= 1; z++) {
                    Location blockLoc = loc.clone().add(x, y, z);
                    if (blockLoc.getBlock().getType() == Material.AIR) {
                        blockLoc.getBlock().setType(Material.BEDROCK);
                        placedBlocks.add(blockLoc);
                    }
                }
            }
        }

        target.sendMessage("You have been jailed for " + seconds + " seconds!");

        // Weird schedule/task thing to avoid misery
        long ticks = seconds * 20L;
        Bukkit.getScheduler().runTaskLater(plugin, () -> {
            for (Location blockLoc : placedBlocks) {
                blockLoc.getBlock().setType(Material.AIR);
            }
            target.sendMessage("You have been released from jail!");
        }, ticks);

        return true;
    }
}
