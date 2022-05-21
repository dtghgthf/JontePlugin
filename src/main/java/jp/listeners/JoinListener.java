package jp.listeners;

import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinListener implements Listener {
    @EventHandler
    public void OnJoin(PlayerJoinEvent event) {
        event.setJoinMessage(ChatColor.YELLOW + "Der Spieler " + ChatColor.GREEN + event.getPlayer().getName() + ChatColor.YELLOW + " hat den Server betreten!");
    }
}
