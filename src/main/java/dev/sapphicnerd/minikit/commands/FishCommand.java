package dev.sapphicnerd.minikit.commands;

// This is not tested!
// I will test this later.

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class FishCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length == 0) {
            sender.sendMessage("Usage: /fish <target> <num>");
            return true;
        }

        Player target = org.bukkit.Bukkit.getPlayer(args[0]);
        int amount = (int) args[1];

        if (amount == (int) null || amount == 0) {
            sender.sendMessage("<num> can't be zero or empty, defaulting to one (1).");
        }

        if (target == null) {
            sender.sendMessage("Player not found!");
            return true;
        }

        for (int i = 0; i < amount; i++) {
            target.getWorld().spawnEntity(target.getLocation(), EntityType.TROPICAL_FISH);
        }

        sender.sendMessage("[] Fished " + target.getName() + "!");
        return true;
    }
}