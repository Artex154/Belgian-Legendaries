package be.artex.belgianLegendaries;

import be.artex.belgianLegendaries.command.LegendaryCommand;
import be.artex.belgianLegendaries.listener.PlayerInteract;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {
    public static JavaPlugin instance = null;

    @Override
    public void onEnable() {
        instance = this;

        Bukkit.getPluginManager().registerEvents(new PlayerInteract(), this);
        getCommand("legendary").setExecutor(new LegendaryCommand());
    }
}
