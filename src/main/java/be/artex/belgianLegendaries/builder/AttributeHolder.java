package be.artex.belgianLegendaries.builder;

import be.artex.belgianLegendaries.Main;
import io.papermc.paper.datacomponent.DataComponentTypes;
import io.papermc.paper.datacomponent.item.ItemAttributeModifiers;
import org.bukkit.NamespacedKey;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.inventory.EquipmentSlotGroup;
import org.bukkit.inventory.ItemStack;

public class AttributeHolder {
    private static final NamespacedKey ATTRIBUTE_MODIFIER = new NamespacedKey(Main.instance, "attribute_modifier");

    private final Attribute attributeType;
    private final double amount;
    private final AttributeModifier.Operation operation;
    private final EquipmentSlotGroup slot;

    public AttributeHolder(Attribute attributeType, double amount, AttributeModifier.Operation operation, EquipmentSlotGroup slot) {
        this.attributeType = attributeType;
        this.amount = amount;
        this.operation = operation;
        this.slot = slot;
    }

    public void apply(ItemStack stack) {
        AttributeModifier attributeModifier = new AttributeModifier(
                ATTRIBUTE_MODIFIER, this.amount, this.operation
        );

        stack.setData(DataComponentTypes.ATTRIBUTE_MODIFIERS, ItemAttributeModifiers.itemAttributes().addModifier(
                this.attributeType, attributeModifier, this.slot
        ));
    }
}
