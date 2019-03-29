package talkbox.common.service;

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

    protected final LinkedHashMap<String, ArrayList<HBox>> convertToMapOfHBoxArrayList(TalkButtonCatalog talkButtonCatalog ){
        return
                getFxButtonCatalog(talkButtonCatalog).keySet()
                        .stream()
                        .collect(Collectors.toMap(
                                Function.identity(),
                                s->{return convertToHBoxesOfButtons(getFxButtonCatalog(talkButtonCatalog).get(s));},
                                (key, value) -> value, LinkedHashMap::new));
    }

    private final ArrayList<HBox> convertToHBoxesOfButtons(ArrayList<ArrayList<Button>> buttonRows){
        return buttonRows
                .stream()
                .map(s-> convertToHBoxOfButtons(s))
                .collect(Collectors.toCollection(ArrayList::new));

    }

    private final HBox convertToHBoxOfButtons(ArrayList<Button> buttonRow){
        HBox hBox = new HBox();
        setupUpEditorButtonHBox(hBox);
        hBox.getChildren().addAll(buttonRow);
        return hBox;
    }

    private final void setupUpEditorButtonHBox(HBox hBox){
        hBox.setSpacing(10);
        hBox.setAlignment(Pos.CENTER);
    }



    protected final  LinkedHashMap<String, ArrayList<ArrayList<Button>>> getFxButtonCatalog(TalkButtonCatalog talkButtonCatalog){
        return talkButtonCatalog.getCatalog().entrySet().stream()
                .collect(Collectors.toMap(Map.Entry::getKey,
                        page-> convertPage(page.getValue()),
                        (key, value) -> value, LinkedHashMap::new));
    }



    private final ArrayList<ArrayList<Button>> convertPage (TalkButtonPage talkButtonPage){
        return talkButtonPage.getPage().stream()
                .map(s ->s.stream()
                        .map(t->convertToFXButton(t))
                        .collect(Collectors.toCollection(ArrayList::new)))
                .collect(Collectors.toCollection(ArrayList::new));

    }



    protected abstract Button convertToFXButton(TalkButton talkButton);



}
