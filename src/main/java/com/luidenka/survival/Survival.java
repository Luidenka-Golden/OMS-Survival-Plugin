package com.luidenka.survival;

import com.luidenka.survival.Commands.LobbyCommand;
import com.luidenka.survival.Events.Events;
import com.luidenka.survival.Recipes.VanillaRecipes;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Recipe;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Iterator;

public final class Survival extends JavaPlugin {

    public static String versionNumber;

    public void setVersionNumber() {
        int majorVersion = 0;
        int minorVersion = 0;
        int buildNumber = 6;
        int patchNumber = 0;
        versionNumber = majorVersion+"."+minorVersion+"."+buildNumber+"."+patchNumber;
    }

    @Override
    public void onEnable() {
        // Plugin startup logic
        setVersionNumber();
        this.getCommand("lobby").setExecutor(new LobbyCommand());
        this.getCommand("l").setExecutor(new LobbyCommand());
        getServer().getPluginManager().registerEvents(new Events(), this);
        getServer().getPluginManager().registerEvents(new VanillaRecipes(), this);
        System.out.println("OMS Survival Plugin v"+versionNumber+" Loaded!");
        Iterator<Recipe> recipeIterator = Bukkit.recipeIterator();
    }

    @Override
    public void onDisable() {
        System.out.println("OMS Survival Plugin disabled!");
    }

    public static void sendToServer(Player player, String name) {
        ByteArrayOutputStream b = new ByteArrayOutputStream();
        DataOutputStream out = new DataOutputStream(b);
        try {
            out.writeUTF("Connect");
            out.writeUTF(name);
        } catch (IOException eee) {
            Bukkit.getLogger().info("You'll never see me!");
        }
        player.sendPluginMessage(JavaPlugin.getProvidingPlugin(Survival.class), "BungeeCord", b.toByteArray());

    }
}
