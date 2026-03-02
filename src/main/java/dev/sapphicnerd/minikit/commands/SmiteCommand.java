package dev.sapphicnerd.minikit.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SmiteCommand implements CommandExecutor {
    
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length == 0) {
            sender.sendMessage("Usage: /smite <target>");
            return true;
        }

        Player target = org.bukkit.Bukkit.getPlayer(args[0]);

        if (target == null) {
            sender.sendMessage("Player not found!");
            return true;
        }

        for (int i = 0; i < 9; i++) {
            target.getWorld().strikeLightning(target.getLocation());
        }

        sender.sendMessage("[⚡] Smited " + target.getName() + "!");
        return true;
    }
}

