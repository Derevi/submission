package talkbox.desktop.editor.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import talkbox.common.service.FileBrowser;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class CreateNewEditorController implements Initializable {
    @FXML
    AnchorPane root;

    @FXML
    GridPane gridPane;

    @FXML
    TextField textField;

    @FXML
    private void load(ActionEvent event){
        try {
            AnchorPane anchorPane = FXMLLoader.load(getClass().getResource("../view/loadeditor.fxml"));
            root.getChildren().setAll(anchorPane);
        } catch (IOException e) {
            e.printStackTrace();
        }
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
        File selectedFile = FileBrowser.selectFile(event);
        updateListView(selectedFile);

    }

    private void updateListView(File selectedFile){
        gridPane.getChildren().clear();
        FileBrowser.generateDirectoryLabel(selectedFile,gridPane);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
