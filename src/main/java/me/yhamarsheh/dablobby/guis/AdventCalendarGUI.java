package me.yhamarsheh.dablobby.guis;

import dev.triumphteam.gui.builder.item.ItemBuilder;
import dev.triumphteam.gui.components.InteractionModifier;
import dev.triumphteam.gui.guis.Gui;
import me.yhamarsheh.dablobby.utilities.ChatUtils;
import net.kyori.adventure.text.Component;
import org.bukkit.entity.Player;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashSet;

public class AdventCalendarGUI {

    private final Gui gui;
    private final String PRESENT_SKIN_TEXTURE = "ewogICJ0aW1lc3RhbXAiIDogMTYyNTkwNzgyNjM4NywKICAicHJvZmlsZUlkIiA6ICJkYmNlZjMyZjI5ZDc0Y2UzOTUzOWMwYjBhMTE1YjZiZCIsCiAgInByb2ZpbGVOYW1lIiA6ICJyYW1waXJlIiwKICAic2lnbmF0dXJlUmVxdWlyZWQiIDogdHJ1ZSwKICAidGV4dHVyZXMiIDogewogICAgIlNLSU4iIDogewogICAgICAidXJsIiA6ICJodHRwOi8vdGV4dHVyZXMubWluZWNyYWZ0Lm5ldC90ZXh0dXJlLzljNmRlMzk2NjI5NWE5ODZlZjYzYWUxNWIzOGQ5ZTgyYzJlN2Q1YTc5Y2M0MjMxM2I2MGFkYmJlNWQ3MDRlMTciCiAgICB9CiAgfQp9";
    public AdventCalendarGUI() {
        this.gui = new Gui(5, "HN Advent Calendar 2023", new HashSet<InteractionModifier>() {{
            add(InteractionModifier.PREVENT_ITEM_PLACE);
            add(InteractionModifier.PREVENT_ITEM_TAKE);
        }});

        setupGui();
    }

    private void setupGui() {
        gui.setItem(22, ItemBuilder.skull().texture(PRESENT_SKIN_TEXTURE)
                .name(Component.text("&cAdvent Calendar Unavailable"))
                        .lore(Component.text("&7The advent calendar is unavailable until the"),
                                Component.text("&7warm month of December. Come back for rewards"),
                                Component.text("&7on the 1st of December!"),
                                Component.text(ChatUtils.color("&7")),
                                Component.text(ChatUtils.color("&b" + ChatUtils.dateDifference(new GregorianCalendar(), new GregorianCalendar(2023, Calendar.DECEMBER, 1)) + " left!")))
                .asGuiItem(e -> e.setCancelled(true)));
    }

    public void open(Player player) {
        gui.open(player);
    }
}
