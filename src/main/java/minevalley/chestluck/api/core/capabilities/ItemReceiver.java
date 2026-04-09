package minevalley.chestluck.api.core.capabilities;

import minevalley.chestluck.api.core.Lockable;
import org.jetbrains.annotations.Contract;

import javax.annotation.Nonnull;

@SuppressWarnings("unused")
public interface ItemReceiver {

    /**
     * Checks whether the ItemReceiver can receive items or not.
     *
     * @return true if the ItemReceiver can receive items, false otherwise
     */
    @Contract(pure = true)
    boolean canReceiveItems();

    /**
     * Sets whether the ItemReceiver can receive items or not.
     *
     * @param canReceiveItems true if the ItemReceiver should be able to receive items, false otherwise
     * @return the underlying Lockable
     */
    @Nonnull
    @Contract("_ -> this")
    Lockable setCanReceiveItems(boolean canReceiveItems);
}