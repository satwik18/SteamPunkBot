package me.SteamPunkBot.bot.utility;

import net.dv8tion.jda.core.Permission;
import net.dv8tion.jda.core.entities.Role;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;

public class EventUtility {
    public static Boolean userHasPermission(GuildMessageReceivedEvent event, Permission permission) {
        for(Role role: event.getMember().getRoles()) {
            if(role.hasPermission(Permission.MANAGE_SERVER))
                return true;
        }
        return false;
    }
}
