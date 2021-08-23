package com.appeazethecheese.aerecipes.commands;

import com.appeazethecheese.aerecipes.Constants;
import com.appeazethecheese.aerecipes.util.ItemUtil;
import com.mojang.datafixers.kinds.Const;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.craftbukkit.v1_17_R1.inventory.CraftItemStack;
import org.bukkit.entity.Player;

public class SplitCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String argString, String[] args) {
        if(!(commandSender instanceof Player))
        {
            commandSender.sendMessage(ChatColor.RED + "You must be a player to use this command.");
            return true;
        }
        if(args.length <= 0){
            commandSender.sendMessage(ChatColor.RED + "You must specify a number of souls.");
            return true;
        }
        int numSouls;
        try{
            numSouls = Integer.parseInt(args[0]);
        }
        catch (Exception e){
            commandSender.sendMessage(ChatColor.RED + "Invalid arguments. You must specify a number of souls.");
            return true;
        }
        if(numSouls < Constants.MinSouls || numSouls > Constants.MaxSouls){
            commandSender.sendMessage( ChatColor.RED + "You must specify a number of souls between " + Constants.MinSouls + " and " + Constants.MaxSouls + " souls.");
            return true;
        }
        var player = (Player) commandSender;
        var item = player.getInventory().getItemInMainHand();
        var stack = CraftItemStack.asNMSCopy(item);
        var tag = stack.getTag();
        if(tag == null || !tag.hasKey("soulGemCount")){
            player.sendMessage(ChatColor.RED + "You must be holding a soul gem to use this command.");
            return true;
        }

        var count = Integer.parseInt(tag.getString("soulGemCount"));
        if(numSouls > count){
            player.sendMessage(ChatColor.RED + "There aren't that many souls on your soul gem.");
            return true;
        }
        var remainingSouls = count - numSouls;
        if(remainingSouls < Constants.MinSouls || remainingSouls > Constants.MaxSouls){
            player.sendMessage(ChatColor.RED + "Splitting this stack would result in a gem with an invalid number of souls. Gems can have between " + Constants.MinSouls + " and " + Constants.MaxSouls + " souls.");
            return true;
        }

        for(var i = 0; i < stack.getCount(); i++) {
            var gem1 = ItemUtil.CreateSoulGem(numSouls);
            var gem2 = ItemUtil.CreateSoulGem(remainingSouls);

            if(i == 0)
                player.getInventory().setItemInMainHand(gem1);
            else
                player.getInventory().addItem(gem1);
            player.getInventory().addItem(gem2);
        }

        player.sendMessage(ChatColor.GREEN + "Successfully split gem.");
        return true;
    }
}
