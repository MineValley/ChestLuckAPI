package minevalley.chestluck.api.core.capabilities;

import minevalley.chestluck.api.core.Lockable;
import org.jetbrains.annotations.Contract;

import javax.annotation.Nonnull;

@SuppressWarnings("unused")
public interface AutoOpenable {

    /**
     * Checks whether the AutoOpenable will automatically open for registrants.
     *
     * @return whether the AutoOpenable will automatically open for registrants
     */
    @Contract(pure = true)
    boolean isAutoOpen();

    /**
     * Sets whether the AutoOpenable will automatically open for registrants.
     *
     * @param autoOpen whether the AutoOpenable should automatically open for registrants
     * @return the underlying Lockable
     */
    @Nonnull
    @Contract("_ -> this")
    Lockable setAutoOpen(boolean autoOpen);
}