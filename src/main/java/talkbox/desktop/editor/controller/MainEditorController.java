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
    public String line;


    @FXML
    public void setprint(String line){
        this.line = line;
        System.out.println(line);
       //System.out.println(fileName.getPath());
       //System.out.println(selectedFile.getName());
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //TODO load fxButtonCatalog in to View, keyset, pages and all buttons


    }


    @FXML
    public void addTalkButton(int row){
        //TODO get row and add button to end of row first on talkbutton
        //TODO update FxButton catalog and refresh view
    }

    @FXML
    public void removeTalkButton(int row){
        //TODO get row and col to delected specified talkbutton
        //TODO update FxButton catalog and refresh view
    }

    @FXML
    public void addRow(int row){
        //TODO insert new row with an empty button
    }

    private void refreshView(){
        //TODO to be done anytime there is an update to the catalog
    }

    @FXML
    public void addNewPage(){
        //TODO @ Dhruv
    }

    @FXML
    public void addPageFromAnotherCatalog(){
        //TODO @ Dhruv
    }

    @FXML
    public void loadOtherCatalog(){
        //TODO allow for loading of a different catalog via menu bar (deser)
    }

    @FXML
    public void saveCatalog(){
        //TODO saving of current catalog file (ser)
    }

    @FXML
    public void saveAsCatalog(){
        //TODO allow uses to save current selected catalog as another file (ser)
    }


    //TODO @ Rachel DRAG AND DROP ACTIONS
    //TODO @ Rachel added images



    }



    /*



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

        TalkButtonCatalog talkButtonCatalog = new TalkButtonCatalog(TalkButtonCatalogLoader.load(selectedFile.getAbsolutePath()));
        ArrayList<TalkButton> talkButtonsList = talkButtonCatalog.getTalkButtonCatalogMap().get(0).getTalkButtons();



private void handleButtonAction(ActionEvent event) {
        // Button was clicked, do something…
        System.out.println("test");
        }
private void save(ActionEvent event){

        }



        */


