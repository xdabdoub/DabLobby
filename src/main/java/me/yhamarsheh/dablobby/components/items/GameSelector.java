package me.yhamarsheh.dablobby.components.items;

import dev.triumphteam.gui.builder.item.ItemBuilder;
import dev.triumphteam.gui.components.InteractionModifier;
import dev.triumphteam.gui.guis.Gui;
import me.yhamarsheh.dablobby.components.LobbyItem;
import me.yhamarsheh.dablobby.utilities.ChatUtils;
import me.yhamarsheh.dablobby.utilities.DabItems;
import me.yhamarsheh.dablobby.utilities.PlayerUtils;
import net.kyori.adventure.text.Component;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import java.util.HashSet;
import java.util.Set;

public class GameSelector extends LobbyItem {

    private final String DISCORD_SKIN_TEXUTRE = "eyJ0aW1lc3RhbXAiOjE1ODI4MzAyNzgwMDEsInByb2ZpbGVJZCI6Ijc3MjdkMzU2NjlmOTQxNTE4MDIzZDYyYzY4MTc1OTE4IiwicHJvZmlsZU5hbWUiOiJsaWJyYXJ5ZnJlYWsiLCJzaWduYXR1cmVSZXF1aXJlZCI6dHJ1ZSwidGV4dHVyZXMiOnsiU0tJTiI6eyJ1cmwiOiJodHRwOi8vdGV4dHVyZXMubWluZWNyYWZ0Lm5ldC90ZXh0dXJlLzU2NGEzMmU2MjVlM2YxZGE1NWIwOGVkY2IyNjIwM2RjZTgxNzBlZDA4Mzg3OWFhNTRiMzRlMzY1MDlmYTg5ZmIifX19";
    private final String SMP_SKIN_TEXTURE = "ewogICJ0aW1lc3RhbXAiIDogMTY3NjkxNTYzMjcyMCwKICAicHJvZmlsZUlkIiA6ICIzOTdlMmY5OTAyNmI0NjI1OTcyNTM1OTNjODgyZjRmMyIsCiAgInByb2ZpbGVOYW1lIiA6ICJ4WnlkdWVMeCIsCiAgInNpZ25hdHVyZVJlcXVpcmVkIiA6IHRydWUsCiAgInRleHR1cmVzIiA6IHsKICAgICJTS0lOIiA6IHsKICAgICAgInVybCIgOiAiaHR0cDovL3RleHR1cmVzLm1pbmVjcmFmdC5uZXQvdGV4dHVyZS81ZWFhOWFjMTU3NThkNTE3N2E4OTY2MDU5ODVlOThiZWFjOGZlZTBlNmIyYzY4YThkYzFmM2M5MWMwNzlmYjg5IgogICAgfQogIH0KfQ==";
    public GameSelector() {
        super(DabItems.GAME_SELECTOR.getItemStack(), Action.RIGHT_CLICK_AIR, 4);
    }

    @Override
    public void onInteraction(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        setupGui(player);
        gui.open(player);
    }

    @Override
    public void setupGui(Player player) {
        gui = new Gui(5, "Game Selector", new HashSet<InteractionModifier>() {{
            add(InteractionModifier.PREVENT_ITEM_PLACE);
            add(InteractionModifier.PREVENT_ITEM_TAKE);
        }});

        gui.setItem(10, ItemBuilder.skull().texture(DISCORD_SKIN_TEXUTRE)
                .name(Component.text(ChatUtils.color("&9Join Our Discord")))
                .lore(Component.text(ChatUtils.color("&7Connect with other players, view")),
                        Component.text(ChatUtils.color("&7recent updates, enter giveaways,")),
                        Component.text(ChatUtils.color("&7and much more! @ &bhttps://discord.gg/85eBDkPZSg")))
                .asGuiItem(e -> {
                    player.sendMessage(ChatUtils.color("&9Discord: https://discord.gg/85eBDkPZSg"));
                    gui.close(player);
                    e.setCancelled(true);
                }));

        gui.setItem(19, ItemBuilder.skull().owner(player)
                .name(Component.text(ChatUtils.color("&bYour Statistics")))
                .lore(Component.text(ChatUtils.color("&csoon."))).asGuiItem());

        gui.setItem(28, ItemBuilder.from(Material.GOLD_NUGGET)
                .name(Component.text(ChatUtils.color("&aVisit Our Store")))
                .lore(Component.text(ChatUtils.color("&7Improve your gameplay, and gain")),
                        Component.text(ChatUtils.color("&7access to exclusive features by")),
                        Component.text(ChatUtils.color("&7purchasing a rank @ &bhttps://store.hybridmc.xyz")))
                .asGuiItem(e -> {
                    player.sendMessage(ChatUtils.color("&aStore: https://store.hybridmc.xyz"));
                    gui.close(player);
                    e.setCancelled(true);
                }));

        gui.setItem(22, ItemBuilder.skull().texture(SMP_SKIN_TEXTURE)
                .name(Component.text(ChatUtils.color("&bSMP")))
                .lore(Component.text(ChatUtils.color("&7Uncover the survival world of")),
                        Component.text(ChatUtils.color("&7Minecraft, wander the wonderful world of")),
                        Component.text(ChatUtils.color("&7Hybrid Network, and complete difficult quests")),
                Component.text(ChatUtils.color("&7in order to win rewards!")),
                        Component.text(ChatUtils.color("&7")),
                        Component.text(ChatUtils.color("&3Click to play!")))
                .asGuiItem(e -> {
                    PlayerUtils.sendToServer(player, "SMP");
                    e.setCancelled(true);
                }));

        gui.setItem(22, ItemBuilder.from(Material.SANDSTONE)
                .name(Component.text(ChatUtils.color("&bFastbridger")))
                .lore(Component.text(ChatUtils.color("&7...")),
                        Component.text(ChatUtils.color("&7..")),
                        Component.text(ChatUtils.color("&7...")),
                        Component.text(ChatUtils.color("&7.")),
                        Component.text(ChatUtils.color("&7")),
                        Component.text(ChatUtils.color("&3Click to play!")))
                .asGuiItem(e -> {
                    PlayerUtils.sendToServer(player, "Fastbridger");
                    e.setCancelled(true);
                }));

        gui.setItem(23, ItemBuilder.from(Material.BARRIER)
                .name(Component.text(ChatUtils.color("&cComing Soon")))
                .lore(Component.text(ChatUtils.color("&7...")),
                        Component.text(ChatUtils.color("&7..")),
                        Component.text(ChatUtils.color("&7...")),
                        Component.text(ChatUtils.color("&7.")),
                        Component.text(ChatUtils.color("&7")),
                        Component.text(ChatUtils.color("&3&mClick to play!")))
                .asGuiItem(e -> {
                    gui.close(player);
                    e.setCancelled(true);
                }));
    }
}
