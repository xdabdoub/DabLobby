package me.yhamarsheh.dablobby.listeners;

import me.yhamarsheh.dablobby.DabLobby;
import org.bukkit.Bukkit;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.weather.WeatherChangeEvent;
import org.bukkit.inventory.CraftingInventory;
import org.bukkit.inventory.FurnaceInventory;
import org.bukkit.inventory.PlayerInventory;

public class QOLListeners implements Listener {

    private DabLobby plugin;
    public QOLListeners(DabLobby plugin) {
        this.plugin = plugin;
        Bukkit.getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    public void onFoodChange(FoodLevelChangeEvent e) {
        HumanEntity entity = e.getEntity();
        if (!(entity instanceof Player)) return;
        e.setCancelled(true);
    }

    @EventHandler
    public void onMove(PlayerMoveEvent e) {
        Player player = e.getPlayer();
        if (player.getLocation().getY() < 3) {
            player.teleport(plugin.lobby);
        }
    }

    @EventHandler
    public void onDamage(EntityDamageEvent e) {
        e.setCancelled(true);
    }

    @EventHandler
    public void onWeatherChange(WeatherChangeEvent e) {
        e.setCancelled(true);
    }

    @EventHandler
    public void inventoryHandler(InventoryClickEvent e) {
        if (e.getWhoClicked().hasPermission("dablobby.inventory.bypass")) return;
        if (e.getClickedInventory() instanceof PlayerInventory || e.getClickedInventory() instanceof CraftingInventory
        || e.getClickedInventory() instanceof FurnaceInventory) e.setCancelled(true);
    }

    @EventHandler
    public void onDrop(PlayerDropItemEvent e) {
        if (e.getPlayer().hasPermission("dablobby.inventory.bypass")) return;
        e.setCancelled(true);
    }
}
