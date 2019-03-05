package me.SteamPunkBot.bot.command.OptionCommands;

import me.SteamPunkBot.bot.character.PlayerProfile;
import me.SteamPunkBot.bot.command.Command;
import me.SteamPunkBot.bot.game.Game;
import me.SteamPunkBot.bot.game.GameProperties;
import me.SteamPunkBot.bot.server.GameServer;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;

public class SelectOptionCommand extends Command {
    public static String FORMAT_ERROR = "Correct Format is `#` where # is the number of the option you would like to select.";

    @Override
    public Boolean equals(String name) {
        int num;
        try {
            num = Integer.parseInt(name);
        }
        catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    @Override
    public String getName() {
        return "select";
    }

    @Override
    public void trigger(String[] args, GuildMessageReceivedEvent event) {
        if(args.length == 1) {
            try {
                int num = Integer.parseInt(args[0]);
                GameServer server = Game.getServer(event.getGuild().getId());
                PlayerProfile profile = server.getProfile(event.getAuthor().getId());
                try {
                    profile.getSelectedCharacter().getEventManager().choose(num, profile);
                }
                catch (IndexOutOfBoundsException e) {
                    profile.getChannel().sendMessage(GameProperties.INVALID_SELECTION_ERROR).queue();
                }
            }
            catch (NumberFormatException e) {
                event.getChannel().sendMessage(GameProperties.INVALID_COMMAND_INPUT_ERROR).queue();
                event.getChannel().sendMessage(FORMAT_ERROR).queue();
            }
        }
    }
}
