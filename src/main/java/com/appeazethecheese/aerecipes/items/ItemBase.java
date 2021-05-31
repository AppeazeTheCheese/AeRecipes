package com.appeazethecheese.aerecipes.items;

import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.plugin.java.JavaPlugin;

public abstract class ItemBase {
    public abstract ItemStack CreateItem();
    public abstract ShapedRecipe GetRecipe(JavaPlugin creator);
}
