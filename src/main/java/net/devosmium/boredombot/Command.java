package net.devosmium.boredombot;

import sx.blah.discord.handle.impl.events.guild.channel.message.MessageReceivedEvent;

import java.util.ArrayList;

/**
 * Created and maintained by Dev_Osmium on 20-Nov-17 at 9:22 PM
 */
public interface Command {

    void runCommand(MessageReceivedEvent event, ArrayList<String> args);

}
