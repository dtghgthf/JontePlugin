package jp.jp;

import jp.commands.*;
import jp.listeners.AdvancementDoneListener;
import jp.listeners.JoinListener;
import jp.listeners.deathListener;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.permissions.PermissionAttachment;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;

public final class Main extends JavaPlugin {

    public static HashMap<Player, Player> tpaHash = new HashMap<Player, Player>();
    public static HashMap<String, Location> warpHash = new HashMap<String, Location>();
    public static HashMap<Player, PermissionAttachment> perms = new HashMap<Player, PermissionAttachment>();

    public static Main MainClass;

    @Override
    public void onEnable() {

        MainClass = this;

        // Plugin startup logic
        System.out.println(ChatColor.GREEN + "[JP]: Plugin Started!");
        System.out.println(ChatColor.GREEN + "[JP]:" + ChatColor.GRAY + " Plugin Created by Erik Echterhoff (Ingame: dtghgthf)");

        // Commands
        this.getCommand("tpa").setExecutor(new tpaCommand());
        this.getCommand("tpaccept").setExecutor(new tpacceptCommand());
        this.getCommand("warp").setExecutor(new warpCommand());
        this.getCommand("warps").setExecutor(new warpsCommand());
        this.getCommand("invsee").setExecutor(new invseeCommand());
        this.getCommand("status").setExecutor(new statusCommand());
        this.getCommand("challenges").setExecutor(new ChallengesCommand());

        // TabCompleter
        // ------------------------->  https://www.youtube.com/watch?v=plOmQ_NoibY <-------------------------

        // Listener
        getServer().getPluginManager().registerEvents(new JoinListener(), this);
        getServer().getPluginManager().registerEvents(new deathListener(), this);
        getServer().getPluginManager().registerEvents(new AdvancementDoneListener(), this);
        getServer().getPluginManager().registerEvents(new ChallengesCommand(), this);

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        System.out.println(ChatColor.GREEN + "[JP]: Plugin Stopped!");
        System.out.println(ChatColor.GREEN + "[JP]:" + ChatColor.GRAY + " Bye Bye!");
    }
}
