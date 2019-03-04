package me.SteamPunkBot.bot.server;

import me.SteamPunkBot.bot.character.PlayerProfile;
import me.SteamPunkBot.bot.command.Command;
import me.SteamPunkBot.bot.command.CreateProfileCommand;

import java.util.ArrayList;
import java.util.List;

public class GameServer {
    private List<PlayerProfile> profileList;
    private String id;

    public GameServer(String id) {
        profileList = new ArrayList<>();
        this.id = id;
    }

    public void addPlayer(PlayerProfile playerProfile) {
        profileList.add(playerProfile);
    }

    public Boolean isExistingProfile(String id) {
        for(int i = 0; i < profileList.size(); i++) {
            if(id.equalsIgnoreCase(profileList.get(i).getId()))
                return true;
        }
        return false; //If it cannot find a matching id, return false
    }

    public PlayerProfile getProfile(String id) {
        for(int i = 0; i < profileList.size(); i++) {
            if(id.equalsIgnoreCase(profileList.get(i).getId()))
                return profileList.get(i);
        }
        return null; //If it cannot find a matching id, return null
    }

    public List<PlayerProfile> getProfileList() {
        return profileList;
    }

    public boolean equals(String id) {
        return id.equals(this.id);
    }

    public boolean equals(GameServer server) {
        return server.getId().equals(this.id);
    }

    public String getId() {
        return id;
    }
}
