package me.SteamPunkBot.bot.event.options;

import me.SteamPunkBot.bot.character.PlayerProfile;
import me.SteamPunkBot.bot.event.GameEvent;
import me.SteamPunkBot.bot.flags.PlayerFlag;

public class RemoveFlagOption extends GameEventOption {
    private GameEventOption option;
    private PlayerFlag flag;

    public RemoveFlagOption (GameEventOption option, PlayerFlag flag) {
        this.option = option;
        this.flag = flag;
    }

    @Override
    public String getDescription() {
        return option.getDescription();
    }

    @Override
    public Boolean isAvailable(PlayerProfile profile) {
        return option.isAvailable(profile);
    }

    @Override
    public GameEvent choose(PlayerProfile profile) {
        profile.getSelectedCharacter().removeFlag(flag);
        return option.choose(profile);
    }
}
