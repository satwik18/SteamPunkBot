package me.SteamPunkBot.bot.event.options;

import me.SteamPunkBot.bot.event.GameEvent;
import me.SteamPunkBot.bot.flags.PlayerFlag;
import net.dv8tion.jda.core.Permission;

import java.util.ArrayList;
import java.util.List;

public class OptionBuilder {
    public static Option start() {
        return new Option();
    }

    public static class Option {
        List<PlayerFlag> addFlag;
        List<PlayerFlag> removeFlag;
        List<PlayerFlag> requirementsList;
        String description;
        String chooseMessage;
        GameEvent nextEvent;

        public Option() {
            addFlag = new ArrayList<>();
            removeFlag = new ArrayList<>();
            requirementsList = new ArrayList<>();
        }

        public Option addFlag(PlayerFlag flag) {
            this.addFlag.add(flag);
            return this;
        }

        public Option addFlag(String flagName) {
            this.addFlag.add(new PlayerFlag(flagName));
            return this;
        }

        public Option removeFlag(PlayerFlag flag) {
            this.removeFlag.add(flag);
            return this;
        }

        public Option removeFlag(String flagName) {
            this.removeFlag.add(new PlayerFlag(flagName));
            return this;
        }

        public Option addRequirement(PlayerFlag flag) {
            this.requirementsList.add(flag);
            return this;
        }

        public Option addRequirement(String flagName) {
            this.requirementsList.add(new PlayerFlag(flagName));
            return this;
        }

        public Option setDescription(String description) {
            this.description = description;
            return this;
        }

        public Option addChooseMessage(String chooseMessage) {
            this.chooseMessage = chooseMessage;
            return this;
        }

        public Option setEvent(GameEvent nextEvent) {
            this.nextEvent = nextEvent;
            return this;
        }

        public GameEventOption build() {
            GameEventOption option = new BasicOption(description, nextEvent);
            for(PlayerFlag f: addFlag) {
                option = new AddPlayerFlagOption(option, f);
            }
            for(PlayerFlag f: removeFlag) {
                option = new RemoveFlagOption(option, f);
            }
            for(PlayerFlag f: requirementsList) {
                option = new RequireFlagOption(option, f);
            }
            if(chooseMessage != null) {
                option = new ChooseMessageOption(option, chooseMessage);
            }
            return option;
        }
    }
}
