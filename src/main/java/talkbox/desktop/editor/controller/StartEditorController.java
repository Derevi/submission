package talkbox.desktop.editor.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class StartEditorController implements Initializable {



    @FXML
    AnchorPane root;

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
    private void createNew(ActionEvent event){

        try {
            AnchorPane anchorPane = FXMLLoader.load(getClass().getResource("../view/createneweditor.fxml"));
            root.getChildren().setAll(anchorPane);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
