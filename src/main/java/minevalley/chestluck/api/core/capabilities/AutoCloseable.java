package minevalley.chestluck.api.core.capabilities;

import minevalley.chestluck.api.core.Lockable;
import org.jetbrains.annotations.Contract;

import javax.annotation.Nonnull;

@SuppressWarnings("unused")
public interface AutoCloseable {

    /**
     * Checks whether the AutoCloseable should automatically close after it has been opened
     *
     * @return whether the AutoCloseable should automatically close after it has been opened
     */
    @Contract(pure = true)
    boolean isAutoClose();

    /**
     * Sets whether the AutoCloseable should automatically close after it has been opened
     *
     * @param autoClose whether the AutoCloseable should automatically close after it has been opened
     * @return the underlying Lockable
     */
    @Nonnull
    @Contract("_ -> this")
    Lockable setAutoClose(boolean autoClose);
}