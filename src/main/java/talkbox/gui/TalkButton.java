package talkbox.gui;

import javafx.scene.media.AudioClip;

import java.io.Serializable;

public class TalkButton implements TalkButtonInterface, Serializable {
    String Label;
    AudioClip audioClip; //connect audio clip here, Iam not sure if the is the right object type
    private static final long serialVersionUID = 1L;


    TalkButton(String s){
        //create label via sprint
        //instantiate label and audioclip


    }

    @Override
    public AudioClip talk() {
        //return audio clip here
        return null;
    }
}
