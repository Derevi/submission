package talkbox.common.service;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import talkbox.common.dataobject.TalkButton;
import talkbox.common.dataobject.TalkButtonCatalog;
import talkbox.common.dataobject.TalkButtonPage;

import java.util.ArrayList;
import java.util.LinkedHashMap;

public class TalkButtonInterpretor {


    public static void toFxButton(TalkButton talkButton){


    }

    public static void toFxButton(TalkButtonPage talkButtonPage){

    }

    public static void toFxButton(TalkButtonCatalog talkButtonCatalog){

    }

    public static LinkedHashMap<String, ArrayList<ArrayList<Button>>> getFxButtonCatalog(TalkButtonCatalog talkButtonCatalog){
        LinkedHashMap<String, ArrayList<ArrayList<Button>>> convertedCatalog = new LinkedHashMap<>();

        for(String pageName: talkButtonCatalog.getCatalog().keySet()) {
            ArrayList<ArrayList<Button>> page = new ArrayList<>();
            convertedCatalog.put(pageName,page);
            for (ArrayList<TalkButton> talkButtonRow : talkButtonCatalog.getCatalog().get(pageName)) {
                ArrayList<Button> row = new ArrayList<>();
                for (TalkButton talkButton : talkButtonRow) {
                   row.add(mainAppButton(talkButton));
                }
                convertedCatalog.get(pageName).add(row);
            }

        }
        return  convertedCatalog;
    }



    public static Button mainAppButton(TalkButton talkButton){
        VBox internalButtonVBox = new VBox();
        internalButtonVBox.setAlignment(Pos.CENTER);
        TextField textField = new TextField();
        textField.setMinSize(talkButton.getButtonSize()-30,25);
        textField.setMaxSize(talkButton.getButtonSize()-30,25);
        textField.setPromptText("INTEPREOTRO SU");
        internalButtonVBox.getChildren().add(textField);
        Button button = new Button(talkButton.getName(), internalButtonVBox);
        button.setMaxSize(talkButton.getButtonSize(),talkButton.getButtonSize());
        button.setMinSize(talkButton.getButtonSize(),talkButton.getButtonSize());
        button.setPrefSize(talkButton.getButtonSize(),talkButton.getButtonSize());
        return button;
    }

    public static Button editorAppButton(TalkButton talkButton){

        VBox internalButtonVBox = new VBox();
        internalButtonVBox.setAlignment(Pos.CENTER);
        TextField textField = new TextField();
        textField.setMinSize(talkButton.getButtonSize()-30,25);
        textField.setMaxSize(talkButton.getButtonSize()-30,25);
        textField.setPromptText("INTEPREOTRO SU");
        internalButtonVBox.getChildren().add(textField);
        Button button = new Button(talkButton.getName(), internalButtonVBox);
        button.setMaxSize(talkButton.getButtonSize(),talkButton.getButtonSize());
        button.setMinSize(talkButton.getButtonSize(),talkButton.getButtonSize());
        button.setPrefSize(talkButton.getButtonSize(),talkButton.getButtonSize());
        return button;
    }
}
