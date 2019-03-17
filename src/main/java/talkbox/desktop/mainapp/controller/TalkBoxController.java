package talkbox.desktop.mainapp.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Separator;
import javafx.scene.layout.*;
import talkbox.common.dataobject.TalkButton;
import talkbox.common.dataobject.TalkButtonCatalog;
import talkbox.common.dataobject.TalkButtonPage;
import talkbox.common.service.AudioPlayer;
import talkbox.common.service.TalkButtonCatalogLoader;
import talkbox.common.service.TalkButtonCatalogSaver;
import talkbox.common.service.TalkButtonInterpretor;

import java.net.URL;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.ResourceBundle;

public class TalkBoxController implements Initializable {
    VBox box;
    TalkButtonCatalog talkButtonCatalog;
    private FXMLLoader fXMLLoader = new FXMLLoader();
    LinkedHashMap<String, ArrayList<ArrayList<Button>>> catalogFxButtons;


    @FXML
    AnchorPane root;

    @FXML
    private VBox baseVBox;

    public Button talkButton;


    //TODO delete this mVar after as it was only for testing
    @FXML
    public String line;

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

        for(ArrayList<Button> list: catalogFxButtons.get("animals")){
            HBox hbox  = new HBox();
            hbox.setAlignment(Pos.CENTER);
            hbox.setSpacing(10);
            for(Button b: list){
                hbox.getChildren().add(b);
            }
            hbox.getChildren().add(new Button("++button++"));
            baseVBox.getChildren().add(hbox);
        }
*/
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

        TalkButtonCatalogSaver.save(catalog);


        this.catalogFxButtons = TalkButtonInterpretor.getFxButtonCatalog(TalkButtonCatalogLoader.load("test"));

        baseVBox.setAlignment(Pos.CENTER);
        baseVBox.setSpacing(10);

        HBox keyBox = new HBox();
        keyBox.setAlignment(Pos.CENTER);
        keyBox.setSpacing(10);
        for(String s:catalogFxButtons.keySet()){
            keyBox.getChildren().add(new Button(s));
        }
        baseVBox.getChildren().add(1,keyBox);



        for(ArrayList<Button> list: catalogFxButtons.get("animals")){
            HBox hbox  = new HBox();
            hbox.setAlignment(Pos.CENTER);
            hbox.setSpacing(10);
            for(Button b: list){
                hbox.getChildren().add(b);
            }
            baseVBox.getChildren().add(hbox);

        }
    }


    @FXML
    public void loadOtherCatalog(){
        //TODO allow for loading of a different catalog via menu bar (deser)
    }


}