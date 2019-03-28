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

    MainAppTalkButtonInterpretor(TalkButtonCatalog talkButtonCatalog){
        this.talkButtonCatalog = talkButtonCatalog;
    }

    protected  LinkedHashMap<String, ArrayList<HBox>> convertToMapOfHBoxArrayList(){
        return MainAppTalkButtonInterpretor.convertToMapOfHBoxArrayList(talkButtonCatalog);
    }

    //TODO IMPLEMENT THIS METHOD
    @Override
    protected Button convertToFXButton(TalkButton talkButton) {
        return null;
    }
}
