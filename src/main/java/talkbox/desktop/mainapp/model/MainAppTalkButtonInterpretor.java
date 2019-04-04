package talkbox.desktop.mainapp.model;

import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import talkbox.common.dataobject.TalkButton;
import talkbox.common.dataobject.TalkButtonCatalog;
import talkbox.common.service.AbstractTalkButtonInterpretor;

import java.util.ArrayList;
import java.util.LinkedHashMap;

public class MainAppTalkButtonInterpretor extends AbstractTalkButtonInterpretor {


    TalkButtonCatalog talkButtonCatalog;

    public MainAppTalkButtonInterpretor(TalkButtonCatalog talkButtonCatalog){
        super(talkButtonCatalog);
    }

    //TODO IMPLEMENT THIS METHOD
    @Override
    protected Button convertToFXButton(TalkButton talkButton) {
        Button button = new Button(talkButton.getName());
        button.setMaxSize(160,160);
        button.setMinSize(160,160);
        return button;
    }
}
