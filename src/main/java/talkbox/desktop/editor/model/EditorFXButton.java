package talkbox.desktop.editor.model;

import javafx.event.Event;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import talkbox.common.dataobject.TalkButton;


public class EditorFXButton {
    TalkButton talkButton;
    Button fxButton;
    VBox vBox;
    TextField textField;
    HBox hBox;

    EditorFXButton(TalkButton talkButton){
        this.talkButton=talkButton;
        fxButton = new Button(talkButton.getName(),vBox);
        fxButton.setUserData(talkButton);
    }


//Constructor for tests ONLY
    EditorFXButton(String name,HBox hBox){
        this.hBox = hBox;
        hBox.setAlignment(Pos.CENTER);
        fxButton = new Button(name,vBox);
        fxButton.setMaxSize(160,160);
        fxButton.setMinSize(160,160);
        textField = new TextField(name);
        hBox.getChildren().add(this.fxButton);
    }

    public void initPageButton(){
        vBox.getChildren().add(this.textField);
    }

    public int getIndex(){
        return hBox.getChildren().indexOf(this.fxButton);
    }

    public void initTalkButton(){
        vBox.getChildren().add(this.textField);
    }

    public void dragAndDrop(Event event){

    }

    public Button getFxButton(){
        return this.fxButton;
    }


}
