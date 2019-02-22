package talkbox.desktop.editor.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import talkbox.common.service.FileBrowser;


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
        /*
        try {
            AnchorPane anchorPane = FXMLLoader.load(getClass().getResource("../view/loadeditor.fxml"));
            root.getChildren().setAll(anchorPane);
        } catch (IOException e) {
            e.printStackTrace();
        }
        */
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
        File selectDirectory = FileBrowser.selectDirectory(event);
        updateTextLabel(selectDirectory);

    }

    private void updateTextLabel(File selectedFile){
        gridPane.getChildren().clear();
        Label label = new Label("Selected Save Directory:  "+selectedFile.getAbsolutePath());
        gridPane.add(label,0,0);
    }

    @FXML
    private void startEditor(ActionEvent  event){
       // if(textField.getText().isEmpty()){  //TODO also check if string has any symbols or white space
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("ERROR");
            alert.setHeaderText("Please enter a valid filename in the textfield, try again");
            alert.showAndWait();
            System.out.println("empty");
            return;

       // }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
