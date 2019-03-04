package me.SteamPunkBot.story.testing;

import me.SteamPunkBot.bot.event.GameEvent;

public class MainArea extends GameEvent {

    public MainArea() {
        super.addOption(new DisplayClassOption());
    }

    @Override
    public String getDescription() {
        return "This is the main area.";
    }
}
