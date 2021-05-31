package com.appeazethecheese.aerecipes.items;

import net.minecraft.server.v1_16_R3.NBTTagCompound;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.craftbukkit.v1_16_R3.inventory.CraftItemStack;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.RecipeChoice;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Arrays;

public class BlackScroll50 extends ItemBase{
    private static final int SuccessRate = 50;
    @Override
    public ItemStack CreateItem() {
        ItemStack item = new ItemStack(Material.INK_SAC);

        net.minecraft.server.v1_16_R3.ItemStack stack = CraftItemStack.asNMSCopy(item);
        NBTTagCompound tag = stack.hasTag() ? stack.getTag() : new NBTTagCompound();
        tag.setString("success", String.valueOf(SuccessRate));
        stack.setTag(tag);
        item = CraftItemStack.asCraftMirror(stack);

        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.WHITE + "" + ChatColor.BOLD + "Black Scroll");
        meta.setLore(Arrays.asList(ChatColor.GRAY + "Removes a random enchantment",
                ChatColor.GRAY + "from an item and converts",
                ChatColor.GRAY + "it into a " + ChatColor.WHITE + SuccessRate + "% " + ChatColor.GRAY + "success book.",
                ChatColor.WHITE + "Place scroll onto item to extract."));
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_POTION_EFFECTS);

        item.setItemMeta(meta);
        return item;
    }

    @Override
    public ShapedRecipe GetRecipe(JavaPlugin creator) {
        ShapedRecipe recipe = new ShapedRecipe(new NamespacedKey(creator, "aeBlackScroll" + SuccessRate), CreateItem());

        recipe.shape("EBE", "XIX", "EGE");

        recipe.setIngredient('E', Material.ENDER_PEARL);
        recipe.setIngredient('B', Material.BOOK);
        recipe.setIngredient('X', Material.EXPERIENCE_BOTTLE);
        recipe.setIngredient('I', new RecipeChoice.ExactChoice(new BlackScroll25().CreateItem()));
        recipe.setIngredient('G', Material.GRINDSTONE);

        return recipe;
    }
}
