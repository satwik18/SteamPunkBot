package me.SteamPunkBot.bot.command;

import me.SteamPunkBot.bot.character.PlayerCharacter;
import me.SteamPunkBot.bot.game.Game;
import me.SteamPunkBot.bot.game.GameProperties;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;

public class CreateCharacterCommand extends Command {
    private static final String INPUT_ERROR = "**ERROR** Command Usage is: !CreateCharacter [name]";

    @Override
    public String getName() {
        return "!CreateCharacter";
    }

    @Override
    public void trigger(String[] args, GuildMessageReceivedEvent event) {
        if(args.length == 2) {
            if(Game.isExistingProfile(event.getAuthor().getId())) {
                if(Game.getProfile(event.getAuthor().getId()).getCharacterNum() < GameProperties.PLAYERCHARACTER_LIMIT) {
                    Game.getProfile(event.getAuthor().getId()).addCharacter(new PlayerCharacter(args[1], Game.getProfile(event.getAuthor().getId())));
                } else {
                    event.getChannel().sendMessage(GameProperties.PLAYERCHARACTER_LIMIT_ERROR).queue();
                }
            } else {
                event.getChannel().sendMessage(GameProperties.NO_PLAYER_PROFILE_ERROR).queue();
            }
        } else {
            event.getChannel().sendMessage(INPUT_ERROR).queue();
        }
    }
}
