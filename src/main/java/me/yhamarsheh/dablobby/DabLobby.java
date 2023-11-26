package me.yhamarsheh.dablobby;

import com.xxmicloxx.NoteBlockAPI.utils.NBSDecoder;
import me.yhamarsheh.dablobby.commands.AdventCalendarCMD;
import me.yhamarsheh.dablobby.commands.DabLobbyCMD;
import me.yhamarsheh.dablobby.commands.MerryChristmasCMD;
import me.yhamarsheh.dablobby.listeners.ItemsHandlerListener;
import me.yhamarsheh.dablobby.listeners.JoinListener;
import me.yhamarsheh.dablobby.listeners.QOLListeners;
import me.yhamarsheh.dablobby.managers.ItemsManager;
import me.yhamarsheh.dablobby.managers.PlayersManager;
import me.yhamarsheh.dablobby.storage.DataFile;
import me.yhamarsheh.dablobby.utilities.MusicPlayer;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;

public class DabLobby extends JavaPlugin {

    private ItemsManager itemsManager;
    public Location lobby;
    private DataFile dataFile;
    private PlayersManager playersManager;
    private MusicPlayer musicPlayer;

    @Override
    public void onEnable() {
        getServer().getMessenger().registerOutgoingPluginChannel(this, "BungeeCord");

        initAttributes();
        loadLobby();
        registerCommands();
        registerListeners();
    }

    @Override
    public void onDisable() {
        this.getServer().getMessenger().unregisterOutgoingPluginChannel(this);
    }

    public ItemsManager getItemsManager() {
        return itemsManager;
    }

    private void registerCommands() {
        new DabLobbyCMD(this);
        new MerryChristmasCMD(this);
        new AdventCalendarCMD(this);
    }

    private void registerListeners() {
        new ItemsHandlerListener(this);
        new JoinListener(this);
        new QOLListeners(this);
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

    private void initAttributes() {
        itemsManager = new ItemsManager();
        dataFile = new DataFile(this);
        playersManager = new PlayersManager();
        musicPlayer = new MusicPlayer(this, NBSDecoder.parse(new File(getDataFolder(),
                "jinglebells.nbs")));

    }

    public void saveLobby() {

        World world = lobby.getWorld();
        double x = lobby.getX();
        double y = lobby.getY();
        double z = lobby.getZ();
        float yaw = lobby.getYaw();
        float pitch = lobby.getPitch();

        getConfig().set("lobby", world.getName() + ";" + x + ";" + y + ";" + z + ";" + yaw + ";" + pitch);
        saveConfig();
    }

    public PlayersManager getPlayersManager() {
        return playersManager;
    }

    public MusicPlayer getMusicPlayer() {
        return musicPlayer;
    }
}
