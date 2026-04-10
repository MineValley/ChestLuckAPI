package minevalley.chestluck.api.core;

import minevalley.core.api.Registrant;
import org.bukkit.block.Block;
import org.bukkit.block.data.type.Chest;
import org.jetbrains.annotations.Contract;

import javax.annotation.Nonnull;

@SuppressWarnings("unused")
public interface Lockable<T extends Lockable<T>> {

    /**
     * Checks if the specified block is currently locked.
     *
     * @param block the block to check; must not be {@code null}
     * @return {@code true} if the block is locked, {@code false} otherwise
     * @throws IllegalArgumentException if the block is null
     */
    @Contract(pure = true)
    boolean isLocked(@Nonnull Block block) throws IllegalArgumentException;

    /**
     * Locks the specified block.
     *
     * @param block the block to lock; must not be {@code null}
     * @return this
     * @throws IllegalArgumentException if the block is null or cannot be locked
     */
    @Nonnull
    @Contract("_ -> this")
    T lock(@Nonnull Block block) throws IllegalArgumentException;

    /**
     * Releases the lock on the specified block.
     *
     * @param block the block to release; must not be {@code null}
     * @return this
     * @throws IllegalArgumentException if the block is null or is not currently locked
     */
    @Nonnull
    @Contract("_ -> this")
    T release(@Nonnull Block block) throws IllegalArgumentException;

    /**
     * Checks if the specified registrant has permission to access this lockable.
     *
     * @param registrant the registrant to check; must not be {@code null}
     * @return {@code true} if the registrant has permission, {@code false} otherwise
     * @throws IllegalArgumentException if the registrant is null
     */
    @Contract(pure = true)
    boolean hasPermission(@Nonnull Registrant registrant) throws IllegalArgumentException;

    /**
     * Grants permission to the specified registrant.
     *
     * @param registrant the registrant to grant permission to; must not be {@code null}
     * @return this
     * @throws IllegalArgumentException if the registrant is null or already has permission
     */
    @Nonnull
    @Contract("_ -> this")
    T grantPermission(@Nonnull Registrant registrant) throws IllegalArgumentException;

    /**
     * Revokes permission from the specified registrant.
     *
     * @param registrant the registrant to revoke permission from; must not be {@code null}
     * @return this
     * @throws IllegalArgumentException if the registrant is null or does not currently have permission
     */
    @Nonnull
    @Contract("_ -> this")
    T revokePermission(@Nonnull Registrant registrant) throws IllegalArgumentException;

    /**
     * Returns the owner registrant
     *
     * @return the owner registrant
     */
    @Nonnull
    @Contract(pure = true)
    Chest getOwner();

    /**
     * Removes this lockable, releasing all locks and permissions.
     */
    void remove();
}