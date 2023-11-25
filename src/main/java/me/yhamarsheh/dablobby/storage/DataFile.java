package me.yhamarsheh.dablobby.storage;

import me.yhamarsheh.dablobby.DabLobby;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;

public class DataFile {

    public static File DATA_FILE;
    public static YamlConfiguration DATA_YAML;
    private DabLobby plugin;

    public DataFile(DabLobby plugin) {
        this.plugin = plugin;
        this.DATA_FILE = new File(plugin.getDataFolder(), "data.yml");
        this.DATA_YAML = YamlConfiguration.loadConfiguration(DATA_FILE);
    }
}
