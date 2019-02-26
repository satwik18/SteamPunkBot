package me.SteamPunkBot.bot.command;

import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;

public class IdCommand extends Command {
    @Override
    public String getName() {
        return "!id";
    }

    @Override
    public void trigger(String[] args, GuildMessageReceivedEvent event) {
        event.getChannel().sendMessage(event.getAuthor().getId()).queue();
    }
}
