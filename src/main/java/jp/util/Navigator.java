package jp.util;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class Navigator implements Listener {

    public final String GUI_NAME = "§6§lTest-GUI";

    public void OpenGUI(Player player) {

        Inventory inventory = Bukkit.createInventory(null, 9*1, GUI_NAME);
        inventory.setItem(3, new ItemStack(Material.GREEN_WOOL));
        inventory.setItem(5, new ItemStack(Material.RED_WOOL));
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

        try {
            if (event.getClickedInventory().equals(GUI_NAME)) {

                switch (event.getCurrentItem().getType()) {


                    case GREEN_WOOL:
                        player.giveExp(10000);
                        player.closeInventory();
                        break;

                    case RED_WOOL:
                        player.damage(20);
                        player.closeInventory();
                        break;

                }

            }

        } catch (Exception e) {
            switch (event.getCurrentItem().getType()) {

                case GREEN_WOOL:
                    player.giveExp(10000);
                    player.closeInventory();
                    break;

                case RED_WOOL:
                    player.damage(20);
                    player.closeInventory();
                    break;

            }

        }
    }

}
