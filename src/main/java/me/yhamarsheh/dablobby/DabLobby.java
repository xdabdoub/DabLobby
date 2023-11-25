package me.yhamarsheh.dablobby;

import me.yhamarsheh.dablobby.commands.DabLobbyCMD;
import me.yhamarsheh.dablobby.listeners.ItemsHandlerListener;
import me.yhamarsheh.dablobby.listeners.JoinListener;
import me.yhamarsheh.dablobby.listeners.QOLListeners;
import me.yhamarsheh.dablobby.managers.ItemsManager;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.plugin.java.JavaPlugin;

public class DabLobby extends JavaPlugin {

    private ItemsManager itemsManager;

    public Location lobby;

    @Override
    public void onEnable() {
        itemsManager = new ItemsManager();
        this.getServer().getMessenger().registerOutgoingPluginChannel(this, "BungeeCord");

        loadLobby();

        new DabLobbyCMD(this);
        new ItemsHandlerListener(this);
        new JoinListener(this);
        new QOLListeners(this);
    }

    @Override
    public void onDisable() {
        this.getServer().getMessenger().unregisterOutgoingPluginChannel(this);
    }

    public ItemsManager getItemsManager() {
        return itemsManager;
    }

    private void loadLobby() {
        if (getConfig() == null) return;
        if (getConfig().getString("lobby") == null) return;

        String[] data = getConfig().getString("lobby").split(";");
        World world = Bukkit.getWorld(data[0]);
        double x = Double.parseDouble(data[1]);
        double y = Double.parseDouble(data[2]);
        double z = Double.parseDouble(data[3]);
        float yaw = Float.parseFloat(data[4]);
        float pitch = Float.parseFloat(data[5]);

        lobby = new Location(world, x,y,z,yaw,pitch);
    }

    public void saveLobby() {

        World world = lobby.getWorld();
        double x = lobby.getX();
        double y = lobby.getY();
        double z = lobby.getZ();
        float yaw = lobby.getYaw();
        float pitch = lobby.getPitch();

        getConfig().set("lobby", x + ";" + y + ";" + z + ";" + yaw + ";" + pitch);
        saveConfig();
    }
}
