package talkbox.desktop.editor.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import talkbox.common.service.FileBrowser;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LoadEditorController implements Initializable {
    @FXML
    AnchorPane root;

    @FXML
    ListView<String> filesInDirectory;

    @FXML
    GridPane gridPane;

    @FXML
    Label selectedDirectory;

    @FXML
    private void Start(ActionEvent event){

    }

    @FXML
    private void back(ActionEvent event){
        try {
            AnchorPane anchorPane = FXMLLoader.load(getClass().getResource("../view/starteditor.fxml"));
            root.getChildren().setAll(anchorPane);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void browse(ActionEvent event){
        FileBrowser fileBrowser = new FileBrowser();
        File selectedFile = fileBrowser.selectDirectory(event);
        updateListView(selectedFile, fileBrowser);
    }

    private void updateListView(File selectedFile, FileBrowser fileBrowser){
        gridPane.getChildren().clear();
        fileBrowser.generateList(selectedFile,filesInDirectory);
        fileBrowser.generateDirectoryLabel(selectedFile,gridPane);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
