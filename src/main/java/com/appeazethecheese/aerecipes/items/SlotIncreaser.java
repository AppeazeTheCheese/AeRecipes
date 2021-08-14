package com.appeazethecheese.aerecipes.items;

import net.minecraft.nbt.NBTTagCompound;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.craftbukkit.v1_17_R1.inventory.CraftItemStack;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Arrays;

public class SlotIncreaser extends ItemBase {

    @Override
    public ItemStack CreateItem() {
        ItemStack item = new ItemStack(Material.ENDER_EYE);

        net.minecraft.world.item.ItemStack stack = CraftItemStack.asNMSCopy(item);
        NBTTagCompound tag = stack.hasTag() ? stack.getTag() : new NBTTagCompound();
        tag.setString("slotIncreaser", "1");
        tag.setString("groupType", "SIMPLE");
        stack.setTag(tag);
        item = CraftItemStack.asCraftMirror(stack);

        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.GRAY + "" + ChatColor.BOLD + "Simple Slot Increaser");
        meta.setLore(Arrays.asList(ChatColor.GRAY + "Increase slots limit on an item by " + ChatColor.GREEN + "+1"));
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_POTION_EFFECTS);

        item.setItemMeta(meta);
        return item;
    }

    @Override
    public ShapedRecipe GetRecipe(JavaPlugin creator) {
        ShapedRecipe recipe = new ShapedRecipe(new NamespacedKey(creator, "aeUpgrade"), this.CreateItem());

        recipe.shape("EBE","CNC","EHE");
        recipe.setIngredient('E', Material.EXPERIENCE_BOTTLE);
        recipe.setIngredient('B', Material.BOOK);
        recipe.setIngredient('C', Material.END_CRYSTAL);
        recipe.setIngredient('N', Material.ENDER_EYE);
        recipe.setIngredient('H', Material.HEART_OF_THE_SEA);

        return recipe;
    }
}
