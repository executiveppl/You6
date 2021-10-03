package me.egidio.You69.commands.music.audio;

import com.sedmelluq.discord.lavaplayer.player.AudioPlayer;
import com.sedmelluq.discord.lavaplayer.player.AudioPlayerManager;

public class ServerMusicManager {

    /**
     * Lettore audio per la guild.
     */
    public final AudioPlayer player;
    /**
     * Track scheduler per il player.
     */
    public final TrackScheduler scheduler;

    /**
     * Crea un player e un track scheduler.
     * @param manager Audio player manager da utilizzare per creare il player.
     */
    public ServerMusicManager(AudioPlayerManager manager) {
        player = manager.createPlayer();
        scheduler = new TrackScheduler(player);
        player.addListener(scheduler);
    }
}