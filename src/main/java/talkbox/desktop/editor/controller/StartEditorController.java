package talkbox.desktop.editor.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class StartEditorController implements Initializable {



    @FXML
    AnchorPane root;

    @FXML
    private void load(ActionEvent event){
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Ser Object File(*.ser)","*.ser"));
        fileChooser.setTitle("Open File");
        File file = fileChooser.showOpenDialog(new Stage());

        if (file != null) {
            try (FileWriter fw = new FileWriter(file.getAbsolutePath())) {
                System.out.println(file.getName());
                fw.write("test");
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }

        }

        //TODO load file and set the file
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/maineditor.fxml"));
            AnchorPane anchorPane = loader.load();
            MainEditorController controller = loader.getController();
            controller.initialSetup(file);
            controller.print();
            root.getChildren().setAll(anchorPane);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    @FXML
    private void createNew(ActionEvent event){

        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Ser Object File(*.ser)","*.ser"));
        fileChooser.setTitle("Save File");
        File file = fileChooser.showSaveDialog(new Stage());

        if (file != null) {
            try (FileWriter fw = new FileWriter(file.getAbsolutePath())) {
                System.out.println(file.getName());
                fw.write("test");
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }

        }

        try {

            FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/maineditor.fxml"));
            AnchorPane anchorPane = loader.load();
            MainEditorController controller = loader.getController();
            controller.initialSetup(file);
            controller.print();
            root.getChildren().setAll(anchorPane);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @FXML
    private void save(){

    }



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {



    }
}
