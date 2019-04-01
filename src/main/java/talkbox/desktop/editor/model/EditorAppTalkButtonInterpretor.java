package talkbox.desktop.editor.model;

import javafx.geometry.Pos;
import javafx.scene.SnapshotParameters;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.transform.Scale;
import talkbox.common.dataobject.TalkButton;
import talkbox.common.dataobject.TalkButtonCatalog;
import talkbox.common.dataobject.TalkButtonPage;
import talkbox.common.service.AbstractTalkButtonInterpretor;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;

//TODO ESSENTIAL KN SETUP INTERPRETOR TO ADD PROPER UTILITY BUTTONS TO ArrayList<HBox>

public class EditorAppTalkButtonInterpretor extends AbstractTalkButtonInterpretor {





    public EditorAppTalkButtonInterpretor(TalkButtonCatalog talkButtonCatalog){
        super(talkButtonCatalog);

    }





    //TODO IMPLEMENT THIS METHOD
    @Override
    protected Button convertToFXButton(TalkButton talkButton) {
        return createEditorFXButtonFromTalkButton(talkButton);
    }

    private Button createEditorFXButtonFromTalkButton(TalkButton talkButton){

        Button editorFXButton= new Button("",createInternalVbox(talkButton));
        editorFXButton.setUserData(talkButton);
        setEditorButtonProperties(editorFXButton,talkButton.getButtonSize());


        editorFXButton.setOnDragDetected(e->{
            Dragboard db = editorFXButton.startDragAndDrop(TransferMode.COPY_OR_MOVE);
            ClipboardContent content = new ClipboardContent();
            //TalkButtonPage tp = (TalkButtonPage) b.getUserData();
           // content.putString(Integer.toString(buttonList.indexOf(b)));

            content.putString("test");
           File imageFile = new File("buttondragimage.PNG");
          // Image dragIcon= new Image(editorFXButton.snapshot(new SnapshotParameters(),null).getUrl(),50,50,false,false);

           SnapshotParameters snapshotParameters = new SnapshotParameters();
           snapshotParameters.setTransform(new Scale(0.6,0.6));



            db.setDragView(editorFXButton.snapshot(snapshotParameters,null),0,0);


            db.setContent(content);

        });
/*
        editorFXButton.setOnDragOver(e->{
            e.acceptTransferModes(TransferMode.COPY);
        });
*/



        //TODO ALL actions must be set HERE
        return editorFXButton;
    }

    private VBox createInternalVbox(TalkButton talkButton){
        VBox internalVbox = new VBox();
        setInternalVBoxProperties(internalVbox, talkButton.getButtonSize()-20);
        internalVbox.getChildren().add(0,createInternalTextField(talkButton));
        internalVbox.getChildren().add(1,createInternalImage(talkButton));
        return internalVbox;
    }

    private TextField createInternalTextField(TalkButton talkButton){
        TextField textField = new TextField(talkButton.getName());
        setInternalTextFieldSize(textField, talkButton.getButtonSize()-30);
        return textField;
    }

    private ImageView createInternalImage(TalkButton talkButton){
        ImageView imageView;
        if(talkButtonHasImage(talkButton)) {
            imageView = new ImageView(talkButton.getImageFile().toURI().toString());
            setImageViewSize(imageView, talkButton.getButtonSize() - 30);
        }else {
            imageView = new ImageView();
        }
        return imageView;
    }

    private void setEditorButtonProperties(Button editorFXButton, int size){
            editorFXButton.setMaxSize(size,size);
            editorFXButton.setMinSize(size,size);
            editorFXButton.setAlignment(Pos.CENTER);
    }


    private void setInternalVBoxProperties(VBox internalVbox, int size){
        internalVbox.setMaxSize(size, size);
        internalVbox.setMinSize(size, size);
        internalVbox.setSpacing(10);
        internalVbox.setAlignment(Pos.TOP_CENTER);
    }

    private void setImageViewSize(ImageView imageView, int size){
        imageView.minHeight(size);
        imageView.maxHeight(size);
        imageView.minWidth(size);
        imageView.maxWidth(size);
    }

    private void setInternalTextFieldSize(TextField textField, int size){
        textField.setMinSize(size,15);
    }

    private boolean talkButtonHasImage(TalkButton talkButton){
        return (talkButton.getImageFile()!=null)? true: false;
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
            toggleBox.getChildren().remove(Integer.parseInt(db.getString()));



        });
        */
    }
}
