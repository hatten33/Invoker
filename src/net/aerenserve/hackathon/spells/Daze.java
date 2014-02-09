package net.aerenserve.hackathon.spells;

import java.util.ArrayList;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class Daze extends Spell {
	
	static ArrayList<ItemStack> reagents = new ArrayList<ItemStack>();
	static SpellType type = SpellType.DAZE;
	
	public Daze() {
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
		p.sendMessage(ChatColor.DARK_GRAY + "Thou foolish one, messing with the darker magics.");
		p.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 60, 1));
		p.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 60, 1));
		p.addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION, 180, 50));
	}
}
