package jp.commands;

import jp.challenges.BedBreakerChallenge;
import jp.jp.Main;
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

public class ChallengesCommand implements CommandExecutor, Listener {

    public final String SELECT_GUI_NAME = "§6§lChallenges";
    public final String BB_SETTINGS_GUI_NAME = ChatColor.RED + "BedBreaker Settings";

    Inventory BBSettingsInventory = Bukkit.createInventory(null, 9*6, BB_SETTINGS_GUI_NAME);
    Inventory selectInventory = Bukkit.createInventory(null, 9*6, SELECT_GUI_NAME);



    public void openSelectGUI(Player player) {

        player.closeInventory();
        selectInventory.setItem(4, new ItemBuilder(Material.IRON_AXE).setName("BedBreaker").setLore(ChatColor.RED + "Linksklick zum Spielen", ChatColor.GREEN + "Rechtsklick für Einstellungen").build());
        player.openInventory(selectInventory);

    }

    public void openBBSettingsGUI(Player player) {

        player.closeInventory();
        /*for (int slot = 0; slot <= 6*9; slot++) {

            BBSettingsInventory.setItem(slot, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").build());

        }*/
        BBSettingsInventory.setItem(0, new ItemBuilder(Material.BARRIER).setName("<--").setLore(ChatColor.RED + "Back to Selection").build());

        if (Main.MainClass.getBBPlayerAmount() == 2) {

            BBSettingsInventory.setItem(2*9+1, new ItemBuilder(Material.YELLOW_STAINED_GLASS_PANE).setName("Player Amount").setLore(ChatColor.YELLOW + "2").build());

        } else if (Main.MainClass.getBBPlayerAmount() == 4) {

            BBSettingsInventory.setItem(2*9+1, new ItemBuilder(Material.PINK_STAINED_GLASS_PANE).setName("Player Amount").setLore("§d4").build());

        } else if (Main.MainClass.getBBPlayerAmount() == 6) {

            BBSettingsInventory.setItem(2*9+1, new ItemBuilder(Material.BLUE_STAINED_GLASS_PANE).setName("Player Amount").setLore(ChatColor.BLUE + "§6§l6").build());

        } else if (Main.MainClass.getBBPlayerAmount() == 8) {

            BBSettingsInventory.setItem(2*9+1, new ItemBuilder(Material.ORANGE_STAINED_GLASS_PANE).setName("Player Amount").setLore("8").build());

        }


        player.openInventory(BBSettingsInventory);

    }

    @EventHandler
    public void handleNavigatorGUIClick(InventoryClickEvent event) {

        if (!(event.getWhoClicked() instanceof Player)) return;

        Player player = (Player) event.getWhoClicked();

        // Selection GUI
        if (event.getView().getTitle().equals(SELECT_GUI_NAME)) {

            switch (event.getCurrentItem().getType()) {

                case IRON_AXE:
                    if (event.getClick().isLeftClick()) {

                        player.sendMessage(ChatColor.YELLOW + "Bedbreaker" + ChatColor.GREEN + " wird gestartet");
                        BedBreakerChallenge.goToArena(player);


                    } else if (event.getClick().isRightClick()) {

                        player.sendMessage((ChatColor.YELLOW + "Eintellungen" + ChatColor.GREEN + " werden geöffnet"));
                        openBBSettingsGUI(player);

                    }
                    break;

            }

        }

        // BedBreaker Settings GUI
        if (event.getView().getTitle().equals(BB_SETTINGS_GUI_NAME)) {

            switch (event.getCurrentItem().getType()) {

                case BARRIER:
                    //player.closeInventory();
                    openSelectGUI(player);
                    break;

                case YELLOW_STAINED_GLASS_PANE:
                    Main.MainClass.setBBPlayerAmount(Main.MainClass.getBBPlayerAmount() + 2);
                    BBSettingsInventory.setItem(2*9+1, new ItemBuilder(Material.PINK_STAINED_GLASS_PANE).setName("Player Amount").setLore("§d4").build());
                    event.setCancelled(true);
                    break;

                case PINK_STAINED_GLASS_PANE:
                    Main.MainClass.setBBPlayerAmount(Main.MainClass.getBBPlayerAmount() + 2);
                    BBSettingsInventory.setItem(2*9+1, new ItemBuilder(Material.BLUE_STAINED_GLASS_PANE).setName("Player Amount").setLore(ChatColor.BLUE + "§6§l6").build());
                    event.setCancelled(true);
                    break;

                case BLUE_STAINED_GLASS_PANE:
                    Main.MainClass.setBBPlayerAmount(Main.MainClass.getBBPlayerAmount() + 2);
                    BBSettingsInventory.setItem(2*9+1, new ItemBuilder(Material.ORANGE_STAINED_GLASS_PANE).setName("Player Amount").setLore("8").build());
                    event.setCancelled(true);
                    break;

                case ORANGE_STAINED_GLASS_PANE:
                    Main.MainClass.setBBPlayerAmount(2);
                    BBSettingsInventory.setItem(2*9+1, new ItemBuilder(Material.YELLOW_STAINED_GLASS_PANE).setName("Player Amount").setLore(ChatColor.YELLOW + "2").build());
                    event.setCancelled(true);
                    break;
            }

        }


    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player) {

            Player player = (Player) sender;
            openSelectGUI(player);

        }

        return false;
    }
}
