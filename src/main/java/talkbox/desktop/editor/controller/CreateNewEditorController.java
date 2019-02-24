package talkbox.desktop.editor.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import talkbox.common.dataobject.TalkButton;
import talkbox.common.dataobject.TalkButtonCatalog;
import talkbox.common.service.FileBrowser;
import talkbox.common.service.TalkButtonCatalogLoader;
import talkbox.common.service.TalkButtonCatalogSaver;


import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class CreateNewEditorController implements Initializable {
    @FXML
    AnchorPane root;

    @FXML
    GridPane gridPane;

    @FXML
    TextField textField;

    File selectDirectory;

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
        this.selectDirectory = FileBrowser.selectDirectory(event);
        updateTextLabel(selectDirectory);

    }

    private void updateTextLabel(File selectedFile){
        gridPane.getChildren().clear();
        Label label = new Label("Selected Save Directory:  "+selectedFile.getAbsolutePath());
        gridPane.add(label,0,0);
    }

    @FXML
    private void startEditor(ActionEvent  event){
       // if(textField.getText().isEmpty()){  //TODO also check if string has any symbols or white space, call isInputEmptyAlert
               // } //TODO check if name has any strings
        TalkButtonCatalog talkButtonCatalog = new TalkButtonCatalog();
        TalkButtonCatalogSaver.save(talkButtonCatalog.getTalkButtonCatalogMap(), selectDirectory,textField.getText());
        }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        
    }

    public void isInputEmptyAlert(){
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("ERROR");
        alert.setHeaderText("Please enter a valid filename in the textfield, try again");
        alert.showAndWait();
        System.out.println("empty");
        return;

    }
}
