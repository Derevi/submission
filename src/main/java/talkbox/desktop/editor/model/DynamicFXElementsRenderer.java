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
    HBox toggleBox;
    TalkButtonCatalog talkButtonCatalog;
    EditorAppTalkButtonInterpretor editorAppTalkButtonInterpretor;
    PageFXToggles pageFXToggles;
    LinkedHashMap<String, ArrayList<ArrayList<Button>>> pageFXButtonMap;
    EditorFXButtonActionSetupUtility editorFXButtonActionSetupUtility;
    LinkedHashMap<String, ArrayList<HBox>> hBoxArrayListMap;

    public DynamicFXElementsRenderer(TalkButtonCatalog talkButtonCatalog, VBox baseVbox, HBox toggleBox) {
        this.talkButtonCatalog= talkButtonCatalog;
        this.baseVbox = baseVbox;
        this.editorAppTalkButtonInterpretor = new EditorAppTalkButtonInterpretor(this.talkButtonCatalog);
        this.pageFXButtonMap = editorAppTalkButtonInterpretor.getMapOfFxButtonCatalog();
        this.hBoxArrayListMap = editorAppTalkButtonInterpretor.getMapOfHBoxArrayList();
        this.pageFXToggles = new PageFXToggles(talkButtonCatalog.getCatalog().keySet());
        this.editorFXButtonActionSetupUtility = new EditorFXButtonActionSetupUtility(pageFXButtonMap);
        this.toggleBox =toggleBox;
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


    private void setupEditorButtons(String selectedPage){
        baseVbox.getChildren().clear();
        ArrayList<HBox> editorTalkBoxButtons = new ArrayList<>(editorAppTalkButtonInterpretor.getMapOfHBoxArrayList().get(selectedPage));

        setupAllUtilityButtonsToView(editorTalkBoxButtons);
        editorTalkBoxButtons.forEach(row-> baseVbox.getChildren().add(row));
    }

    private  void setupButtonPageToggles(){
        this.toggleBox.getChildren().add(firstRowIndex,this.pageFXToggles.getHbox());
    }



    private  void setupAllUtilityButtonsToView(ArrayList<HBox> editorTalkBoxButtons){
       setupAddNewButtonUtility(editorTalkBoxButtons);
       setupAddNewButtonRowUtility(editorTalkBoxButtons);
    }

    private void setupAddNewButtonRowUtility(ArrayList<HBox> editorTalkBoxButtons){

        ArrayList<HBox> editorButtonRowsWithUtilities = new ArrayList<>();
        for(int i =0; i<editorTalkBoxButtons.size();i++){
            HBox addRowUtility = new HBox();
            addRowUtility.getChildren().add(new Button("++ ADD ROW ++"));
            addRowUtility.setAlignment(Pos.CENTER);
            editorButtonRowsWithUtilities.add(addRowUtility);
            editorButtonRowsWithUtilities.add(editorTalkBoxButtons.get(i));
        }
        editorTalkBoxButtons = editorButtonRowsWithUtilities;

    }

    private void setupAddNewButtonUtility(ArrayList<HBox> editorTalkBoxButtons){
        editorTalkBoxButtons.forEach(
                row->{
                    for(int i=0; i<=row.getChildren().size();i=i+2){
                        row.getChildren().add(i,new Button("+"));
                    }

                }
        );
    }
}
