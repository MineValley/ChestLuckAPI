package minevalley.chestluck.api.core;

import org.jetbrains.annotations.Contract;

import javax.annotation.Nonnull;

@SuppressWarnings("unused")
public interface ItemHolder extends Lockable<ItemHolder> {

    /**
     * Checks whether the ItemHolder can receive items or not.
     *
     * @return true if the ItemHolder can receive items, false otherwise
     */
    @Contract(pure = true)
    boolean canReceiveItems();

    /**
     * Sets whether the ItemHolder can receive items or not.
     *
     * @param canReceiveItems true if the ItemHolder should be able to receive items, false otherwise
     * @return this
     */
    @Nonnull
    @Contract("_ -> this")
    ItemHolder setCanReceiveItems(boolean canReceiveItems);

    /**
     * Checks whether the ItemHolder can supply items or not.
     *
     * @return true if the ItemHolder can supply items, false otherwise
     */
    @Contract(pure = true)
    boolean canSupplyItems();

    /**
     * Sets whether the ItemHolder can supply items or not.
     *
     * @param canSupplyItems true if the ItemHolder can supply items, false otherwise
     * @return this
     */
    @Nonnull
    @Contract("_ -> this")
    ItemHolder setCanSupplyItems(boolean canSupplyItems);
}
