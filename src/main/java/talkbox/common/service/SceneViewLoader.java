package talkbox.common.service;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import talkbox.desktop.editor.controller.MainEditorController;
import talkbox.desktop.mainapp.controller.TalkBoxController;

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
        callInitializerBasedOnControllerName(loader);
        refreshScene(event, loader.getRoot());
    }


    //TODO automate explicit casting so you dont have to keep adding to if statements
    public void callInitializerBasedOnControllerName(FXMLLoader loader){
        if(pathToFXML.contains("editor")){ initializeControllerVariable((MainEditorController) loader.getController(),selectedSerFileToLoad);}
        else{initializeControllerVariable((TalkBoxController) loader.getController(),selectedSerFileToLoad);}
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

    private void initializeControllerVariable(TalkBoxController talkBoxController, File file){
        //TODO load and convert catalog and pass through here. Below is just example method to show that variables are being carried over to new FXML
        talkBoxController.line = file.getName();
        talkBoxController.setprint(file.getName());
    }

    private void refreshScene(ActionEvent event, Parent parent){
        Stage newWindow=(Stage)((Node)event.getSource()).getScene().getWindow();
        newWindow.setScene(new Scene(parent));
        newWindow.show();
    }
}
