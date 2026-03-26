package be.artex.belgianLegendaries;

import be.artex.belgianLegendaries.builder.ItemStackBuilder;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import net.kyori.adventure.text.format.TextDecoration;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class Stacks {
    public static ItemStack DASH_SWORD = ItemStackBuilder.create(new ItemStack(Material.DIAMOND_SWORD))
            .name(Component.text("Dash", NamedTextColor.GOLD).decorate(TextDecoration.BOLD).append(Component.text(" Sword").decoration(TextDecoration.BOLD, false)))
            .lore(Component.text("Right click to dash forward!", NamedTextColor.WHITE))
            .build();
}
