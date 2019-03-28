package talkbox.desktop.editor.model;

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
import talkbox.common.dataobject.TalkButtonCatalog;
import talkbox.common.dataobject.TalkButtonPage;
import talkbox.common.service.AbstractTalkButtonInterpretor;

import java.util.ArrayList;
import java.util.LinkedHashMap;

public class EditorAppTalkButtonInterpretor extends AbstractTalkButtonInterpretor {


    TalkButtonCatalog talkButtonCatalog;

    EditorAppTalkButtonInterpretor(TalkButtonCatalog talkButtonCatalog){
        this.talkButtonCatalog = talkButtonCatalog;
    }

    protected  LinkedHashMap<String, ArrayList<HBox>> convertToMapOfHBoxArrayList(){
        return EditorAppTalkButtonInterpretor.convertToMapOfHBoxArrayList(talkButtonCatalog);
    }

    //TODO IMPLEMENT THIS METHOD
    @Override
    protected Button convertToFXButton(TalkButton talkButton) {

        hBox.setAlignment(Pos.CENTER);
        fxButton = new Button(name,vBox);
        fxButton.setMaxSize(160,160);
        fxButton.setMinSize(160,160);
        textField = new TextField(name);
        return null;
    }

    public static void initTalkButton(VBox internalButtonVBox, String name){
        TextField textField = new TextField(name);
        internalButtonVBox.getChildren().add(textField);
    }
    public void initTalkButton(VBox internalButtonVBox, TalkButton talkButton){
        initTalkButton(internalButtonVBox, talkButton.getName());
        Image image = new Image(talkButton.toString());
        ImageView imageView = new ImageView(image);
        Button button = new Button();
        setImageInButtonSize(imageView, button);
        internalButtonVBox.getChildren().add(imageView);
    }

    private void setImageInButtonSize(ImageView imageInButtonSize, Button button){
        double imageHeightScaled = button.getHeight()-30;
        double imageWidthScaled = button.getWidth()-30;
        imageInButtonSize.minHeight(imageHeightScaled);
        imageInButtonSize.maxHeight(imageHeightScaled);
        imageInButtonSize.minWidth(imageWidthScaled);
        imageInButtonSize.maxWidth(imageWidthScaled);

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
}
