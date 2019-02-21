package talkbox.common.dataobject;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.media.AudioClip;
import talkbox.common.service.AudioPlayer;


import java.io.Serializable;

public class TalkButton implements TalkButtonInterface, Serializable {

    String buttonLabel;
    AudioClip audioClip; //connect audio clip here, Iam not sure if the is the right object type
    private Button button;

    private static final long serialVersionUID = 1L;

    public TalkButton(String buttonLabel){
        this.buttonLabel = buttonLabel;
        if(buttonLabel.isEmpty()){throw new IllegalArgumentException();}
        button = new Button(buttonLabel);
        button.setMinSize(20,20);
    }




    @Override
    public AudioClip talk() {
        AudioPlayer.talk(buttonLabel);
        return null;
    }

    public Button getButton(){
        return button;

    }

    public String getName(){
        return new String(buttonLabel);
    }

    private void handleButtonAction(ActionEvent event) {
        // Button was clicked, do something…
        System.out.println("test");
    }
}
