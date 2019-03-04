package me.SteamPunkBot.bot.game;

import me.SteamPunkBot.bot.command.*;
import me.SteamPunkBot.bot.command.OptionCommands.ResumeCommand;
import me.SteamPunkBot.bot.command.OptionCommands.SelectOptionCommand;
import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;

import javax.security.auth.login.LoginException;
import java.util.Scanner;

public class BotMain {

    public static JDA jda;

    public static void main(String[] args) throws LoginException {
        Game.init();

        System.out.println("Enter the token:");
        Scanner reader = new Scanner(System.in);
        String token = reader.nextLine();
        jda = new JDABuilder(AccountType.BOT).setToken(token).build();

        GameEventListener listener = new GameEventListener();
        listener.addCommand(new HelloCommand());
        listener.addCommand(new IdCommand());
        listener.addCommand(new CreateProfileCommand());
        listener.addCommand(new CreateCharacterCommand());
        listener.addCommand(new ListCharactersCommand());
        listener.addCommand(new SelectOptionCommand());
        listener.addCommand(new ResumeCommand());
        jda.addEventListener(listener);
    }
}
