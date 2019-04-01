package talkbox.desktop.editor.model;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import talkbox.common.service.SceneViewLoader;
import talkbox.desktop.editor.controller.MainEditorController;
import talkbox.desktop.editor.controller.NewPageController;

import javax.sound.midi.SysexMessage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class PageFXToggles {
    static ArrayList<ToggleButton> toggleButtons;
    ToggleGroup toggleGroup;
    HBox toggleBox; //Adds main catalogs such as animals,pokemons etc..
    VBox baseVBox;
   // Button newPage;
    LinkedHashMap<String, ArrayList<HBox>> hBoxArrayListMap;
    //static String pageName;

    public PageFXToggles(LinkedHashMap<String, ArrayList<HBox>> hBoxArrayListMap, VBox baseVBox) {
        this.hBoxArrayListMap = hBoxArrayListMap;
        toggleButtons = new ArrayList<>();
        toggleGroup = new ToggleGroup();
        this.baseVBox = baseVBox;
        setupToggleButtons();
        this.toggleBox = new HBox();
        setupToggleBoxProperties();
        EditorFXButtonActionSetupUtility.setPageFXToggles(this);
    }

    private void setupToggleButtons() {
        this.hBoxArrayListMap.keySet().stream()
                .map(this::generateDefaultToggleButton)
                .forEach(toggleButton -> toggleButtons.add(toggleButton));

        toggleButtons.stream()
                .forEach(toggleButton -> this.toggleGroup.getToggles().add(toggleButton));
    }

    private void setupToggleBoxProperties() {
        this.toggleBox.setAlignment(Pos.CENTER);
        this.toggleBox.setSpacing(10);
        this.toggleBox.getChildren().addAll(toggleButtons);
    }

    public HBox getToggleBox() {
        return this.toggleBox;
    }

    public ToggleGroup getToggleGroup() {
        return this.toggleGroup;
    }


    public ArrayList<ToggleButton> getToggleButtons() {
        return (ArrayList<ToggleButton>) toggleButtons.clone();
    }

    public ToggleButton generateDefaultToggleButton(String name) {
        VBox vBox = toggleButtonInternalVBox(150, 150);
        TextField textField = textFieldInternal(name, 120, 30);
        vBox.getChildren().add(textField);
        ToggleButton toggleButton = new ToggleButton("", vBox);
        setToggleButtonSize(toggleButton, 160, 160);
        toggleButton.setUserData(name);
        EditorFXButtonActionSetupUtility.setupRenderPageViewAction(toggleButton, hBoxArrayListMap, baseVBox);
        return toggleButton;
    }

    private void setToggleButtonSize(ToggleButton toggleButton, int width, int height) {
        toggleButton.setMaxSize(width, height);
        toggleButton.setMinSize(width, height);
    }

    private VBox toggleButtonInternalVBox(int width, int height) {
        VBox vBox = new VBox();
        vBox.setMaxSize(width, height);
        vBox.setAlignment(Pos.CENTER);
        return vBox;
    }

    private TextField textFieldInternal(String name, int width, int height) {
        TextField textField = new TextField(name);
        textField.setMinSize(width, height);
        textField.setMaxSize(width, height);
        return textField;
    }

    public HBox getButtonPageToggleBox() {
        HBox keyBox = new HBox();
        keyBox.setAlignment(Pos.CENTER);
        keyBox.setSpacing(10);
        keyBox.getChildren().addAll(this.toggleButtons);
        keyBox.getChildren().add(new Button("+PAGE+"));
        return keyBox;
    }


    //TODO @DHRUV add a button which adds a new list add the button to the end of toggleBox
    //TODO @DHRUV IF you are creating a new button you can call metod and pass in string to: generateDefaultToggleButton(String name)
    //TODO @DHRUV **Make sure that new Added buttons are ToggleButtons and that they are added before the add button


    /* MOVED TO A DIFFERENT CLASS
    public void addNewPage(Button newPage) {
        //System.out.println("SizeBefoeBefore: " + toggleBox.getChildren().size());
       newPage.setOnAction(new EventHandler<ActionEvent>() {
           @Override
           public void handle(ActionEvent event) {
               //System.out.println("SizeBefore: " + toggleBox.getChildren().size());
               String title = "New Page Editor";
               NewPageController page = new NewPageController();
               SceneViewLoader.loadNewWindow(page, "/talkbox/desktop/editor/view/newpageeditor.fxml", title);

               //System.out.println("PageName: " + pageName);
               ToggleButton newToggleBtn = generateDefaultToggleButton(pageName);
               //System.out.println(generateDefaultToggleButton(pageName).getText());
               toggleButtons.add(generateDefaultToggleButton(pageName));
               //System.out.println("SizeToggleBox: " + toggleBox.getChildren().size());
               //System.out.println(toggleButtons.get(toggleButtons.size()-1).getText());

           }
       });

        System.out.println("Size: "+ toggleBox.getChildren().size());



    }*/

}
