package talkbox.desktop.editor.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import talkbox.common.dataobject.TalkButtonCatalog;
import talkbox.common.service.FileBrowser;
import talkbox.common.service.TalkButtonCatalogSaver;

import java.io.File;
import java.net.URL;
import java.util.*;

public class TestController implements Initializable {

    @FXML
    AnchorPane root;

    @FXML
    GridPane gridPane;

    @FXML
    GridPane gridPaneList;

    @FXML
    GridPane parentDirectoryGridPane;

    @FXML
    GridPane selectedFileGridPane;

    @FXML
    TextField textField;

    @FXML
    Label selectedDirectory;

    File selectDirectory;

    TalkButtonCatalog talkButtonCatalog;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        /*
        talkButtonCatalog = new TalkButtonCatalog();

        TalkButtonInventory talkButtonInventory = new TalkButtonInventory("Animals");
        talkButtonInventory.addTalkButton("Turkey");
        talkButtonInventory.addTalkButton("Cat");
        talkButtonInventory.addTalkButton("Dog");
        talkButtonCatalog.addTalkButtonInventory(talkButtonInventory);

        TalkButtonInventory talkButtonInventory2 = new TalkButtonInventory("Colours");
        talkButtonInventory2.addTalkButton("Blue");
        talkButtonInventory2.addTalkButton("Red");
        talkButtonInventory2.addTalkButton("Black");
        talkButtonInventory2.addTalkButton("Yellow");
        talkButtonCatalog.addTalkButtonInventory(talkButtonInventory2);

        ArrayList<Button> list = new ArrayList<>();
        list.add(new Button("Animals"));
        list.add(new Button("Colours"));

        int row = 0;
        int column =0;

        Button browse = new Button("BROWSE");

        GenerateTalkButtonsToView.generateButtons(gridPane,talkButtonCatalog.getTalkButtonInventory("Animals"));



        GenerateTalkButtonsToView.generateButtons(gridPane,gridPaneList,talkButtonCatalog);

*/

    }

    @FXML
    private void save(ActionEvent event) {
        /*
        talkButtonCatalog = new TalkButtonCatalog();

        TalkButtonInventory talkButtonInventory = new TalkButtonInventory("Animals");
        talkButtonInventory.addTalkButton("Turkey");
        talkButtonInventory.addTalkButton("Cat");
        talkButtonInventory.addTalkButton("Dog");
        talkButtonCatalog.addTalkButtonInventory(talkButtonInventory);

        TalkButtonInventory talkButtonInventory2 = new TalkButtonInventory("Colours");
        talkButtonInventory2.addTalkButton("Blue");
        talkButtonInventory2.addTalkButton("Red");
        talkButtonInventory2.addTalkButton("Black");
        talkButtonInventory2.addTalkButton("Yellow");
        talkButtonCatalog.addTalkButtonInventory(talkButtonInventory2);
        */

        LinkedHashMap<String, ArrayList<String>> catalog = new LinkedHashMap<>();
        ArrayList<String> colors = new ArrayList<>();
        colors.add("blue");
        colors.add("yellow");
        colors.add("red");
        colors.add("black");
        ArrayList<String> animals = new ArrayList<>();
        animals.add("cow");
        animals.add("turtle");
        animals.add("dog");
        animals.add("salmon");
        animals.add("chicken");
        animals.add("turkey");
        catalog.put("colors", colors);
        catalog.put("animals", animals);

        TalkButtonCatalog talkBoxCatalog = new TalkButtonCatalog(catalog);

        TalkButtonCatalogSaver.save(talkBoxCatalog.getCatalogLabels(), selectDirectory,textField.getText());
    }
        @FXML
        private void browse(ActionEvent event){
            this.selectDirectory = FileBrowser.selectDirectory(event);
            updateTextLabel(selectDirectory);

        }

    private void updateTextLabel(File selectedFile){
        parentDirectoryGridPane.getChildren().clear();
        Label label = new Label("Selected Save Directory:  "+selectedFile.getAbsolutePath());
        parentDirectoryGridPane.add(label,0,0);
      //  System.out.println(selectedFile.getAbsolutePath()+File.separator+"fileNAMe.ser");
    }

    private void updateListView(File selectedFile){
        parentDirectoryGridPane.getChildren().clear();
        Label label = new Label("Selected Directory:  "+selectedFile.getParentFile().getAbsolutePath());
        parentDirectoryGridPane.setAlignment(Pos.CENTER_LEFT);
        parentDirectoryGridPane.add(label,0,0);


    }



        //TalkButtonCatalog talkButtonCatalog = new TalkButtonCatalog(TalkButtonCatalogLoader.load(fileName));








    private void cleanEmpty(){

    }
}
