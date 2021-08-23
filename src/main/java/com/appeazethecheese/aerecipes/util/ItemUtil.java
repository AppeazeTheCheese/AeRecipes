package com.appeazethecheese.aerecipes.util;

import net.minecraft.nbt.NBTTagCompound;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.craftbukkit.v1_17_R1.inventory.CraftItemStack;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;

public class ItemUtil {
    public static ItemStack CreateSoulGem(int soulCount){
        ItemStack item = new ItemStack(Material.EMERALD);
        net.minecraft.world.item.ItemStack stack = CraftItemStack.asNMSCopy(item);
        NBTTagCompound tag = stack.getOrCreateTag();
        tag.setString("soulGemCount", String.valueOf(soulCount));
        tag.setInt("CustomModelData", 0);
        stack.setTag(tag);
        item = CraftItemStack.asCraftMirror(stack);

        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.RED + "" + ChatColor.BOLD + "Soul Gem " + ChatColor.GRAY + "[" + ChatColor.GREEN + soulCount + ChatColor.GRAY + "]");
        meta.setLore(Arrays.asList(ChatColor.GRAY + "Apply to an item to add souls."));
        item.setItemMeta(meta);

        return item;
    }
}
