package com.luidenka.survival.Recipes;

import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.Objects;

public class EnchantedOakWood {

    public static void onCraftedEnchantedOakWood(Inventory inventory) {
        if (Objects.equals(inventory.getItem(12), new ItemStack(Material.LOG, 32))) {

        }
    }
}
