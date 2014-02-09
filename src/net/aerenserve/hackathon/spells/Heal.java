package net.aerenserve.hackathon.spells;

import java.util.ArrayList;

import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class Heal extends Spell {
	
	static ArrayList<ItemStack> reagents = new ArrayList<ItemStack>();
	static SpellType type = SpellType.HEAL;
	
	public Heal() {
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
		p.sendMessage("You feel your health being restored");
		p.playSound(p.getLocation(), Sound.PORTAL, 5, 5);
		p.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 100, 2));	
	}
}
