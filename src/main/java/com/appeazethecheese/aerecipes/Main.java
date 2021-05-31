package com.appeazethecheese.aerecipes;

import com.appeazethecheese.aerecipes.items.*;
import org.bukkit.Server;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
    public static Main instance;
    public Main(){
        instance = this;
    }
    @Override
    public void onEnable() {
        Server server = getServer();
        server.addRecipe(new SlotIncreaser().GetRecipe(this));
        server.addRecipe(new ExpBottle().GetRecipe(this));
        server.addRecipe(new WhiteScroll().GetRecipe(this));
        server.addRecipe(new BlackScroll25().GetRecipe(this));
        server.addRecipe(new BlackScroll50().GetRecipe(this));
        server.addRecipe(new BlackScroll75().GetRecipe(this));
        server.addRecipe(new BlackScroll100().GetRecipe(this));
    }
}
