package talkbox.desktop.editor.model;


import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class DynamicFXElementsRenderer {

    public static void renderButtonPageToggles(VBox baseVbox, HBox keyBox){
        baseVbox.getChildren().add(0,keyBox);
    }
}
