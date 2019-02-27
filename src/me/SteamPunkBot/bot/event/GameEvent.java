package me.SteamPunkBot.bot.event;

import java.util.List;

public abstract class GameEvent {
    public abstract String getDescription();
    public List<GameEventOption> optionList;

}
