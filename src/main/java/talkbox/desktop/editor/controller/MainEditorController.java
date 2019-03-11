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
import talkbox.common.dataobject.TalkButton;
import talkbox.common.dataobject.TalkButtonCatalog;
import talkbox.common.service.AudioPlayer;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class MainEditorController implements Initializable {


    @FXML
    private AnchorPane root;

    private TalkButtonCatalog talkButtonCatalog;




    public void setTalkButtonCatalog(TalkButtonCatalog talkButtonCatalog) {
        this.talkButtonCatalog = talkButtonCatalog;
        System.out.println("Printing all Keys from loaded:");
        for(String s : talkButtonCatalog.getCatalog().keySet()){
            System.out.println(s);
            for(ArrayList<TalkButton> row: talkButtonCatalog.getCatalog().get(s)){
                for(TalkButton talkButton: row){
                    System.out.println(talkButton.getName() + talkButton.getButtonSize());
                }

            }
        }
        System.out.println("PROPERLY LOADED FILE!!!!");
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




