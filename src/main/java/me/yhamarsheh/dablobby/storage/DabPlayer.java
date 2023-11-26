package me.yhamarsheh.dablobby.storage;

import org.bukkit.entity.Player;

public class DabPlayer {

    private final Player player;
    private boolean music;

    public DabPlayer(Player player) {
        this.player = player;
        this.music = true;
        init();
    }

    private void init() {
        if (DataFile.getData(player, "music") == null) {
            save();
            return;
        }

        music = (boolean) DataFile.getData(player, "music");
    }

    public void save() {
        DataFile.updateData(player, "music", music);
    }

    public boolean isMusicOn() {
        return music;
    }

    public boolean toggleMusic() {
        music = !isMusicOn();
        return music;
    }

    public Player getPlayer() {
        return player;
    }

}
