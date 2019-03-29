package talkbox.desktop.editor.model;

import javafx.scene.control.Button;
import talkbox.common.dataobject.TalkButton;
import talkbox.common.dataobject.TalkButtonCatalog;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

public class EditorFXButtonActionSetupUtility {
    TalkButtonCatalog talkButtonCatalog;
    LinkedHashMap<String, ArrayList<ArrayList<Button>>> pageFXButtonMap;

    public EditorFXButtonActionSetupUtility(LinkedHashMap<String, ArrayList<ArrayList<Button>>> pageFXButtonMap) {
        this.pageFXButtonMap = pageFXButtonMap;

    }

    public void setupDrapAction(){
        this.pageFXButtonMap.entrySet().stream()
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
}
