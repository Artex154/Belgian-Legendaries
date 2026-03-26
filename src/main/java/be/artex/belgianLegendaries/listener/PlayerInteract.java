package be.artex.belgianLegendaries.listener;

import be.artex.belgianLegendaries.api.Legendary;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class PlayerInteract implements Listener {
    @EventHandler
    public void onItemInteract(PlayerInteractEvent event) {
        ItemStack item = event.getItem();

        if (item == null)
            return;

        Legendary legendary = Legendary.getLegendaryFromStack(event.getItem());

        if (legendary != null)
            legendary.onClick(event);
    }
}
