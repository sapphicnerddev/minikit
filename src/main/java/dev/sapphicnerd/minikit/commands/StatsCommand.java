package dev.sapphicnerd.minikit.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class StatsCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        Runtime runtime = Runtime.getRuntime();

        long freeMem = runtime.freeMemory() / 1024 / 1024;
        long totalMem = runtime.totalMemory() / 1024 / 1024;
        long maxMem = runtime.maxMemory() / 1024 / 1024;
        long usedMem = totalMem - freeMem;

        sender.sendMessage(ChatColor.GRAY + "------------------------------");
        sender.sendMessage(ChatColor.GOLD + "" + ChatColor.BOLD + "Server Stats (@minikit)");
        sender.sendMessage(ChatColor.GRAY + "------------------------------");

        sender.sendMessage(ChatColor.YELLOW + "CPU Cores: "
                + ChatColor.WHITE + runtime.availableProcessors());

        sender.sendMessage(ChatColor.YELLOW + "Memory Used: "
                + ChatColor.WHITE + usedMem + " MB");

        sender.sendMessage(ChatColor.YELLOW + "Memory Free: "
                + ChatColor.WHITE + freeMem + " MB");

        sender.sendMessage(ChatColor.YELLOW + "Memory Max: "
                + ChatColor.WHITE + maxMem + " MB");

        sender.sendMessage(ChatColor.GRAY + "------------------------------");

        sender.sendMessage(ChatColor.YELLOW + "OS Name: "
                + ChatColor.WHITE + System.getProperty("os.name"));

        sender.sendMessage(ChatColor.YELLOW + "OS Version: "
                + ChatColor.WHITE + System.getProperty("os.version"));

        sender.sendMessage(ChatColor.YELLOW + "Architecture: "
                + ChatColor.WHITE + System.getProperty("os.arch"));

        sender.sendMessage(ChatColor.GRAY + "------------------------------");

        sender.sendMessage(ChatColor.YELLOW + "Server Version: "
                + ChatColor.WHITE + Bukkit.getVersion());

        sender.sendMessage(ChatColor.YELLOW + "Online Players: "
                + ChatColor.WHITE + Bukkit.getOnlinePlayers().size());

        sender.sendMessage(ChatColor.GRAY + "------------------------------");

        return true;
    }
}