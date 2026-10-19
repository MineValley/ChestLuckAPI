package eu.minevalley.chestluck.api;

import eu.minevalley.chestluck.api.core.locking.Lockable;
import eu.minevalley.chestluck.api.core.logging.LogEntry;
import eu.minevalley.chestluck.api.core.logging.LogQuery;
import eu.minevalley.proxima.api.Registrant;
import org.bukkit.block.Block;
import org.jetbrains.annotations.ApiStatus;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@ApiStatus.Internal
public interface ChestLuckProvider {

    @Nonnull
    Lockable<? extends Lockable<?>> createLockable(Registrant owner, Block block, Registrant... registrants) throws IllegalArgumentException;

    @Nullable
    Lockable<? extends Lockable<?>> getLockableAt(Block block) throws IllegalArgumentException;

    @Nonnull
    <T extends LogEntry> CompletableFuture<List<T>> getLogs(@Nonnull LogQuery<T> query);

    void log(@Nonnull LogEntry... entries);
}