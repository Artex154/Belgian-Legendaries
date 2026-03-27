package be.artex.belgianLegendaries;

import be.artex.belgianLegendaries.builder.ItemStackBuilder;
import io.papermc.paper.datacomponent.DataComponentTypes;
import io.papermc.paper.datacomponent.item.ItemAttributeModifiers;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import net.kyori.adventure.text.format.TextDecoration;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.inventory.EquipmentSlotGroup;
import org.bukkit.inventory.ItemStack;

public class Stacks {
    private static final NamespacedKey ATTRIBUTE_MODIFIER = new NamespacedKey(Main.instance, "attribute_modifier");

    public static ItemStack getVelox() {
        ItemStack velox = ItemStackBuilder.create(new ItemStack(Material.DIAMOND_SWORD))
                .name(Component.text("Velox", NamedTextColor.GOLD).decorate(TextDecoration.BOLD, TextDecoration.ITALIC))
                .lore(Component.empty(), Component.text(" Right click while sneaking to dash forward!", NamedTextColor.GRAY), Component.text("  Cooldown:", NamedTextColor.GRAY).append(Component.text(" 25s", NamedTextColor.YELLOW)).append(Component.text(".", NamedTextColor.GRAY)),
                        Component.empty(), Component.text(" Faites un clique droit en sneakant pour dash en avant!        ", NamedTextColor.GRAY), Component.text("  Cooldown:", NamedTextColor.GRAY).append(Component.text(" 25s", NamedTextColor.YELLOW)).append(Component.text(".", NamedTextColor.GRAY)))
                .build();

        AttributeModifier speedModifier = new AttributeModifier(
                ATTRIBUTE_MODIFIER, 0.15f,
                AttributeModifier.Operation.MULTIPLY_SCALAR_1);
        AttributeModifier damageModifier = new AttributeModifier(
                ATTRIBUTE_MODIFIER, 7,
                AttributeModifier.Operation.ADD_NUMBER);
        AttributeModifier attackSpeedModifier = new AttributeModifier(
                ATTRIBUTE_MODIFIER, -2.4f,
                AttributeModifier.Operation.ADD_NUMBER);

        velox.setData(DataComponentTypes.ATTRIBUTE_MODIFIERS,
                ItemAttributeModifiers.itemAttributes()
                        .addModifier(Attribute.MOVEMENT_SPEED, speedModifier, EquipmentSlotGroup.MAINHAND)
                        .addModifier(Attribute.ATTACK_DAMAGE, damageModifier, EquipmentSlotGroup.MAINHAND)
                        .addModifier(Attribute.ATTACK_SPEED, attackSpeedModifier, EquipmentSlotGroup.MAINHAND));

        return velox.clone();
    }

    public static ItemStack getRegalis() {
        ItemStack regalis = ItemStackBuilder.create(new ItemStack(Material.DIAMOND_HELMET))
                .name(Component.text("Regalis", NamedTextColor.GOLD).decorate(TextDecoration.BOLD, TextDecoration.ITALIC))
                .lore(Component.empty(), Component.text(" When worn, grants +0.3 attack speed and +2 hearts.", NamedTextColor.GRAY),
                        Component.empty(), Component.text(" Quand équipé, il confère +0,3 vitesse d'attaque et +2 cœurs!        ", NamedTextColor.GRAY))
                .build();

        AttributeModifier attackSpeedModifier = new AttributeModifier(
                ATTRIBUTE_MODIFIER, 0.2f,
                AttributeModifier.Operation.ADD_NUMBER);
        AttributeModifier maxHealthModifier = new AttributeModifier(
                ATTRIBUTE_MODIFIER, 4,
                AttributeModifier.Operation.ADD_NUMBER);
        AttributeModifier armorModifier = new AttributeModifier(
                ATTRIBUTE_MODIFIER, 3,
                AttributeModifier.Operation.ADD_NUMBER);
        AttributeModifier toughnessModifier = new AttributeModifier(
                ATTRIBUTE_MODIFIER, 2,
                AttributeModifier.Operation.ADD_NUMBER);

        regalis.setData(DataComponentTypes.ATTRIBUTE_MODIFIERS,
                ItemAttributeModifiers.itemAttributes()
                        .addModifier(Attribute.ATTACK_SPEED, attackSpeedModifier, EquipmentSlotGroup.HEAD)
                        .addModifier(Attribute.MAX_HEALTH, maxHealthModifier, EquipmentSlotGroup.HEAD)
                        .addModifier(Attribute.ARMOR, armorModifier, EquipmentSlotGroup.HEAD)
                        .addModifier(Attribute.ARMOR_TOUGHNESS, toughnessModifier, EquipmentSlotGroup.HEAD));

        return regalis.clone();
    }
}
