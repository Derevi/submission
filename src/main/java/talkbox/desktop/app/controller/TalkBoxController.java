package talkbox.desktop.app.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import talkbox.common.dataobject.TalkButtonCatalog;
import talkbox.common.service.AudioPlayer;
import talkbox.desktop.app.model.InitialLoadSetup;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class TalkBoxController implements Initializable {
    VBox box;
    TalkButtonCatalog talkButtonCatalog;
    private FXMLLoader fXMLLoader = new FXMLLoader();

    @FXML
    GridPane gridPane;
    @FXML
    BorderPane borderPane;
    @FXML
    StackPane stackPane;
    AnchorPane root;


    public Button talkButton;

    public void talk() {
        //make this pull from list
        String userInput = "hello";
        AudioPlayer.talk(userInput);

    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

       // InitialLoadSetup initialLoadSetup = new InitialLoadSetup(gridPane);
       //GridPane gpane = new GridPane();
       //gpane.add(new Button("TEST"),0,0);
      //  initialLoadSetup.generateLoadingScreen(gridPane);
        Button button = new Button("TEST");
      //  borderPane.setCenter(button);
        stackPane.getChildren().add(button);
        stackPane.setAlignment(button, Pos.CENTER);





        //TODO make load screen with two buttons, load existing or create new
        //If create New selected allows for set new name and select selectDirectory file
        //filepath is saved in txt





    }
    public void loadAnother(ActionEvent event){

        try{

        GridPane gPane = fXMLLoader.load(getClass().getResource("../view/talkboxeditor.fxml"));
        gridPane.getChildren().setAll(gPane);
        }catch (IOException ioe){
            ioe.printStackTrace();
        }

    }


}