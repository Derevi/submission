package talkbox.desktop.editor.model;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.util.ArrayList;
import java.util.Set;

public class PageFXToggles {
    Set<String> keySet;
    ArrayList<ToggleButton> toggleButtons;
    ToggleGroup toggleGroup;
    HBox hBox;

    protected PageFXToggles(Set<String> keySet){
        this.keySet=keySet;
        toggleButtons = new ArrayList<>();
        toggleGroup = new ToggleGroup();
        setupToggleButtons();

        this.hBox = new HBox();
        setupHboxProperties();
    }

    private void setupToggleButtons(){
        keySet.stream()
                .map(this::generateDefaultToggleButton)
                .forEach(toggleButton -> toggleButtons.add(toggleButton));

        toggleButtons.stream()
                .forEach(toggleButton -> this.toggleGroup.getToggles().add(toggleButton));


    }

    private void setupHboxProperties(){
        this.hBox.setAlignment(Pos.CENTER);
        this.hBox.setSpacing(10);
        this.hBox.getChildren().addAll(toggleButtons);
    }

    public HBox getHbox(){
        return this.hBox;
    }

    public ToggleGroup getToggleGroup(){
        return this.toggleGroup;
    }



    public ArrayList<ToggleButton> getToggleButtons(){
        return (ArrayList<ToggleButton>)toggleButtons.clone();
    }

    public ToggleButton generateDefaultToggleButton(String name){
        VBox vBox = toggleButtonInternalVBox(150,150);
        TextField textField = textFieldInternal(name,120,30);
        vBox.getChildren().add(textField);
        ToggleButton toggleButton = new ToggleButton("",vBox);
        setToggleButtonSize(toggleButton,160,160);
        toggleButton.setUserData(name);
        return toggleButton;
    }

    private void setToggleButtonSize(ToggleButton toggleButton,int width, int height){
        toggleButton.setMaxSize(width,height);
        toggleButton.setMinSize(width,height);
    }

    private VBox toggleButtonInternalVBox(int width, int height){
        VBox vBox =new VBox();
        vBox.setMaxSize(width,height);
        vBox.setAlignment(Pos.CENTER);

        return vBox;
    }

    private TextField textFieldInternal(String name,int width, int height){
        TextField textField = new TextField(name);
        textField.setMinSize(width,height);
        textField.setMaxSize(width,height);
        return textField;
    }

    public HBox getButtonPageToggleBox(){
        HBox keyBox = new HBox();
        keyBox.setAlignment(Pos.CENTER);
        keyBox.setSpacing(10);
        keyBox.getChildren().addAll(this.toggleButtons);
        keyBox.getChildren().add(new Button("+PAGE+"));
        return keyBox;
    }




}
