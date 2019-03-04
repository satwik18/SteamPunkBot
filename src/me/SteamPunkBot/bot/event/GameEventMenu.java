package me.SteamPunkBot.bot.event;

import me.SteamPunkBot.bot.character.PlayerProfile;
import me.SteamPunkBot.bot.event.options.GameEventOption;
import net.dv8tion.jda.core.entities.TextChannel;

import java.util.List;

public class GameEventMenu {
    public GameEventMenu(TextChannel channel, List<GameEventOption> eventOptionList) {
        for(int i = 0; i < eventOptionList.size(); i++) {
            channel.sendMessage((i + 1) + ": " + eventOptionList.get(i).getDescription()).queue();
        }
    }
}
