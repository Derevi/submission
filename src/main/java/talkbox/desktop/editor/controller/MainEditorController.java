package talkbox.desktop.editor.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import talkbox.common.dataobject.TalkButtonCatalog;
import talkbox.common.dataobject.TalkButtonPage;
import talkbox.common.service.*;
import talkbox.desktop.editor.model.*;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.ResourceBundle;

public class MainEditorController implements Initializable {


    @FXML
    private AnchorPane root;

    @FXML
    private GridPane imageGrid;

    @FXML
    private AnchorPane imageWindowRoot;

    @FXML
    private HBox toggleBox;

    @FXML
    private Button newPage;

    private VBox box;
    private TalkButtonCatalog talkButtonCatalog;
    private FXMLLoader fXMLLoader = new FXMLLoader();
    private LinkedHashMap<String, ArrayList<ArrayList<Button>>> catalogFxButtons;
    private LinkedHashMap<String, ArrayList<HBox>> hBoxArrayListMap;

    @FXML
    private VBox baseVBox;

    @FXML
    private HBox keyBox;

    public void setTalkButtonCatalog(TalkButtonCatalog talkButtonCatalog) {

    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        intializeUIComponents();
        renderGUI();


    }

    public void imageWindow() {
        ImageWindowController imageWindowController = new ImageWindowController();
        SceneViewLoader.loadNewWindow(imageWindowController, "/talkbox/desktop/editor/view/imagewindow.fxml", "Image Window");
    }

    public LinkedHashMap<String, ArrayList<HBox>> gethBoxArrayListMap() {
        return this.hBoxArrayListMap;
    }

    public VBox getBaseVBox() {
        return this.baseVBox;
    }

    public HBox getToggleBox() {
        return this.toggleBox;
    }

    private void intializeUIComponents() {
        bindNodeContainerSize();
        loadCatalog();
        initializeMaps(new EditorAppTalkButtonInterpretor(this.talkButtonCatalog));
        EditorFXButtonActionSetupUtility.setupAddBtnPage(newPage, this.talkButtonCatalog, this);
    }

    private void bindNodeContainerSize() {
        this.baseVBox.prefWidthProperty().bind(root.widthProperty());
        this.toggleBox.prefWidthProperty().bind(root.widthProperty());
    }

    private void loadCatalog() {
        this.talkButtonCatalog = TalkButtonCatalogLoader.load("test");
    }

    public void initializeMaps(EditorAppTalkButtonInterpretor editorAppTalkButtonInterpretor) {
        this.catalogFxButtons = editorAppTalkButtonInterpretor.getMapOfFxButtonCatalog();
        this.hBoxArrayListMap = editorAppTalkButtonInterpretor.getMapOfHBoxArrayList();
        EditorUtilityFXButtons.setupMapWithUtilities(this.hBoxArrayListMap, baseVBox);
    }

    private void renderGUI() {
        DynamicFXElementsRenderer.render(hBoxArrayListMap, baseVBox, toggleBox);
    }

    private static void filterFX() {

    }

    private void save() {
        TalkButtonCatalogSaver.save(talkButtonCatalog);
    }
}



