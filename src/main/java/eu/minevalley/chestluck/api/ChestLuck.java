package eu.minevalley.chestluck.api;

import eu.minevalley.chestluck.api.core.locking.Lockable;
import eu.minevalley.chestluck.api.core.logging.LogEntry;
import eu.minevalley.chestluck.api.core.logging.LogQuery;
import eu.minevalley.proxima.api.Registrant;
import org.bukkit.block.Block;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@SuppressWarnings({"unused", "UnusedReturnValue"})
public class ChestLuck {

    private static ChestLuckProvider provider;

    /**
     * Creates a new lockable at the given block with the given owner and registrants.
     *
     * @param owner       the owner of the lockable
     * @param block       the block of the lockable
     * @param registrants the registrants of the lockable
     * @return the created lockable
     * @throws IllegalArgumentException if the owner is null, the block is null, the registrants are null or if a lockable already exists at the given block
     */
    @Nonnull
    public static Lockable<? extends Lockable<?>> createLockable(@Nonnull Registrant owner, @Nonnull Block block, @Nonnull Registrant... registrants) throws IllegalArgumentException {
        return provider.createLockable(owner, block, registrants);
    }

    /**
     * Gets the lockable at the given block.
     *
     * @param block the block to get the lockable at
     * @return the lockable at the given block or null if no lockable exists at the given block
     * @throws IllegalArgumentException if the block is null
     */
    @Nullable
    public static Lockable<? extends Lockable<?>> getLockableAt(@Nonnull Block block) throws IllegalArgumentException {
        return provider.getLockableAt(block);
    }

    /**
     * Gets all log entries matching the given query, newest first.
     *
     * @param query the query to filter by
     * @return a future completing with the matching log entries
     */
    @Nonnull
    public static <T extends LogEntry> CompletableFuture<List<T>> getLogs(@Nonnull LogQuery<T> query) {
        return provider.getLogs(query);
    }

    /**
     * Logs the given entries. The entries are persisted asynchronously.
     *
     * @param entries the entries to log
     * @throws IllegalArgumentException if the entries are null
     */
    public static void log(@Nonnull LogEntry... entries) throws IllegalArgumentException {
        provider.log(entries);
    }
}