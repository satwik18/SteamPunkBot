package me.SteamPunkBot.bot;

import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;

import java.util.ArrayList;
import java.util.List;

public class EventListener {
    private List<Command> commandList;

    public EventListener() {
        commandList = new ArrayList<Command>();
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
