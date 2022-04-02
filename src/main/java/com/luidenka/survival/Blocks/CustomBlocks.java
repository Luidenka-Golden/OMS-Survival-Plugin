package com.luidenka.survival.Blocks;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class CustomBlocks {

    public static ItemStack enchantedOakWood() {
        ItemStack enchantedOakWood = new ItemStack(Material.LOG, 1);
        ItemMeta im = enchantedOakWood.getItemMeta();

        enchantedOakWood.addUnsafeEnchantment(Enchantment.ARROW_INFINITE, 0);
        im.setDisplayName(ChatColor.GREEN+"Enchanted Oak Wood");
        im.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        enchantedOakWood.setItemMeta(im);

        return enchantedOakWood;
    }

}
