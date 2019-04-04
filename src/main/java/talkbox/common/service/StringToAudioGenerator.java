package talkbox.common.service;

import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;
import com.sun.speech.freetts.audio.AudioPlayer;
import com.sun.speech.freetts.audio.SingleFileAudioPlayer;
import javax.sound.sampled.AudioFileFormat;
import java.io.File;


public class StringToAudioGenerator {

    public static void generateAudio(String word){
        System.setProperty("freetts.voices", "com.sun.speech.freetts.en.us.cmu_us_kal.KevinVoiceDirectory");
        Voice voice;
        voice = VoiceManager.getInstance().getVoice("kevin16");
        voice.allocate();
        //TODO allow for user to set directory
        AudioPlayer audioPlayer = new SingleFileAudioPlayer("audio"+ File.separator+word, AudioFileFormat.Type.WAVE);
        voice.setAudioPlayer(audioPlayer);
        voice.speak(word);
        voice.deallocate();
        audioPlayer.close();
    }
}
