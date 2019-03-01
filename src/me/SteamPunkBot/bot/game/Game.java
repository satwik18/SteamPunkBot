package me.SteamPunkBot.bot.game;

import me.SteamPunkBot.bot.server.GameServer;

import java.util.ArrayList;
import java.util.List;

public class Game {

    private static List<GameServer> serverList;

    public static void init() {
        serverList = new ArrayList<>();
    }

    public static GameServer getServer(String id) {
        for(int i = 0; i < serverList.size(); i++) {
            if(serverList.get(i).equals(id))
                return serverList.get(i);
        }
        GameServer server = new GameServer(id);
        serverList.add(server);
        return server; // Returns new server of id if it doesn't exist
    }
}
