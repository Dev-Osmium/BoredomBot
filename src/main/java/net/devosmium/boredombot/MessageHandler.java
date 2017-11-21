package net.devosmium.boredombot;

import sx.blah.discord.api.events.EventSubscriber;
import sx.blah.discord.handle.impl.events.guild.channel.message.MessageReceivedEvent;

import java.util.*;

/**
 * Created and maintained by Dev_Osmium on 20-Nov-17 at 9:22 PM
 */
public class MessageHandler {
    private static Map<String, Command> commandMap = new HashMap<>();
    static {
        commandMap.put("test", (event, args) -> {
            BotUtils.sendMessage(event.getChannel(), "Test!", "Test!", event, true);
        });
    }

    @EventSubscriber
    public void onMessageReceived(MessageReceivedEvent event) {
        String[] argArray = event.getMessage().getContent().split(" ");

        // First ensure at least the command and prefix is present, the arg length can be handled by your command func
        if (argArray.length == 0)
            return;

        // Check if the first arg (the command) starts with the prefix defined in the utils class
        if (!argArray[0].startsWith(BotUtils.PREFIX))
            return;

        // Extract the "command" part of the first arg out by just ditching the first character
        String commandStr = argArray[0].substring(1);

        // Load the rest of the args in the array into a List for safer access
        ArrayList<String> argsList = new ArrayList<>(Arrays.asList(argArray));
        argsList.remove(0); // Remove the command

        // Instead of delegating the work to a switch, automatically do it via calling the mapping if it exists
        boolean testMode = true;
        if (testMode) {
            if (event.getAuthor().getStringID().equals("118455061222260736")) {
                if (commandMap.containsKey(commandStr))
                    commandMap.get(commandStr).runCommand(event, argsList);
            } else {
                BotUtils.sendMessage(event.getChannel(), "Testing mode is engaged. Please" +
                        " hold.", "Sorry!", event, false);
            }
        } else {
            if (commandMap.containsKey(commandStr))
                commandMap.get(commandStr).runCommand(event, argsList);
        }
    }

}
