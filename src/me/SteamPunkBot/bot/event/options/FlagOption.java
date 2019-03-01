package me.SteamPunkBot.bot.event.options;

import me.SteamPunkBot.bot.character.PlayerProfile;
import me.SteamPunkBot.bot.event.GameEvent;
import me.SteamPunkBot.bot.flags.PlayerFlag;

public class FlagOption extends GameEventOption {
    private GameEventOption option;
    private PlayerFlag flag;

    FlagOption(GameEventOption option, PlayerFlag flag) {
        this.option = option;
        this.flag = flag;
    }

    @Override
    public String getDescription() {
        return option.getDescription();
    }

    @Override
    public Boolean isAvailable(PlayerProfile profile) {
        return option.isAvailable(profile) && profile.getSelectedCharacter().hasFlag(flag);
    }

    @Override
    public GameEvent choose(PlayerProfile profile) {
        return option.choose(profile);
    }
}
