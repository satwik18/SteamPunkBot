package me.SteamPunkBot.bot.event.options;

import me.SteamPunkBot.bot.character.PlayerProfile;
import me.SteamPunkBot.bot.event.GameEvent;

public class BasicOption extends GameEventOption {
    private String description;
    private GameEvent nextEvent;

    public BasicOption(String description, GameEvent nextEvent) {
        this.description = description;
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
        return nextEvent;
    }
}
