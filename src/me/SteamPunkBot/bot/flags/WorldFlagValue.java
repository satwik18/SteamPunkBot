package me.SteamPunkBot.bot.flags;

public class WorldFlagValue extends WorldFlag {
    private int value;

    public WorldFlagValue(String name, int value) {
        super(name);
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
