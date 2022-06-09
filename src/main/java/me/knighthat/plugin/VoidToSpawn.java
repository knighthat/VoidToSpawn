package me.knighthat.plugin;

import lombok.NonNull;
import me.knighthat.apis.file.YamlFile;
import me.knighthat.plugin.commands.Manager;
import org.bukkit.plugin.java.JavaPlugin;

public final class VoidToSpawn extends JavaPlugin {

    public @NonNull final YamlFile config = new YamlFile(this, "config");
    public @NonNull final YamlFile message = new YamlFile(this, "message");

    @Override
    public void onEnable() {

        getCommand("voidtospawn").setExecutor(new Manager(this));
    }
}