package talkbox.desktop.editor.model;

import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import talkbox.common.dataobject.TalkButton;
import talkbox.common.dataobject.TalkButtonCatalog;
import talkbox.desktop.editor.controller.MainEditorController;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

//ALL METHODS IN THIS CLASS SHOULD BE STATIC, ITS PURPOSE IS TO SETUP ACTIONS FOR ALL UTILITY BUTTONS IN THE EDITOR

public class EditorFXButtonActionSetupUtility {



    public static void setupDrapAction(LinkedHashMap<String, ArrayList<ArrayList<Button>>> pageFXButtonMap){
        pageFXButtonMap.entrySet().stream()
                .map(Map.Entry::getValue)
                .flatMap(ArrayList::stream)
                .flatMap(ArrayList::stream)
                .forEach(button -> {
                    button.setOnAction(e->{
                        TalkButton talkButton = (TalkButton)button.getUserData();
                        System.out.println(talkButton.getName());
                    });
                });
    }

    public static void setupDrapAction(){

    }

    public static void setupRenderPageViewAction(ToggleButton toggleButton, LinkedHashMap<String, ArrayList<HBox>> hBoxArrayListMap, VBox baseVbox){

            toggleButton.setOnAction(e->{
                String pageName = (String)toggleButton.getUserData();
                DynamicFXElementsRenderer.renderTalkButonsToView(hBoxArrayListMap.get(pageName),baseVbox);
            });

    }

    private static void getArrayHBox(ArrayList<HBox> editorTalkBoxButtons, boolean deleteMode) {
        editorTalkBoxButtons.forEach(
                row->{
                    for(int i = 0; i <= row.getChildren().size(); i ++){

                    }
                }
        );
    }

    public static void getButtonFromHBox(Button fxButton) {

    }

    public static void deleteButtons(Button removeButton, LinkedHashMap<String, ArrayList<HBox>> hBoxArrayListMap) {
        // if the removeButton reads "Cancel"
        if (removeButton.isCancelButton()) {
            hBoxArrayListMap.entrySet().forEach(s->getArrayHBox(s.getValue(), false));


            //catalogFxButtons.forEach((s, array) -> {cancelDeleteButtonsAccessHBox(array);});

            /*
            catalogFxButtons.forEach((s, array) -> {
                for (ArrayList<Button> innerArray: array) {
                    for (Button b: innerArray) {
                        b.getStyleClass().clear();
                        b.getStyleClass().add("button");
                        b.setOnAction(e->
                        {
                            // do we want the fx buttons to play their audio when clicked?
                            // if not this remains empty
                            System.out.println("Regular buttons");
                        });
                    }
                }
            });
            */

            removeButton.setText("Remove Buttons");
            removeButton.setCancelButton(false);
        }
        else {
            hBoxArrayListMap.entrySet().forEach(s->getArrayHBox(s.getValue(), true));

            //catalogFxButtons.forEach((s, array) -> {deleteMode(array);});
            //catalogFxButtons.entrySet().forEach(s -> deleteMode(s.getValue()));

            /*
            catalogFxButtons.forEach((s, array) -> {
                for (ArrayList<Button> innerArray: array) {
                    for (Button b: innerArray) {
                        b.getStyleClass().add("delete-button");
                        b.setOnAction(e->
                        {
                            // do we want the fx buttons to play their audio when clicked?
                            // if not this remains empty
                            System.out.println("Delete Button would occur");
                        });
                    }
                }
            });
            */
            removeButton.setText("Cancel");
            removeButton.setCancelButton(true);
        }

    }

    /*
    public static void cancelDeleteButtonsAccessHBox(ArrayList<ArrayList<Button>> catalogFxButtons) {
        for (ArrayList<Button> array: catalogFxButtons) {
            for (Button b: array) {
                b.getStyleClass().clear();
                b.getStyleClass().add("button");
                b.setOnAction(e->
                {
                    // do we want the fx buttons to play their audio when clicked?
                    // if not this remains empty
                });
            }
        }

        /*
        for (int i = 1; i < editorTalkBoxButtons.size(); i = i + 2) {
            HBox hbox = editorTalkBoxButtons.get(i);

            for (int j = 1; j < hbox.getChildren().size(); j = j + 2) {
                hbox.getChildren().get(j).getStyleClass().clear();
                hbox.getChildren().get(j).getStyleClass().add("button");


            }

        }
        // add asterick forward slash here
    }

    public static void deleteMode(ArrayList<ArrayList<Button>> catalogFxButtons) {
        for (ArrayList<Button> array: catalogFxButtons) {
            for (Button b: array) {
                b.getStyleClass().add("delete-button");
                b.setOnAction(e->
                {

                });
            }
        }
        /*
        for (int i = 1; i < editorTalkBoxButtons.size(); i = i + 2) {
            HBox hbox = editorTalkBoxButtons.get(i);

            for (int j = 1; j < hbox.getChildren().size(); j = j + 2) {
                hbox.getChildren().get(j).getStyleClass().add("delete-button");


            }
        }
        // add asterick forward slash here
    }
    */
}
