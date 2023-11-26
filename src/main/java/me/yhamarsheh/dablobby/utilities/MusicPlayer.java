package me.yhamarsheh.dablobby.utilities;

import com.xxmicloxx.NoteBlockAPI.model.RepeatMode;
import com.xxmicloxx.NoteBlockAPI.model.Song;
import com.xxmicloxx.NoteBlockAPI.songplayer.RadioSongPlayer;
import me.yhamarsheh.dablobby.DabLobby;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.ComponentBuilder;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.UUID;

public class MusicPlayer {

    private Song song;
    private RadioSongPlayer rsp;
    private DabLobby plugin;
    public MusicPlayer(DabLobby plugin, Song song) {
        this.plugin = plugin;
        this.song = song;
        this.rsp = new RadioSongPlayer(song);
        this.rsp.setPlaying(true);
        this.rsp.setRepeatMode(RepeatMode.ALL);

        actionBarHandler();
    }

    public void play(Player player) {
        rsp.addPlayer(player);
    }

    public void stop(Player player) {
        rsp.removePlayer(player);
    }

    private void actionBarHandler() {
        new BukkitRunnable() {

            @Override
            public void run() {
                for (UUID uuid : rsp.getPlayerUUIDs()) {
                    Player player = Bukkit.getPlayer(uuid);
                    if (player == null) {
                        rsp.removePlayer(uuid);
                        continue;
                    }

                    player.spigot().sendMessage(ChatMessageType.ACTION_BAR,
                            new ComponentBuilder(ChatUtils.color("&bTurn off the music via " +
                                    "'&c/&fm&ce&fr&cr&fy&cc&fh&cr&fi&cs&ft&cm&fa&cs&b'")).create());
                }
            }
        }.runTaskTimer(plugin, 0, 2L);
    }
}
