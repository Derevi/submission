package talkbox.catalogedit;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.ResourceBundle;

//import javafx.scene.control.Button;

public class EditCatalogController implements Initializable {


    public LinkedHashMap<Button, ArrayList<Button>> defaultMap = new LinkedHashMap<>();
    //private LinkedHashMap<Button, ArrayList<Button>> loadedMap = new LinkedHashMap<>();
    public ArrayList<Button> defaultArr;
    @FXML
    private ListView<Button> catalogList = new ListView<>();
    @FXML
    private ListView<Button> innerList = new ListView<>();
    @FXML
    AnchorPane rootpane;
    FXMLController controller;



    public EditCatalogController(){
    defaultInit();
    }

    public void init(FXMLController controller){
        this.controller = controller;
    }

    @FXML
    public void loadCatalog(ActionEvent event){
        Stage stage = new Stage();
        FileChooser file = new FileChooser();
        file.setTitle("Open Resource File");
        file.showOpenDialog(stage);

    }

    public void defaultInit(){
        ArrayList<Button> animals = new ArrayList<>();
        animals.add(new Button("Dog"));
        animals.add(new Button("Cat"));

        ArrayList<Button> Emojis = new ArrayList<>();
        Emojis.add(new Button("Smile face"));
        Emojis.add(new Button("Happy face"));
        ArrayList<Button> Sounds = new ArrayList<>();
        Sounds.add(new Button("Waves"));
        Sounds.add(new Button("Engine"));
        ArrayList<Button> Music = new ArrayList<>();
        Music.add(new Button("Hip-hop"));
        Music.add(new Button("Rock"));
        ArrayList<Button> Fruits = new ArrayList<>();
        Fruits.add(new Button("Apple"));
        Fruits.add(new Button("Orange"));

        defaultMap.put(new Button("Animals"),animals);
        defaultMap.put(new Button("Emojis"),Emojis);
        defaultMap.put(new Button("Sounds"),Sounds);
        defaultMap.put(new Button("Music"),Music);
        defaultMap.put(new Button("Fruits"),Fruits);
        innerList.setEditable(false);
    }


    @FXML
    public void handlebtnPage(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("NewButtonPage.fxml"));
        rootpane.getChildren().setAll(pane);
    }



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //System.out.println("OneTimdsfs");




        for( Map.Entry<Button,ArrayList<Button>> entry : defaultMap.entrySet() ){
            catalogList.getItems().add(entry.getKey());
            entry.getKey().setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    innerList.getItems().clear();
                    for(int x =0;x<entry.getValue().size();x++){

                        innerList.getItems().add(entry.getValue().get(x));
                    }
                }
            });
            catalogList.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        }



    }
}
