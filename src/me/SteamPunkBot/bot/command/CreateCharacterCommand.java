package me.SteamPunkBot.bot.command;

import me.SteamPunkBot.bot.character.PlayerCharacter;
import me.SteamPunkBot.bot.game.Game;
import me.SteamPunkBot.bot.game.GameProperties;
import me.SteamPunkBot.bot.server.GameServer;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;

public class CreateCharacterCommand extends Command {
    private static final String INPUT_ERROR[] = {"**ERROR** Command Usage is: `", "CreateCharacter [name]`"};

    @Override
    public String getName() {
        return "CreateCharacter";
    }

    @Override
    public void trigger(String[] args, GuildMessageReceivedEvent event) {
        if(args.length == 2) {
            GameServer server = Game.getServer(event.getGuild().getId());
            if(server.isExistingProfile(event.getAuthor().getId())) {
                if(server.getProfile(event.getAuthor().getId()).getCharacterNum() < GameProperties.PLAYERCHARACTER_LIMIT) {
                    server.getProfile(event.getAuthor().getId()).addCharacter(new PlayerCharacter(args[1], server.getProfile(event.getAuthor().getId())));
                    event.getChannel().sendMessage("Created new character *" + args[1] + "* for " + event.getAuthor()).queue();
                } else {
                    event.getChannel().sendMessage(GameProperties.PLAYERCHARACTER_LIMIT_ERROR).queue();
                }
            } else {
                Command makeProfile = new CreateProfileCommand();
                makeProfile.trigger(null, event);
                if(server.getProfile(event.getAuthor().getId()).getCharacterNum() < GameProperties.PLAYERCHARACTER_LIMIT) {
                    server.getProfile(event.getAuthor().getId()).addCharacter(new PlayerCharacter(args[1], server.getProfile(event.getAuthor().getId())));
                    event.getChannel().sendMessage("Created new character *" + args[1] + "* for " + event.getAuthor().getName()).queue();
                } else {
                    event.getChannel().sendMessage(GameProperties.PLAYERCHARACTER_LIMIT_ERROR).queue();
                }
            }
        } else {
            event.getChannel().sendMessage(INPUT_ERROR[0] + Game.getServer(event).getPrefix() + INPUT_ERROR[1]).queue();
        }
    }
}
