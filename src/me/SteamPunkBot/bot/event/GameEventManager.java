package me.SteamPunkBot.bot.event;

import me.SteamPunkBot.bot.character.PlayerProfile;
import me.SteamPunkBot.bot.event.options.GameEventOption;
import me.SteamPunkBot.story.testing.GameStart;

import java.util.ArrayList;
import java.util.List;

public class GameEventManager {
    private GameEvent currentEvent;

    public GameEventManager() {
        currentEvent = new GameStart();
    }

    public void choose(int num, PlayerProfile profile) throws IndexOutOfBoundsException {
        List<GameEventOption> optionList = getAvailableOptions(profile);
        if(!(num < 1 || num > optionList.size())) {
            //Displays next event
            currentEvent = optionList.get(num - 1).choose(profile);
            profile.getChannel().sendMessage(currentEvent.getDescription()).queue();
            new GameEventMenu(profile.getChannel(), getAvailableOptions(profile));
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    public List<GameEventOption> getAvailableOptions(PlayerProfile profile) {
        List<GameEventOption> optionList = new ArrayList<>();
        for(GameEventOption o: currentEvent.getOptionList()) {
            if (o.isAvailable(profile)) optionList.add(o);
        }
        return optionList;
    }

    public void displayMenu(PlayerProfile profile) {
        profile.getChannel().sendMessage(currentEvent.getDescription()).queue();
        new GameEventMenu(profile.getChannel(), getAvailableOptions(profile));
    }
}
