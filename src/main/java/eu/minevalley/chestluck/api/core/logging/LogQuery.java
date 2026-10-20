package eu.minevalley.chestluck.api.core.logging;

import eu.minevalley.chestluck.api.ChestLuck;
import eu.minevalley.proxima.api.user.User;
import lombok.Getter;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.jetbrains.annotations.Contract;

import javax.annotation.Nonnull;
import java.time.Instant;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@SuppressWarnings("unused")
@Getter
public final class LogQuery<T extends LogEntry> {

    private final Class<T> type;
    private User user;
    private Location location;
    private Instant from, to;
    private int limit = 100;

    private LogQuery(Class<T> type) {
        this.type = type;
    }

    /**
     * Query for a specific log type. Use {@code LogEntry.class} for all types.
     */
    @Nonnull
    public static <T extends LogEntry> LogQuery<T> of(@Nonnull Class<T> type) {
        return new LogQuery<>(type);
    }

    /**
     * Query for a specific user. If not set, all users will be queried.
     *
     * @param user the user to query for
     * @return this
     */
    @Nonnull
    @Contract("_ -> this")
    public LogQuery<T> user(@Nonnull User user) {
        this.user = user;
        return this;
    }

    /**
     * Query for a specific block. If not set, all blocks will be queried.
     *
     * @param block the block to query for
     * @return this
     */
    @Nonnull
    @Contract("_ -> this")
    public LogQuery<T> at(@Nonnull Block block) {
        this.location = block.getLocation();
        return this;
    }

    /**
     * Limit the query to logs since the given timestamp. If not set, all logs will be queried.
     *
     * @param from the timestamp to query from
     * @return this
     */
    @Nonnull
    @Contract("_ -> this")
    public LogQuery<T> since(@Nonnull Instant from) {
        this.from = from;
        return this;
    }

    /**
     * Limit the query to logs until the given timestamp. If not set, all logs will be queried.
     *
     * @param to the timestamp to query until
     * @return this
     */
    @Nonnull
    @Contract("_ -> this")
    public LogQuery<T> until(@Nonnull Instant to) {
        this.to = to;
        return this;
    }

    /**
     * Limit the amount of logs to be queried. If not set, the default limit is 100. Set to 0 for no limit.
     *
     * @param limit the limit amount
     * @return this
     */
    @Nonnull
    @Contract("_ -> this")
    public LogQuery<T> limit(int limit) {
        this.limit = limit;
        return this;
    }

    /**
     * Gets all log entries matching this query, newest first.
     *
     * @return a future completing with the matching log entries
     */
    @Nonnull
    @Contract(pure = true)
    public CompletableFuture<List<T>> execute() {
        return ChestLuck.service().getLogs(this);
    }
}