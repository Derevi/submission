package talkbox.desktop.mainapp.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import talkbox.common.service.FileBrowser;
import talkbox.common.service.SceneViewLoader;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class StartTalkBoxController implements Initializable {



    @FXML
    AnchorPane root;

    @FXML
    private void load(ActionEvent event){
        File loadFile = FileBrowser.loadFile();
        setNewScene("/talkbox/desktop/mainapp/view/talkbox.fxml", event);
    }



    private void setNewScene(String pathToFXML, ActionEvent event){
        SceneViewLoader sceneViewLoader = new SceneViewLoader(pathToFXML);
        sceneViewLoader.setNewScene(event);
    }



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


    }
}
