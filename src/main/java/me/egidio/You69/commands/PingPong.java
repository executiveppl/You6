package me.egidio.You69.commands;

import me.egidio.You69.Main;
import org.javacord.api.event.message.MessageCreateEvent;
import org.javacord.api.listener.message.MessageCreateListener;

import java.util.concurrent.TimeUnit;

public class PingPong implements MessageCreateListener {

    @Override
    public void onMessageCreate(MessageCreateEvent message) {

        if (message.getMessageContent().equalsIgnoreCase(Main.Prefix + "ping")) {

            message.getChannel().sendMessage(":ping_pong: Pong!");
        }
    }
}