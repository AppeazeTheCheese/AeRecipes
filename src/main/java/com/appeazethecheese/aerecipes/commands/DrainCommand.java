package com.appeazethecheese.aerecipes.commands;

import com.appeazethecheese.aerecipes.Constants;
import com.appeazethecheese.aerecipes.util.ItemUtil;
import net.minecraft.nbt.NBTTagCompound;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.craftbukkit.v1_17_R1.inventory.CraftItemStack;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;

public class DrainCommand implements CommandExecutor {


    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String argString, String[] args) {
        if(!(commandSender instanceof Player)) {
            commandSender.sendMessage(ChatColor.RED + "You must be a player to execute this command.");
            return true;
        }

        Player player = (Player)commandSender;
        if(args.length <= 0){
            commandSender.sendMessage(ChatColor.RED + "You must specify a number of souls to drain.");
            return true;
        }
        int soulsToDrain;
        try{
            soulsToDrain = Integer.parseInt(args[0]);
        }catch(Exception e){
            commandSender.sendMessage(ChatColor.RED + "Invalid arguments. You must specify a number of souls to drain.");
            return true;
        }
        if(soulsToDrain > Constants.MaxSouls || soulsToDrain < Constants.MinSouls){
            commandSender.sendMessage(ChatColor.RED + "Please specify a number between " + Constants.MinSouls + " and " + Constants.MaxSouls);
            return true;
        }

        ItemStack item = player.getInventory().getItemInMainHand();
        var stack = CraftItemStack.asNMSCopy(item);
        var tag = stack.getTag();
        if(tag == null || !tag.hasKey("souls")){
            player.sendMessage(ChatColor.RED + "Your item must have a Soul Tracker to use this command.");
            return true;
        }

        var totalSouls = tag.getInt("souls");
        if(soulsToDrain > totalSouls){
            player.sendMessage(ChatColor.RED + "You don't have that many souls.");
            return true;
        }

        var taxedSouls = (int) Math.ceil(soulsToDrain * Constants.SoulTax);
        var drainedSouls = soulsToDrain - taxedSouls;
        var gem = ItemUtil.CreateSoulGem(drainedSouls);
        var remainingSouls = totalSouls - soulsToDrain;
        tag.setInt("souls", remainingSouls);
        stack.setTag(tag);

        item = CraftItemStack.asCraftMirror(stack);
        var meta = item.getItemMeta();
        var lore = meta.getLore();
        for(var i = 0; i < (long) lore.size(); i++){
            var text = lore.get(i);
            if(text.contains("Souls Collected: "))
                lore.set(i, ChatColor.RED + "Souls Collected: " + remainingSouls);
        }
        meta.setLore(lore);
        item.setItemMeta(meta);

        player.getInventory().setItemInMainHand(item);
        player.getInventory().addItem(gem);
        player.sendMessage(ChatColor.GREEN + "Successfully drained " + drainedSouls + " souls into a soul gem " + ChatColor.RED + "with a soul tax of " + taxedSouls);
        return true;
    }

}
