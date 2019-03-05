package me.SteamPunkBot.bot.game;

public class GameProperties {
    //PLAYER CHARACTERS
    public static final int PLAYERCHARACTER_LIMIT = 5;
    public static final String PLAYERCHARACTER_LIMIT_ERROR = "**ERROR** Player Character limit reached!";

    //PLAYER PROFILE
    public static final String NO_PLAYER_PROFILE_ERROR = "**ERROR** You do not currently have a profile. Use `!CreateProfile` to create one.";
    public static final String PLAYER_PROFILE_EXISTS_ERROR = "**ERROR** You already have a profile created!";

    //PLAYER CHARACTERS
    public static final String NO_PLAYER_CHARACTERS_ERROR = "**ERROR** You do not currently have any characters. Use `!CreateCharacter [Name]` to create one.";

    //COMMANDS
    public static final int PREFIX_SIZE_LIMIT = 10;
    public static final String PREFIX_SIZE_LIMIT_ERROR[] = {"**ERROR** The Prefix may only be up to ", " characters long!"};
    public static final String[] ID_HELP_MSG = {"Hi ", "! Use `", "help` to learn about my commands."};
    public static final String INVALID_COMMAND_INPUT_ERROR = "**ERROR** The Command input is invalid!";
    public static final String INVALID_SELECTION_ERROR = "**ERROR** The Command input is invalid!";

    //PERMISSIONS
    public static final String NEED_PERMISSION_ERROR[] = {"**ERROR** You need the **", "** permission to use this command!"};
}
