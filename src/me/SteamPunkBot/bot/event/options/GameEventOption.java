package me.SteamPunkBot.bot.event.options;

import me.SteamPunkBot.bot.character.PlayerCharacter;
import me.SteamPunkBot.bot.character.PlayerProfile;
import me.SteamPunkBot.bot.event.GameEvent;

public abstract class GameEventOption {

    public abstract String getDescription();

    public abstract Boolean isAvailable(PlayerProfile profile);

    public abstract GameEvent choose(PlayerProfile profile);
}
