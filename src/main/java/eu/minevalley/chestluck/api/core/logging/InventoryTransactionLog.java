package eu.minevalley.chestluck.api.core.logging;

import eu.minevalley.proxima.api.user.User;
import org.bukkit.block.Block;
import org.bukkit.inventory.ItemStack;

import javax.annotation.Nonnull;
import java.time.Instant;

@SuppressWarnings("unused")
public record InventoryTransactionLog(
        @Nonnull Block block, @Nonnull User user, @Nonnull String description, @Nonnull Instant timestamp,
        @Nonnull Direction direction, @Nonnull ItemStack itemStack, int amount) implements LogEntry {

    public enum Direction {GIVE, TAKE}
}