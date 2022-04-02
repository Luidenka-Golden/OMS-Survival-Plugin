package com.luidenka.survival.Menus;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.HumanEntity;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class CustomCraftingGrid {

    public static Inventory grid;

    public static void openCustomCraftingGrid(HumanEntity p, ItemStack craftedItem) {
        grid = Bukkit.createInventory(null, 45, "Crafting Table");
        for (int i = 0; i < 45; i++) {
            grid.setItem(i, createGuiItem(Material.STAINED_GLASS));
        }
        grid.setItem(10, createGuiItem(Material.AIR));
        grid.setItem(11, createGuiItem(Material.AIR));
        grid.setItem(12, createGuiItem(Material.AIR));
        grid.setItem(19, createGuiItem(Material.AIR));
        grid.setItem(20, createGuiItem(Material.AIR));
        grid.setItem(21, createGuiItem(Material.AIR));
        grid.setItem(28, createGuiItem(Material.AIR));
        grid.setItem(29, createGuiItem(Material.AIR));
        grid.setItem(30, createGuiItem(Material.AIR));

        grid.setItem(24, craftedItem);

        p.openInventory(grid);
    }

    public static ItemStack createGuiItem(final Material material) {
        ItemStack item;
        if (material == Material.STAINED_GLASS) {item = new ItemStack(Material.STAINED_GLASS_PANE, 1,
                (short) 15);
        } else {
            item = new ItemStack(material, 1);
        }
        return item;
    }
}