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
import talkbox.desktop.editor.controller.NewPageController;
import talkbox.desktop.mainapp.controller.TalkBoxController;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class SceneViewLoader {

    private String pathToFXML;
    private File selectedSerFileToLoad;


    public static  void loadNewWindow(Object controller,String pathToFXML, String title){

            try{
                FXMLLoader fxmlLoader = new FXMLLoader(controller.getClass().getResource(pathToFXML));
                Parent imgWindowRoot =  fxmlLoader.load();
                Stage stage = new Stage();
                stage.setTitle(title);
                stage.setScene(new Scene(imgWindowRoot));
                NewPageController.setStage(stage);
                stage.showAndWait();
            }catch (IOException ioe){
                ioe.printStackTrace();
            }



    }

    public SceneViewLoader(String pathToFXML, File selectedSerFileToLoad){
        this.pathToFXML = pathToFXML;
        this.selectedSerFileToLoad = selectedSerFileToLoad;

    }
        //CONSTRUCTOR WILL BE REMOVED LATER
    public SceneViewLoader(String pathToFXML){
        this.pathToFXML = pathToFXML;
        this.selectedSerFileToLoad = selectedSerFileToLoad;

    }

    public void createNewSceneWindow(){
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(this.pathToFXML));
            Parent imgWindowRoot =  fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle("My New Stage Title");
            stage.setScene(new Scene(imgWindowRoot));
            stage.show();
        }catch (IOException ioe){
            ioe.printStackTrace();
        }
    }

    public void setNewScene(ActionEvent event){
        FXMLLoader loader = new FXMLLoader();
        loaderSetup(loader);
        callInitializerBasedOnControllerName(loader);
        refreshScene(event, loader.getRoot());
    }


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
        mainEditorController.setTalkButtonCatalog(loadTalkButtonCatalog());
    }

    private void initializeControllerVariable(TalkBoxController talkBoxController, File file){
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
