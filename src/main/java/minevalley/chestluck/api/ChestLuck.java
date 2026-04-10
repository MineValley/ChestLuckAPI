package minevalley.chestluck.api;

import minevalley.chestluck.api.core.Lockable;
import minevalley.core.api.Registrant;
import org.bukkit.block.Block;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

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
}