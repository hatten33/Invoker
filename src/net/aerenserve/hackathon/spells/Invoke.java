package net.aerenserve.hackathon.spells;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Invoke extends Spell {
	
	static ArrayList<ItemStack> reagents = new ArrayList<ItemStack>(); //yeah... not used.
	static SpellType type = SpellType.INVOKE;
	
	public Invoke() {
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
		p.sendMessage(ChatColor.BLUE + "Invoking...");
		p.playSound(p.getLocation(), Sound.FUSE, 5, 5);
		ItemStack item = new ItemStack(Material.BLAZE_ROD, 1);
		ItemMeta im = item.getItemMeta();
		
		SpellType st = invoke(p.getInventory());
		
		switch(st) {
			case INVOKE:
				im.setDisplayName(ChatColor.DARK_AQUA + "Cast Invoke");
				List<String> i = Arrays.asList(ChatColor.DARK_AQUA + "Invoke");
				im.setLore(i);
				item.setItemMeta(im);
				p.getInventory().clear(5);
				p.getInventory().clear(6);
				p.getInventory().clear(7);
				p.updateInventory();
				break;
			case FIREBALL:
				im.setDisplayName(ChatColor.RED + "Cast Fireball");
				List<String> fb = Arrays.asList(ChatColor.RED + "Fireball");
				im.setLore(fb);
				item.setItemMeta(im);
				p.getInventory().clear(3);
				p.getInventory().setItem(3, item);
				p.updateInventory();
				break;
			case HEAL:
				im.setDisplayName(ChatColor.AQUA + "Cast Heal");
				List<String> h = Arrays.asList(ChatColor.AQUA + "Heal");
				im.setLore(h);
				item.setItemMeta(im);
				p.getInventory().clear(3);
				p.getInventory().setItem(3, item);
				p.updateInventory();
				break;
			case DAZE:
				im.setDisplayName(ChatColor.GRAY + "Cast Daze");
				List<String> d = Arrays.asList(ChatColor.GRAY + "Daze");
				im.setLore(d);
				item.setItemMeta(im);				
				p.getInventory().clear(3);
				p.getInventory().setItem(3, item);
				p.updateInventory();
				break;
			case SMITE:
				im.setDisplayName(ChatColor.WHITE + "Cast Smite");
				List<String> s = Arrays.asList(ChatColor.WHITE + "Smite");
				im.setLore(s);
				item.setItemMeta(im);
				p.getInventory().clear(3);
				p.getInventory().setItem(3, item);
				p.updateInventory();
				break;
			case ARROW:
				im.setDisplayName(ChatColor.BLACK + "Cast Arrow");
				List<String> a = Arrays.asList(ChatColor.BLACK + "Arrow");
				im.setLore(a);
				item.setItemMeta(im);
				p.getInventory().clear(3);
				p.getInventory().setItem(3, item);
				p.updateInventory();
				break;
			case CLOCK:
				im.setDisplayName(ChatColor.YELLOW + "Cast Clock");
				List<String> c = Arrays.asList(ChatColor.YELLOW + "Clock");
				im.setLore(c);
				item.setItemMeta(im);
				p.getInventory().clear(3);
				p.getInventory().setItem(3, item);
				p.updateInventory();
				break;
			case DRAGON:
				im.setDisplayName(ChatColor.DARK_PURPLE + "Cast Dragon");
				List<String> dg = Arrays.asList(ChatColor.DARK_PURPLE + "Dragon");
				im.setLore(dg);
				item.setItemMeta(im);
				p.getInventory().clear(3);
				p.getInventory().setItem(3, item);
				p.updateInventory();
				break;
			case SPEED:
				im.setDisplayName(ChatColor.BLUE + "Cast Speed");
				List<String> sp = Arrays.asList(ChatColor.BLUE + "Speed");
				im.setLore(sp);
				item.setItemMeta(im);
				p.getInventory().clear(3);
				p.getInventory().setItem(3, item);
				p.updateInventory();
				break;
			case BLINK:
				im.setDisplayName(ChatColor.DARK_GREEN + "Cast Blink");
				List<String> b = Arrays.asList(ChatColor.DARK_GREEN + "Blink");
				im.setLore(b);
				item.setItemMeta(im);
				p.getInventory().clear(3);
				p.getInventory().setItem(3, item);
				p.updateInventory();
				break;
			default:
				break;
		}
		p.getInventory().clear(5);
		p.getInventory().clear(6);
		p.getInventory().clear(7);
		p.updateInventory();
	}
	
	private SpellType invoke(Inventory inv) {
		if(inv.getItem(5) != null && inv.getItem(6) != null && inv.getItem(7) != null) {
			if(inv.getItem(5).getType().equals(Material.REDSTONE) 
					&& inv.getItem(6).getType().equals(Material.REDSTONE) 
					&& inv.getItem(7).getType().equals(Material.EMERALD))
				return SpellType.FIREBALL;
			if(inv.getItem(5).getType().equals(Material.REDSTONE) 
					&& inv.getItem(6).getType().equals(Material.DIAMOND) 
					&& inv.getItem(7).getType().equals(Material.EMERALD))
				return SpellType.DAZE;
			if(inv.getItem(5).getType().equals(Material.EMERALD) 
					&& inv.getItem(6).getType().equals(Material.EMERALD) 
					&& inv.getItem(7).getType().equals(Material.EMERALD))
				return SpellType.HEAL;
			if(inv.getItem(5).getType().equals(Material.DIAMOND) 
					&& inv.getItem(6).getType().equals(Material.EMERALD) 
					&& inv.getItem(7).getType().equals(Material.DIAMOND))
				return SpellType.SMITE;
			if(inv.getItem(5).getType().equals(Material.REDSTONE) 
					&& inv.getItem(6).getType().equals(Material.DIAMOND) 
					&& inv.getItem(7).getType().equals(Material.DIAMOND))
				return SpellType.ARROW;
			if(inv.getItem(5).getType().equals(Material.EMERALD) 
					&& inv.getItem(6).getType().equals(Material.DIAMOND) 
					&& inv.getItem(7).getType().equals(Material.DIAMOND))
				return SpellType.CLOCK;
			if(inv.getItem(5).getType().equals(Material.DIAMOND) 
					&& inv.getItem(6).getType().equals(Material.DIAMOND) 
					&& inv.getItem(7).getType().equals(Material.DIAMOND))
				return SpellType.DRAGON;
			if(inv.getItem(5).getType().equals(Material.EMERALD) 
					&& inv.getItem(6).getType().equals(Material.EMERALD) 
					&& inv.getItem(7).getType().equals(Material.REDSTONE))
				return SpellType.SPEED;
			if(inv.getItem(5).getType().equals(Material.REDSTONE) 
					&& inv.getItem(6).getType().equals(Material.REDSTONE) 
					&& inv.getItem(7).getType().equals(Material.REDSTONE))
				return SpellType.BLINK;
		}
		return SpellType.INVOKE;
	}

}
