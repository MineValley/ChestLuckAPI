package eu.minevalley.chestluck.api.core.logging;

import eu.minevalley.proxima.api.user.User;
import org.bukkit.Material;
import org.bukkit.block.Block;

import javax.annotation.Nonnull;
import java.time.Instant;

@SuppressWarnings("unused")
public record BlockActionLog(
        @Nonnull Block block, @Nonnull User user, @Nonnull String description, @Nonnull Instant timestamp,
        @Nonnull Action action, @Nonnull Material material) implements LogEntry {

    public enum Action {PLACE, BREAK}
}