package talkbox.desktop.editor.model;


import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import talkbox.common.dataobject.TalkButtonCatalog;

import java.util.ArrayList;
import java.util.LinkedHashMap;

public class DynamicFXElementsRenderer {
    VBox baseVbox;
    TalkButtonCatalog talkButtonCatalog;
    EditorAppTalkButtonInterpretor editorAppTalkButtonInterpretor;

    public DynamicFXElementsRenderer(TalkButtonCatalog talkButtonCatalog, VBox baseVbox) {
        this.talkButtonCatalog= talkButtonCatalog;
        this.baseVbox = baseVbox;
        this.editorAppTalkButtonInterpretor = new EditorAppTalkButtonInterpretor(this.talkButtonCatalog);
    }

    public  void renderButtonPageToggles(VBox baseVbox){
        PageFXToggles pageFXToggles = new PageFXToggles(talkButtonCatalog.getCatalog().keySet());
        HBox hBox = new HBox();
        hBox.getChildren().addAll(pageFXToggles.toggleButtons);
        baseVbox.getChildren().add(0,hBox);
    }

    public void renderEditorButtons(VBox baseVbox,String selectedPage){
        LinkedHashMap<String, ArrayList<HBox>> editorButtonRows = editorAppTalkButtonInterpretor.convertToMapOfHBoxArrayList();
        renderUtilityButtonsToView(editorButtonRows.get(selectedPage)).stream()
                .forEach(row->baseVbox.getChildren().addAll(row));
    }

    public  ArrayList<HBox> renderUtilityButtonsToView(ArrayList<HBox> editorButtonRows){
       renderAddNewButtonUtility(editorButtonRows);
       renderAddNewButtonRowUtility(editorButtonRows);
        return editorButtonRows;
    }

    public void renderAddNewButtonRowUtility(ArrayList<HBox> editorButtonRows){
        editorButtonRows.forEach(row->{
            HBox addRowUtility = new HBox();
            baseVbox.getChildren().add(addRowUtility);
        });
    }

    public void renderAddNewButtonUtility (ArrayList<HBox> editorButtonRows){
        editorButtonRows.forEach(
                row->{
                    int counter = 0;
                    for(int i=0; i<=row.getChildren().size();i=i+2){
                        row.getChildren().add(0,new Button("+"));
                    }

                }
        );
    }
}
