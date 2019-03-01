package me.SteamPunkBot.bot.event;

import me.SteamPunkBot.bot.character.PlayerProfile;
import me.SteamPunkBot.bot.event.options.GameEventOption;

import java.util.ArrayList;
import java.util.List;

public class GameEventManager {
    private GameEvent currentEvent;

    public GameEventManager() {
    }

    public void choose(int num, PlayerProfile profile) throws IndexOutOfBoundsException {
        List<GameEventOption> optionList = getAvailableOptions(profile);
        if(!(num < 1 || num > optionList.size())) {
            currentEvent = optionList.get(num - 1).choose(profile);
            //TODO add menu
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
}
