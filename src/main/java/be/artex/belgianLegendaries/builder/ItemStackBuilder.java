package be.artex.belgianLegendaries.builder;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextDecoration;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ItemType;
import org.bukkit.inventory.meta.ItemMeta;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class ItemStackBuilder {
    private final ItemStack stack;
    private Component name = Component.empty();
    private List<Component> lore = new ArrayList<>();
    private boolean unbreakable = false;

    private ItemStackBuilder(ItemStack stack) {
        this.stack = stack;
    }

    public static ItemStackBuilder create(@NotNull ItemStack stack) {
        return new ItemStackBuilder(stack);
    }

    public static ItemStackBuilder create(@NotNull ItemType type) {
        return create(type.createItemStack());
    }

    public ItemStackBuilder name(@NotNull Component name) {
        this.name = name;
        return this;
    }

    public ItemStackBuilder name(@NotNull String name) {
        this.name = Component.text(name);
        return this;
    }

    public ItemStackBuilder unbreakable(@NotNull boolean unbreakable) {
        this.unbreakable = unbreakable;
        return this;
    }

    public ItemStackBuilder lore(@NotNull Component... lore) {
        List<Component> l = new ArrayList<>();

        for (Component s : lore) {
            l.add(s.decoration(TextDecoration.ITALIC, false));
        }

        this.lore = l;

        return this;
    }

    public ItemStackBuilder lore(@NotNull List<Component> lore) {
        List<Component> l = new ArrayList<>();

        for (Component s : lore) {
            l.add(s.decoration(TextDecoration.ITALIC, false));
        }

        this.lore = l;
        return this;
    }

    public ItemStack build() {
        ItemMeta meta = this.stack.getItemMeta();

        if (!this.name.equals(Component.empty()))
            meta.displayName(this.name.decoration(TextDecoration.ITALIC, false));

        if (!this.lore.isEmpty())
            meta.lore(lore);

        meta.setUnbreakable(unbreakable);
        this.stack.setItemMeta(meta);

        return this.stack;
    }

}
