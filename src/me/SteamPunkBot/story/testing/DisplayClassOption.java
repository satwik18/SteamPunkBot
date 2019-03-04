package me.SteamPunkBot.story.testing;

import me.SteamPunkBot.bot.character.PlayerProfile;
import me.SteamPunkBot.bot.event.GameEvent;
import me.SteamPunkBot.bot.event.options.GameEventOption;

public class DisplayClassOption extends GameEventOption {

    public String getDescription() {
        return "Class Info";
    }

    @Override
    public Boolean isAvailable(PlayerProfile profile) {
        return true;
    }

    @Override
    public GameEvent choose(PlayerProfile profile) {
        if(profile.getSelectedCharacter().hasFlag("Hunter")) {
            profile.getChannel().sendMessage("You are a Hunter").queue();
        } else if(profile.getSelectedCharacter().hasFlag("Rogue")) {
            profile.getChannel().sendMessage("You are a Rogue").queue();
        }
        return new MainArea();
    }
}
