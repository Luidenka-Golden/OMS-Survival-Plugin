package com.luidenka.survival.Menus;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import java.util.Arrays;

public class SMPMenu {
    public static Inventory menu;
    public static Inventory skillsMenu;

    public static void openSMPMenu(Player ent) {
        // Create a new inventory
        menu = Bukkit.createInventory(null, 9, "OMS SMP Menu");
        // Put the items into the inventory
        menu.addItem(createGuiItem(Material.AIR, " ", ""));
        menu.addItem(createGuiItem(Material.DIAMOND_SWORD, ChatColor.GREEN+"Skills",
                "Click to view your skills!"));
        menu.addItem(createGuiItem(Material.PAINTING, ChatColor.GREEN+"Collections",
                "Click to view your collections!"));
        menu.addItem(createGuiItem(Material.BOOK, ChatColor.GREEN+"Recipe Book",
                "Click to view the recipe book your have unlocked!"));
        menu.addItem(createHeadItem(ent));
        menu.addItem(createGuiItem(Material.EXP_BOTTLE, ChatColor.GREEN+"Shop",
                "Click to view the shop!"));
        menu.addItem(createGuiItem(Material.EMERALD, ChatColor.GREEN+"Bank",
                "Click to view the bank!"));
        menu.addItem(createGuiItem(Material.ENDER_CHEST, ChatColor.GREEN+"Ender Chest",
                "Click to view the your ender chest!"));
        menu.setItem(8, createGuiItem(Material.AIR, " ", ""));
        ent.openInventory(menu);
    }

    public static void openEChest(Player p) {
        Inventory eChest = p.getEnderChest();
        p.openInventory(eChest);
    }

    public static ItemStack createHeadItem(Player p) {
        ItemStack i = new ItemStack(Material.SKULL_ITEM, 1, (short) 3);
        SkullMeta im = (SkullMeta) i.getItemMeta();
        im.setOwner(p.getName());
        return i;
    }

    public static ItemStack createGuiItem(final Material material, final String name, final String... lore) {
        ItemStack item;
        if (material == Material.AIR) {item = new ItemStack(Material.STAINED_GLASS_PANE, 1,
                (short) 15);
        } else {
            item = new ItemStack(material, 1);
        }
        final ItemMeta meta = item.getItemMeta();
        // Set the name of the item
        meta.setDisplayName(name);
        // Set the lore of the item
        meta.setLore(Arrays.asList(lore));
        item.setItemMeta(meta);
        return item;
    }

    public static void openSkillsGUI(Player p) {
        skillsMenu = Bukkit.createInventory(null, 9, "Skills Menu");
        skillsMenu.setItem(1, createGuiItem(Material.STONE_PICKAXE, ChatColor.GREEN+"Mining",
                ChatColor.RESET+"Click to see your mining skills!"));
        skillsMenu.setItem(2, createGuiItem(Material.GOLD_HOE, ChatColor.GREEN+"Farming",
                ChatColor.RESET+"Click to see your farming skills!"));
        skillsMenu.setItem(3, createGuiItem(Material.STONE_SWORD, ChatColor.GREEN+"Combat",
                ChatColor.RESET+"Click to see your combat skills!"));
        skillsMenu.setItem(4, createGuiItem(Material.SAPLING, ChatColor.GREEN+"Foraging",
                ChatColor.RESET+"Click to see your foraging skills!"));
        skillsMenu.setItem(5, createGuiItem(Material.FISHING_ROD, ChatColor.GREEN+"Fishing",
                ChatColor.RESET+"Click to see your fishing skills!"));
        skillsMenu.setItem(6, createGuiItem(Material.ENCHANTMENT_TABLE, ChatColor.GREEN+"Enchanting",
                ChatColor.RESET+"Click to see your enchanting skills!"));
        skillsMenu.setItem(7, createGuiItem(Material.BREWING_STAND_ITEM, ChatColor.GREEN+"Alchemy",
                ChatColor.RESET+"Click to see your potion skills!"));
        p.openInventory(skillsMenu);
    }

}
