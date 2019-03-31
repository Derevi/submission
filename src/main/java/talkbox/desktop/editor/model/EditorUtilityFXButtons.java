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
import talkbox.desktop.editor.model.EditorAppTalkButtonInterpretor;

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
    public  static void setupMapWithUtilities( LinkedHashMap<String, ArrayList<HBox>> hBoxArrayListMap, VBox useBaseVBoxHere){
       // hBoxArrayListMap.entrySet().stream().forEach(v->setupAddNewButtonUtility(v.getValue()));
        hBoxArrayListMap.entrySet().stream().forEach(s-> setupAllUtilityButtonsToView(s.getValue(), useBaseVBoxHere));
    }


    private static void setupAllUtilityButtonsToView(ArrayList<HBox> editorTalkBoxButtons, VBox useBaseVBoxHere){
        setupAddNewButtonUtility(editorTalkBoxButtons);
        setupAddNewButtonRowUtility(editorTalkBoxButtons, useBaseVBoxHere);
    }





    private static void  setupAddNewButtonRowUtility(ArrayList<HBox> editorTalkBoxButtons, VBox useBaseVBoxHere){

        int initialLength = editorTalkBoxButtons.size();

        for(int i = 0; i <= editorTalkBoxButtons.size(); i = i + 2){
            editorTalkBoxButtons.add(i, createAddRowUtility(useBaseVBoxHere));
        }
    }






    private static void setupAddNewButtonUtility(ArrayList<HBox> editorTalkBoxButtons){
        editorTalkBoxButtons.forEach(
                row->{
                    for(int i = 0; i <= row.getChildren().size(); i = i + 2){
                        row.getChildren().add(i, createAddNewButtonUtility(row));
                    }
                }
        );

    }


    private static HBox createAddRowUtility(VBox useBaseVBoxHere){
        HBox addRowUtility = new HBox();
        addRowUtility.getChildren().addAll(horizontalSeparator(), createAddRowButton(addRowUtility, useBaseVBoxHere), horizontalSeparator());
        addRowUtility.setAlignment(Pos.CENTER);
        addRowUtility.setSpacing(10);
        return addRowUtility;
    }

    private static Button createAddRowButton(HBox currentHBox, VBox useBaseVBoxHere){
        Button addRowButton = new Button("++ ADD ROW ++");
        addRowButton.getStyleClass().add("blue-button");
        setupAddRowButtonAction(addRowButton, currentHBox, useBaseVBoxHere);
        return addRowButton;
    }

    private static void setupAddRowButtonAction(Button button, HBox currentHBox, VBox useBaseVBoxHere){
        button.setOnAction(e->{
            int index = useBaseVBoxHere.getChildren().indexOf(currentHBox);

            HBox newButtonRow = new HBox();
            newButtonRow.setAlignment(Pos.CENTER);
            newButtonRow.setSpacing(10);

            //TODO @ Kevin replace this button with FX button
            Button newFXButton = new Button("Test");

            newButtonRow.getChildren().add(createAddNewButtonUtility(newButtonRow));
            newButtonRow.getChildren().add(newFXButton);
            newButtonRow.getChildren().add(createAddNewButtonUtility(newButtonRow));

            useBaseVBoxHere.getChildren().add(index, createAddRowUtility(useBaseVBoxHere));
            useBaseVBoxHere.getChildren().add(index + 1, newButtonRow);
        });

    }



    private static VBox createAddNewButtonUtility(HBox currentHBox){
        Button addButton = new Button("+");
        addButton.getStyleClass().add("blue-button");
        setAddNewButtonAction(addButton, currentHBox);
        VBox vBox = new VBox(verticalSeparator(), addButton, verticalSeparator());
        vBox.setAlignment(Pos.CENTER);
        vBox.setSpacing(10);
        return vBox;
    }

    private static void setAddNewButtonAction(Button button, HBox currentHBox){
        button.setOnAction(e->{
            int index = currentHBox.getChildren().indexOf(button.getParent());

            //TODO @ Kevin replace this button with FX button
            Button newFXButton = new Button("Test");

            currentHBox.getChildren().add(index + 1, newFXButton);
            currentHBox.getChildren().add(index + 2, createAddNewButtonUtility(currentHBox));
        });
    }


    public static void setButtonSize(Button button, int width, int height){
        button.setMaxSize(width, height);
        button.setMinSize(width, height);
    }



    private static Separator verticalSeparator(){
        Separator verticalSeparatorComponent = new Separator();
        verticalSeparatorComponent.setOrientation(Orientation.VERTICAL);
        verticalSeparatorComponent.setMaxSize(3,10);
        verticalSeparatorComponent.setMinSize(3,10);
        return verticalSeparatorComponent;
    }

    private static Separator horizontalSeparator(){
        Separator horizontalSeparatorComponent = new Separator();
        horizontalSeparatorComponent.setOrientation(Orientation.HORIZONTAL);
        horizontalSeparatorComponent.setMinSize(300,1);
        horizontalSeparatorComponent.setMaxSize(300,1);
        return horizontalSeparatorComponent;
    }







}
