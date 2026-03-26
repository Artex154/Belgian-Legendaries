package be.artex.belgianLegendaries.command;

import be.artex.belgianLegendaries.api.Legendary;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class LegendaryCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String @NotNull [] args) {
        if (!(sender instanceof Player player))
            return true;

        if (args.length == 0)
            return true;

        if (!player.isOp())
            return true;

        Legendary legendary = Legendary.getLegendaryFromID(args[0]);

        if (legendary != null)
            player.getInventory().addItem(legendary.getStack());

        return true;
    }
}
