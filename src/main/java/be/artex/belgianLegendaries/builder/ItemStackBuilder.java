package be.artex.belgianLegendaries.builder;

import be.artex.belgianLegendaries.Main;
import io.papermc.paper.datacomponent.DataComponentTypes;
import io.papermc.paper.datacomponent.item.ItemAttributeModifiers;
import net.kyori.adventure.key.Key;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextDecoration;
import org.bukkit.NamespacedKey;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.inventory.EquipmentSlotGroup;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ItemType;
import org.bukkit.inventory.meta.ItemMeta;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class ItemStackBuilder {
    private static final NamespacedKey ATTRIBUTE_MODIFIER = new NamespacedKey(Main.instance, "attribute_modifier");

    private final ItemStack stack;
    private Component name = Component.empty();
    private List<Component> lore = new ArrayList<>();
    private boolean unbreakable = false;
    private Key itemModel = null;

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

    public ItemStackBuilder setItemModel(Key key) {
        this.itemModel = key;

        return this;
    }

    public ItemStackBuilder addAttribute(Attribute attribute, double amount, AttributeModifier.Operation operation, EquipmentSlotGroup slotGroup) {
        AttributeModifier attributeModifier = new AttributeModifier(
                ATTRIBUTE_MODIFIER, amount, operation
        );

        stack.setData(DataComponentTypes.ATTRIBUTE_MODIFIERS, ItemAttributeModifiers.itemAttributes().addModifier(
                attribute, attributeModifier, slotGroup
        ));

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

        meta.setUnbreakable(unbreakable);

        this.stack.setItemMeta(meta);

        return this.stack;
    }

}
