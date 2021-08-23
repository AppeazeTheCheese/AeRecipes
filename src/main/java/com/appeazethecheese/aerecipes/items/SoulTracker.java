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

public class SoulTracker extends ItemBase {

    @Override
    public ItemStack CreateItem() {
        ItemStack item = new ItemStack(Material.PAPER);

        net.minecraft.world.item.ItemStack stack = CraftItemStack.asNMSCopy(item);
        NBTTagCompound tag = stack.hasTag() ? stack.getTag() : new NBTTagCompound();
        tag.setString("soultracker", "yeah");
        tag.setInt("CustomModelData", 0);
        stack.setTag(tag);
        item = CraftItemStack.asCraftMirror(stack);

        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.WHITE + "" + ChatColor.BOLD + "Soul Tracker");
        meta.setLore(Arrays.asList(ChatColor.GRAY + "Apply to weapons to start tracking",
                                   ChatColor.GRAY + "souls collected from kills"));

        item.setItemMeta(meta);
        return item;
    }

    @Override
    public ShapedRecipe GetRecipe(JavaPlugin creator) {
        ShapedRecipe recipe = new ShapedRecipe(new NamespacedKey(creator, "aeSoulTracker"), this.CreateItem());

        recipe.shape("NSN","RPR","NLN");
        recipe.setIngredient('N', Material.NETHERITE_SCRAP);
        recipe.setIngredient('S', Material.NETHER_STAR);
        recipe.setIngredient('R', Material.BLAZE_ROD);
        recipe.setIngredient('P', Material.PAPER);
        recipe.setIngredient('L', Material.SOUL_LANTERN);

        return recipe;
    }
}
