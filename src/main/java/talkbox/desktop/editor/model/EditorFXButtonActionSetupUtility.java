package talkbox.desktop.editor.model;

import javafx.scene.control.Button;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import talkbox.common.dataobject.TalkButton;
import talkbox.common.dataobject.TalkButtonCatalog;
import talkbox.common.dataobject.TalkButtonPage;
import talkbox.common.service.SceneViewLoader;
import talkbox.desktop.editor.controller.MainEditorController;
import talkbox.desktop.editor.controller.NewPageController;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

//ALL METHODS IN THIS CLASS SHOULD BE STATIC, ITS PURPOSE IS TO SETUP ACTIONS FOR ALL UTILITY BUTTONS IN THE EDITOR

public class EditorFXButtonActionSetupUtility {

    private static String pageName;
    private static LinkedHashMap<String,Integer> subList;
    private static PageFXToggles pagetoggles;

    public static void setupDrapAction(LinkedHashMap<String, ArrayList<ArrayList<Button>>> pageFXButtonMap){
        pageFXButtonMap.entrySet().stream()
                .map(Map.Entry::getValue)
                .flatMap(ArrayList::stream)
                .flatMap(ArrayList::stream)
                .forEach(button -> {
                    button.setOnAction(e->{
                        TalkButton talkButton = (TalkButton)button.getUserData();
                        System.out.println(talkButton.getName());
                    });
                });
    }

    public static void setupDrapAction(){

    }

    public static void setupRenderPageViewAction(ToggleButton toggleButton, LinkedHashMap<String, ArrayList<HBox>> hBoxArrayListMap, VBox baseVbox){

            toggleButton.setOnAction(e->{
                String pageName = (String)toggleButton.getUserData();
                DynamicFXElementsRenderer.renderTalkButonsToView(hBoxArrayListMap.get(pageName),baseVbox);
            });

    }

    public static void setPageFXToggles(PageFXToggles pg){
        pagetoggles = pg;


    }

    public static void setElements(String pagename, LinkedHashMap<String,Integer> sublist){
        pageName = pagename;
        subList = sublist;

    }

    public static void setupAddBtnPage(Button addPage, TalkButtonCatalog talkButtonCatalog, MainEditorController mc){

        addPage.setOnAction(e->{

            String title = "New Page Editor";
            NewPageController page = new NewPageController();
            SceneViewLoader.loadNewWindow(page, "/talkbox/desktop/editor/view/newpageeditor.fxml", title);
            ToggleButton newToggleBtn = pagetoggles.generateDefaultToggleButton(pageName);

            mc.getToggleBox().getChildren().add(newToggleBtn);


            TalkButtonPage talkButtonPage = new TalkButtonPage(pageName, 150);

            for(int i=0; i<subList.size();i++){
                talkButtonPage.addRow();

                for(int j=0;j<subList.get(subList.keySet().toArray()[i]);j++) {

                    talkButtonPage.addButtonToRow(i,"enter name");

                }

            }
            talkButtonCatalog.addPage(talkButtonPage);
            mc.initializeMaps(new EditorAppTalkButtonInterpretor(talkButtonCatalog));
            DynamicFXElementsRenderer.renderTalkButonsToView(mc.gethBoxArrayListMap().get(mc.gethBoxArrayListMap().keySet().toArray()[mc.gethBoxArrayListMap().size()-1]),mc.getBaseVBox());
            setupRenderPageViewAction(newToggleBtn,mc.gethBoxArrayListMap(),mc.getBaseVBox());




        });

    }

}
