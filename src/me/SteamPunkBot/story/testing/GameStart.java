package me.SteamPunkBot.story.testing;

import me.SteamPunkBot.bot.event.GameEvent;
import me.SteamPunkBot.bot.event.options.AddPlayerFlagOption;
import me.SteamPunkBot.bot.event.options.BasicOption;
import me.SteamPunkBot.bot.flags.PlayerFlag;

public class GameStart extends GameEvent {

    public GameStart() {
        super.addOption(new AddPlayerFlagOption(new BasicOption("Hunter", new MainArea()), new PlayerFlag("Hunter")));
        super.addOption(new AddPlayerFlagOption(new BasicOption("Rogue", new MainArea()), new PlayerFlag("Rogue")));
    }

    @Override
    public String getDescription() {
        return "Choose your new character's class:";
    }
}
