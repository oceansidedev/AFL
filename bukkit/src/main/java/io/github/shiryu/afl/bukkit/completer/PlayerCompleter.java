package io.github.shiryu.afl.bukkit.completer;

import io.github.shiryu.afl.api.completer.Completer;
import io.github.shiryu.afl.api.sender.CommandSender;
import org.apache.commons.lang3.StringUtils;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.stream.Collectors;

public class PlayerCompleter implements Completer {

    @Override
    public @NotNull List<String> getSuggestions(@NotNull final CommandSender sender, @NotNull final String value) {
        return Bukkit.getOnlinePlayers().parallelStream()
                .map(Player::getName)
                .filter(s -> StringUtils.startsWithIgnoreCase(s, value))
                .collect(Collectors.toList());
    }
}
