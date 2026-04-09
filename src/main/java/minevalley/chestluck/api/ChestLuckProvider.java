package minevalley.chestluck.api;

import minevalley.chestluck.api.core.Lockable;
import minevalley.core.api.Registrant;
import org.bukkit.Location;
import org.jetbrains.annotations.ApiStatus;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

@ApiStatus.Internal
public interface ChestLuckProvider {

    @Nonnull
    Lockable createLockable(Registrant owner, Location location, Registrant... registrants) throws IllegalArgumentException;

    @Nullable
    Lockable getLockableAt(Location location) throws IllegalArgumentException;
}