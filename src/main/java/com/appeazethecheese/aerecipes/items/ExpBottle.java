package com.appeazethecheese.aerecipes.items;

import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.plugin.java.JavaPlugin;

public class ExpBottle extends ItemBase{
    @Override
    public ItemStack CreateItem() {
        return new ItemStack(Material.EXPERIENCE_BOTTLE);
    }

    @Override
    public ShapedRecipe GetRecipe(JavaPlugin creator) {
        ShapedRecipe recipe = new ShapedRecipe(new NamespacedKey(creator, "aeExpBottle"), this.CreateItem());

        recipe.shape("RGR", "EBE", "RGR");
        recipe.setIngredient('R', Material.REDSTONE);
        recipe.setIngredient('G', Material.GREEN_DYE);
        recipe.setIngredient('E', Material.ENDER_PEARL);
        recipe.setIngredient('B', Material.GLASS_BOTTLE);

        return recipe;
    }
}
