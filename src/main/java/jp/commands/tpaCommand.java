package jp.commands;

import jp.jp.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class tpaCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (args.length == 0) {
                player.sendMessage(ChatColor.RED + "Bitte benutze " + ChatColor.YELLOW + "/tpa [Spieler]" + ChatColor.RED + "!");
            } else if (args.length == 1) {

                try {
                    Player target = Bukkit.getPlayer(args[0]);

                    Main.tpaHash.put(target, player);

                    target.sendMessage(ChatColor.GREEN + "Du hast eine TPA-Anfrage von " + ChatColor.YELLOW + player.getName() + ChatColor.GREEN + " bekommen! Zum Annehmen benutze " + ChatColor.YELLOW + "/tpaccept" + ChatColor.GREEN + "!");
                    player.sendMessage(ChatColor.GREEN + "Der Spieler " + ChatColor.YELLOW + target.getName() + ChatColor.GREEN + " hat die Anfrage bekommen!");
                } catch (Exception ex) {
                    player.sendMessage(ChatColor.RED + "Der Spieler " + ChatColor.YELLOW + args[0] + ChatColor.RED + " ist nicht Online!");
                }

            } else {
                player.sendMessage(ChatColor.RED + "Bitte benutze " + ChatColor.YELLOW + "/tpa [Spieler]" + ChatColor.RED + "!");
            }
        } else {
            sender.sendMessage(ChatColor.RED + "Dazu musst du Spieler sein!");
        }
        return false;
    }
}
