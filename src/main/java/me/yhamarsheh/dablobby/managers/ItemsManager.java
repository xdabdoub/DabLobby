package me.yhamarsheh.dablobby.managers;

import me.yhamarsheh.dablobby.components.LobbyItem;
import me.yhamarsheh.dablobby.components.items.GameSelector;
import me.yhamarsheh.dablobby.utilities.DabItems;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;

public class ItemsManager {

    private Map<Player, LobbyItem> items;
    /*
    Items | Instead of creating multiple instances of the item, we just create it once to improve performance.
     */
    private GameSelector gameSelector;
    public ItemsManager() {
        this.items = new HashMap<>();
        init();
    }

    private void init() {
        gameSelector = new GameSelector();
    }

    public LobbyItem getLobbyItemByName(String s) {
        if (s == null) return null;

        switch (s) {
            case "gameselector":
                return getGameSelector();
            default:
                return null;
        }
    }

    public GameSelector getGameSelector() {
        return gameSelector;
    }

}
