package me.yhamarsheh.dablobby.commands;

import com.xxmicloxx.NoteBlockAPI.model.Song;
import com.xxmicloxx.NoteBlockAPI.songplayer.RadioSongPlayer;
import com.xxmicloxx.NoteBlockAPI.utils.NBSDecoder;
import me.yhamarsheh.dablobby.DabLobby;
import me.yhamarsheh.dablobby.storage.DabPlayer;
import me.yhamarsheh.dablobby.utilities.ChatUtils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.io.File;

public class MerryChristmasCMD implements CommandExecutor {

    private DabLobby plugin;
    public MerryChristmasCMD(DabLobby plugin) {
        this.plugin = plugin;
        plugin.getCommand("merrychristmas").setExecutor(this);
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String s, @NotNull String[] args) {
        if (!(sender instanceof Player)) return true;
        Player player = (Player) sender;
        DabPlayer dabPlayer = plugin.getPlayersManager().getPlayerData(player);
        if (dabPlayer == null) {
            player.sendMessage(ChatUtils.color("&cIt seems like an error has occurred. Please forward this to the administrators of the server."));
            return true;
        }

        player.sendMessage(ChatUtils.color("&aThank you for the christmas wishes! Merry Christmas to you too!"));
        if (dabPlayer.toggleMusic()) {
            plugin.getMusicPlayer().play(player);
            player.sendMessage(ChatUtils.color("&aAdditionally, we've turned on your music for you."));
        } else {
            plugin.getMusicPlayer().stop(player);
            player.sendMessage(ChatUtils.color("&cAdditionally, we've turned off your music for you."));
        }

        return false;
    }
}
