package com.luidenka.survival.Events;

import com.luidenka.survival.Menus.CustomCraftingGrid;
import com.luidenka.survival.Menus.SMPMenu;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.inventory.*;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.ItemStack;

import java.util.Objects;

import static com.luidenka.survival.Menus.SMPMenu.*;

public class Events implements Listener {

    @EventHandler
    public void onLogin(PlayerJoinEvent e) {
        e.setJoinMessage(e.getPlayer().getDisplayName()+" has joined the world!");
    }

    @EventHandler
    public void onDC(PlayerQuitEvent e) {
        e.setQuitMessage(e.getPlayer().getDisplayName()+" has left the world!");
    }

    @EventHandler
    public void onPlayerOpenMenu(PlayerInteractEvent event) {
        Player p = event.getPlayer();
        if (p.getItemInHand().getType() == Material.COMPASS){
            SMPMenu.openSMPMenu(p);
        }
    }

    @EventHandler
    public void onInventoryDrag(InventoryDragEvent e) {
        if (e.getInventory().equals(menu) ||
        e.getInventory().equals(skillsMenu)) {
            e.setCancelled(true);
        }
    }

    @EventHandler
    public void onPlayerKillMobs(EntityDeathEvent e) {
        if (e.getEntity().getKiller() != null){
            if (e.getEntity().equals(EntityType.ZOMBIE)) {
                // Still not been developed
            }
        }
    }

    @EventHandler
    public void onMenuClick(final InventoryClickEvent e) {
        final ItemStack clickedItem = e.getCurrentItem();
        if (clickedItem.getType() == Material.DIAMOND_SWORD &&
                Objects.equals(clickedItem.getItemMeta().getDisplayName(), ChatColor.GREEN + "Skills")) {
            openSkillsGUI((Player) e.getWhoClicked());
        }
        else if (clickedItem.getType() == Material.ENDER_CHEST &&
                Objects.equals(clickedItem.getItemMeta().getDisplayName(), ChatColor.GREEN+"Ender Chest")) {
            e.getWhoClicked().openInventory(e.getWhoClicked().getEnderChest());
        }
        else if (clickedItem.getType() == Material.STAINED_GLASS_PANE ||
                clickedItem.getType() == Material.BARRIER) {
            e.setCancelled(true);
        }
    }

    @EventHandler
    public static void onOpenCraftingGrid(InventoryOpenEvent e) {
        if(e.getInventory().getType() == InventoryType.WORKBENCH) {
            e.setCancelled(true);
            CustomCraftingGrid.openCustomCraftingGrid(e.getPlayer(), new ItemStack(Material.BARRIER));
        }
    }
}
