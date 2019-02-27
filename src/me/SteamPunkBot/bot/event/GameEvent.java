package me.SteamPunkBot.bot.event;

import me.SteamPunkBot.bot.event.options.GameEventOption;

import java.util.ArrayList;
import java.util.List;

public abstract class GameEvent {
    private List<GameEventOption> optionList;

    public GameEvent() {
        optionList = new ArrayList<>();
    }

    public List<GameEventOption> getOptionList() {
        return optionList;
    }

    public abstract String getDescription();

    protected void addOption(GameEventOption option) {
        optionList.add(option);
    }
}
