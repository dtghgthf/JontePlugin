package jp.commands;

import jp.jp.Main;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class warpCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player) {

            Player player = (Player) sender;

            if (args.length == 1) {

                // zum warp teleportieren
                if (Main.warpHash.containsKey(args[0])) {

                    player.teleport(Main.warpHash.get(args[0]));
                    player.sendMessage(ChatColor.GREEN + "Du wurdest zu dem Warp " + ChatColor.YELLOW + "'" + args[0] + "'" + ChatColor.GREEN + " teleportiert");

                } else {

                    player.sendMessage(ChatColor.RED + "Diesen Warp gibt es nicht!");

                }


            } else if (args.length == 2) {

                // warp hinzufügen
                if (args[0].equals("add")) {


                    if (!Main.warpHash.containsKey(args[1])) {

                        Main.warpHash.put(args[1], player.getLocation());
                        player.sendMessage(ChatColor.GREEN + "Der Warp " + ChatColor.YELLOW + "'" + args[1] + "'" + ChatColor.GREEN + " wurde hinzugefügt");

                    } else {

                        player.sendMessage(ChatColor.RED + "Diesen Warp gibt es schon!");

                    }

                } else if (args[0].equals("delete")) {


                    if (Main.warpHash.containsKey(args[1])) {
                        // warp entfernen

                        Main.warpHash.remove(args[1]);
                        player.sendMessage(ChatColor.GREEN + "Der Warp " + ChatColor.YELLOW + "'" + args[1] + "'" + ChatColor.GREEN + " wurde entfernt");

                    } else {

                        player.sendMessage(ChatColor.RED + "Diesen Warp gibt es nicht!");

                    }

                }

            } else {

                player.sendMessage(ChatColor.RED + "Bitte benutze " + ChatColor.YELLOW + "/warp add [warp] oder /warp [warp]");

            }
        } else {

            sender.sendMessage(ChatColor.RED + "Dazu musst du Spieler sein!");

        }

        return false;
    }
}
