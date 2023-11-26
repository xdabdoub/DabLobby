package me.yhamarsheh.dablobby.managers;

import me.yhamarsheh.dablobby.storage.DabPlayer;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;

public class PlayersManager {

    private Map<Player, DabPlayer> playersData;
    public PlayersManager() {
        this.playersData = new HashMap<>();
    }

    public DabPlayer getPlayerData(Player player) {
        return playersData.get(player);
    }

    public Map<Player, DabPlayer> getPlayersData() {
        return playersData;
    }
}
