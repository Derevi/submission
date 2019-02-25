package talkbox.gui;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.io.File;

 public final class AudioPlayer {


     public static final void talk(String audioFile){
        MediaPlayer mediaPlayer = new MediaPlayer(new Media(new File(audioFile+".wav").toURI().toString()));
        mediaPlayer.setAutoPlay(true);
    }

}
