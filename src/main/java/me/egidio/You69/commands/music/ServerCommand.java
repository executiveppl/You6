/*
Questa classe esiste solo per velocizzare il tutto,
piuttosto che copiare e incollare di nuovo le stesse cose.
*/

package me.egidio.You69.commands.music;

import me.egidio.You69.Main;
import org.javacord.api.entity.channel.ServerTextChannel;
import org.javacord.api.entity.server.Server;
import org.javacord.api.entity.user.User;
import org.javacord.api.event.message.MessageCreateEvent;
import org.javacord.api.listener.message.MessageCreateListener;

public abstract class ServerCommand implements MessageCreateListener {

    private String command;

    protected ServerCommand(String command){
        this.command = command;
    }

    @Override
    public void onMessageCreate(MessageCreateEvent event) {

        if(!event.isServerMessage())
            return;

        if(!event.getMessageAuthor().isRegularUser())
            return;

        if(!event.getMessageContent().startsWith(Main.Prefix+command))
            return;

        // Fa partire tutto.
        event.getServer().ifPresent(server -> event.getMessageAuthor().asUser().ifPresent(user ->
                event.getServerTextChannel().ifPresent(serverTextChannel -> runCommand(event, server, serverTextChannel, user, event.getMessageContent().split(" ")))));
    }

    protected abstract void runCommand(MessageCreateEvent event, Server server, ServerTextChannel channel, User user, String[] args);
}
