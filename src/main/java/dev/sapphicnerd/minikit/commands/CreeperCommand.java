package dev.sapphicnerd.minikit.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.entity.Creeper;
import org.bukkit.entity.EntityType;

public class CreeperCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (args.length < 2) {
            sender.sendMessage("Usage: /creeper <target> <charged>");
            return true;
        }

        Player target = Bukkit.getPlayer(args[0]);

        if (target == null) {
            sender.sendMessage("[❌] Player not found!");
            return true;
        }

        boolean charged = Boolean.parseBoolean(args[1]);

        Creeper creeper = (Creeper) target.getWorld().spawnEntity(
                target.getLocation(),
                EntityType.CREEPER
        );

        if (charged) {
            creeper.setPowered(true);
        }

        sender.sendMessage("[✔] Spawned " +
                (charged ? "charged " : "") +
                "creeper on " + target.getName() + "!");

        return true;
    }
}