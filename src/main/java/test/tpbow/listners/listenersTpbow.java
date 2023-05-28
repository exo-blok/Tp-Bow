package test.tpbow.listners;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import test.tpbow.Tpbow;
import test.tpbow.Utillities.UtilsBow;

public class listenersTpbow implements Listener {
    private final Tpbow plugin;
    private final  UtilsBow utilsBow;

    public listenersTpbow(Tpbow plugin) {
        this.plugin = plugin;
        this.utilsBow = new UtilsBow(plugin);
    }

    @EventHandler
    public void onarrowland(ProjectileHitEvent e) {

        if (e.getEntity().getShooter() instanceof Player p) {

            ItemStack hand = p.getInventory().getItemInMainHand();

            if (hand.getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("bow-name")))) {

                Location location = e.getEntity().getLocation();
                p.teleport(location);
                e.getEntity().remove();
                p.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("tp-message")));

            }

        }

    }

    @EventHandler
    public void onplayerjoin(PlayerJoinEvent e){
        if (plugin.getConfig().getBoolean("giveonjoin")) {
            Player p = e.getPlayer();
            ItemStack tpbow = utilsBow.createbow();
            p.getInventory().addItem(tpbow);
            p.getInventory().addItem(new ItemStack(Material.ARROW));
        }


    }
}
