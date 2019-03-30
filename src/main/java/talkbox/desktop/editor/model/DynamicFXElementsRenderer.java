package talkbox.desktop.editor.model;


import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import talkbox.common.dataobject.TalkButtonCatalog;

import java.util.ArrayList;
import java.util.LinkedHashMap;

public class DynamicFXElementsRenderer {

    VBox baseVbox;
    HBox toggleBox;
    LinkedHashMap<String, ArrayList<ArrayList<Button>>> pageFXButtonMap;
    LinkedHashMap<String, ArrayList<HBox>> hBoxArrayListMap;

    EditorAppTalkButtonInterpretor editorAppTalkButtonInterpretor;
    PageFXToggles pageFXToggles;
   // EditorFXButtonActionSetupUtility editorFXButtonActionSetupUtility;


    public DynamicFXElementsRenderer(LinkedHashMap<String, ArrayList<HBox>> hBoxArrayListMap, VBox baseVbox, HBox toggleBox) {
        this.baseVbox = baseVbox;
        this.toggleBox =toggleBox;
        this.hBoxArrayListMap = hBoxArrayListMap;
        this.pageFXToggles = new PageFXToggles(hBoxArrayListMap.keySet());

        initialSetupViewBox();
    }

    private void initialSetupViewBox(){
        baseVbox.setAlignment(Pos.CENTER);
        baseVbox.setSpacing(10);
        toggleBox.setAlignment(Pos.CENTER);
        toggleBox.setSpacing(10);


    }

    public void render(){
        clearUIView();
        renderPageToggles();
        initialBaseVBoxStartupRender();
    }

    private void clearUIView(){
        baseVbox.getChildren().clear();
        toggleBox.getChildren().clear();
    }

    private void initialBaseVBoxStartupRender(){
        baseVbox.getChildren().clear();
        baseVbox.getChildren().addAll(hBoxArrayListMap.get(hBoxArrayListMap.keySet().toArray()[0]));
    }

    public void renderPageToggles(){
        setupRenderPageViewAction();
        toggleBox.getChildren().addAll(this.pageFXToggles.getToggleButtons());
    }

    private void setupRenderPageViewAction(){
        this.pageFXToggles.getToggleButtons().forEach(toggleButton -> {
            toggleButton.setOnAction(e->{
                renderTalkButtons((String)toggleButton.getUserData());
            });
        });
    }



    private void renderTalkButtons(String pageName){
        baseVbox.getChildren().clear();
        baseVbox.getChildren().addAll(hBoxArrayListMap.get(pageName));
    }










}
