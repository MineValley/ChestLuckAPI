package eu.minevalley.chestluck.api.core.logging;

import eu.minevalley.proxima.api.user.User;
import org.bukkit.block.Block;
import org.jetbrains.annotations.Contract;

import javax.annotation.Nonnull;
import java.time.Instant;

@SuppressWarnings("unused")
public sealed interface LogEntry permits BlockActionLog, InteractionLog, InventoryTransactionLog {

    /**
     * Gets the timestamp of this log entry
     *
     * @return timestamp of this log entry
     */
    @Nonnull
    @Contract(pure = true)
    Instant timestamp();

    /**
     * Gets the block associated with this log entry
     *
     * @return block associated with this log entry
     */
    @Nonnull
    @Contract(pure = true)
    Block block();

    /**
     * Gets the user associated with this log entry
     *
     * @return user associated with this log entry
     */
    @Nonnull
    @Contract(pure = true)
    User user();

    /**
     * Gets the description of this log entry
     *
     * @return description of this log entry
     */
    @Nonnull
    @Contract(pure = true)
    String description();
}