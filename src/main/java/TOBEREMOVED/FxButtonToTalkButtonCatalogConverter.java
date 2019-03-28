package TOBEREMOVED;

import javafx.event.Event;
import javafx.geometry.Pos;
import javafx.scene.SnapshotParameters;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import talkbox.common.dataobject.TalkButton;
import talkbox.common.dataobject.TalkButtonPage;

import java.io.File;

public class FxButtonToTalkButtonCatalogConverter {

    //TODO, constructor pulls in entire VBOX from view
    //ignores row 0 since that is the key set
    //ignores the last button of every row since that is the  "add button" button
    //ignores any row that contains a separator
    //creates a new catalog with all the button data, transfer over all member variables (button size, audio file locations etc.

    //TODO ALTERNATIVE: make action event everytime add is called talk button page is altered, this dyanimcally updating it (this may be better)




    public void initPageButton(){

    }

    public static int getIndex(HBox hBox,Button button){
        return hBox.getChildren().indexOf(button);
    }

    public static void initTalkButton(VBox internalButtonVBox, String name){
        TextField textField = new TextField(name);
        internalButtonVBox.getChildren().add(textField);
    }
    public static void initTalkButton(VBox internalButtonVBox, TalkButton talkButton){

        initTalkButton(internalButtonVBox, talkButton.getName());
        Image image = new Image(talkButton.toString());
        ImageView imageView = new ImageView(image);
        Button button = new Button();
        setImageInButtonSize(imageView, button);
        internalButtonVBox.getChildren().add(imageView);
    }

    private static void setImageInButtonSize(ImageView imageInButtonSize, Button button){
        double imageHeightScaled = button.getHeight()-30;
        double imageWidthScaled = button.getWidth()-30;
        imageInButtonSize.minHeight(imageHeightScaled);
        imageInButtonSize.maxHeight(imageHeightScaled);
        imageInButtonSize.minWidth(imageWidthScaled);
        imageInButtonSize.maxWidth(imageWidthScaled);
    }

    public void setDefaultActions(Button fxButton){

    }

    public void enableDragAndDropAction(Button sourcefxButton, HBox hBox){
/*
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
        */
    }

    public Button getFxButton(){
        //return this.fxButton;
        return new Button();
    }

    public HBox setupAddButtonToRow(HBox hBox){
        return hBox;


    }



    public void setButtonSize(Button button, int width, int height){
        button.setMaxSize(width,height);
        button.setMinSize(width,height);
        button.setOnAction(event -> {

        });
    }

    public void addNewTalkButonToUI(Button addButton){
       // hBox.getChildren().add(hBox.getChildren().get(hBox.getChildren().indexOf(addButton)+1));
    }



}
