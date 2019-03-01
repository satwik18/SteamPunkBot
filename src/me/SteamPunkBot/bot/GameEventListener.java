package me.SteamPunkBot.bot;

import me.SteamPunkBot.bot.command.Command;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

import java.util.ArrayList;
import java.util.List;

public class GameEventListener extends ListenerAdapter {
    private List<Command> commandList;

    public GameEventListener() {
        commandList = new ArrayList<>();
    }

    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
        String[] args = event.getMessage().getContentRaw().split(" ");

        if(!event.getMember().getUser().isBot())
            for(Command c: commandList)
                if(c.getName().equalsIgnoreCase(args[0]))
                    c.trigger(args, event);
    }

    public void addCommand(Command command) {
        commandList.add(command);
    }
}
