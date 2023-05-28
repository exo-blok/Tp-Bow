package test.tpbow;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;
import test.tpbow.commands.commandGiveBow;
import test.tpbow.listners.listenersTpbow;

public final class Tpbow extends JavaPlugin {

    @Override
    public void onEnable() {
        getConfig().options().copyDefaults();
        saveDefaultConfig();

        getCommand("givebow").setExecutor(new commandGiveBow(this));
        getServer().getPluginManager().registerEvents(new listenersTpbow(this), this);



    }

}
