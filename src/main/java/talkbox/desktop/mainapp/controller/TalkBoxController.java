package talkbox.desktop.mainapp.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import talkbox.common.dataobject.TalkButtonCatalog;
import talkbox.common.service.AudioPlayer;

import java.net.URL;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.ResourceBundle;

public class TalkBoxController implements Initializable {
    VBox box;
    TalkButtonCatalog talkButtonCatalog;
    private FXMLLoader fXMLLoader = new FXMLLoader();

    @FXML
    AnchorPane root;

    private
    TalkButtonCatalog catalog;

    public Button talkButton;

    @FXML
    public String line;

    public void setTalkButtonCatalog(TalkButtonCatalog talkButtonCatalog) {
        //TODO link this to start screen controller
        this.talkButtonCatalog = talkButtonCatalog;
    }

    public LinkedHashMap<String, ArrayList<ArrayList<Button>>> convertTalkButtonCatalogToFxButtons(){
        //TODO replace intialization with call to conversion method
        LinkedHashMap<String, ArrayList<ArrayList<Button>>> catalogFxButtons = new LinkedHashMap<>();
        return catalogFxButtons;
    }

    //TODO delete this method after as it was only for testing
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
        //TODO load fxButtonCatalog in to View, keyset, pages and all buttons
    }


    @FXML
    public void loadOtherCatalog(){
        //TODO allow for loading of a different catalog via menu bar (deser)
    }


}