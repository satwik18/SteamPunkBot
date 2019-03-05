package me.SteamPunkBot.bot.command;

import me.SteamPunkBot.bot.character.PlayerCharacter;
import me.SteamPunkBot.bot.character.PlayerProfile;
import me.SteamPunkBot.bot.game.Game;
import me.SteamPunkBot.bot.game.GameProperties;
import me.SteamPunkBot.bot.server.GameServer;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;

public class ListCharactersCommand extends Command {
    @Override
    public String getName() {
        return "ListCharacters";
    }

    @Override
    public void trigger(String[] args, GuildMessageReceivedEvent event) {
        GameServer server = Game.getServer(event.getGuild().getId());
        if(server.isExistingProfile(event.getAuthor().getId())) {
            PlayerProfile profile = server.getProfile(event.getAuthor().getId());
            if(profile.getCharacterNum() != 0) {
                for(int i = 0; i < profile.getCharacterNum(); i++) {
                    event.getChannel().sendMessage("*" + profile.getCharacterList().get(i).getCharacterName() + "*").queue();
                }
            } else {
                event.getChannel().sendMessage(GameProperties.NO_PLAYER_CHARACTERS_ERROR).queue();
            }
        } else {
            event.getChannel().sendMessage(GameProperties.NO_PLAYER_PROFILE_ERROR).queue();
        }
    }
}
