package talkbox.desktop.editor.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import talkbox.common.dataobject.TalkButtonCatalog;
import talkbox.common.service.StringToAudioGenerator;
import talkbox.common.service.AudioPlayer;
import talkbox.common.dataobject.TalkButton;
import talkbox.desktop.editor.SerButton;
import talkbox.common.dataobject.TalkButtons;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ConfiguratorController implements Initializable {
//public class ConfiguratorController{
    TalkButtonCatalog catalog;

    @FXML
    Button button;

    @FXML
    GridPane gridPane;

    @FXML
    Button SaveAndCompile;


    public void load(){

    }

    public void saveAndCompile(){

    }

    public void speak(String word){
        AudioPlayer.talk(word);
    }

    public void save(){
       // TalkButtons.save(catalog.getButtonInventoryMap("test"));

    }

    public void compileAudio(){
      // for(TalkButton talkButton:catalog.getButtonInventoryMap().get("animals").getTalkButtons())
     //  StringToAudioGenerator.generateAudio(talkButton.getName());

    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


        }

    private void handleButtonAction(ActionEvent event) {
        // Button was clicked, do something…
        System.out.println("test");
    }
    private void save(ActionEvent event){

    }


    }


