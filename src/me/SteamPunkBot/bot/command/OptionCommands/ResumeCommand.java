package me.SteamPunkBot.bot.command.OptionCommands;

import me.SteamPunkBot.bot.character.PlayerProfile;
import me.SteamPunkBot.bot.command.Command;
import me.SteamPunkBot.bot.game.Game;
import me.SteamPunkBot.bot.game.GameProperties;
import me.SteamPunkBot.bot.server.GameServer;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;

public class ResumeCommand extends Command {
    @Override
    public String getName() {
        return "Resume";
    }

    @Override
    public void trigger(String[] args, GuildMessageReceivedEvent event) {
        GameServer server = Game.getServer(event.getGuild().getId());
        PlayerProfile profile = server.getProfile(event.getAuthor().getId());
        if(profile != null) {
            if(profile.getSelectedCharacter() != null) {
                profile.getSelectedCharacter().getEventManager().displayMenu(profile);
            } else {
                event.getChannel().sendMessage(GameProperties.NO_PLAYER_CHARACTERS_ERROR).queue();
            }
        } else {
            event.getChannel().sendMessage(GameProperties.NO_PLAYER_PROFILE_ERROR).queue();
        }
    }
}
