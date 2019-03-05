package me.SteamPunkBot.bot.character;

import me.SteamPunkBot.bot.flags.PlayerFlag;
import me.SteamPunkBot.bot.flags.ProfileFlag;
import me.SteamPunkBot.bot.game.GameProperties;
import net.dv8tion.jda.core.entities.TextChannel;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class PlayerProfile implements Serializable {
    private String id;
    private String name;
    private List<PlayerCharacter> characterList;
    private List<ProfileFlag> flagList;
    private PlayerCharacter selectedCharacter;
    private TextChannel channel; //Most recent text channel for profile

    /**
     * Creates a Profile for a Discord User
     * @param id The String id of the Discord user
     * @param name The name of the Discord user
     * @param channel The textchannel
     */
    public PlayerProfile (String id, String name, TextChannel channel) {
        this.id = id;
        this.name = name;
        characterList = new ArrayList<>();
        flagList = new ArrayList<>();
        this.channel = channel;
    }

    /**
     * Returns true or false depending on whether the profile has a given flag
     * @param flag the given flag
     * @return Boolean value whether the profile has the given flag
     */
    public Boolean hasFlag(ProfileFlag flag) {
        for(int i = 0; i < flagList.size(); i++) {
            if (flagList.get(i).getName().equalsIgnoreCase(flag.getName()))
                return true;
        }
        return false;
    }

    /**
     * getter function for the List of characters
     * @return List of PlayerCharacters characterList
     */
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

    /**
     * Getter for the size of the character list
     * @return integer number of characters
     */
    public int getCharacterNum() {
        return characterList.size();
    }

    /**
     * Getter for id of player
     * @return String id
     */
    public String getId() {
        return id;
    }

    /**
     * Getter for selected character
     * @return PlayerCharacter selectedCharacter
     */
    public PlayerCharacter getSelectedCharacter() {
        return selectedCharacter;
    }

    /**
     * Getter for most recent TextChannel
     * @return TextChannel
     */
    public TextChannel getChannel() {
        return channel;
    }

    /**
     * Setter for most recent TextChannel
     * @param channel TextChannel
     */
    public void setChannel(TextChannel channel) {
        this.channel = channel;
    }
}
