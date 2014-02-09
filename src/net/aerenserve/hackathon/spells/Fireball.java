package net.aerenserve.hackathon.spells;

import java.util.ArrayList;

import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.entity.SmallFireball;
import org.bukkit.inventory.ItemStack;

public class Fireball extends Spell {

	static ArrayList<ItemStack> reagents = new ArrayList<ItemStack>();
	static SpellType type = SpellType.FIREBALL;

	public Fireball() {
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
		p.playSound(p.getLocation(), Sound.GHAST_FIREBALL, 5, 5);
		p.launchProjectile(SmallFireball.class).setVelocity(p.getLocation().getDirection().multiply(0.5));
	}
}
