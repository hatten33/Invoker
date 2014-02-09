package net.aerenserve.hackathon.spells;

import java.util.ArrayList;

import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class Blink extends Spell {
	
	static ArrayList<ItemStack> reagents = new ArrayList<ItemStack>();
	static SpellType type = SpellType.BLINK;
	
	public Blink() {
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
		p.playSound(p.getLocation(), Sound.ENDERMAN_TELEPORT, 5, 5);
		@SuppressWarnings("deprecation")
		Location loc = p.getTargetBlock(null, 200).getLocation();	
		p.teleport(loc);
	}

}
