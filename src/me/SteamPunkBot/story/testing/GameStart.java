package me.SteamPunkBot.story.testing;

import me.SteamPunkBot.bot.event.GameEvent;
import me.SteamPunkBot.bot.event.options.OptionBuilder;

public class GameStart extends GameEvent {

    public GameStart() {
        addOption(OptionBuilder.start().setDescription("Hunter").setEvent(new MainArea()).addFlag("Hunter").build());
        addOption(OptionBuilder.start().setDescription("Rogue").setEvent(new MainArea()).addFlag("Rogue").build());
    }

    @Override
    public String getDescription() {
        return "Choose your new character's class:";
    }
}
