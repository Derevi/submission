package talkbox.common.dataobject;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.media.AudioClip;
import talkbox.common.service.AudioPlayer;


import java.io.Serializable;

public class TalkButton implements TalkButtonInterface, Serializable {

    String name;
    AudioClip audioClip; //connect audio clip here, Iam not sure if the is the right object type
    private Button button;
    private TextField textField;
    private final int texFieldHeight = 30;
    private int textFieldWidth;
    private int buttonSize;
    private Image buttonImage;
    private VBox internalButtonVBox;
    private Label buttonLabel;


    private static final long serialVersionUID = 1L;

    public TalkButton(){
        this.name = " ";
        this.buttonSize = 150;

    }

    public TalkButton(String name, int buttonSize){
        this.name = name;
        buttonLabel = new Label(name);
        internalButtonVBox = new VBox();
        internalButtonVBox.getChildren().clear();
        internalButtonVBox.getChildren().add(1,textField);
        internalButtonVBox.getChildren().get(0);
        button = new Button(name, internalButtonVBox);
        this.buttonSize = buttonSize;
        if(name.isEmpty()){throw new IllegalArgumentException();}
        button.setMaxSize(buttonSize,buttonSize);
        button.setMinSize(buttonSize,buttonSize);
        button.setPrefSize(buttonSize,buttonSize);

    }

    public TalkButton(String name, int buttonSize, ImageView image){
        this(name, buttonSize);
        internalButtonVBox.getChildren().add(0, image);
    }

    //TODO set up with image view in order to load image on to button
    //TODO set pre condition such that image is smaller than button
    public void setButtonImage(Image image){
        this.buttonImage = image;

    }

    //TODO make return deep copy of image
    public Image getButtonImage(){
        return this.buttonImage;
    }

    @Override
    public AudioClip talk() {
        AudioPlayer.talk(name);
        return null;
    }

    public Button getButton(){
        this.button = new Button("",textField);
        button.setMaxSize(buttonSize,buttonSize);
        button.setMinSize(buttonSize,buttonSize);
        button.setPrefSize(buttonSize,buttonSize);
        return button;
    }
    //TODO implement private method to clone button.

    public int getButtonSize(){
        return buttonSize;
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
