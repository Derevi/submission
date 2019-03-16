package talkbox.common.service;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import talkbox.common.dataobject.TalkButton;
import talkbox.common.dataobject.TalkButtonCatalog;
import talkbox.common.dataobject.TalkButtonPage;
import talkbox.desktop.editor.controller.MainEditorController;
import talkbox.desktop.mainapp.controller.TalkBoxController;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

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
        mainEditorController.setTalkButtonCatalog(loadTalkButtonCatalog());
    }

    private void initializeControllerVariable(TalkBoxController talkBoxController, File file){
        //TODO load and convert catalog and pass through here. Below is just example method to show that variables are being carried over to new FXML
        talkBoxController.setTalkButtonCatalog(loadTalkButtonCatalog());
    }

    private TalkButtonCatalog loadTalkButtonCatalog(){
        TalkButtonCatalog loaded = TalkButtonCatalogLoader.load("/test.ser");
        return loaded;
    }


    private void refreshScene(ActionEvent event, Parent parent){
        Stage newWindow=(Stage)((Node)event.getSource()).getScene().getWindow();
        newWindow.setScene(new Scene(parent));
        newWindow.show();
    }
}
/*  //THIS IS THE CODE IN A SINGLE BLOCK
        FXMLLoader loader = new FXMLLoader();
        try{
            loader.setLocation(getClass().getResource(pathToFXML));
            loader.load();
        }catch (IOException ioe){
            ioe.printStackTrace();
        }
        TalkBoxController talkBoxController = loader.getController();

        TalkButtonCatalog loaded = TalkButtonCatalogLoader.load("/test.ser");
        talkBoxController.setTalkButtonCatalog(loaded);

        Parent parent = loader.getRoot();
        Stage newWindow=(Stage)((Node)event.getSource()).getScene().getWindow();
        newWindow.setScene(new Scene(parent));
        newWindow.show();


            private void initializeEditorControllerVariable(MainEditorController mainEditorController, File file){
        TalkButtonCatalog loaded = TalkButtonCatalogLoader.load("/test.ser");
        mainEditorController.setTalkButtonCatalog(loaded);

      //  TalkButtonCatalog catalog = TalkButtonCatalogLoader.load(file.getPath());
      //  mainEditorController.setTalkButtonCatalog(catalog);
    }

    private void initializeMainAppControllerVariable(TalkBoxController talkBoxController, File file){
        TalkButtonCatalog loaded = TalkButtonCatalogLoader.load("/test.ser");
        talkBoxController.setTalkButtonCatalog(loaded);

        //TalkButtonCatalog catalog = TalkButtonCatalogLoader.load(file.getPath());
        //talkBoxController.setTalkButtonCatalog(catalog);
        //talkBoxController.setprint(file.getName());
    }

 */