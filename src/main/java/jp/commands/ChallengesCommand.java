package jp.commands;

import jp.util.ItemBuilder;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class ChallengesCommand implements CommandExecutor, Listener {

    public final String GUI_NAME = "§6§lChallenges";

    public void OpenGUI(Player player) {

        Inventory inventory = Bukkit.createInventory(null, 9*6, GUI_NAME);
        inventory.setItem(4, new ItemBuilder(Material.IRON_AXE).setName("BedBreaker").setLore(ChatColor.RED + "Linksklick zum Spielen", ChatColor.GREEN + "Rechtsklick für Einstellungen").build());
        player.openInventory(inventory);

    }

    /*@EventHandler
    public void handleNavigatorOpener(PlayerInteractEvent event) {

        if (event.getItem().getType() != Material.BELL) return;

        if (event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK) {

            OpenGUI(event.getPlayer());

        }

    }*/

    @EventHandler
    public void handleNavigatorGUIClick(InventoryClickEvent event) {

        if (!(event.getWhoClicked() instanceof Player)) return;

        Player player = (Player) event.getWhoClicked();

        if (event.getView().getTitle().equals(GUI_NAME)) {

            switch (event.getCurrentItem().getType()) {

                case IRON_AXE:
                    if (event.getClick().isLeftClick()) {

                        player.sendMessage(ChatColor.YELLOW + "Bedbreaker" + ChatColor.GREEN + " wird gestartet");

                    } else if (event.getClick().isRightClick()) {

                        player.sendMessage((ChatColor.YELLOW + "Eintellungen" + ChatColor.GREEN + " werden geöffnet"));

                    }
                    player.closeInventory();
                    break;

                default:
                    player.damage(20);
                    player.closeInventory();
                    break;

            }

        }


    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player) {

            Player player = (Player) sender;
            OpenGUI(player);

        }

        return false;
    }
}
