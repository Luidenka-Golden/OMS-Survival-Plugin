package com.luidenka.survival.Recipes;

import com.luidenka.survival.Menus.CustomCraftingGrid;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryMoveItemEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.Recipe;
import org.bukkit.inventory.ShapedRecipe;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class VanillaRecipes implements Listener {
    @EventHandler
    public static void checkRecipes(InventoryMoveItemEvent e) {
        List<ItemStack> recipe = new ArrayList<>();
        recipe.add(e.getDestination().getItem(10));
        recipe.add(e.getDestination().getItem(11));
        recipe.add(e.getDestination().getItem(12));
        recipe.add(e.getDestination().getItem(19));
        recipe.add(e.getDestination().getItem(20));
        recipe.add(e.getDestination().getItem(21));
        recipe.add(e.getDestination().getItem(28));
        recipe.add(e.getDestination().getItem(29));
        recipe.add(e.getDestination().getItem(30));
        Iterator<Recipe> recipeIterator = Bukkit.recipeIterator();
        while (recipeIterator.hasNext()) {
            Recipe itemRecipe = recipeIterator.next();
            System.out.println(recipe);
            if (itemRecipe.equals(recipe)) {
                e.getDestination().setItem(24, new ItemStack(Material.WOOD_PICKAXE));
            }
        }
    }
}