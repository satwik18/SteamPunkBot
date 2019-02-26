package me.SteamPunkBot.bot.game;

import me.SteamPunkBot.bot.character.PlayerCharacter;
import me.SteamPunkBot.bot.character.PlayerProfile;

import java.util.ArrayList;
import java.util.List;

public class Game {

    private static List<PlayerProfile> playerProfileList;

    public static void init() {
        playerProfileList = new ArrayList<>();
    }

    public static void addPlayer(PlayerProfile playerProfile) {
        playerProfileList.add(playerProfile);
    }

    public static List<PlayerProfile> getPlayerProfileList() {
        return playerProfileList;
    }

    public static Boolean isExistingProfile(String id) {
        for(int i = 0; i < playerProfileList.size(); i++) {
            if(id.equalsIgnoreCase(playerProfileList.get(i).getId()))
                return true;
        }
        return false; //If it cannot find a matching id, return false
    }

    public static PlayerProfile getProfile(String id) {
        for(int i = 0; i < playerProfileList.size(); i++) {
            if(id.equalsIgnoreCase(playerProfileList.get(i).getId()))
                return playerProfileList.get(i);
        }
        return null; //If it cannot find a matching id, return null
    }
}
