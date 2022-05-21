package jp.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

public class statusCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player) {

            Player player = (Player) sender;

            if (args.length == 1) {

                Scoreboard suffixBoard = Bukkit.getScoreboardManager().getNewScoreboard();

                suffixBoard.registerNewTeam(args[0]);

                Team suffixTeam = suffixBoard.getTeam(args[0]);
                suffixTeam.setSuffix(args[0]);

                suffixBoard.getTeam(args[0]);

                player.setScoreboard(suffixBoard);

                player.sendMessage(ChatColor.GREEN + "Dein Status wurde auf " + ChatColor.YELLOW + "'" + args[0] + "'" + ChatColor.GREEN + " gesetzt");

            }

        } else {

           sender.sendMessage(ChatColor.RED + "Dazu musst du Spieler sein!");

        }

        return false;
    }
}
