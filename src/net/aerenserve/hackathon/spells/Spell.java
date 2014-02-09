package net.aerenserve.hackathon.spells;

import java.util.ArrayList;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public abstract class Spell {
	
	public SpellType type;
	public ArrayList<ItemStack> reagents;
	
	protected Spell(SpellType type, ArrayList<ItemStack> reagents) {
		this.type = type;
	}
	
	public abstract ArrayList<ItemStack> getReagents();
	
	public abstract SpellType getType();
	
	public abstract void castSpell(Player caster);
	

}
