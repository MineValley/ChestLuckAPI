package minevalley.chestluck.api;

import minevalley.chestluck.api.core.Lockable;
import minevalley.core.api.Registrant;
import org.bukkit.Location;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

@SuppressWarnings({"unused", "UnusedReturnValue"})
public class ChestLuck {

    private static ChestLuckProvider provider;

    /**
     * Creates a new lockable at the given location with the given owner and registrants.
     *
     * @param owner       the owner of the lockable
     * @param location    the location of the lockable
     * @param registrants the registrants of the lockable
     * @return the created lockable
     * @throws IllegalArgumentException if the owner is null, the location is null, the registrants are null or if a lockable already exists at the given location
     */
    @Nonnull
    public static Lockable<? extends Lockable<?>> createLockable(@Nonnull Registrant owner, @Nonnull Location location, @Nonnull Registrant... registrants) throws IllegalArgumentException {
        return provider.createLockable(owner, location, registrants);
    }

    /**
     * Gets the lockable at the given location.
     *
     * @param location the location to get the lockable at
     * @return the lockable at the given location or null if no lockable exists at the given location
     * @throws IllegalArgumentException if the location is null
     */
    @Nullable
    public static Lockable<? extends Lockable<?>> getLockableAt(@Nonnull Location location) throws IllegalArgumentException {
        return provider.getLockableAt(location);
    }
}