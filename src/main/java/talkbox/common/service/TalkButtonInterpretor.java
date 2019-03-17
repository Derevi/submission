package talkbox.common.service;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import talkbox.common.dataobject.TalkButton;
import talkbox.common.dataobject.TalkButtonCatalog;
import talkbox.common.dataobject.TalkButtonPage;

import java.util.*;
import java.util.stream.Collectors;

public class TalkButtonInterpretor {


    public static void toFxButton(TalkButton talkButton){


    }

    public static void toFxButton(TalkButtonPage talkButtonPage){

    }

    public static void toFxButton(TalkButtonCatalog talkButtonCatalog){

    }



    public static  LinkedHashMap<String, ArrayList<ArrayList<Button>>> getFxButtonCatalog(TalkButtonCatalog talkButtonCatalog){
       return talkButtonCatalog.getCatalog().keySet()
               .stream()
               .map(s -> talkButtonCatalog.getTalkButtonPage(s))
               .collect(Collectors.toMap(TalkButtonPage::getPageName, TalkButtonInterpretor::convertPage))
               .entrySet()
               .stream()
               .collect(Collectors
                       .toMap(Map.Entry::getKey, Map.Entry::getValue, (x, y) -> y, LinkedHashMap::new));
    }



    public static ArrayList<ArrayList<Button>> convertPage (TalkButtonPage talkButtonPage){
        return talkButtonPage.getPage().stream()
                .map(s ->s.stream()
                        .map(t->mainAppButton(t))
                        .collect(Collectors.toCollection(ArrayList::new)))
                .collect(Collectors.toCollection(ArrayList::new));

    }

    //TODO give each button action event that allows them to play audi
    public static Button mainAppButton(TalkButton talkButton){
        //TODO if image exist load it on to button
        VBox internalButtonVBox = new VBox();
        internalButtonVBox.setAlignment(Pos.CENTER);
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
