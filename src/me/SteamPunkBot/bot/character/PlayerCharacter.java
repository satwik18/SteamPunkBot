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

    public Boolean hasFlag(PlayerFlag flag) {
        for(int i = 0; i < flagList.size(); i++) {
            if (flagList.get(i).equals(flag))
                return true;
        }
        return false;
    }

    public Boolean hasFlag(String flagName) {
        for(int i = 0; i < flagList.size(); i++) {
            if (flagList.get(i).equals(flagName))
                return true;
        }
        return false;
    }

    public void addFlag(PlayerFlag flag) {
        flagList.add(flag);
    }

    public String getCharacterName() {
        return characterName;
    }

    public GameEventManager getEventManager() {
        return eventManager;
    }

    public List<PlayerFlag> getFlagList() {
        return flagList;
    }
}
