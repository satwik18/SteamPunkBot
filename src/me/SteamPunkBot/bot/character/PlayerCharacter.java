package me.SteamPunkBot.bot.character;

import me.SteamPunkBot.bot.event.GameEventManager;

public class PlayerCharacter {
    private String characterName;
    private GameEventManager eventManager;

    public PlayerCharacter(String characterName) {
        this.characterName = characterName;
        eventManager = new GameEventManager();
    }

    public String getCharacterName() {
        return characterName;
    }

    public GameEventManager getEventManager() {
        return eventManager;
    }
}
