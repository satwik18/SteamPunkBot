package me.SteamPunkBot.bot.game;

import net.dv8tion.jda.core.entities.TextChannel;

public class TextDisplay {
    public TextDisplay(String message, TextChannel channel) {
        channel.sendMessage(message).queue();
    }
}
