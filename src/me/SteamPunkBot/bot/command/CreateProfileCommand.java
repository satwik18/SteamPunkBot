package me.SteamPunkBot.bot.command;

import me.SteamPunkBot.bot.character.PlayerProfile;
import me.SteamPunkBot.bot.game.Game;
import me.SteamPunkBot.bot.game.GameProperties;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;

public class CreateProfileCommand extends Command {
    @Override
    public String getName() {
        return "!CreateProfile";
    }

    @Override
    public void trigger(String[] args, GuildMessageReceivedEvent event) {
        if(!Game.isExistingProfile(event.getAuthor().getId())) {
            Game.addPlayer(new PlayerProfile(event.getAuthor().getId(), event.getAuthor().getName()));
            event.getChannel().sendMessage("Created Profile for " + event.getAuthor().getName() + "!").queue();
        } else {
            event.getChannel().sendMessage(GameProperties.PLAYER_PROFILE_EXISTS_ERROR).queue();
        }
    }
}
