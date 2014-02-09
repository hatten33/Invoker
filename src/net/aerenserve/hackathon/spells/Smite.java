package net.aerenserve.hackathon.spells;

import java.util.ArrayList;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class Smite extends Spell {
	
	static ArrayList<ItemStack> reagents = new ArrayList<ItemStack>();
	static SpellType type = SpellType.SMITE;
	
	public Smite() {
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
		p.getWorld().strikeLightning(p.getTargetBlock(null, 200).getLocation());
	}

}
