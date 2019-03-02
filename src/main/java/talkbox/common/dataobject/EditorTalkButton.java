package talkbox.common.dataobject;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.media.AudioClip;

import java.io.Serializable;
import java.lang.reflect.Field;

public class EditorTalkButton extends TalkButton implements TalkButtonInterface, Serializable {

    String name;
    AudioClip audioClip; //connect audio clip here, Iam not sure if the is the right object type
    private Button button;
    private TextField textField;
    private final int texFieldHeight = 30;
    private int textFieldWidth;
    private int buttonSize;
    private Image buttonImage;
    private VBox internalButtonVBox;

    private static final long serialVersionUID = 1L;

    public EditorTalkButton(String name, int buttonSize ){
        super(name, buttonSize);
        internalButtonVBox.getChildren().remove(1);
        this.textField = new TextField(name);
        this.textField.setMaxSize(this.textFieldWidth,this.texFieldHeight);
        this.textField.setMinSize(this.textFieldWidth,this.texFieldHeight);
        this.textFieldWidth = this.buttonSize-20;
        internalButtonVBox.getChildren().add(1, textField);

    }

    public EditorTalkButton(String name, int buttonSize, ImageView image){
        this(name,buttonSize);
        internalButtonVBox.getChildren().add(0, image);
    }


    @Override
    public Button getButton(){
        return this.button;
    }



    public TextField getTextField(){
        return  this.textField;
    }
}
