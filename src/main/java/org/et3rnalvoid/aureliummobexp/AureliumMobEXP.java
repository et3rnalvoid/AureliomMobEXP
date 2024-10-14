package org.et3rnalvoid.aureliummobexp;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.plugin.java.JavaPlugin;

public final class AureliumMobEXP extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        Bukkit.getPluginManager().registerEvents(this, this);
    }

    @Override
    public void onDisable() {

    }

    @EventHandler
    public void onEntityDeath(EntityDeathEvent event) {
        if (event.getEntity().getKiller() != null && event.getEntity().getKiller() instanceof Player) {
            Player player = event.getEntity().getKiller();
            double health = event.getEntity().getMaxHealth();
            int exp = (int) health; // assuming 1 HP = 1 EXP
            player.giveExp(exp);

            String command = String.format("skill xp add %s fighting %d", player.getName(), exp);
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), command);
        }
    }
}
