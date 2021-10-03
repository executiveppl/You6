package me.egidio.You69.commands.music.commands;

import me.egidio.You69.Main;
import org.javacord.api.entity.channel.ServerTextChannel;
import org.javacord.api.entity.server.Server;
import org.javacord.api.entity.user.User;
import org.javacord.api.event.message.MessageCreateEvent;

import me.egidio.You69.commands.music.ServerCommand;
import me.egidio.You69.commands.music.audio.AudioManager;

public class LeaveCommand extends ServerCommand {

    public LeaveCommand(){
        super(Main.Prefix + "leave");
    }

    @Override
    protected void runCommand(MessageCreateEvent event, Server server, ServerTextChannel channel, User user, String[] args) {
        // Controlla se il bot è connesso a qualsiasi canale vocale, altrimenti segnala all'utente che non lo è.
        server.getConnectedVoiceChannel(event.getApi().getYourself()).ifPresentOrElse(voiceChannel -> {
            // Lasciamo il canale vocale e togliamo la musica.
            server.getAudioConnection().ifPresentOrElse(connection -> {
                AudioManager.get(server.getId()).player.stopTrack();
                connection.close();
            }, () -> event.getChannel().sendMessage("Il bot non è in nessun canale vocale."));
        }, () -> event.getChannel().sendMessage("Il bot non è in nessun canale vocale"));
    }
}
