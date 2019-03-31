package talkbox.desktop.editor.model;

import javafx.event.Event;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Separator;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import talkbox.common.dataobject.TalkButton;
import talkbox.common.dataobject.TalkButtonCatalog;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class EditorUtilityFXButtons {
    TalkButton talkButton;
    Button fxButton;
    VBox vBox;
    TextField textField;
    HBox hBox;
    EditorAppTalkButtonInterpretor editorAppTalkButtonInterpretor;
    TalkButtonCatalog talkButtonCatalog;
    LinkedHashMap<String, ArrayList<ArrayList<Button>>> pageFXButtonMap;
    EditorFXButtonActionSetupUtility editorFXButtonActionSetupUtility;
    LinkedHashMap<String, ArrayList<HBox>> hBoxArrayListMap;
/*
    EditorUtilityFXButtons(LinkedHashMap<String, ArrayList<ArrayList<Button>>> pageFXButtonMap){
        this.talkButtonCatalog = talkButtonCatalog;
        this.editorAppTalkButtonInterpretor = new EditorAppTalkButtonInterpretor(this.talkButtonCatalog);
        this.pageFXButtonMap = editorAppTalkButtonInterpretor.getMapOfFxButtonCatalog();
        this.hBoxArrayListMap = editorAppTalkButtonInterpretor.getMapOfHBoxArrayList();
        setupMapWithUtilities(this.hBoxArrayListMap);
    }
*/
    public  static void setupMapWithUtilities( LinkedHashMap<String, ArrayList<HBox>> hBoxArrayListMap ){
       // hBoxArrayListMap.entrySet().stream().forEach(v->setupAddNewButtonUtility(v.getValue()));
        hBoxArrayListMap.entrySet().stream().forEach(s-> setupAllUtilityButtonsToView(s.getValue()));
    }


    private static void setupAllUtilityButtonsToView(ArrayList<HBox> editorTalkBoxButtons){
        setupAddNewButtonUtility(editorTalkBoxButtons);
        setupAddNewButtonRowUtility(editorTalkBoxButtons);
    }





    private static void  setupAddNewButtonRowUtility(ArrayList<HBox> editorTalkBoxButtons){

        int initialLength = editorTalkBoxButtons.size();

        for(int i =0; i<= editorTalkBoxButtons.size();i=i+2){
            editorTalkBoxButtons.add(i,createAddRowUtility());
        }

    }






    private static void setupAddNewButtonUtility(ArrayList<HBox> editorTalkBoxButtons){
        editorTalkBoxButtons.forEach(
                row->{
                    for(int i=0; i<=row.getChildren().size();i=i+2){
                        row.getChildren().add(i,createAddNewButtonUtility());
                    }
                }

        );

    }


    public static HBox createAddRowUtility(){
        HBox addRowUtility = new HBox();
        addRowUtility.getChildren().addAll(horizontalSeparator(), createAddRowButton(), horizontalSeparator());
        addRowUtility.setAlignment(Pos.CENTER);
        return addRowUtility;
    }

    private static Button createAddRowButton(){
        Button addRowButton = new Button("++ ADD ROW ++");
        addRowButton.getStyleClass().add("blue-button");
        setupAddRowButtonAction(addRowButton);
        return addRowButton;
    }

    private static void setupAddRowButtonAction(Button button){
        button.setOnAction(e->{
            createAddRowUtility(); //add this to the bottom of the current row
            //TODO set action to create new row and also add another utility button
        });

    }



    public static VBox createAddNewButtonUtility(){
        Button addButton = new Button("+");
        addButton.getStyleClass().add("blue-button");
        setAddNewButtonAction(addButton);
        VBox vBox = new VBox(verticalSeparator(), addButton, verticalSeparator());
        vBox.setAlignment(Pos.CENTER);
        return vBox;
    }

    public static void setAddNewButtonAction(Button button){
        button.setOnAction(e->{
            //TODO implement tool to add new button
        });
    }


    public static void setButtonSize(Button button, int width, int height){
        button.setMaxSize(width,height);
        button.setMinSize(width,height);
    }



    public static Separator verticalSeparator(){
        Separator verticalSeparatorComponent = new Separator();
        verticalSeparatorComponent.setOrientation(Orientation.VERTICAL);
        verticalSeparatorComponent.setMaxSize(3,10);
        verticalSeparatorComponent.setMinSize(3,10);
        return verticalSeparatorComponent;
    }

    public static Separator horizontalSeparator(){
        Separator horizontalSeparatorComponent =new Separator();
        horizontalSeparatorComponent.setOrientation(Orientation.HORIZONTAL);
        horizontalSeparatorComponent.setMinSize(300,1);
        horizontalSeparatorComponent.setMaxSize(300,1);
        return horizontalSeparatorComponent;

    }







}
