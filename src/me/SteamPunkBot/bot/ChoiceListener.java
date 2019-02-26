package me.SteamPunkBot.bot;

import me.SteamPunkBot.bot.event.GameEvent;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

public class ChoiceListener extends ListenerAdapter {
    private GameEvent eventList[];

    public ChoiceListener() {
        eventList = new GameEvent[4];
    }

    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
        String[] args = event.getMessage().getContentRaw().split(" ");
        if(args[0].equals("!1") && eventList[0] != null) {
            eventList[0].trigger();
        } else if(args[1].equals("!1") && eventList[1] != null) {
            eventList[1].trigger();
        } else if(args[2].equals("!1") && eventList[2] != null) {
            eventList[2].trigger();
        } else if(args[3].equals("!1") && eventList[3] != null) {
            eventList[3].trigger();
        }
    }
}
