package dev.sapphicnerd.minikit.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.entity.EntityType;

public class FishCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (args.length < 2) {
            sender.sendMessage("Usage: /fish <target> <num>");
            return true;
        }

        Player target = Bukkit.getPlayer(args[0]);

        if (target == null) {
            sender.sendMessage("[❌] Player not found!");
            return true;
        }

        int amount;

        try {
            amount = Integer.parseInt(args[1]);
        } catch (NumberFormatException e) {
            sender.sendMessage("[!] <num> must be a number, defaulting to 1.");
            amount = 1;
        }

        if (amount <= 0) {
            sender.sendMessage("[!] <num> can't be zero or negative, defaulting to 1.");
            amount = 1;
        }

        for (int i = 0; i < amount; i++) {
            target.getWorld().spawnEntity(
                target.getLocation(),
                EntityType.TROPICAL_FISH
            );
        }

        sender.sendMessage("[✔] Fished " + target.getName() + "!");
        return true;
    }
}