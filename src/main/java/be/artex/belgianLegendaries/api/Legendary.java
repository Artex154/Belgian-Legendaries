package be.artex.belgianLegendaries.api;

import be.artex.belgianLegendaries.LegendaryRegistry;
import be.artex.belgianLegendaries.Main;
import net.kyori.adventure.key.Key;
import org.bukkit.NamespacedKey;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataType;
import org.jetbrains.annotations.NotNull;
import org.jspecify.annotations.Nullable;

public class Legendary {
    private static final NamespacedKey stackData = new NamespacedKey(Main.instance, "legendary");

    private final String ID;
    private final Key key;
    private final ItemStack stack;

    public Legendary(String ID, ItemStack stack) {
        this.ID = ID;
        this.key = Key.key(ID);
        this.stack = stack;
    }

    public String getID() {
        return ID;
    }

    public Key getKey() {
        return key;
    }

    public ItemStack getStack() {
        ItemStack dataStack = stack.clone();
        dataStack.editPersistentDataContainer(persistentDataContainer -> {
            persistentDataContainer.set(stackData, PersistentDataType.STRING, ID);
        });

        return dataStack;
    }

    public void onClick(PlayerInteractEvent event) {
    }

    @Nullable
    public static Legendary getLegendaryFromStack(@NotNull ItemStack stack) {
        String legendaryData = stack.getPersistentDataContainer().get(stackData, PersistentDataType.STRING);

        for (Legendary l : LegendaryRegistry.getLegendaries())
            if (l.getID().equals(legendaryData))
                return l;

        return null;
    }

    @Nullable
    public static Legendary getLegendaryFromID(@NotNull String id) {
        for (Legendary l : LegendaryRegistry.getLegendaries())
            if (l.getID().equals(id))
                return l;

        return null;
    }

}
