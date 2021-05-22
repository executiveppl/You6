package me.egidio.You69.commands;

import me.egidio.You69.Main;
import org.javacord.api.entity.message.embed.EmbedBuilder;
import org.javacord.api.event.message.MessageCreateEvent;
import org.javacord.api.listener.message.MessageCreateListener;

import java.awt.*;

public class OwnerCommand implements MessageCreateListener {

    @Override
    public void onMessageCreate(MessageCreateEvent event) {

        if (event.getMessageContent().equalsIgnoreCase(Main.Prefix + "owner")) {
            EmbedBuilder embed = new EmbedBuilder()
                    .setAuthor("Egidio Capasso", "https://www.instagram.com/egi.dioo/", "https://cdn.discordapp.com/avatars/585805640278999040/7f9d0292992e7b2593a51a2155aac4b7.png?size=1024")
                    .setDescription("This is my dad U+1F600")
                    .addInlineField("GitHub", "https://github.com/executiveppl/You6")
                    .setColor(Color.GREEN);

            event.getChannel().sendMessage(embed);
        }
    }
}
