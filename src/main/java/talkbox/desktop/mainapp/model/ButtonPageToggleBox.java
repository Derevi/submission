package talkbox.desktop.mainapp.model;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.HBox;

import java.util.ArrayList;

public class ButtonPageToggleBox {

    public static HBox getButtonPageToggleBox(ArrayList<ToggleButton> toggleButtons){
        HBox keyBox = new HBox();
        keyBox.setAlignment(Pos.CENTER);
        keyBox.setSpacing(10);
        keyBox.getChildren().addAll(toggleButtons);
        keyBox.getChildren().add(new Button("+PAGE+"));
        return keyBox;
    }
}
