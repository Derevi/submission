package talkbox.desktop.editor.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import talkbox.common.dataobject.TalkButton;
import talkbox.common.dataobject.TalkButtonCatalog;
import talkbox.common.dataobject.TalkButtonPage;
import talkbox.common.service.*;

import java.awt.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.ResourceBundle;

public class StartEditorController {

    @FXML
    AnchorPane root;

    private SceneViewLoader loader;

    @FXML
    private void load(ActionEvent event){

            File loadFile = FileBrowser.loadFile();
            //TODO send file to Main editor screen
            setNewScene("/talkbox/desktop/editor/view/maineditor.fxml", event);
    }

    @FXML
    private void createNew(ActionEvent event){
        File saveFile = FileBrowser.saveFile();
        //TODO send file to Main editor screen
        setNewScene("/talkbox/desktop/editor/view/maineditor.fxml", event);
    }

    private void setNewScene(String pathToFXML, ActionEvent event){
        SceneViewLoader sceneViewLoader = new SceneViewLoader(pathToFXML);
        sceneViewLoader.setNewScene(event);
    }
}
