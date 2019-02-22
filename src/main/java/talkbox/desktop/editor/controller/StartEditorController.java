package talkbox.desktop.editor.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class StartEditorController implements Initializable {



    @FXML
    BorderPane root;

    @FXML
    private void load(ActionEvent event){
        try {
            BorderPane borderPane = FXMLLoader.load(getClass().getResource("../view/loadeditor.fxml"));
            root.getChildren().setAll(borderPane);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void createNew(ActionEvent event){
        try {
            BorderPane borderPane = FXMLLoader.load(getClass().getResource("../view/createneweditor.fxml"));
            root.getChildren().setAll(borderPane);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
