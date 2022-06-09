package me.knighthat.plugin.commands;

import lombok.NonNull;
import me.knighthat.apis.color.Color;
import me.knighthat.plugin.VoidToSpawn;
import net.kyori.adventure.text.Component;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;


public class ReloadCommand extends PluginCommand implements Color {

    public ReloadCommand(@NonNull VoidToSpawn plugin) {
        super(plugin);
    }

    @Override
    public @NonNull String getName() {
        return "reload";
    }

    @Override
    public @NonNull String getPermission() {
        return getName();
    }

    @Override
    public boolean isPlayerRequired() {
        return false;
    }

    @Override
    public void execute(@NonNull CommandSender sender, @NotNull @NonNull String[] args) {

       getPlugin().config.reload();


       String rldMsg = getPlugin().message.get().getString("reload", "&aReloaded successfully");
       sender.sendMessage(color(rldMsg));
    }
}
