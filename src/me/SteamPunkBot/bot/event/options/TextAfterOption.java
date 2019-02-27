package me.SteamPunkBot.bot.event.options;

import me.SteamPunkBot.bot.character.PlayerProfile;
import me.SteamPunkBot.bot.event.GameEvent;
import me.SteamPunkBot.bot.game.TextDisplay;

public class TextAfterOption extends GameEventOption {
    private String description;
    private String afterText;
    private GameEvent nextEvent;

    public TextAfterOption(String description, String afterText, GameEvent nextEvent) {
        this.description = description;
        this.afterText = afterText;
        this.nextEvent = nextEvent;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public Boolean isAvailable(PlayerProfile profile) {
        return true;
    }

    @Override
    public GameEvent choose(PlayerProfile profile) {
        new TextDisplay(afterText, profile.getChannel());
        return nextEvent;
    }
}
