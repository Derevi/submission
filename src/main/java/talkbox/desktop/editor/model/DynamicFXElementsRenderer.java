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
    PageFXToggles pageFXToggles;

    public DynamicFXElementsRenderer(TalkButtonCatalog talkButtonCatalog, VBox baseVbox) {
        this.talkButtonCatalog= talkButtonCatalog;
        this.baseVbox = baseVbox;
        this.editorAppTalkButtonInterpretor = new EditorAppTalkButtonInterpretor(this.talkButtonCatalog);
        this.pageFXToggles = new PageFXToggles(talkButtonCatalog.getCatalog().keySet());
    }

    public void render(String pageName){
      //  renderEditorButtons(pageName);
        renderButtonPageToggles();

    }

    private  void renderButtonPageToggles(){
        this.baseVbox.getChildren().add(0,this.pageFXToggles.getHbox());
    }

    private void renderEditorButtons(String selectedPage){
        LinkedHashMap<String, ArrayList<HBox>> editorButtonRows = editorAppTalkButtonInterpretor.convertToMapOfHBoxArrayList();
        renderUtilityButtonsToView(editorButtonRows.get(selectedPage)).stream()
                .forEach(row->this.baseVbox.getChildren().addAll(row));
    }

    private  ArrayList<HBox> renderUtilityButtonsToView(ArrayList<HBox> editorButtonRows){
       renderAddNewButtonUtility(editorButtonRows);
       renderAddNewButtonRowUtility(editorButtonRows);
        return editorButtonRows;
    }

    private void renderAddNewButtonRowUtility(ArrayList<HBox> editorButtonRows){
        editorButtonRows.forEach(row->{
            HBox addRowUtility = new HBox();
            baseVbox.getChildren().add(addRowUtility);
        });
    }

    private void renderAddNewButtonUtility (ArrayList<HBox> editorButtonRows){
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
