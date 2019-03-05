package me.SteamPunkBot.bot.character;

import me.SteamPunkBot.bot.event.GameEventManager;
import me.SteamPunkBot.bot.flags.PlayerFlag;

import java.util.ArrayList;
import java.util.List;

public class PlayerCharacter {
    private String characterName;
    private GameEventManager eventManager;
    private List<PlayerFlag> flagList;

    public PlayerCharacter(String characterName, PlayerProfile profile) {
        this.characterName = characterName;
        eventManager = new GameEventManager();
        flagList = new ArrayList<>();
    }

    /**
     * Returns true or false depending on whether the player has a given flag
     * @param flag the given flag
     * @return Boolean value whether the player has the given flag
     */
    public Boolean hasFlag(PlayerFlag flag) {
        for(int i = 0; i < flagList.size(); i++) {
            if (flagList.get(i).getName().equalsIgnoreCase(flag.getName()))
                return true;
        }
        return false;
    }

    /**
     * Returns true or false depending on whether the player has a given flag
     * @param flagName the String name of the flag
     * @return Boolean value whether the player has the given flag
     */
    public Boolean hasFlag(String flagName) {
        for(int i = 0; i < flagList.size(); i++) {
            if (flagList.get(i).getName().equalsIgnoreCase(flagName))
                return true;
        }
        return false;
    }

    /**
     * Adds flag to player flags
     * @param flag
     */
    public void addFlag(PlayerFlag flag) {
        flagList.add(flag);
    }

    /**
     * Getter for character name
     * @return String character name
     */
    public String getCharacterName() {
        return characterName;
    }

    /**
     * Getter for player eventmanager
     * @return EventManager
     */
    public GameEventManager getEventManager() {
        return eventManager;
    }

    public List<PlayerFlag> getFlagList() {
        return flagList;
    }
}
