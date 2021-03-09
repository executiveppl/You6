package me.egidio.You69.commands;

import me.egidio.You69.Main;
import org.javacord.api.event.message.MessageCreateEvent;
import org.javacord.api.listener.message.MessageCreateListener;

public class OwnerCommand implements MessageCreateListener {

    @Override
    public void onMessageCreate(MessageCreateEvent message) {

        if (message.getMessageContent().equalsIgnoreCase(Main.Prefix + "owner")) {

            message.getChannel().sendMessage("My owner is: @prodbyxgi");

        }
    }
}