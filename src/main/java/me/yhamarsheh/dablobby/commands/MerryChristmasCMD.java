package me.yhamarsheh.dablobby.commands;

import me.yhamarsheh.dablobby.DabLobby;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

public class MerryChristmasCMD implements CommandExecutor {

    private DabLobby plugin;
    public MerryChristmasCMD(DabLobby plugin) {
        this.plugin = plugin;
        plugin.getCommand("merrychristmas").setExecutor(this);
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String s, @NotNull String[] args) {


        return false;
    }
}
