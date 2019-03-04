package me.SteamPunkBot.bot.command;

import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;

public abstract class Command {
    public abstract String getName(); //case insensitive
    public abstract void trigger(String[] args, GuildMessageReceivedEvent event);
    public Boolean equals(String name) {
        return getName().equalsIgnoreCase(name);
    }
}
