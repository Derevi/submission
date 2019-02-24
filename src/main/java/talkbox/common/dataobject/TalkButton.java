package talkbox.common.dataobject;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.media.AudioClip;
import talkbox.common.service.AudioPlayer;


import java.io.Serializable;

public class TalkButton implements TalkButtonInterface, Serializable {

    String name;
    AudioClip audioClip; //connect audio clip here, Iam not sure if the is the right object type
    private Button button;
    private TextField textField;
    private final int texFieldHeight = 30;
    private final int textFieldWidth = 130;
    private final int buttonSize = 150;


    private static final long serialVersionUID = 1L;

    public TalkButton(String name){
        this.name = name;
        button = new Button(name);
        textField = new TextField(name);

        if(name.isEmpty()){throw new IllegalArgumentException();}

        textField.setMaxSize(textFieldWidth,texFieldHeight);
        textField.setMinSize(textFieldWidth,texFieldHeight);
        textField.setPrefSize(textFieldWidth,texFieldHeight);
        button.setMaxSize(buttonSize,buttonSize);
        button.setMinSize(buttonSize,buttonSize);
        button.setPrefSize(buttonSize,buttonSize);

    }




    @Override
    public AudioClip talk() {
        AudioPlayer.talk(name);
        return null;
    }

    public Button getButton(){

        return this.button;

    }

    public Button getTextFieldButton(){

        this.button = new Button("",textField);
        button.setMaxSize(buttonSize,buttonSize);
        button.setMinSize(buttonSize,buttonSize);
        button.setPrefSize(buttonSize,buttonSize);
        return button;
    }

    public TextField getTextField(){
        return  this.textField;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return new String(name);
    }

    private void handleButtonAction(ActionEvent event) {
        // Button was clicked, do something…
        System.out.println("test");
    }
}
