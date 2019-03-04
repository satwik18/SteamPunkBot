package me.SteamPunkBot.bot.character;

import me.SteamPunkBot.bot.game.GameProperties;
import net.dv8tion.jda.core.entities.TextChannel;

import javax.xml.soap.Text;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class PlayerProfile implements Serializable {
    private String id;
    private String name;
    private List<PlayerCharacter> characterList;
    private PlayerCharacter selectedCharacter;
    private TextChannel channel;

    public PlayerProfile (String id, String name, TextChannel channel) {
        this.id = id;
        this.name = name;
        characterList = new ArrayList<>();
        this.channel = channel;
    }

    public List<PlayerCharacter> getCharacterList () {
        return characterList;
    }

    public void addCharacter (PlayerCharacter character) {
        if(getCharacterNum() < GameProperties.PLAYERCHARACTER_LIMIT) {
            characterList.add(character);
            if(selectedCharacter == null) {
                selectedCharacter = character;
            }
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

    public PlayerCharacter getSelectedCharacter() {
        return selectedCharacter;
    }

    public TextChannel getChannel() {
        return channel;
    }
}
