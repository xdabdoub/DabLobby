package me.yhamarsheh.dablobby.listeners;

import me.yhamarsheh.dablobby.DabLobby;
import me.yhamarsheh.dablobby.components.LobbyItem;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinListener implements Listener {

    private DabLobby plugin;
    public JoinListener(DabLobby plugin) {
        this.plugin = plugin;
        Bukkit.getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    @SuppressWarnings("UnstableApiUsage")
    public void onJoin(PlayerJoinEvent e) {
        Player player = e.getPlayer();

        player.getInventory().clear();
        player.teleport(plugin.lobby);

        LobbyItem lobbyItem = plugin.getItemsManager().getGameSelector();
        if (lobbyItem == null) return;

        player.getInventory().setItem(lobbyItem.getSlot(), lobbyItem.getItemStack());
        player.updateInventory();
    }
}
