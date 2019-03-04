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

    @Override
    public boolean equals(PlayerFlag flag) {
        if(flag instanceof  PlayerFlagValue) {
            return value == ((PlayerFlagValue) flag).getValue() && super.getName().equals(flag.getName());
        } else {
            return false;
        }
    }
}
