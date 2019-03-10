package talkbox.common.service;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class SceneViewLoader {

    private Parent parent;
    private String pathToFXML;

    public SceneViewLoader(String pathToFXML){
    this.pathToFXML = pathToFXML;

    }

    public void setNewScene(ActionEvent event){

        try {
            Parent parent = FXMLLoader.load(getClass().getResource(pathToFXML));
            Stage newWindow=(Stage)((Node)event.getSource()).getScene().getWindow();
            newWindow.setScene(new Scene(parent));
            newWindow.show();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
