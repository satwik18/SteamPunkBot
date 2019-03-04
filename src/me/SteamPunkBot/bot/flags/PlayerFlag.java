package me.SteamPunkBot.bot.flags;

public class PlayerFlag {
    private String name;

    public PlayerFlag(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public boolean equals(PlayerFlag flag) {
        return getName().equals(flag.getName());
    }

    public boolean equals(String flagName) {
        return getName().equals(flagName);
    }
}
