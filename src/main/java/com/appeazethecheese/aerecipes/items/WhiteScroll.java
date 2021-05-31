package com.appeazethecheese.aerecipes.items;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Arrays;

public class WhiteScroll extends ItemBase {
    @Override
    public ItemStack CreateItem() {
        ItemStack item = new ItemStack(Material.MAP);

        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.WHITE + "White Scroll");
        meta.setLore(Arrays.asList(ChatColor.WHITE + "Prevents an item from being destroyed",
                ChatColor.WHITE + "due to a failed Enchantment Book",
                ChatColor.YELLOW + "Place scroll on item to apply it"));
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_POTION_EFFECTS);

        item.setItemMeta(meta);
        return item;
    }

    @Override
    public ShapedRecipe GetRecipe(JavaPlugin creator) {
        ShapedRecipe recipe = new ShapedRecipe(new NamespacedKey(creator, "aeWhiteScroll"), CreateItem());

        recipe.shape("EBE", "XPX", "ETE");

        recipe.setIngredient('E', Material.ENDER_EYE);
        recipe.setIngredient('B', Material.BOOK);
        recipe.setIngredient('X', Material.EXPERIENCE_BOTTLE);
        recipe.setIngredient('P', Material.PAPER);
        recipe.setIngredient('T', Material.TOTEM_OF_UNDYING);

        return recipe;
    }
}
