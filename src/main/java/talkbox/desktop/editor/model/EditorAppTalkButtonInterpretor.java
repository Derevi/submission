package talkbox.desktop.editor.model;

import javafx.geometry.Pos;
import javafx.scene.SnapshotParameters;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
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
        enableDragAndDropAction(editorFXButton);

        editorFXButton.setOnAction(e->{
            System.out.println("TEST WORKED");
        });




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


    public void enableDragAndDropAction(Button sourcefxButton){

        sourcefxButton.setOnDragDetected(e->{
            Dragboard db = sourcefxButton.startDragAndDrop(TransferMode.COPY_OR_MOVE);
            ClipboardContent content = new ClipboardContent();
            db.setDragView(sourcefxButton.snapshot(new SnapshotParameters(),null),0,0);
            db.setContent(content);
        });

        sourcefxButton.setOnDragOver(e->{
            e.acceptTransferModes(TransferMode.COPY);
        });

       sourcefxButton.setOnDragDropped(e->{
            Dragboard db = e.getDragboard();
            System.out.println(db.getString());



        });

    }
}
