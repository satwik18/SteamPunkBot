package me.SteamPunkBot.bot.flags;

public class Flag {
    private String name;

    public Flag(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public boolean equals(Flag flag) {
        return getName().equals(flag.getName());
    }

    public boolean equals(String flagName) {
        return getName().equals(flagName);
    }
}
