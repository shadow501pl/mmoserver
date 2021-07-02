package com.ultraplugins.mmomain;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class weaponCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (args.length != 1) {
            sender.sendMessage(format("&cWrong usage! /weapon <name>"));
            return true;
        }
        if (!(sender instanceof Player)) {
            sender.sendMessage(format("&cYoure not a player!"));
            return true;
        }
        Player player = (Player) sender;
        if (args[0].equalsIgnoreCase("taped_wooden_sword")) {
            ItemStack item = new ItemStack(Material.WOODEN_SWORD, 1);
            ItemMeta meta = item.getItemMeta();
            meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
            meta.setDisplayName(format("&bTaped Wooden Sword"));
            List<String> lore = new ArrayList<>();
            lore.add(format("&8Hit damage: &43"));
            lore.add(format("&8Hit Cooldown: &41.6"));
            lore.add(format(" "));
            lore.add(format("&b&lMEDIUM DAMAGE SWORD"));
            meta.setLore(lore);
            meta.setCustomModelData(11);
            item.setItemMeta(meta);
            player.getInventory().addItem(item);
            sender.sendMessage(format("&aYou have recieved '&eTaped Wooden Sword&a'"));
            return true;
        }
        if (args[0].equalsIgnoreCase("steel_sword")) {
            ItemStack item = new ItemStack(Material.IRON_SWORD, 1);
            ItemMeta meta = item.getItemMeta();
            meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
            meta.setDisplayName(format("&bSteel Sword"));
            List<String> lore = new ArrayList<>();
            lore.add(format("&8Hit damage: &49"));
            lore.add(format("&8Hit Cooldown: &41.6"));
            lore.add(format(" "));
            lore.add(format("&b&lHEAVY DAMAGE SWORD"));
            meta.setLore(lore);
            meta.setCustomModelData(12);
            item.setItemMeta(meta);
            player.getInventory().addItem(item);
            sender.sendMessage(format("&aYou have recieved '&eSteel Sword&a'"));
            return true;
        }
        if (args[0].equalsIgnoreCase("amethyst_dagger")) {
            ItemStack item = new ItemStack(Material.DIAMOND_HOE, 1);
            ItemMeta meta = item.getItemMeta();
            meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
            meta.setDisplayName(format("&dAmethyst Dagger"));
            List<String> lore = new ArrayList<>();
            lore.add(format("&8Hit damage: &49"));
            lore.add(format("&8Hit Cooldown: &44"));
            lore.add(format(" "));
            lore.add(format("&d&lDECENT DAMAGE DAGGER"));
            meta.setLore(lore);
            meta.setCustomModelData(12);
            item.setItemMeta(meta);
            player.getInventory().addItem(item);
            sender.sendMessage(format("&aYou have recieved '&eSteel Sword&a'"));
            return true;
        }
        sender.sendMessage(format("&cWrong usage! /resource <name of the item>"));
        return true;
    }

    public String format(String text) { return ChatColor.translateAlternateColorCodes('&', text); }
}
