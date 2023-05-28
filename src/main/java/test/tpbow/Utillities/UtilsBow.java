package test.tpbow.Utillities;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import test.tpbow.Tpbow;

import java.util.ArrayList;
import java.util.List;

public class UtilsBow {
    private final Tpbow plugin;

    public UtilsBow(Tpbow plugin) {
        this.plugin = plugin;
    }

    public ItemStack createbow() {

        ItemStack bow = new ItemStack(Material.BOW);
        ItemMeta bowmeta = bow.getItemMeta();
        bowmeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("bow-name")));
        List<String> bowlore = new ArrayList<>();
        bowlore.add(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("bow-description")));
        bowmeta.setLore(bowlore);
        bowmeta.addEnchant(Enchantment.ARROW_INFINITE, 1, false);
        bow.setItemMeta(bowmeta);
        return bow;
    }
}
