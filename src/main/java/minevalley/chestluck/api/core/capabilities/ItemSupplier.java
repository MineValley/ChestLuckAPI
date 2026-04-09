package minevalley.chestluck.api.core.capabilities;

import minevalley.chestluck.api.core.Lockable;
import org.jetbrains.annotations.Contract;

import javax.annotation.Nonnull;

@SuppressWarnings("unused")
public interface ItemSupplier {

    /**
     * Checks whether the ItemReceiver can supply items or not.
     *
     * @return true if the ItemReceiver can supply items, false otherwise
     */
    @Contract(pure = true)
    boolean canSupplyItems();

    /**
     * Sets whether the ItemReceiver can supply items or not.
     *
     * @param canSupplyItems true if the ItemReceiver can supply items, false otherwise
     * @return the underlying Lockable
     */
    @Nonnull
    @Contract("_ -> this")
    Lockable setCanSupplyItems(boolean canSupplyItems);
}