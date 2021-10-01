package me.egidio.You69.commands;

import me.egidio.You69.Main;
import org.javacord.api.entity.message.embed.EmbedBuilder;
import org.javacord.api.event.message.MessageCreateEvent;
import org.javacord.api.listener.message.MessageCreateListener;

import java.awt.*;

public class Help implements MessageCreateListener {

    @Override
    public void onMessageCreate(MessageCreateEvent event) {

        if (event.getMessageContent().equalsIgnoreCase(Main.Prefix + "help")) {
            EmbedBuilder embed = new EmbedBuilder()
                    .setAuthor("Comandi")
                    .setDescription("Tutti i comandi di questo bot")
                    .addInlineField("?ping", "Rispondo :ping_pong: pong!")
                    .addInlineField("?Owner", "Chi mi ha creato")
                    .setColor(Color.RED);

            event.getChannel().sendMessage(embed);
        }
    }
}