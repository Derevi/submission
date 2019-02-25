package talkbox.desktop.editor.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.InputEvent;
import javafx.scene.layout.GridPane;
import talkbox.common.dataobject.TalkButtonCatalog;
import talkbox.common.service.AudioPlayer;
import talkbox.common.dataobject.TalkButton;
import talkbox.common.service.TalkButtonCatalogLoader;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class MainEditorController implements Initializable {


    @FXML
    Button button;

    @FXML
    GridPane gridPane;

    @FXML
    Button SaveAndCompile;

    @FXML
    private String fileName;

    @FXML
    private File selectedDirectory;

    @FXML
    public TextField textField;

    public void initialSetup(String name, File selectedDirectory){
        this.fileName = name;
        this.selectedDirectory = selectedDirectory;

        //use name to generate the TalkButonCatalog
      // System.out.println(name);

    }

    public void initialSetup(File selectedFile){
        this.fileName = selectedFile.getName();
        this.selectedDirectory = selectedFile.getParentFile();

        //use name to generate the TalkButonCatalog
       // System.out.println(name);

    }

    public void load(){

            //precondition talkbuttoncatalogMap must not be empty.
            //load key set to a gridPane
            //load all other talkbuttons to othergrid pane


    }

    public void saveAndCompile(){
        //save the current progress
        //compile all audio

    }

    public void speak(String word){
        //play audio upon button click
        AudioPlayer.talk(word);
    }

    public void save(){
        //saves catalog
       // TalkButtons.save(catalog.getButtonInventoryMap("test"));

    }

    public void compileAudio(){
        //compiles audio
      // for(TalkButton talkButton:catalog.getButtonInventoryMap().get("animals").getTalkButtons())
     //  StringToAudioGenerator.generateAudio(talkButton.getName());

    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {





    }

    private void inputTextField(InputEvent inputEvent){
      /*
        TalkButtonCatalog talkButtonCatalog = new TalkButtonCatalog(TalkButtonCatalogLoader.load(selectedFile.getAbsolutePath()));
        ArrayList<TalkButton> talkButtonsList = talkButtonCatalog.getTalkButtonCatalogMap().get(0).getTalkButtons();
    */
    }

    private void handleButtonAction(ActionEvent event) {
        // Button was clicked, do something…
        System.out.println("test");
    }
    private void save(ActionEvent event){

    }

    //TODO implement all above methods
    //TODO implement method to create new button and add to grid pane
    //TODO remove button from grid pane
    //TODO update and link FXML file and controller


    }

