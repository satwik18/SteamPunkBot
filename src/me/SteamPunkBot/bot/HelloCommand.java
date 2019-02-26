package me.SteamPunkBot.bot;

import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;

public class HelloCommand extends Command {
    @Override
    public String getName() {
        return "Hello";
    }

    @Override
    public void trigger(String[] args, GuildMessageReceivedEvent event) {
        event.getChannel().sendMessage("Hello " + event.getMember().getUser().getName() + "!");
    }
}
