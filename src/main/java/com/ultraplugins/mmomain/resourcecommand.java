package com.ultraplugins.mmomain;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.jetbrains.annotations.NotNull;

import javax.swing.text.PlainDocument;
import java.util.ArrayList;
import java.util.List;

public class resourcecommand implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (args.length != 1) {
            sender.sendMessage(format("&cWrong usage! /resource <nameoftheresource>"));
            return true;
        }
        if (!(sender instanceof Player)) {
            sender.sendMessage(format("&cWrong usage! /resource <nameoftheresource>"));
            return true;
        }
        Player player = (Player) sender;
        if (args[0].equalsIgnoreCase("copper")) {
            ItemStack item = new ItemStack(Material.GOLD_INGOT, 1);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(format("&eCopper"));
            List<String> lore = new ArrayList<>();
            lore.add(format("&7A basic resource used to craft usefull tools"));
            lore.add(format(" "));
            lore.add(format("&e&lRESOURCE ITEM"));
            meta.setLore(lore);
            meta.setCustomModelData(21);
            item.setItemMeta(meta);
            player.getInventory().addItem(item);
            sender.sendMessage(format("&aYou have recieved '&eCopper Ingot&a'"));
            return true;
        }
        if (args[0].equalsIgnoreCase("amethyst")) {
            ItemStack item = new ItemStack(Material.DIAMOND, 1);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(format("&eAmethyst"));
            List<String> lore = new ArrayList<>();
            lore.add(format("&7A hard material which is the sharpest rock on earth"));
            lore.add(format(" "));
            lore.add(format("&e&lRESOURCE ITEM"));
            meta.setLore(lore);
            meta.setCustomModelData(22);
            item.setItemMeta(meta);
            player.getInventory().addItem(item);
            sender.sendMessage(format("&aYou have recieved '&eAmethyst&a'"));
            return true;
        }
        sender.sendMessage(format("&cWrong usage! /resource <name of the item>"));
        return true;
    }

    public String format(String text) { return ChatColor.translateAlternateColorCodes('&', text); }
}