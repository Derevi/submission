package talkbox.desktop.editor.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import talkbox.common.dataobject.TalkButton;
import talkbox.common.dataobject.TalkButtonCatalog;
import talkbox.common.dataobject.TalkButtonPage;
import talkbox.common.service.TalkButtonCatalogLoader;
import talkbox.common.service.TalkButtonCatalogSaver;
import talkbox.common.service.TalkButtonInterpretor;

import java.awt.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.ResourceBundle;

public class StartEditorController implements Initializable {



    @FXML
    AnchorPane root;

    @FXML
    private void load(ActionEvent event){

        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Ser Object File(*.ser)","*.ser"));
        fileChooser.setTitle("Open File");
        File file = fileChooser.showOpenDialog(new Stage());

        if (file != null) {
            try (FileWriter fw = new FileWriter(file.getAbsolutePath())) {
                System.out.println(file.getName());
                fw.write("test");
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }

        }


        try {
            Parent parent = FXMLLoader.load(getClass().getResource("../view/maineditor.fxml"));
           // Scene dashboard=new Scene(parent);
            Stage newWindow=(Stage)((Node)event.getSource()).getScene().getWindow();
            newWindow.setScene(new Scene(parent));
            newWindow.show();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }



    @FXML
    private void createNew(ActionEvent event){

        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("TalkBox Object File(*.ser)","*.ser"));
        fileChooser.setTitle("Save File");
        File file = fileChooser.showSaveDialog(new Stage());

        if (file != null) {
            try (FileWriter fw = new FileWriter(file.getAbsolutePath())) {
                System.out.println(file.getName());
                fw.write("test");
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }

        }

        try {

            Parent parent = FXMLLoader.load(getClass().getResource("../view/maineditor.fxml"));
            //Scene dashboard=new Scene(parent);
            Stage newWindow=(Stage)((Node)event.getSource()).getScene().getWindow();
            newWindow.setScene(new Scene(parent));
            newWindow.show();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @FXML
    private void save(){

    }



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //TODO use this initialization for testing
        TalkButtonPage talkButtonPage = new TalkButtonPage("animal",150);
        Button button = new Button("test");

        ArrayList<TalkButton> rowOne = new ArrayList<>();
        ArrayList<TalkButton> rowTwo = new ArrayList<>();
        ArrayList<TalkButton> rowThree = new ArrayList<>();
        talkButtonPage.addRow(rowOne);
        talkButtonPage.addRow(rowTwo);
        talkButtonPage.addRow(rowThree);

        talkButtonPage.addButtonToRow(0,"cat");
        talkButtonPage.addButtonToRow(0,"dog");
        talkButtonPage.addButtonToRow(0,"bird");
        talkButtonPage.addButtonToRow(0,"cat");

        talkButtonPage.addButtonToRow(1,"Fish");
        talkButtonPage.addButtonToRow(1,"Whale");
        talkButtonPage.addButtonToRow(1,"Dolphin");
        talkButtonPage.addButtonToRow(1,"Crab");

        talkButtonPage.addButtonToRow(2,"Monkey");
        talkButtonPage.addButtonToRow(2,"Ape");
        talkButtonPage.addButtonToRow(2,"gorilla");


        TalkButtonCatalog catalog = new TalkButtonCatalog();
        catalog.addPage(talkButtonPage.getPageName(), talkButtonPage.getPage());

        System.out.println("Printing all Keys original:");
        for(String s : catalog.getCatalog().keySet()){
            System.out.println(s);
            for(ArrayList<TalkButton> row: catalog.getCatalog().get(s)){
                for(TalkButton talkButton: row){
                    System.out.println(talkButton.getName());
                }

            }
        }
      //  root.getChildren().add(new Button("TESTETSTSETSETSEt"));
        Button converted = TalkButtonInterpretor.mainAppButton(catalog.getCatalog().get("animal").get(1).get(2));
        root.getChildren().add(converted);

        System.out.println();
        System.out.println();

        TalkButtonCatalogSaver.save(catalog);

        TalkButtonCatalog loaded = TalkButtonCatalogLoader.load("test.ser");

        System.out.println("Printing all Keys from loaded:");
        for(String s : loaded.getCatalog().keySet()){
            System.out.println(s);
            for(ArrayList<TalkButton> row: loaded.getCatalog().get(s)){
                for(TalkButton talkButton: row){
                    System.out.println(talkButton.getName());
                }

            }
        }






     //  TalkButtonCatalog anothercat = new TalkButtonCatalog(TalkButtonCatalogLoader.load("test.ser"));



    }
}
