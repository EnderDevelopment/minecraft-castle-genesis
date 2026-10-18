package com.enderdevelopment.plugin;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CastleSizeCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("This command can only be used by players.");
            return true;
        }

        if (args.length != 1) {
            sender.sendMessage("Usage: /castlesize <size>");
            return true;
        }

        try {
            int size = Integer.parseInt(args[0]);
            CastleGenerator.setCastleSize(size);
            sender.sendMessage("Castle size set to " + size);
        } catch (NumberFormatException e) {
            sender.sendMessage("Invalid size. Please enter a number.");
        }
        return true;
    }
}