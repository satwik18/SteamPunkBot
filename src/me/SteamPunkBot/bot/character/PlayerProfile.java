package me.SteamPunkBot.bot.character;

import me.SteamPunkBot.bot.game.GameProperties;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class PlayerProfile implements Serializable {
    private String id;
    private String name;
    private List<PlayerCharacter> characterList;

    public PlayerProfile (String id, String name) {
        this.id = id;
        this.name = name;
        characterList = new ArrayList<>();
    }

    public List<PlayerCharacter> getCharacterList () {
        return characterList;
    }

    public void addCharacter (PlayerCharacter character) {
        if(getCharacterNum() < GameProperties.PLAYERCHARACTER_LIMIT) {
            characterList.add(character);
        } else {
            //Error
        }
    }

    public int getCharacterNum() {
        return characterList.size();
    }

    public String getId() {
        return id;
    }
}
