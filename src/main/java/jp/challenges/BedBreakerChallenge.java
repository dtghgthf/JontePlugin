package jp.challenges;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Player;

public class BedBreakerChallenge {

    public static final Location arenaPos = new Location(Bukkit.getWorld("World"), -277.999, 14.00, 371.999);

    public static void goToArena(Player player) {

        player.teleport(arenaPos);
        player.sendTitle(ChatColor.RED + "BedBreaker", ChatColor.GREEN + "Welcome!", 20, 50, 30);

    }

}
