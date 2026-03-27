package be.artex.belgianLegendaries.builder;

import io.papermc.paper.datacomponent.DataComponentTypes;
import net.kyori.adventure.key.Key;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextDecoration;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ItemType;
import org.bukkit.inventory.meta.ItemMeta;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ItemStackBuilder {
    private final ItemStack stack;
    private Component name = Component.empty();
    private final List<Component> lore = new ArrayList<>();
    private boolean unbreakable = false;
    private Key itemModel = null;
    private final List<AttributeHolder> attributes = new ArrayList<>();

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

    public ItemStackBuilder unbreakable(boolean unbreakable) {
        this.unbreakable = unbreakable;
        return this;
    }

    public ItemStackBuilder lore(@NotNull Component... lore) {
        List<Component> l = new ArrayList<>();

        for (Component s : lore) {
            l.add(s.decoration(TextDecoration.ITALIC, false));
        }

        this.lore.addAll(l);

        return this;
    }

    public ItemStackBuilder lore(@NotNull List<Component> lore) {
        List<Component> l = new ArrayList<>();

        for (Component s : lore) {
            l.add(s.decoration(TextDecoration.ITALIC, false));
        }

        this.lore.addAll(l);
        return this;
    }

    public ItemStackBuilder setItemModel(Key key) {
        this.itemModel = key;

        return this;
    }

    public ItemStackBuilder addAttribute(AttributeHolder... attributeHolders) {
        Collections.addAll(this.attributes, attributeHolders);

        return this;
    }

    public ItemStack build() {
        ItemMeta meta = this.stack.getItemMeta();

        if (!this.name.equals(Component.empty()))
            meta.displayName(this.name.decoration(TextDecoration.ITALIC, false));

        if (!this.lore.isEmpty())
            meta.lore(lore);

        if (this.itemModel != null)
            stack.setData(DataComponentTypes.ITEM_MODEL, this.itemModel);

        for (AttributeHolder attributeHolder : this.attributes)
            attributeHolder.apply(stack);

        meta.setUnbreakable(unbreakable);

        this.stack.setItemMeta(meta);

        return this.stack;
    }

}
