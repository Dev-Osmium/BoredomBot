package net.devosmium.boredombot;

import sx.blah.discord.api.IDiscordClient;

/**
 * Created and maintained by Dev_Osmium on 20-Nov-17 at 9:06 PM
 */
public class Main {

    public static void main(String[] args) {

        if (args.length != 1) {
            System.out.println("Please put the Discord Bot Token as the first (and only) argument");
        }

        IDiscordClient cli = BotUtils.getBuiltDiscordClient(args[0]);

        cli.getDispatcher().registerListener(new MessageHandler());
        cli.login();

    }

}
