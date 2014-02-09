package net.aerenserve.hackathon.spells;

import java.util.ArrayList;

import org.bukkit.ChatColor;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class Dragon extends Spell{
	
	static ArrayList<ItemStack> reagents = new ArrayList<ItemStack>();
	static SpellType type = SpellType.DRAGON;
	
	public Dragon() {
		super(type, reagents);
	}

	@Override
	public ArrayList<ItemStack> getReagents() {
		return reagents;
	}

	@Override
	public SpellType getType() {
		return type;
	}
	
	@Override
	public void castSpell(Player p) {
		p.sendMessage(ChatColor.DARK_PURPLE + "HOW COULD YOU DO THIS TO YOURSELF!?!");
		p.getWorld().spawnEntity(p.getLocation(), EntityType.ENDER_DRAGON);
	}

}
