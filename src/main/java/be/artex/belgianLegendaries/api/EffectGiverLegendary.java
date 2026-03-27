package be.artex.belgianLegendaries.api;

import net.kyori.adventure.key.Key;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import org.bukkit.entity.Player;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;

import java.util.Arrays;

public class EffectGiverLegendary extends Legendary {
    private static PotionEffect effect;
    private static int cooldownTime = 600;

    private static final Action[] allowedActions = {
            Action.RIGHT_CLICK_AIR, Action.RIGHT_CLICK_BLOCK
    };

    private EffectGiverLegendary(String ID, ItemStack stack) {
        super(ID, stack);
    }

    public static EffectGiverLegendary create(String ID, ItemStack stack, PotionEffect potionEffect, int cooldownTicks) {
        effect = potionEffect;
        cooldownTime = cooldownTicks;

        return new EffectGiverLegendary(ID, stack);
    }

    public static EffectGiverLegendary create(String ID, ItemStack stack, PotionEffect potionEffect) {
        effect = potionEffect;

        return new EffectGiverLegendary(ID, stack);
    }

    @Override
    public void onClick(PlayerInteractEvent event) {
        Player player = event.getPlayer();

        if (!player.isSneaking())
            return;

        if (Arrays.stream(allowedActions).noneMatch(a -> a == event.getAction()))
            return;

        Key key = getKey();
        int cooldownTimeLeft = player.getCooldown(key);

        if (cooldownTimeLeft != 0) {
            player.sendMessage(Component.text("This item is still in cooldown for " + (cooldownTimeLeft / 20) +" second(s)!", NamedTextColor.RED));
            return;
        }

        player.addPotionEffect(effect);
        player.setCooldown(key, cooldownTime);
    }
}
