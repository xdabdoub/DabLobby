package me.yhamarsheh.dablobby.utilities;

import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;
import me.yhamarsheh.dablobby.DabLobby;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class PlayerUtils {

    public static void sendToServer(Player player, String server) {
        ByteArrayDataOutput out = ByteStreams.newDataOutput();
        out.writeUTF("Connect");
        out.writeUTF(server);

        player.sendPluginMessage(JavaPlugin.getPlugin(DabLobby.class), "BungeeCord", out.toByteArray());
    }
}
