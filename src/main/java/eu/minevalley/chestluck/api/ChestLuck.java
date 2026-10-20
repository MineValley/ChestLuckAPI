package eu.minevalley.chestluck.api;

import org.jetbrains.annotations.Contract;

import javax.annotation.Nonnull;

@SuppressWarnings("unused")
public class ChestLuck {

    private static Service service;

    @Nonnull
    @Contract(pure = true)
    public static Service service() {
        return service;
    }
}