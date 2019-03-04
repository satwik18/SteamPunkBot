package me.SteamPunkBot.bot.command;

import me.SteamPunkBot.bot.command.Command;
import me.SteamPunkBot.bot.command.CreateCharacterCommand;
import me.SteamPunkBot.bot.command.CreateProfileCommand;

import java.util.ArrayList;

public class PlayerCommandList extends ArrayList<Command> {
    public PlayerCommandList() {
        super.add(new CreateCharacterCommand());
        super.add(new CreateProfileCommand());
    }
}