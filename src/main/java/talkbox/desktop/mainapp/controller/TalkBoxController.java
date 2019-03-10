package talkbox.desktop.mainapp.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import talkbox.common.dataobject.TalkButtonCatalog;
import talkbox.common.service.AudioPlayer;

import java.net.URL;
import java.util.ResourceBundle;

public class TalkBoxController implements Initializable {
    VBox box;
    TalkButtonCatalog talkButtonCatalog;
    private FXMLLoader fXMLLoader = new FXMLLoader();

    //@FXML
    //GridPane gridPane;
    //@FXML
    //BorderPane borderPane;
    //@FXML
    //StackPane stackPane;
    @FXML
    AnchorPane root;


    public Button talkButton;

    @FXML
    public String line;


    @FXML
    public void setprint(String line){
        this.line = line;
        System.out.println(line);
        //System.out.println(fileName.getPath());
        //System.out.println(selectedFile.getName());
    }

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
      //  initialLoadSetup.generateLoadingScreen(gridPane)
        // Button button = new Button("TEST");
      //  borderPane.setCenter(button);
        //stackPane.getChildren().add(button);
        //stackPane.setAlignment(button, Pos.CENTER);





        //TODO make load screen with two buttons, load existing or create new
        //If create New selected allows for set new name and select loadFile file
        //filepath is saved in txt





    }

    //TODO controller for loading a different talk box, or maybe just a load button
    //TODO set up grid pane to load all talk buttons


}