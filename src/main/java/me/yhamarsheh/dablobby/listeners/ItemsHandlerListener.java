package me.yhamarsheh.dablobby.listeners;

import dev.triumphteam.gui.components.util.ItemNbt;
import me.yhamarsheh.dablobby.DabLobby;
import me.yhamarsheh.dablobby.components.LobbyItem;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class ItemsHandlerListener implements Listener {

    private DabLobby plugin;
    public ItemsHandlerListener(DabLobby plugin) {
        this.plugin = plugin;
        Bukkit.getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    public void onInteraction(PlayerInteractEvent e) {
        ItemStack item = e.getItem();
        Player player = e.getPlayer();

        if (item == null) return;
        if (!isLobbyItem(item)) return;
        LobbyItem lobbyItem = plugin.getItemsManager().getLobbyItemByName(getNbt(item));
        if (lobbyItem == null) return;
        if (e.getAction() != lobbyItem.getAction()) return;
        lobbyItem.onInteraction(e);
    }

    private boolean isLobbyItem(ItemStack itemStack) {
        if (itemStack == null) return false;
        final String nbt = ItemNbt.getString(itemStack, "dabitem");
        return nbt != null;
    }

    private String getNbt(ItemStack itemStack) {
        if (itemStack == null) return null;
        final String nbt = ItemNbt.getString(itemStack, "dabitem");
        if (nbt == null) return null;
        return nbt;
    }
}
