package talkbox.desktop.editor.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.InputEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import talkbox.common.service.AudioPlayer;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainEditorController implements Initializable {



    @FXML
    private GridPane gridPane;

    @FXML
    private AnchorPane root;

    @FXML
    private Button SaveAndCompile;

    @FXML
    private String fileName;

    @FXML
    private File selectedDirectory;

    @FXML
    private File selectedFile;

    @FXML
    private TextField textField;

    @FXML
    private void back(ActionEvent event){
        try {
            //AnchorPane anchorPane = FXMLLoader.load(getClass().getResource("../view/starteditor.fxml"));
           // root.getChildren().setAll(anchorPane);


            AnchorPane anchorPane = FXMLLoader.load(getClass().getResource("../view/starteditor.fxml"));
            anchorPane.getStylesheets().add(getClass().getResource("../../styles.css").toExternalForm());
            root.getScene();

           // primaryStage.setScene(anchorPane);

          //  primaryStage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void print(){
       // System.out.println(fileName);
       // System.out.println(selectedFile.getName());
    }


    public void initialSetup(String name, File selectedDirectory){
        //this.fileName = name;
        //this.selectedDirectory = selectedDirectory;

        //use name to generate the TalkButonCatalog
      // System.out.println(name);

    }

    public void initialSetup(File selectedFile){
      //  this.fileName = selectedFile.getName();
        //this.selectedFile = selectedFile;

        //use name to generate the TalkButonCatalog
       // System.out.println(fileName);

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


