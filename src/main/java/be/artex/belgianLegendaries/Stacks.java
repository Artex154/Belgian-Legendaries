package be.artex.belgianLegendaries;

import be.artex.belgianLegendaries.builder.ItemStackBuilder;
import io.papermc.paper.datacomponent.DataComponentTypes;
import io.papermc.paper.datacomponent.item.ItemAttributeModifiers;
import net.kyori.adventure.key.Key;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import net.kyori.adventure.text.format.TextDecoration;
import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.inventory.EquipmentSlotGroup;
import org.bukkit.inventory.ItemStack;

public class Stacks {
    public static final ItemStack VELOX = ItemStackBuilder.create(new ItemStack(Material.DIAMOND_SWORD))
            .name(Component.text("Velox", NamedTextColor.GOLD).decorate(TextDecoration.BOLD, TextDecoration.ITALIC))
            .lore(Component.empty(), Component.text(" Right click while sneaking to dash forward!", NamedTextColor.GRAY), Component.text("  Cooldown:", NamedTextColor.GRAY).append(Component.text(" 25s", NamedTextColor.YELLOW)).append(Component.text(".", NamedTextColor.GRAY)),
                    Component.empty(), Component.text(" Faites un clique droit en sneakant pour dash en avant!        ", NamedTextColor.GRAY), Component.text("  Cooldown:", NamedTextColor.GRAY).append(Component.text(" 25s", NamedTextColor.YELLOW)).append(Component.text(".", NamedTextColor.GRAY)))
            .unbreakable(true)
            .addAttribute(Attribute.MOVEMENT_SPEED, 0.15, AttributeModifier.Operation.MULTIPLY_SCALAR_1, EquipmentSlotGroup.MAINHAND)
            .addAttribute(Attribute.ATTACK_DAMAGE, 7, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlotGroup.MAINHAND)
            .addAttribute(Attribute.ATTACK_SPEED, -2.4, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlotGroup.MAINHAND)
            .setItemModel(Key.key("belgian-legendaries:velox"))
            .build();

    public static final ItemStack REGALIS = ItemStackBuilder.create(new ItemStack(Material.DIAMOND_HELMET))
            .name(Component.text("Regalis", NamedTextColor.GOLD).decorate(TextDecoration.BOLD, TextDecoration.ITALIC))
            .lore(Component.empty(), Component.text(" When worn, grants +0.2 attack speed and +2 hearts.", NamedTextColor.GRAY),
                    Component.empty(), Component.text(" Quand équipé, il confère +0,2 vitesse d'attaque et +2 cœurs!        ", NamedTextColor.GRAY))
            .unbreakable(true)
            .addAttribute(Attribute.ATTACK_SPEED, 0.2, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlotGroup.HEAD)
            .addAttribute(Attribute.MAX_HEALTH, 4, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlotGroup.HEAD)
            .addAttribute(Attribute.ARMOR, 3, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlotGroup.HEAD)
            .addAttribute(Attribute.ARMOR_TOUGHNESS, 2, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlotGroup.HEAD)
            .setItemModel(Key.key("belgian-legendaries:regalis"))
            .build();

    public static final ItemStack EXITIUM = ItemStackBuilder.create(ItemStack.of(Material.DIAMOND_AXE))
            .name(Component.text("Exitium", NamedTextColor.GOLD).decorate(TextDecoration.BOLD, TextDecoration.ITALIC))
            .lore(Component.empty(), Component.text(" Right click while sneaking to gain resistance 3 for 5s.", NamedTextColor.GRAY), Component.text("  Cooldown:", NamedTextColor.GRAY).append(Component.text(" 60s", NamedTextColor.YELLOW)).append(Component.text(".", NamedTextColor.GRAY)),
            Component.empty(), Component.text(" Faites un clique droit en sneakant pour recevoir resistance 3 pour 5s.        ", NamedTextColor.GRAY), Component.text("  Cooldown:", NamedTextColor.GRAY).append(Component.text(" 60s", NamedTextColor.YELLOW)).append(Component.text(".", NamedTextColor.GRAY)))
            .unbreakable(true)
            .setItemModel(Key.key("belgian-legendaries:exitium"))
            .build();
}
