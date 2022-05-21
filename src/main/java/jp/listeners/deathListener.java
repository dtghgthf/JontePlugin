package jp.listeners;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockState;
import org.bukkit.block.Skull;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

import java.util.Random;
import java.util.UUID;

public class deathListener implements Listener {

    @EventHandler
    public void onDeath(PlayerDeathEvent event) {

        Player player = (Player) event.getEntity().getPlayer();

        player.sendMessage(ChatColor.RED + "Aua! Das sah schmerzhaft aus! \n Du bist hier gestorben: " + ChatColor.YELLOW + Math.round(event.getEntity().getLocation().getX()) + ", " +
                Math.round(event.getEntity().getLocation().getY()) + ", " + Math.round(event.getEntity().getLocation().getZ()));

    }

}
