package eu.minevalley.chestluck.api;

import eu.minevalley.chestluck.api.core.locking.Lockable;
import eu.minevalley.chestluck.api.core.logging.LogEntry;
import eu.minevalley.chestluck.api.core.logging.LogQuery;
import eu.minevalley.proxima.api.Registrant;
import org.bukkit.block.Block;
import org.jetbrains.annotations.Contract;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@SuppressWarnings("unused")
public interface Service {

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
    @Contract("_, _, _ -> new")
    Lockable<? extends Lockable<?>> createLockable(Registrant owner, Block block, Registrant... registrants) throws IllegalArgumentException;

    /**
     * Gets the lockable at the given block.
     *
     * @param block the block to get the lockable at
     * @return the lockable at the given block or null if no lockable exists at the given block
     * @throws IllegalArgumentException if the block is null
     */
    @Nullable
    @Contract(pure = true)
    Lockable<? extends Lockable<?>> getLockableAt(Block block) throws IllegalArgumentException;

    /**
     * Gets all log entries matching the given query, newest first.
     *
     * @param query the query to filter by
     * @return a future completing with the matching log entries
     */
    @Nonnull
    @Contract(pure = true)
    <T extends LogEntry> CompletableFuture<List<T>> getLogs(@Nonnull LogQuery<T> query);

    /**
     * Logs the given entries. The entries are persisted asynchronously.
     *
     * @param entries the entries to log
     * @throws IllegalArgumentException if the entries are null
     */
    void log(@Nonnull LogEntry... entries);
}