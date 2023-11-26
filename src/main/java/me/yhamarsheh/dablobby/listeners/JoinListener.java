package me.yhamarsheh.dablobby.listeners;

import me.yhamarsheh.dablobby.DabLobby;
import me.yhamarsheh.dablobby.components.LobbyItem;
import me.yhamarsheh.dablobby.storage.DabPlayer;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

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
        DabPlayer dabPlayer = new DabPlayer(player);
        plugin.getPlayersManager().getPlayersData().put(player, dabPlayer);

        player.getInventory().clear();
        player.teleport(plugin.lobby);

        LobbyItem lobbyItem = plugin.getItemsManager().getGameSelector();
        if (lobbyItem == null) return;

        player.getInventory().setItem(lobbyItem.getSlot(), lobbyItem.getItemStack());
        if (dabPlayer.isMusicOn()) plugin.getMusicPlayer().play(player);
        player.updateInventory();
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent e) {
        Player player = e.getPlayer();
        DabPlayer dabPlayer = plugin.getPlayersManager().getPlayerData(player);
        if (dabPlayer == null) return;

        plugin.getMusicPlayer().stop(player);
        dabPlayer.save();
        plugin.getPlayersManager().getPlayersData().remove(player);
    }
}
