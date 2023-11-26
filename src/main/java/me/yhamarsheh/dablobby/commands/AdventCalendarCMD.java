package me.yhamarsheh.dablobby.commands;

import me.yhamarsheh.dablobby.DabLobby;
import me.yhamarsheh.dablobby.guis.AdventCalendarGUI;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class AdventCalendarCMD implements CommandExecutor {

    private final DabLobby plugin;
    public AdventCalendarCMD(DabLobby plugin) {
        this.plugin = plugin;
        this.plugin.getCommand("advent").setExecutor(this);
    }

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] args) {
        if (!(commandSender instanceof Player)) return true;

        Player player = (Player) commandSender;
        AdventCalendarGUI gui = new AdventCalendarGUI();
        gui.open(player);
        return false;
    }
}
