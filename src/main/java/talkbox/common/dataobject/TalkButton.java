package talkbox.common.dataobject;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.media.AudioClip;
import talkbox.common.service.AudioPlayer;


import java.io.Serializable;
import java.util.ArrayList;

public class TalkButton implements Serializable {

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
    private int row; //start at 1
    private int column;
    private boolean initialized;


    private static final long serialVersionUID = 1L;

    public TalkButton(){
        this.name = " ";
        this.buttonSize = 150;
        initialized = false;
    }

    public TalkButton(String name, int buttonSize){
        this.name = name;
        this.buttonSize = buttonSize;

    }

    public void initializeFxButton(){
        if(!isInitialized(initialized)){ this.initialized = true;}
        else{
            //TODO THROW ERROR
            System.out.println("WAS ALREADY INITIALIZEd");
        }

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
        HBox hBox = new HBox();
    }

    public Button getFxButton(){
        if(!isInitialized(initialized)){
            System.out.println("please initialize with initialize FxButton first");
            //TODO throw error
        }
        return button;

    }
    private boolean isInitialized(boolean initialized){
        return initialized;
    }
}
