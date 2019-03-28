package talkbox.desktop.editor.model;

import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import talkbox.common.dataobject.TalkButton;
import talkbox.common.dataobject.TalkButtonCatalog;
import talkbox.common.service.AbstractTalkButtonInterpretor;

import java.util.ArrayList;
import java.util.LinkedHashMap;

public class EditorAppTalkButtonInterpretor extends AbstractTalkButtonInterpretor {


    TalkButtonCatalog talkButtonCatalog;

    EditorAppTalkButtonInterpretor(TalkButtonCatalog talkButtonCatalog){
        this.talkButtonCatalog = talkButtonCatalog;
    }

    protected  LinkedHashMap<String, ArrayList<HBox>> convertToMapOfHBoxArrayList(){
        return EditorAppTalkButtonInterpretor.convertToMapOfHBoxArrayList(talkButtonCatalog);
    }

    //TODO IMPLEMENT THIS METHOD
    @Override
    protected Button convertToFXButton(TalkButton talkButton) {
        return null;
    }
}
