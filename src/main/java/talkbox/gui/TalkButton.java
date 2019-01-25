package talkbox.gui;

import javafx.scene.media.AudioClip;

public class TalkButton implements TalkButtonInterface{
    String Label;
    AudioClip audioClip; //connect audio clip here, Iam not sure if the is the right object type

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
