package test.tpbow.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import test.tpbow.Tpbow;
import test.tpbow.Utillities.UtilsBow;

public class commandGiveBow implements CommandExecutor {
    private final Tpbow plugin;
    private final UtilsBow Utilsbow;

    public commandGiveBow(Tpbow plugin) {
        this.plugin = plugin;
        this.Utilsbow = new UtilsBow(plugin);
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {
        Player p = (Player) commandSender;
        ItemStack tpbow = Utilsbow.createbow();

        if (p.hasPermission("tpbow.givebow")) {
            if(args.length == 1) {
                Player target = Bukkit.getPlayerExact(args[0]);
                if (target == null) {

                    p.sendMessage(ChatColor.RED + "This user is not online");

                } else {
                    target.getInventory().addItem(tpbow);
                    target.getInventory().addItem(new ItemStack(Material.ARROW));
                    target.sendMessage("You have been sent a teleport bow by " + p);
                    p.sendMessage("You sent a teleport bow to " + target);

                }


            } else if (args.length == 0) {
                p.getInventory().addItem(tpbow);
                p.getInventory().addItem(new ItemStack(Material.ARROW));
                p.sendMessage("You gave yourself a teleport bow");

            } else {
                p.sendMessage("Correct usage is /givebow <username>");

            }


        }



        return true;
    }
}
