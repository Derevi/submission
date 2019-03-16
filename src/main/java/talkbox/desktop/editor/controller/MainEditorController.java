package talkbox.desktop.editor.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Separator;
import javafx.scene.control.TextField;
import javafx.scene.input.InputEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import talkbox.common.dataobject.TalkButton;
import talkbox.common.dataobject.TalkButtonCatalog;
import talkbox.common.dataobject.TalkButtonPage;
import talkbox.common.service.AudioPlayer;
import talkbox.common.service.TalkButtonInterpretor;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.ResourceBundle;

public class MainEditorController implements Initializable {


    @FXML
    private AnchorPane root;

    private VBox box;
    private TalkButtonCatalog talkButtonCatalog;
    private FXMLLoader fXMLLoader = new FXMLLoader();
    private LinkedHashMap<String, ArrayList<ArrayList<Button>>> catalogFxButtons;



    @FXML
    private VBox baseVBox;


    //TODO send initializers all to service
    //TODO add roww creates new row with new button, same size and style
    //TODO add button, make '+' button be smaller than minimum so it can be filtered out
    public void setTalkButtonCatalog(TalkButtonCatalog talkButtonCatalog) {
/*
        //TODO link this to start screen controller
        this.talkButtonCatalog = talkButtonCatalog;
        this.catalogFxButtons = TalkButtonInterpretor.getFxButtonCatalog(talkButtonCatalog);
        baseVBox.setAlignment(Pos.CENTER);
        baseVBox.setSpacing(10);

        HBox keyBox = new HBox();
        keyBox.setAlignment(Pos.CENTER);
        keyBox.setSpacing(10);
        for(String s:catalogFxButtons.keySet()){
            keyBox.getChildren().add(new Button(s));
        }
        keyBox.getChildren().add(new Button("+PAGE+"));
        baseVBox.getChildren().add(1,keyBox);

        HBox initialHBoxAboveButtons = new HBox();
        initialHBoxAboveButtons.setAlignment(Pos.CENTER);
        initialHBoxAboveButtons.setSpacing(20);
        Button addIntialRowButton = new Button("++add row++");

        Separator separatorL1 =new Separator();
        separatorL1.setOrientation(Orientation.HORIZONTAL);
        separatorL1.prefWidth(200);
        separatorL1.setMinSize(300,1);
        separatorL1.setMaxSize(300,1);

        Separator separatorR1 =new Separator();
        separatorR1.setOrientation(Orientation.HORIZONTAL);
        separatorR1.setMinSize(300,1);
        separatorR1.setMaxSize(300,1);
        initialHBoxAboveButtons.getChildren().add(separatorL1);
        initialHBoxAboveButtons.getChildren().add(addIntialRowButton);
        initialHBoxAboveButtons.getChildren().add(separatorR1);
        baseVBox.getChildren().add(initialHBoxAboveButtons);


        for(ArrayList<Button> list: catalogFxButtons.get("animal")){
            HBox hbox  = new HBox();
            hbox.setAlignment(Pos.CENTER);
            hbox.setSpacing(10);
            for(Button b: list){
                hbox.getChildren().add(b);
            }
            hbox.getChildren().add(new Button("++button++"));
            baseVBox.getChildren().add(hbox);

            Button addRowButton = new Button("++add row++");
            HBox hBoxBelowButtons = new HBox();
            hBoxBelowButtons.setAlignment(Pos.CENTER);
            hBoxBelowButtons.setSpacing(20);

            Separator separatorL =new Separator();
            separatorL.setOrientation(Orientation.HORIZONTAL);
            separatorL.prefWidth(200);
            separatorL.setMinSize(300,1);
            separatorL.setMaxSize(300,1);

            Separator separatorR =new Separator();
            separatorR.setOrientation(Orientation.HORIZONTAL);
            separatorR.setMinSize(300,1);
            separatorR.setMaxSize(300,1);


            hBoxBelowButtons.getChildren().add(separatorL);
            hBoxBelowButtons.getChildren().add(addRowButton);
            hBoxBelowButtons.getChildren().add(separatorR);

            baseVBox.getChildren().add(hBoxBelowButtons);
        }

*/
    }



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        TalkButtonCatalog catalog = new TalkButtonCatalog();
        catalog.addPage("animals", 150);

        TalkButtonPage talkButtonPage = new TalkButtonPage("animals",150);
        // Button button = new Button("test");


        talkButtonPage.addRow();
        talkButtonPage.addRow();
        talkButtonPage.addRow();
        System.out.println(talkButtonPage.getPage().size());


        talkButtonPage.addButtonToRow(0,"dog");
        talkButtonPage.addButtonToRow(0,"cat");
        talkButtonPage.addButtonToRow(0,"bird");
        talkButtonPage.addButtonToRow(0,"cat");

        talkButtonPage.addButtonToRow(1,"Fish");
        talkButtonPage.addButtonToRow(1,"Whale");
        talkButtonPage.addButtonToRow(1,"Dolphin");
        talkButtonPage.addButtonToRow(1,"Crab");

        talkButtonPage.addButtonToRow(2,"Monkey");
        talkButtonPage.addButtonToRow(2,"Ape");
        talkButtonPage.addButtonToRow(2,"gorilla");
        catalog.addPage(talkButtonPage);


        talkButtonPage.getPage()
                .stream()
                .flatMap(t -> t.stream())
                .map(t-> t.getName())
                .forEach(System.out::println);
        System.out.println();

        catalog.getTalkButtonPage("animals")
                .getPage()
                .stream()
                .flatMap(t -> t.stream())
                .map(t-> t.getName())
                .forEach(System.out::println);

        System.out.println();

        LinkedHashMap<String, ArrayList<ArrayList<Button>>> fxButtonPage = TalkButtonInterpretor.getFxButtonCatalog(catalog);
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
     */




