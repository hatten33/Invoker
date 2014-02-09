package net.aerenserve.hackathon;

import java.util.ArrayList;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class Invoker extends JavaPlugin {

	Listeners l;
	ArrayList<String> cooldown;
	ArrayList<String> recipes;

	@Override
	public void onEnable() {

		cooldown = new ArrayList<String>();
		recipes = new ArrayList<String>();

		recipes.add(ChatColor.RED + "Fireball" + ChatColor.WHITE + " : "
				+ ChatColor.RED + " 0 " + ChatColor.RED + " 0 "
				+ ChatColor.GREEN + " 0");
		recipes.add(ChatColor.AQUA + "Heal" + ChatColor.WHITE + " : "
				+ ChatColor.GREEN + " 0 " + ChatColor.GREEN + " 0 "
				+ ChatColor.GREEN + " 0");
		recipes.add(ChatColor.GRAY + "Daze" + ChatColor.WHITE + " : "
				+ ChatColor.RED + " 0 " + ChatColor.AQUA + " 0 "
				+ ChatColor.GREEN + " 0");
		recipes.add(ChatColor.WHITE + "Smite" + ChatColor.WHITE + " : "
				+ ChatColor.AQUA + " 0 " + ChatColor.GREEN + " 0 "
				+ ChatColor.AQUA + " 0");
		recipes.add(ChatColor.BLACK + "Arrow" + ChatColor.WHITE + " : "
				+ ChatColor.RED + " 0 " + ChatColor.AQUA + " 0 "
				+ ChatColor.AQUA + " 0");
		recipes.add(ChatColor.YELLOW + "Clock" + ChatColor.WHITE + " : "
				+ ChatColor.GREEN + " 0 " + ChatColor.AQUA + " 0 "
				+ ChatColor.AQUA + " 0");
		recipes.add(ChatColor.DARK_PURPLE + "Dragon" + ChatColor.WHITE + " : "
				+ ChatColor.AQUA + " 0 " + ChatColor.AQUA + " 0 "
				+ ChatColor.AQUA + " 0");
		recipes.add(ChatColor.BLUE + "Speed" + ChatColor.WHITE + " : "
				+ ChatColor.GREEN + " 0 " + ChatColor.GREEN + " 0 "
				+ ChatColor.RED + " 0");
		recipes.add(ChatColor.DARK_GREEN + "Blink" + ChatColor.WHITE + " : "
				+ ChatColor.RED + " 0 " + ChatColor.RED + " 0 " + ChatColor.RED
				+ " 0");

		l = new Listeners(this);

		getLogger().info("Invoker v1.0 by hatten33 enabled");
	}

	@Override
	public void onDisable() {
		getLogger().info("Invoker v1.0 by hatten33 disabled");
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (sender instanceof Player) {
			Player p = (Player) sender;
			if (cmd.getName().equalsIgnoreCase("invoke")) {
				for (String s : recipes) {
					p.sendMessage(s);
				}
			}
		}
		return false;
	}

}
