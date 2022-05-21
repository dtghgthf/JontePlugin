package jp.commands;

import jp.jp.Main;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class tpacceptCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (args.length == 0) {
                Player tpaSender = Main.tpaHash.get(player);

                tpaSender.teleport(player.getLocation());
                tpaSender.sendMessage(ChatColor.GREEN + "Du wurdest erfolgreich zu " + ChatColor.YELLOW + tpaSender.getName() + ChatColor.GREEN + " teleportiert!");
                player.sendMessage(ChatColor.YELLOW + tpaSender.getName() + ChatColor.GREEN + " wurde Erfolgreich zu dir teleportiert!");
            } else {
                player.sendMessage(ChatColor.RED + "Bitte benutze " + ChatColor.YELLOW + "/tpaccept" + ChatColor.RED + "!");
            }
        } else {
            sender.sendMessage(ChatColor.RED + "Dazu musst du Spieler sein!");
        }
        return false;
    }
}
