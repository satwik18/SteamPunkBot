package me.SteamPunkBot.bot.game;

import me.SteamPunkBot.bot.command.Command;
import me.SteamPunkBot.bot.server.GameServer;
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

        if(!event.getMember().getUser().isBot()) {
            GameServer server = Game.getServer(event.getGuild().getId());
            if(server.isExistingProfile(event.getAuthor().getId()))
                server.getProfile(event.getAuthor().getId()).setChannel(event.getChannel());
            for (Command c : commandList) {
                if (c.equals(args[0])) {
                    c.trigger(args, event);
                }
            }
        }
    }

    public void addCommand(Command command) {
        commandList.add(command);
    }

    public void addCommand(List<Command> commandList) {
        commandList.addAll(commandList);
    }
}
