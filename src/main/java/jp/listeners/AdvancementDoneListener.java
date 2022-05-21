package jp.listeners;

import jp.jp.Main;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerAdvancementDoneEvent;
import org.bukkit.permissions.PermissionAttachment;

public class AdvancementDoneListener implements Listener {

    @EventHandler
    public void OnAdvancementDone(PlayerAdvancementDoneEvent event) {

        Player player = event.getPlayer();

        if (event.getAdvancement().equals("adventure/adventuring_time")) {

            PermissionAttachment att = player.addAttachment(Main.MainClass);

            att.setPermission("commands.invsee", true);

            Main.perms.put(player, att);

            player.sendMessage(ChatColor.GREEN + "Glückwunsch! Du hast dir etwas verdient! Du hast den " + ChatColor.YELLOW + "/invsee " + ChatColor.GREEN + "freigeschaltet!");

        }

    }

}
