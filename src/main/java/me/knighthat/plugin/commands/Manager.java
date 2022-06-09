package me.knighthat.plugin.commands;

import lombok.Getter;
import lombok.NonNull;
import me.knighthat.apis.color.Color;
import me.knighthat.plugin.VoidToSpawn;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class Manager implements CommandExecutor, Color {

    private VoidToSpawn plugin;
    private final @NonNull List<PluginCommand> commands = new ArrayList<>();

    public Manager(VoidToSpawn plugin){

        this.plugin = plugin;

        commands.add(new ReloadCommand(plugin));
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

        if(args.length < 1) return true;

        for(PluginCommand cmd : commands)
            if(cmd.getName().equalsIgnoreCase(args[0])){

                if(!cmd.getPermission().isEmpty()) {

                    String permission = "voidtospawn.command." + cmd.getPermission();

                    if (!sender.hasPermission(permission)) {

                        String noPermMsg = plugin.message.get().getString("no-permission");
                        noPermMsg = noPermMsg.replace("%perm",permission );

                        sender.sendMessage(color(noPermMsg));
                        return true;
                    }
                }


            }
        return true;
    }
}

abstract class PluginCommand extends me.knighthat.apis.command.PluginCommand{

    @Getter
    private @NonNull final VoidToSpawn plugin;

    protected PluginCommand(@NonNull VoidToSpawn plugin){
        this.plugin = plugin;
    }
}
