package talkbox.common.service;

import TOBEREMOVED.TalkButtonInterpretor;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import talkbox.common.dataobject.TalkButton;
import talkbox.common.dataobject.TalkButtonCatalog;
import talkbox.common.dataobject.TalkButtonPage;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public abstract class AbstractTalkButtonInterpretor {

    protected static LinkedHashMap<String, ArrayList<HBox>> convertToMapOfHBoxArrayList(TalkButtonCatalog talkButtonCatalog ){
        return
                getFxButtonCatalog(talkButtonCatalog).keySet()
                        .stream()
                        .collect(Collectors.toMap(
                                Function.identity(),
                                s->{return convertToHBoxesOfButtons(getFxButtonCatalog(talkButtonCatalog).get(s));},
                                (key, value) -> value, LinkedHashMap::new));
    }

    private static ArrayList<HBox> convertToHBoxesOfButtons(ArrayList<ArrayList<Button>> buttonRows){
        return buttonRows
                .stream()
                .map(AbstractTalkButtonInterpretor::convertToHBoxOfButtons)
                .collect(Collectors.toCollection(ArrayList::new));

    }

    private static HBox convertToHBoxOfButtons(ArrayList<Button> buttonRow){
        HBox hBox = new HBox();
        hBox.getChildren().addAll(buttonRow);
        return hBox;
    }



    protected static  LinkedHashMap<String, ArrayList<ArrayList<Button>>> getFxButtonCatalog(TalkButtonCatalog talkButtonCatalog){
        return talkButtonCatalog.getCatalog().keySet()
                .stream()
                .map(s -> talkButtonCatalog.getTalkButtonPage(s))
                .collect(Collectors.toMap(TalkButtonPage::getPageName, TalkButtonInterpretor::convertPage))
                .entrySet()
                .stream()
                .collect(Collectors
                        .toMap(Map.Entry::getKey,
                                Map.Entry::getValue,
                                (key, value) -> value, LinkedHashMap::new));
    }



    private static ArrayList<ArrayList<Button>> convertPage (TalkButtonPage talkButtonPage){
        return talkButtonPage.getPage().stream()
                .map(s ->s.stream()
                        .map(t->mainAppButton(t))
                        .collect(Collectors.toCollection(ArrayList::new)))
                .collect(Collectors.toCollection(ArrayList::new));

    }

    //TODO give each button action event that allows them to play audi
    private static Button mainAppButton(TalkButton talkButton){
        //TODO if image exist load it on to button
        VBox internalButtonVBox = new VBox();
        internalButtonVBox.setAlignment(Pos.CENTER);
        Button button = new Button(talkButton.getName(), internalButtonVBox);
        button.setMaxSize(talkButton.getButtonSize(),talkButton.getButtonSize());
        button.setMinSize(talkButton.getButtonSize(),talkButton.getButtonSize());
        button.setPrefSize(talkButton.getButtonSize(),talkButton.getButtonSize());
        return button;
    }


    private static Button editorAppButton(TalkButton talkButton){
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

    protected abstract Button convertToFXButton(TalkButton talkButton);



}
