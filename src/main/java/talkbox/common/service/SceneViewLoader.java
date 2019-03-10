package talkbox.common.service;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import talkbox.desktop.editor.controller.MainEditorController;

import java.io.File;
import java.io.IOException;

public class SceneViewLoader {

    private String pathToFXML;
    private File selectedSerFileToLoad;

    public SceneViewLoader(String pathToFXML, File selectedSerFileToLoad){
    this.pathToFXML = pathToFXML;
    this.selectedSerFileToLoad = selectedSerFileToLoad;

    }

    public void setNewScene(ActionEvent event){
        FXMLLoader loader = new FXMLLoader();
        loaderSetup(loader);
        initializeControllerVariable(loader.getController(),selectedSerFileToLoad);
        refreshScene(event, loader.getRoot());
    }

    private void loaderSetup(FXMLLoader loader){
        try{
            loader.setLocation(getClass().getResource(pathToFXML));
            loader.load();
        }catch (IOException ioe){
            ioe.printStackTrace();
        }
    }

    private void initializeControllerVariable(MainEditorController mainEditorController, File file){
        //TODO load and convert catalog and pass through here. Below is just example method to show that variables are being carried over to new FXML
        mainEditorController.line = file.getName();
        mainEditorController.setprint(file.getName());
    }

    private void refreshScene(ActionEvent event, Parent parent){
        Stage newWindow=(Stage)((Node)event.getSource()).getScene().getWindow();
        newWindow.setScene(new Scene(parent));
        newWindow.show();
    }
}
