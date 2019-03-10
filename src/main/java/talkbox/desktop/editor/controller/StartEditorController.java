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

        TalkButtonPage talkButtonPage = new TalkButtonPage("animal",150);
        Button button = new Button("test");

        ArrayList<TalkButton> rowOne = new ArrayList<>();
        rowOne.add(new TalkButton("cat",130));
        rowOne.add(new TalkButton("dog",130));
        rowOne.add(new TalkButton("bird",130));

        ArrayList<TalkButton> rowTwo = new ArrayList<>();
        rowTwo.add(new TalkButton("Fish",130));
        rowTwo.add(new TalkButton("Whale",130));
        rowTwo.add(new TalkButton("Dolphin",130));
        rowTwo.add(new TalkButton("Crab",130));


        ArrayList<TalkButton> rowThree = new ArrayList<>();
        rowThree.add(new TalkButton("Monkey",130));
        rowThree.add(new TalkButton("Ape",130));
        rowThree.add(new TalkButton("gorilla",130));

        talkButtonPage.add(rowOne);
        talkButtonPage.add(rowTwo);
        talkButtonPage.add(rowThree);

        TalkButtonCatalog catalog = new TalkButtonCatalog();
        catalog.put("animals",talkButtonPage.getPage());

        System.out.println("Printing all Keys original:");
        for(String s : catalog.getCatalog().keySet()){
            System.out.println(s);
            for(TalkButton talkButton: catalog.getCatalog().get(s).get(0)){
                System.out.println(talkButton.getName());
            }
        }
      //  root.getChildren().add(new Button("TESTETSTSETSETSEt"));
        root.getChildren().add(TalkButtonInterpretor.mainAppButton(catalog.getCatalog().get("animals").get(1).get(1)));

        System.out.println();
        System.out.println();

        LinkedHashMap<String, ArrayList<ArrayList<Button>>> fxCat = TalkButtonInterpretor.getFxButtonCatalog(catalog);

        root.getChildren().add(fxCat.get("animals").get(1).get(1));
        System.out.println("TEST FROM CONVERTED TABLE");
        for(String s : fxCat.keySet()){
            System.out.println(s);
            for(ArrayList<Button> row: fxCat.get(s)){
                for(Button button1: row){
                    System.out.println(button1.getText());
                }

            }
        }



      //  TalkButtonCatalogSaver.save(catalog.getCatalog());



     //  TalkButtonCatalog anothercat = new TalkButtonCatalog(TalkButtonCatalogLoader.load("test.ser"));



    }
}
