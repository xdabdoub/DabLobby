package me.yhamarsheh.dablobby.components;

import dev.triumphteam.gui.guis.Gui;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public abstract class LobbyItem {

    protected ItemStack itemStack;
    protected Action action;
    protected Gui gui;

    protected LobbyItem(ItemStack itemStack, Action action) {
        this.itemStack = itemStack;
        this.action = action;
    }

    protected LobbyItem(ItemStack itemStack, Action action, Gui gui) {
        this(itemStack, action);
        this.gui = gui;
    }

    public abstract void onInteraction(PlayerInteractEvent event);
    public abstract void setupGui();
    public ItemStack getItemStack() {
        return itemStack;
    }

    public Action getAction() {
        return action;
    }

    public Gui getGui() {
        return gui;
    }
}
