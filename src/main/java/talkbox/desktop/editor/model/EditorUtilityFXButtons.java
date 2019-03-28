package talkbox.desktop.editor.model;

import javafx.event.Event;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import talkbox.common.dataobject.TalkButton;

public class EditorUtilityFXButtons {
    TalkButton talkButton;
    Button fxButton;
    VBox vBox;
    TextField textField;
    HBox hBox;

    EditorUtilityFXButtons(TalkButton talkButton){
        this.talkButton=talkButton;
        fxButton = new Button(talkButton.getName(),vBox);
        fxButton.setUserData(talkButton);
    }


    //Constructor for tests ONLY
    EditorUtilityFXButtons(String name,HBox hBox){
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


    public void setDefaultActions(Button fxButton){
        //TODO set drag and drop action/properties
        //TODO set Textfield edit actions
    }


    public HBox setupAddButtonToRow(HBox hBox){
        return hBox;


    }

    public Button addButton(){
        Button addButton = new Button("+");
        setButtonSize(addButton,20,20);
        return addButton;


    }

    public void setButtonSize(Button button, int width, int height){
        button.setMaxSize(width,height);
        button.setMinSize(width,height);
        button.setOnAction(event -> {
            actionnn(event);
        });
    }

    public void addNewTalkButonToUI(Button addButton){
        hBox.getChildren().add(hBox.getChildren().get(hBox.getChildren().indexOf(addButton)+1));
    }

    public void actionnn(Event event){

    }

}
