package net.aerenserve.hackathon.spells;

import java.util.ArrayList;

import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class Speed extends Spell {
	
	static ArrayList<ItemStack> reagents = new ArrayList<ItemStack>();
	static SpellType type = SpellType.SPEED;
	
	public Speed() {
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
		p.playSound(p.getLocation(), Sound.ENDERDRAGON_WINGS, 5, 5);
		p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 400, 3));
	}

}
