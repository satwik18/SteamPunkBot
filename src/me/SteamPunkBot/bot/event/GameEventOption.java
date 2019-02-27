package me.SteamPunkBot.bot.event;

public abstract class GameEventOption {
    private String description;

    public GameEventOption(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
