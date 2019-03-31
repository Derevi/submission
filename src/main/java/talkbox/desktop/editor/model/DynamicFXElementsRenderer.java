package talkbox.desktop.editor.model;


import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.awt.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;

///IMPORTANT NOTE, The Renderer should NOT mutate any data elements, it can only update the toggleBox and baseVBox THUS METHODS SHOULD ALL BE STATIC


public class DynamicFXElementsRenderer {



    public static void render(LinkedHashMap<String, ArrayList<HBox>> hBoxArrayListMap, VBox baseVbox, HBox toggleBox) {
        if(isViewEmpty(baseVbox, toggleBox) && hasUtilityButtons(hBoxArrayListMap)){
            initialRender(hBoxArrayListMap, baseVbox,toggleBox);
        }
        setBoxProperties(baseVbox, toggleBox);
    }



    private static void initialRender(LinkedHashMap<String, ArrayList<HBox>> hBoxArrayListMap, VBox baseVbox, HBox toggleBox){
        renderPageToggleButton(hBoxArrayListMap,baseVbox,toggleBox);
        initialTalkButtonStartupRender(hBoxArrayListMap, baseVbox);
    }

    private static void renderPageToggleButton(LinkedHashMap<String, ArrayList<HBox>> hBoxArrayListMap,VBox baseVBox, HBox toggleBox){
        PageFXToggles pageFXToggles = new PageFXToggles(hBoxArrayListMap,baseVBox);
        toggleBox.getChildren().addAll(pageFXToggles.getToggleButtons());
        System.out.println("Render Size: " + toggleBox.getChildren().size());
    }

    private static void initialTalkButtonStartupRender(LinkedHashMap<String, ArrayList<HBox>> hBoxArrayListMap, VBox baseVbox){
        baseVbox.getChildren().clear();
        renderTalkButonsToView(hBoxArrayListMap.get(hBoxArrayListMap.keySet().toArray()[0]),baseVbox);
    }

    public static void renderTalkButonsToView(ArrayList<HBox> hBoxArrayList, VBox baseVbox){
        baseVbox.getChildren().clear();
        baseVbox.getChildren().addAll(hBoxArrayList);
    }

    private static boolean isViewEmpty(VBox baseVbox, HBox toggleBox){
        return baseVbox.getChildren().isEmpty()&&toggleBox.getChildren().isEmpty()?true:false;
    }

    private static boolean hasUtilityButtons(LinkedHashMap<String, ArrayList<HBox>> hBoxArrayListMap){
        HBox firstRow = (HBox) hBoxArrayListMap.get(hBoxArrayListMap.keySet().toArray()[0]).get(0);
        Button addRowButton = (Button) firstRow.getChildren().get(1);
        return addRowButton.getText().contains("++")?true:false;
    }

    private static void setBoxProperties(VBox baseVbox, HBox toggleBox){
        baseVbox.setAlignment(Pos.CENTER);
        baseVbox.setSpacing(10);
        toggleBox.setAlignment(Pos.CENTER);
        toggleBox.setSpacing(10);
    }


}
