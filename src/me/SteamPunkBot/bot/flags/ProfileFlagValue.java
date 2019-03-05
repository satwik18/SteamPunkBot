package me.SteamPunkBot.bot.flags;

public class ProfileFlagValue extends ProfileFlag {
    private int value;

    public ProfileFlagValue(String name, int value) {
        super(name);
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public boolean equals(ProfileFlagValue flag) {
        return value == flag.getValue() && super.equals(flag);
    }
}
