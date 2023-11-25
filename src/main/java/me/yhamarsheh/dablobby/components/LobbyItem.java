package me.yhamarsheh.dablobby.components;

import dev.triumphteam.gui.guis.Gui;
import org.bukkit.entity.Player;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public abstract class LobbyItem {

    protected ItemStack itemStack;
    protected Action action;
    protected Gui gui;
    protected int slot;

    protected LobbyItem(ItemStack itemStack, Action action, int slot) {
        this.itemStack = itemStack;
        this.action = action;
        this.slot = slot;
    }

    protected LobbyItem(ItemStack itemStack, Action action, Gui gui, int slot) {
        this(itemStack, action, slot);
        this.gui = gui;
    }

    public abstract void onInteraction(PlayerInteractEvent event);
    public abstract void setupGui(Player player);
    public ItemStack getItemStack() {
        return itemStack;
    }

    public Action getAction() {
        return action;
    }

    public Gui getGui() {
        return gui;
    }

    public int getSlot() {
        return slot;
    }
}
