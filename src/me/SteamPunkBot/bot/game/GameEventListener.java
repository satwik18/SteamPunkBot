package me.SteamPunkBot.bot.game;

import me.SteamPunkBot.bot.command.Command;
import me.SteamPunkBot.bot.server.GameServer;
import net.dv8tion.jda.core.entities.Member;
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

        GameServer server = Game.getServer(event.getGuild().getId());

        Boolean isMentioned = false;
        for(Member m : event.getMessage().getMentionedMembers()) {
            if(m.getUser().getId().equals(BotMain.getId())) {
                isMentioned = true;
                break;
            }
        }

        if(isMentioned) {
            event.getChannel().sendMessage(GameProperties.ID_HELP_MSG[0] + event.getAuthor().getName() +
                    GameProperties.ID_HELP_MSG[1] + server.getPrefix() + GameProperties.ID_HELP_MSG[2]).queue();
        }

        if(!event.getMember().getUser().isBot()) {
            //If the author has a profile, update the channel for the profile
            if(server.isExistingProfile(event.getAuthor().getId()))
                server.getProfile(event.getAuthor().getId()).setChannel(event.getChannel());
            if(args[0].startsWith(server.getPrefix())) {
                args[0] = args[0].substring(server.getPrefix().length());
                for (Command c : commandList) {
                    if (c.equals(args[0])) {
                        c.trigger(args, event);
                    }
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
