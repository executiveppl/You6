package me.egidio.You69.commands.music.audio;

import com.sedmelluq.discord.lavaplayer.player.AudioPlayer;
import com.sedmelluq.discord.lavaplayer.player.event.AudioEventAdapter;
import com.sedmelluq.discord.lavaplayer.track.AudioTrack;
import com.sedmelluq.discord.lavaplayer.track.AudioTrackEndReason;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class TrackScheduler extends AudioEventAdapter {
    private final AudioPlayer player;
    private final BlockingQueue<AudioTrack> queue;

    /**
     * @param player Il lettore audio usato da TrackScheduler
     */
    public TrackScheduler(AudioPlayer player) {
        this.player = player;
        this.queue = new LinkedBlockingQueue<>();
    }

    /**
     * Aggiungi la traccia successiva alla coda o riproduci subito se non c'è nulla in coda.
     *
     * @param track La traccia da riprodurre o aggiungere alla coda.
     */
    public void queue(AudioTrack track) {
        // La chiamata a startTrack con noInterrupt impostato su true avvierà la traccia solo se non è attualmente in riproduzione nulla.
        // Se qualcosa sta suonando, restituisce false e non fa nulla.
        // In questo caso il player sta già riproducendo qualcosa quindi la traccia va in coda.
        if (!player.startTrack(track, true)) {
            queue.offer(track);
        }
    }

    /**
     * Avvia la traccia successiva, interrompendo quella corrente se è in riproduzione.
     */
    public void nextTrack() {
        // Avvia la traccia successiva, indipendentemente dal fatto che qualcosa sia già in riproduzione o meno. Nel caso in cui la coda fosse vuota, stiamo
        // dando null a startTrack, che è un argomento valido e fermerà semplicemente il player.
        player.startTrack(queue.poll(), false);
    }

    @Override
    public void onTrackEnd(AudioPlayer player, AudioTrack track, AudioTrackEndReason endReason) {
        // Avvia la traccia successiva solo se il motivo della fine è adatto (FINISHED o LOAD_FAILED)
        if (endReason.mayStartNext) {
            nextTrack();
        }
    }
}