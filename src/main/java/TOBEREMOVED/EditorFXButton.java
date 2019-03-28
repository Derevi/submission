package TOBEREMOVED;

import javafx.event.Event;
import javafx.geometry.Pos;
import javafx.scene.SnapshotParameters;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import talkbox.common.dataobject.TalkButton;
import talkbox.common.dataobject.TalkButtonPage;


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
    public void setDefaultActions(Button fxButton){

    }

    public void enableDragAndDropAction(Button sourcefxButton, HBox hBox){

            this.fxButton.setOnDragDetected(e->{
                Dragboard db = this.fxButton.startDragAndDrop(TransferMode.COPY_OR_MOVE);
                ClipboardContent content = new ClipboardContent();
                TalkButtonPage tp = (TalkButtonPage) this.fxButton.getUserData();
                db.setDragView(this.fxButton.snapshot(new SnapshotParameters(),null),0,0);
                db.setContent(content);
            });

            this.fxButton.setOnDragOver(e->{
                e.acceptTransferModes(TransferMode.COPY);
            });

            this.fxButton.setOnDragDropped(e->{
                Dragboard db = e.getDragboard();
                System.out.println(db.getString());
                hBox.getChildren().remove(Integer.parseInt(db.getString()));



            });
    }

    public Button getFxButton(){
        return this.fxButton;
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
