package com.appeazethecheese.aerecipes.commands;

import com.appeazethecheese.aerecipes.Constants;
import com.appeazethecheese.aerecipes.util.ItemUtil;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.craftbukkit.v1_17_R1.inventory.CraftItemStack;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;

public class CombineCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String argString, String[] args) {
        if(!(commandSender instanceof Player))
        {
            commandSender.sendMessage(ChatColor.RED + "You must be a player to use this command.");
            return true;
        }

        var player = (Player) commandSender;
        var inventory = player.getInventory();

        var totalSouls = 0;
        var itemsToRemove = new ArrayList<ItemStack>();
        for (ItemStack item : inventory) {
            if(item == null || item.getType() != Material.EMERALD)
                continue;
            var stack = CraftItemStack.asNMSCopy(item);
            var tag = stack.getTag();
            if(tag == null || !tag.hasKey("soulGemCount"))
                continue;
            totalSouls += Integer.parseInt(tag.getString("soulGemCount")) * stack.getCount();
            itemsToRemove.add(item);
        }
        for (ItemStack item : itemsToRemove)
            inventory.remove(item);

        while (totalSouls > 0){
            var soulCount = Math.min(totalSouls, Constants.MaxSouls);
            inventory.addItem(ItemUtil.CreateSoulGem(soulCount));
            totalSouls -= soulCount;
        }

        player.sendMessage(ChatColor.GREEN + "Successfully combined soul gems.");
        return true;
    }
}
