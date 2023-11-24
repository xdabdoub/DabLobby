package me.yhamarsheh.dablobby.components.items;

import dev.triumphteam.gui.builder.item.ItemBuilder;
import dev.triumphteam.gui.components.InteractionModifier;
import dev.triumphteam.gui.guis.Gui;
import me.yhamarsheh.dablobby.components.LobbyItem;
import me.yhamarsheh.dablobby.utilities.DabItems;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import java.util.Set;

public class GameSelector extends LobbyItem {

    public GameSelector() {
        super(DabItems.GAME_SELECTOR.getItemStack(), Action.RIGHT_CLICK_AIR, null);
    }

    @Override
    public void onInteraction(PlayerInteractEvent event) {

    }

    @Override
    public void setupGui() {
        gui = new Gui(45, "Game Selector", Set.of(InteractionModifier.PREVENT_ITEM_PLACE, InteractionModifier.PREVENT_ITEM_TAKE));

        gui.setItem(10, ItemBuilder.skull().texture("http://textures.minecraft.net/texture/2c3e35586df6b942128e08d978a86cf7c0827c4b3ea0f6de43bb0a59a687fe98"));
    }
}
