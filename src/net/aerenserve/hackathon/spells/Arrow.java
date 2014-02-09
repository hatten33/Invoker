package net.aerenserve.hackathon.spells;

import java.util.ArrayList;

import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class Arrow extends Spell {
	
	static ArrayList<ItemStack> reagents = new ArrayList<ItemStack>();
	static SpellType type = SpellType.ARROW;
	
	public Arrow() {
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
	
	@SuppressWarnings("deprecation")
	@Override
	public void castSpell(Player p) {
		p.playSound(p.getLocation(), Sound.SKELETON_HURT, 5, 5);
		p.shootArrow();
	}
}
