package talkbox.desktop.editor.model;


import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import talkbox.common.dataobject.TalkButtonCatalog;

import java.util.ArrayList;
import java.util.LinkedHashMap;

public class DynamicFXElementsRenderer {
    public static final int firstRowIndex = 0;
    VBox baseVbox;
    TalkButtonCatalog talkButtonCatalog;
    EditorAppTalkButtonInterpretor editorAppTalkButtonInterpretor;
    PageFXToggles pageFXToggles;
    ArrayList<HBox> editorTalkBoxButtons;

    public DynamicFXElementsRenderer(TalkButtonCatalog talkButtonCatalog, VBox baseVbox) {
        this.talkButtonCatalog= talkButtonCatalog;
        this.baseVbox = baseVbox;
        this.editorAppTalkButtonInterpretor = new EditorAppTalkButtonInterpretor(this.talkButtonCatalog);
        this.pageFXToggles = new PageFXToggles(talkButtonCatalog.getCatalog().keySet());
        setupToggleButtonFunction();
    }

    private void setupToggleButtonFunction(){
        pageFXToggles.getToggleButtons().forEach(toggleButton -> {
            toggleButton.setOnAction(e->{
                 render((String)toggleButton.getUserData());
            });
        });
    }

    public void render(String pageName){
        setupEditorButtons(pageName);
        setupButtonPageToggles();
    }



    private  void setupButtonPageToggles(){
        this.baseVbox.getChildren().add(firstRowIndex,this.pageFXToggles.getHbox());
    }

    private void setupEditorButtons(String selectedPage){
        baseVbox.getChildren().clear();
      this.editorTalkBoxButtons = editorAppTalkButtonInterpretor.convertToMapOfHBoxArrayList().get(selectedPage);
        setupAllUtilityButtonsToView();
        this.editorTalkBoxButtons.forEach(row-> baseVbox.getChildren().add(row));
    }

    private  void setupAllUtilityButtonsToView(){
       setupAddNewButtonUtility();
       setupAddNewButtonRowUtility();

    }

    private void setupAddNewButtonRowUtility(){

        ArrayList<HBox> editorButtonRowsWithUtilities = new ArrayList<>();
        for(int i =0; i<this.editorTalkBoxButtons.size();i++){
            HBox addRowUtility = new HBox();
            addRowUtility.getChildren().add(new Button("++ ADD ROW ++"));
            addRowUtility.setAlignment(Pos.CENTER);
            editorButtonRowsWithUtilities.add(addRowUtility);
            editorButtonRowsWithUtilities.add(this.editorTalkBoxButtons.get(i));
        }

        this.editorTalkBoxButtons = editorButtonRowsWithUtilities;

    }

    private void setupAddNewButtonUtility(){
        this.editorTalkBoxButtons.forEach(
                row->{

                    for(int i=0; i<=row.getChildren().size();i=i+2){
                        row.getChildren().add(i,new Button("+"));
                    }

                }
        );
    }
}
