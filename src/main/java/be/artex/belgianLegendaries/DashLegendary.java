package be.artex.belgianLegendaries;

import be.artex.belgianLegendaries.api.Legendary;
import net.kyori.adventure.key.Key;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.Vector;

public class DashLegendary extends Legendary {
    private static float dashHorizontal = 2.5f; // 0.166f = ~1 block
    private static float dashVertical = 0.75f; // 0.266f = ~1 block
    private static int cooldownTime = 500;

    private DashLegendary(String ID, ItemStack stack) {
        super(ID, stack);
    }

    public static DashLegendary create(String ID, ItemStack stack, int cooldownTicks) {
        cooldownTime = cooldownTicks;

        return new DashLegendary(ID, stack);
    }

    public static DashLegendary create(String ID, ItemStack stack, float dashHorizontalMultiplier, float dashVerticalMultiplier, int cooldownTicks) {
        dashHorizontal = dashHorizontalMultiplier;
        dashVertical = dashVerticalMultiplier;
        cooldownTime = cooldownTicks;

        return new DashLegendary(ID, stack);
    }

    @Override
    public void onClick(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        Key key = getKey();
        int cooldownTimeLeft = player.getCooldown(key);

        if (cooldownTimeLeft != 0) {
            player.sendMessage(Component.text("This item is still in cooldown for " + (cooldownTimeLeft / 20) +" second(s)!", NamedTextColor.RED));
            return;
        }

        dash(event.getPlayer());
        player.setCooldown(key, cooldownTime);
    }

    public void dash(Player player) {
        Vector dir = player.getLocation().getDirection().normalize().multiply(dashHorizontal);
        dir.setY(dashVertical);

        player.setVelocity(dir);
    }
}
