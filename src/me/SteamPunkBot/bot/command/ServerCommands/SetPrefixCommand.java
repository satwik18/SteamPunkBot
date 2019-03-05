package me.SteamPunkBot.bot.command.ServerCommands;

import me.SteamPunkBot.bot.command.Command;
import me.SteamPunkBot.bot.game.Game;
import me.SteamPunkBot.bot.game.GameProperties;
import me.SteamPunkBot.bot.server.GameServer;
import me.SteamPunkBot.bot.utility.EventUtility;
import net.dv8tion.jda.core.Permission;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;

public class SetPrefixCommand extends Command {
    private static final String INPUT_ERROR[] = {"**ERROR** Command Usage is: `", "SetPrefix [prefix]`"};
    private static final String SUCCESS[] = {"Set Command Prefix to `", "`"};

    @Override
    public String getName() {
        return "SetPrefix";
    }

    @Override
    public void trigger(String[] args, GuildMessageReceivedEvent event) {
        if(EventUtility.userHasPermission(event, Permission.MANAGE_SERVER)) {
            if (args.length == 2) {
                if(!(args[1].length() > GameProperties.PREFIX_SIZE_LIMIT)) {
                    GameServer server = Game.getServer(event);
                    server.setPrefix(args[1]);
                    event.getChannel().sendMessage(SUCCESS[0] + args[1] + SUCCESS[1]).queue();
                } else {
                    event.getChannel().sendMessage(GameProperties.PREFIX_SIZE_LIMIT_ERROR[0] +
                            GameProperties.PREFIX_SIZE_LIMIT + GameProperties.PREFIX_SIZE_LIMIT_ERROR[1]).queue();
                }
            } else {
                event.getChannel().sendMessage(INPUT_ERROR[0] + Game.getServer(event).getPrefix() + INPUT_ERROR[1]).queue();
            }
        } else {
            event.getChannel().sendMessage(GameProperties.NEED_PERMISSION_ERROR[0] +
                    Permission.MANAGE_SERVER.getName() + GameProperties.NEED_PERMISSION_ERROR[1]).queue();
        }
    }
}
