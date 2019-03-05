package me.SteamPunkBot.bot.event.options;

import me.SteamPunkBot.bot.character.PlayerProfile;
import me.SteamPunkBot.bot.event.GameEvent;

public class ChooseMessageOption extends GameEventOption{
    private GameEventOption option;
    private String message;

    public ChooseMessageOption(GameEventOption option, String message) {
        this.message = message;
        this.option = option;
    }

    @Override
    public String getDescription() {
        return option.getDescription();
    }

    @Override
    public Boolean isAvailable(PlayerProfile profile) {
        return option.isAvailable(profile);
    }

    @Override
    public GameEvent choose(PlayerProfile profile) {
        profile.getChannel().sendMessage(message).queue();
        return option.choose(profile);
    }
}
