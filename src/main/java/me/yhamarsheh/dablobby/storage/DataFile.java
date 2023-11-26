package me.yhamarsheh.dablobby.storage;

import me.yhamarsheh.dablobby.DabLobby;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;
import java.io.IOException;

public class DataFile {

    private static File dataFile;
    private static YamlConfiguration dataYaml;
    private DabLobby plugin;
    public DataFile(DabLobby plugin) {
        this.plugin = plugin;
        dataFile = new File(plugin.getDataFolder(), "data.yml");
        dataYaml = YamlConfiguration.loadConfiguration(dataFile);
    }

    public static void updateData(Player player, String path, Object obj) {
        dataYaml.set(player.getUniqueId() + "." + path, obj);
        try {
            dataYaml.save(dataFile);
        } catch(IOException ex) {
            ex.printStackTrace();
        }
    }

    public static Object getData(Player player, String path) {
        return dataYaml.get(player.getUniqueId() + "." + path);
    }

}
