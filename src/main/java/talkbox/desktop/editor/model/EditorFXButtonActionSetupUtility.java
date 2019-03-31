package talkbox.desktop.editor.model;

import com.sun.speech.freetts.en.us.FeatureProcessors;
import javafx.scene.control.Button;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import talkbox.common.dataobject.TalkButton;
import talkbox.common.dataobject.TalkButtonCatalog;
import talkbox.common.service.SceneViewLoader;
import talkbox.desktop.editor.controller.NewPageController;

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




}
