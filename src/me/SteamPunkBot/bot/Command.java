package me.SteamPunkBot.bot;

import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;

public abstract class Command {
    public abstract String getName();
    public abstract void trigger(String[] args, GuildMessageReceivedEvent event);
}
