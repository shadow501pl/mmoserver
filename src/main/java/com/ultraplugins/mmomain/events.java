package com.ultraplugins.mmomain;

import net.minecraft.server.v1_16_R3.PacketPlayOutAnimation;
import net.minecraft.server.v1_16_R3.PacketPlayOutEntityStatus;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.craftbukkit.v1_16_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class events implements Listener {
    @EventHandler
    public void ondamage(EntityDamageByEntityEvent event) {
        if (!(event.getDamager() instanceof Player)) {
            return;
        }
        Player damager = (Player) event.getDamager();
        ItemStack item = damager.getItemInHand();
        if (!(item.hasItemMeta())) {
            return;
        }
        if (!(item.getItemMeta().hasLore())) {
            return;
        }

        List<String> lore2 = new ArrayList<>();
        for (String lore : item.getItemMeta().getLore()) {
            if (lore.toLowerCase().contains("hit damage")) {
                lore2 = Arrays.asList(lore.split(": "));
            }
        }
        damager.sendMessage("The damage is" + lore2.get(2));
    }
    @EventHandler
    public void rightclick(PlayerInteractEvent e) {
        Player p = e.getPlayer();
        CraftPlayer craftplayer = (CraftPlayer) p;
        if(!(e.hasItem())){
            return;
        }
            if (e.getAction() == e.getAction().RIGHT_CLICK_AIR || e.getAction() == e.getAction().RIGHT_CLICK_BLOCK) {
                if (e.getItem().getType() == Material.SLIME_BALL) {
                    PacketPlayOutAnimation packetmainhand = new PacketPlayOutAnimation((craftplayer).getHandle(), 0);
                    craftplayer.getHandle().playerConnection.sendPacket(packetmainhand);
                    p.sendMessage("Should send packet");
                }
            }
        }
    public String format(String text) { return ChatColor.translateAlternateColorCodes('&', text); }
}

