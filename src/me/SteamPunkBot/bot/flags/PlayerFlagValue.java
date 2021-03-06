package me.SteamPunkBot.bot.flags;

public class PlayerFlagValue extends PlayerFlag {
    private int value;

    public PlayerFlagValue(String name, int value) {
        super(name);
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public boolean equals(PlayerFlagValue flag) {
        return value == flag.getValue() && super.equals(flag);
    }
}
