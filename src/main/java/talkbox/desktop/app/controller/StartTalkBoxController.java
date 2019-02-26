package talkbox.desktop.app.controller;

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


        try {
            Parent parent = FXMLLoader.load(getClass().getResource("../view/maineditor.fxml"));
            Scene dashboard=new Scene(parent);
            Stage newWindow=(Stage)((Node)event.getSource()).getScene().getWindow();
            newWindow.setScene(dashboard);
            newWindow.show();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }



    @FXML
    private void createNew(ActionEvent event){

        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("TalkBox Object File(*.ser)","*.ser"));
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

            Parent parent = FXMLLoader.load(getClass().getResource("../view/maineditor.fxml"));
            Scene dashboard=new Scene(parent);
            Stage newWindow=(Stage)((Node)event.getSource()).getScene().getWindow();
            newWindow.setScene(dashboard);
            newWindow.show();

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
