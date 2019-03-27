package talkbox.desktop.editor.model;

import javafx.collections.ObservableList;
import javafx.scene.control.TextField;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class PageFXToggles {
    Set<String> keySet;
    ArrayList<ToggleButton> toggleButtons;
    ToggleGroup toggleGroup;

    public PageFXToggles(Set<String> keySet){
        this.keySet=keySet;
        toggleButtons = new ArrayList<>();
        toggleGroup = new ToggleGroup();
        init();
    }

    public void init(){
        keySet.stream()
                .map(this::generateDefaultToggleButton)
                .forEach(toggleButton -> toggleButtons.add(toggleButton));
        toggleButtons.stream()
                .forEach(toggleButton -> this.toggleGroup.getToggles().add(toggleButton));
    }


    public ToggleGroup getToggleGroup(){
        return this.toggleGroup;
    }



    public ArrayList<ToggleButton> getToggleButtons(){
        return (ArrayList<ToggleButton>)toggleButtons.clone();
    }

    public ToggleButton generateDefaultToggleButton(String name){
        VBox vBox = toggleButtonInternalVBox(150,150);
        TextField textField = textFieldInternal(name,120,20);
        vBox.getChildren().add(textField);
        ToggleButton toggleButton = new ToggleButton(name,vBox);
        setToggleButtonSize(toggleButton,160,160);
        return toggleButton;
    }

    private void setToggleButtonSize(ToggleButton toggleButton,int width, int height){
        toggleButton.setMaxSize(width,height);
        toggleButton.setMinSize(width,height);
    }

    private VBox toggleButtonInternalVBox(int width, int height){
        VBox vBox =new VBox();
        vBox.setMaxSize(width,height);

        return vBox;
    }

    private TextField textFieldInternal(String name,int width, int height){
        TextField textField = new TextField(name);
        textField.setMinSize(width,height);
        textField.setMaxSize(width,height);
        return textField;
    }


}
