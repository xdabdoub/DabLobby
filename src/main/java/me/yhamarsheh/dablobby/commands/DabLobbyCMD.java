package me.yhamarsheh.dablobby.commands;

import me.yhamarsheh.dablobby.DabLobby;
import me.yhamarsheh.dablobby.utilities.ChatUtils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class DabLobbyCMD implements CommandExecutor {

    private DabLobby plugin;
    public DabLobbyCMD(DabLobby plugin) {
        this.plugin = plugin;
        plugin.getCommand("dablobby").setExecutor(this);
    }

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] args) {
        if (!(commandSender instanceof Player)) return true;
        Player player = (Player) commandSender;
        if (!player.hasPermission("dablobby.use")) {
            player.sendMessage("Unknown command. Type \"/help\" for help.");
            return true;
        }

        if (args.length == 0) {
            player.sendMessage(ChatUtils.color("&cInvalid Usage: /dablobby setlobby"));
            return true;
        }

        if (!args[0].equalsIgnoreCase("setlobby")) {
            player.sendMessage(ChatUtils.color("&cInvalid Subcommand! Use /dablobby setlobby"));
            return true;
        }

        plugin.lobby = player.getLocation();
        player.sendMessage(ChatUtils.color("&aSUCCESS! Lobby was set to your location."));
        plugin.saveLobby();
        return false;
    }
}
