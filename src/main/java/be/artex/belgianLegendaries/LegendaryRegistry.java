package be.artex.belgianLegendaries;

import be.artex.belgianLegendaries.api.DashLegendary;
import be.artex.belgianLegendaries.api.Legendary;
import org.bukkit.inventory.ItemStack;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LegendaryRegistry {
    private static final List<Legendary> LEGENDARIES = new ArrayList<>();

    public static final DashLegendary DASH_SWORD = registerDashLegendary("velox", Stacks.getVelox(), 500);

    private static DashLegendary registerDashLegendary(String ID, ItemStack stack, float dashHorizontalMultiplier, float dashVerticalMultiplier, int cooldownTicks) {
        DashLegendary legendary = DashLegendary.create(ID, stack, dashHorizontalMultiplier, dashVerticalMultiplier, cooldownTicks);
        LEGENDARIES.add(legendary);
        return legendary;
    }

    private static DashLegendary registerDashLegendary(String ID, ItemStack stack, int cooldownTicks) {
        DashLegendary legendary = DashLegendary.create(ID, stack, cooldownTicks);
        LEGENDARIES.add(legendary);

        return legendary;
    }

    private static DashLegendary registerDashLegendary(String ID, ItemStack stack) {
        DashLegendary legendary = DashLegendary.create(ID, stack);
        LEGENDARIES.add(legendary);
        return legendary;
    }

    @NotNull
    public static List<Legendary> getLegendaries() {
        return Collections.unmodifiableList(LEGENDARIES);
    }
}
