package dev.sapphicnerd.minikit.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class StatsCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label) {
        sender.sendMessage("---- Server Stats and System Info ---");
        sender.sendMessage("[⛏] Available cores: " + Runtime.getRuntime().availableProcessors());
        sender.sendMessage("[⛏] Free memory (bytes):  " + Runtime.getRuntime().freeMemory());
        
        long maxMemory = Runtime.getRuntime().maxMemory();
        System.out.println("[⛏] Maximum memory (bytes): " + (maxMemory == Long.MAX_VALUE ? "N/A" : maxMemory));
        System.out.println("[⛏] Total memory available to JVM (bytes): " + Runtime.getRuntime().totalMemory());
        sender.sendMessage("-----------------------------------");

        String serverNameOS = System.getProperty("os.name");
        String serverArchOS = System.getProperty("os.arch");
        String serverVersionOS = System.getProperty("os.version");

        sender.sendMessage("[⛏] Name: " + serverNameOS);
        sender.sendMessage("[⛏] Version: " + serverVersionOS);
        sender.sendMessage("[⛏] Arch: " + serverArchOS);
        sender.sendMessage("-----------------------------------");

        return true;
    }
}