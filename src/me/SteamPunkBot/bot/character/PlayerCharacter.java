package me.SteamPunkBot.bot.character;

import me.SteamPunkBot.bot.event.GameEventManager;
import me.SteamPunkBot.bot.flags.PlayerFlag;
import me.SteamPunkBot.bot.flags.PlayerFlagValue;

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
     * Removes flag from player flags
     * @param flag
     */
    public void removeFlag(PlayerFlag flag) {
        PlayerFlag remove = null;
        for(PlayerFlag f: flagList) {
            if(f.equals(flag)) {
                remove = f;
                break;
            }
        }
        flagList.remove(remove);
    }

    /**
     * Removes flag from player flags
     * @param flagName
     */
    public void removeFlag(String flagName) {
        for(int i = 0; i < flagList.size(); i++) {
            if(flagList.get(i).equals(flagName)) {
                flagList.remove(i);
                i--;
            }
        }
    }

    /**
     * Returns value of flag
     * @param flag
     * @return value
     */
    public int getValue(PlayerFlag flag) {
        if(hasFlag(flag)) {
            for(int i = 0; i < flagList.size(); i++) {
                if(flag.getName().equalsIgnoreCase(flagList.get(i).getName()) && flagList.get(i) instanceof PlayerFlagValue)
                    return ((PlayerFlagValue) flagList.get(i)).getValue();
            }
            return 0;
        } else {
            return 0;
        }
    }

    /**
     * Returns value of flag
     * @param flagName
     * @return value
     */
    public int getValue(String flagName) {
        if(hasFlag(flagName)) {
            for(int i = 0; i < flagList.size(); i++) {
                if(flagList.get(i).getName().equalsIgnoreCase(flagName) && flagList.get(i) instanceof PlayerFlagValue)
                    return ((PlayerFlagValue) flagList.get(i)).getValue();
            }
            return 0;
        } else {
            return 0;
        }
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

    /**
     * Getter for list of player flags
     * @return flagList
     */
    public List<PlayerFlag> getFlagList() {
        return flagList;
    }
}
