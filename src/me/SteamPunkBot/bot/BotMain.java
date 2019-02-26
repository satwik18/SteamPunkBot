package me.SteamPunkBot.bot;

import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;

import javax.security.auth.login.LoginException;
import java.util.Scanner;

public class BotMain {

    public static JDA jda;

    public static void main(String[] args) throws LoginException {
        System.out.println("Enter the token:");
        Scanner reader = new Scanner(System.in);
        String token = reader.nextLine();
        jda = new JDABuilder(AccountType.BOT).setToken(token).build();
    }
}
