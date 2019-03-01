package me.SteamPunkBot.bot.event;

import me.SteamPunkBot.bot.character.PlayerProfile;
import me.SteamPunkBot.bot.event.options.GameEventOption;

import java.util.ArrayList;
import java.util.List;

public class GameEventManager {
    private GameEvent currentEvent;
    private PlayerProfile profile;

    public GameEventManager(PlayerProfile profile) {
        this.profile = profile;
    }

    public void choose(int num) throws IndexOutOfBoundsException{
        List<GameEventOption> optionList = getAvailableOptions();
        if(!(num < 1 || num > getAvailableOptions().size())) {
            currentEvent = optionList.get(num).choose(profile);
            //TODO add menu
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    public List<GameEventOption> getAvailableOptions() {
        List<GameEventOption> optionList = new ArrayList<>();
        for(GameEventOption o: currentEvent.getOptionList()) {
            if (o.isAvailable(profile)) optionList.add(o);
        }
        return optionList;
    }
}
