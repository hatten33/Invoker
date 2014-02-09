package net.aerenserve.hackathon;

import java.util.Arrays;
import java.util.List;

import net.aerenserve.hackathon.spells.Arrow;
import net.aerenserve.hackathon.spells.Blink;
import net.aerenserve.hackathon.spells.Clock;
import net.aerenserve.hackathon.spells.Daze;
import net.aerenserve.hackathon.spells.Dragon;
import net.aerenserve.hackathon.spells.Fireball;
import net.aerenserve.hackathon.spells.Heal;
import net.aerenserve.hackathon.spells.Invoke;
import net.aerenserve.hackathon.spells.Smite;
import net.aerenserve.hackathon.spells.Speed;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerItemHeldEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Listeners implements Listener {
	
	Invoker plugin;
	
	public Listeners(Invoker plugin) {
		this.plugin = plugin;		
		plugin.getServer().getPluginManager().registerEvents(this, plugin);
	}
	
	@EventHandler
	public void onJoin(PlayerJoinEvent e) {
		Player p = e.getPlayer();
		p.getInventory().clear();
		Inventory inv = p.getInventory();
		ItemStack i = new ItemStack(Material.BLAZE_ROD, 1);
			ItemMeta meta = i.getItemMeta();
			meta.setDisplayName(ChatColor.DARK_AQUA + "Cast Invoke");
			List<String> lore = Arrays.asList(ChatColor.DARK_AQUA + "Invoke");
			meta.setLore(lore);
			i.setItemMeta(meta);
		inv.setItem(3, i);
		inv.setItem(0, new ItemStack(Material.REDSTONE, 1));
		inv.setItem(1, new ItemStack(Material.EMERALD, 1));
		inv.setItem(2, new ItemStack(Material.DIAMOND, 1));
		
	}
	
	@EventHandler
	public void onItemSwitch(PlayerItemHeldEvent e) {
		int slot = e.getNewSlot();
		Inventory inv = e.getPlayer().getInventory();
		Integer replaceSlot = null;
		
		if(slot == 0 || slot == 1 || slot == 2) {
			e.setCancelled(true);
			replaceSlot = moveEssence(e.getPlayer(), slot);
			
			if(inv.getItem(slot) != null) {
				inv.setItem(replaceSlot, inv.getItem(slot));
			} else {
				inv.setItem(replaceSlot, new ItemStack(Material.AIR, 1));
			}
		}
		
		if(slot == 5 || slot == 6 || slot == 7) {
			e.setCancelled(true);
		}
		
	}
	
	private Integer moveEssence(Player p, int fromSlot) {
		Inventory inv = p.getInventory();
		Integer replaceSlot = null;
		int i = 5;
		while(i <= 7) {
			if(inv.getItem(i) != null) { //Is an item in slot
				if(i >= 7) {//Is last slot, needs loop
					return 5;
				}
			} else { //No item in slot
				return i;
			}
			i++;
		}
		return replaceSlot;
	}

	@EventHandler
	public void onDrop(PlayerDropItemEvent e) {
		if(e.getItemDrop().getItemStack().getType().equals(Material.REDSTONE) 
				|| e.getItemDrop().getItemStack().getType().equals(Material.EMERALD) 
				|| e.getItemDrop().getItemStack().getType().equals(Material.DIAMOND))
			e.setCancelled(true);
	}
	
	@EventHandler
	public void onInteract(PlayerInteractEvent e) {
		if(e.getAction().equals(Action.RIGHT_CLICK_AIR) || e.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {		
			if(e.getPlayer().getItemInHand().getType().equals(Material.BLAZE_ROD)) { //Normal wand
				ItemStack i = e.getPlayer().getItemInHand();
				if(i.getItemMeta().getLore() != null) {
					if(i.getItemMeta().getLore().get(0).equalsIgnoreCase(ChatColor.DARK_AQUA + "Invoke")) {
						Invoke invoke = new Invoke();
						invoke.castSpell(e.getPlayer());
						return;
					}
					if(i.getItemMeta().getLore().get(0).equalsIgnoreCase(ChatColor.RED + "Fireball")) {
						Fireball fireball = new Fireball();
						fireball.castSpell(e.getPlayer());
						e.getPlayer().getInventory().setItem(3, getInvokeWand());
						return;
					}
					if(i.getItemMeta().getLore().get(0).equalsIgnoreCase(ChatColor.AQUA + "Heal")) {
						Heal heal = new Heal();
						heal.castSpell(e.getPlayer());
						e.getPlayer().getInventory().setItem(3, getInvokeWand());
						return;
					}
					if(i.getItemMeta().getLore().get(0).equalsIgnoreCase(ChatColor.GRAY + "Daze")) {
						Daze daze = new Daze();
						daze.castSpell(e.getPlayer());
						e.getPlayer().getInventory().setItem(3, getInvokeWand());
						return;
					}
					if(i.getItemMeta().getLore().get(0).equalsIgnoreCase(ChatColor.WHITE + "Smite")) {
						Smite smite = new Smite();
						smite.castSpell(e.getPlayer());
						e.getPlayer().getInventory().setItem(3, getInvokeWand());
						return;
					}
					if(i.getItemMeta().getLore().get(0).equalsIgnoreCase(ChatColor.BLACK + "Arrow")) {
						Arrow arrow = new Arrow();
						arrow.castSpell(e.getPlayer());
						e.getPlayer().getInventory().setItem(3, getInvokeWand());
						return;
					}
					if(i.getItemMeta().getLore().get(0).equalsIgnoreCase(ChatColor.YELLOW + "Clock")) {
						Clock clock = new Clock();
						clock.castSpell(e.getPlayer());
						e.getPlayer().getInventory().setItem(3, getInvokeWand());
						return;
					}
					if(i.getItemMeta().getLore().get(0).equalsIgnoreCase(ChatColor.DARK_PURPLE + "Dragon")) {
						Dragon dragon = new Dragon();
						dragon.castSpell(e.getPlayer());
						e.getPlayer().getInventory().setItem(3, getInvokeWand());
						return;
					}
					if(i.getItemMeta().getLore().get(0).equalsIgnoreCase(ChatColor.BLUE + "Speed")) {
						Speed speed = new Speed();
						speed.castSpell(e.getPlayer());
						e.getPlayer().getInventory().setItem(3, getInvokeWand());
						return;
					}
					if(i.getItemMeta().getLore().get(0).equalsIgnoreCase(ChatColor.DARK_GREEN + "Blink")) {
						Blink blink = new Blink();
						blink.castSpell(e.getPlayer());
						e.getPlayer().getInventory().setItem(3, getInvokeWand());
						return;
					}
				}			
				//Not a valid spell!
				e.getPlayer().sendMessage("Your wand fizzles");
			}
		}
	}
	
	private ItemStack getInvokeWand() {
		ItemStack i = new ItemStack(Material.BLAZE_ROD, 1);
		ItemMeta meta = i.getItemMeta();
		meta.setDisplayName(ChatColor.DARK_AQUA + "Cast Invoke");
		List<String> lore = Arrays.asList(ChatColor.DARK_AQUA + "Invoke");
		meta.setLore(lore);
		i.setItemMeta(meta);
		return i;
	}
}
