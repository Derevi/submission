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
        return convertToMapOfHBoxArrayList(talkButtonCatalog);
    }

    //TODO IMPLEMENT THIS METHOD
    @Override
    protected Button convertToFXButton(TalkButton talkButton) {
        return createEditorFXButton(talkButton);
    }

    private Button createEditorFXButton(TalkButton talkButton){
        Button editorFXButton= new Button(talkButton.getName(),createInternalVbox(talkButton));
        setEditorButtonSize(editorFXButton,talkButton.getButtonSize());
        return editorFXButton;
    }

    private void setEditorButtonSize(Button editorFXButton, int size){
            editorFXButton.setMaxSize(size,size);
            editorFXButton.setMinSize(size,size);
    }


    public VBox createInternalVbox(TalkButton talkButton){
        VBox internalVbox = new VBox();
        TextField internalTextField = createInternalTextField(talkButton);
        internalVbox.getChildren().add(0,internalTextField);

        ImageView internalImageView = createInternalImage(talkButton);
        internalVbox.getChildren().add(1,internalImageView);

        return internalVbox;
    }

    private ImageView createInternalImage(TalkButton talkButton){
        ImageView imageView = new ImageView(talkButton.getImageFile().toURI().toString());
       setImageViewSize(imageView,talkButton.getButtonSize()-30);
       return imageView;
    }

    private void setImageViewSize(ImageView imageView, int size){
        imageView.minHeight(size);
        imageView.maxHeight(size);
        imageView.minWidth(size);
        imageView.maxWidth(size);
    }

    private TextField createInternalTextField(TalkButton talkButton){
        TextField textField = new TextField(talkButton.getName());
        setInternalTextFieldSize(textField, talkButton.getButtonSize()-20);
        return textField;
    }

    private void setInternalTextFieldSize(TextField textField, int size){
        textField.setMinSize(size,20);

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
