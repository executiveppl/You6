package me.egidio.You69;

import me.egidio.You69.commands.PingPong;
import org.javacord.api.DiscordApi;
import org.javacord.api.DiscordApiBuilder;
import org.javacord.api.entity.activity.ActivityType;

public class Main {

    public static final String Prefix = "?";

    public static void main(String[] args) {
        DiscordApi Bot = new DiscordApiBuilder().setToken(System.getenv().get("TOKEN")).login().join();
        Bot.updateActivity(ActivityType.PLAYING, "??help");

        Bot.addListener(new PingPong());

        System.out.println("Bot is online!");
        System.out.println("You can invite the bot by using the following url: " + Bot.createBotInvite());
    }

}