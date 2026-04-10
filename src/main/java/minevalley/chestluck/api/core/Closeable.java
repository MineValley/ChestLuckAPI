package minevalley.chestluck.api.core;

import org.jetbrains.annotations.Contract;

import javax.annotation.Nonnull;

@SuppressWarnings("unused")
public interface Closeable extends Lockable<Closeable> {

    /**
     * Checks whether the Closeable should automatically close after it has been opened
     *
     * @return whether the Closeable should automatically close after it has been opened
     */
    @Contract(pure = true)
    boolean isAutoClose();

    /**
     * Sets whether the Closeable should automatically close after it has been opened
     *
     * @param autoClose whether the Closeable should automatically close after it has been opened
     * @return this
     */
    @Nonnull
    @Contract("_ -> this")
    Closeable setAutoClose(boolean autoClose);

    /**
     * Checks whether the Closeable will automatically open for registrants.
     *
     * @return whether the Closeable will automatically open for registrants
     */
    @Contract(pure = true)
    boolean isAutoOpen();

    /**
     * Sets whether the Closeable will automatically open for registrants.
     *
     * @param autoOpen whether the Closeable should automatically open for registrants
     * @return this
     */
    @Nonnull
    @Contract("_ -> this")
    Closeable setAutoOpen(boolean autoOpen);
}
