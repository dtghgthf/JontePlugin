package jp.commands;

import jp.jp.Main;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class warpsCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player) {

            Player player = (Player) sender;

            if (args.length == 0) {

                player.sendMessage(ChatColor.GREEN + "Die warps sind: ");

                for (String key: Main.warpHash.keySet()){
                    player.sendMessage(ChatColor.GREEN + key + ChatColor.GRAY + " -> " + ChatColor.YELLOW + Math.round(Main.warpHash.get(key).getX()) + ", " + Math.round(Main.warpHash.get(key).getY()) + ", " + Math.round(Main.warpHash.get(key).getZ()));
                }

            } else {

                player.sendMessage(ChatColor.RED + "Bitte benutze " + ChatColor.YELLOW + "/warps");

            }

        } else {

            sender.sendMessage(ChatColor.RED + "Dazu musst du Spieler sein!");

        }

        return false;
    }
}
