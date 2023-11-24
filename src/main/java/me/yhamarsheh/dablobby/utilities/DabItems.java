package me.yhamarsheh.dablobby.utilities;

import dev.triumphteam.gui.builder.item.ItemBuilder;
import net.kyori.adventure.text.Component;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public enum DabItems {

    GAME_SELECTOR(ItemBuilder.from(Material.NETHER_STAR)
            .name(Component.text("<aqua>Game Selector <gray>(Right Click)"))
            .lore(Component.text("<gray>Right click to open the Game Selector!"))
            .build());

    private ItemStack itemStack;
    DabItems(ItemStack itemStack) {
        this.itemStack = itemStack;
    }

    public ItemStack getItemStack() {
        return itemStack;
    }
}
