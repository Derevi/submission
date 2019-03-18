package talkbox.catalogedit;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.ResourceBundle;

//import javafx.scene.control.Button;

public class EditCatalogController implements Initializable, EventHandler<ActionEvent> {


    public LinkedHashMap<Button, ArrayList<String>> defaultMap = new LinkedHashMap<>();
    public ArrayList<String> defaultArr;
    @FXML
    private ListView<Button> catalogList = new ListView<>();
    @FXML
    private ListView<String> innerList = new ListView<>();
    @FXML
    AnchorPane rootpane;
    FXMLController controller;

    @FXML
    private Label selectedBtnPage;

    private TextField txtName= new TextField(), txtNumBtns=new TextField(), txtMaxRows= new TextField(), txtMaxCols = new TextField();
    private Button btnAddPage = new Button(), btnCancel = new Button();

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
        ArrayList<String> animals = new ArrayList<>();
        animals.add("Dog");
        animals.add("Cat");

        ArrayList<String> Emojis = new ArrayList<>();
        Emojis.add("Smile face");
        Emojis.add("Happy face");
        ArrayList<String> Sounds = new ArrayList<>();
        Sounds.add("Waves");
        Sounds.add("Engine");
        ArrayList<String> Music = new ArrayList<>();
        Music.add("Hip-hop");
        Music.add("Rock");
        ArrayList<String> Fruits = new ArrayList<>();
        Fruits.add("Apple");
        Fruits.add("Orange");

        defaultMap.put(new Button("Animals"), animals);
        defaultMap.put(new Button("Emojis"),Emojis);
        defaultMap.put(new Button("Sounds"),Sounds);
        defaultMap.put(new Button("Music"),Music);
        defaultMap.put(new Button("Fruits"),Fruits);
        innerList.setEditable(false);
    }


    @FXML
    public void handlebtnPage(ActionEvent event) throws IOException {

        final Stage dialog = new Stage();
        dialog.initModality(Modality.APPLICATION_MODAL);
        //dialog.initOwner(primaryStage);
        GridPane dialogVbox = new GridPane();
        dialogVbox.add(new Text("Create a new Button Page"), 2,1);
        dialogVbox.add(new Text("Name: "), 2,3);
        dialogVbox.add(txtName,3,3);

        dialogVbox.add(new Text("Number of Buttons: "), 2, 4);
        dialogVbox.add(txtNumBtns,3,4);

        dialogVbox.add(new Text("Max number of Buttons per Rows: "), 2, 5);
        dialogVbox.add(txtMaxRows,3,5);

        dialogVbox.add(new Text("Max number of Buttons per Columns: "), 2, 6);
        dialogVbox.add(txtMaxCols,3,6);
        btnAddPage.setText("Add Button Page");
        btnCancel.setText("Cancel");
        dialogVbox.add(btnAddPage, 2,7);
        dialogVbox.add(btnCancel, 3, 7);

        btnAddPage.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                dialog.close();
                defaultMap.put(new Button(txtName.getText()),new ArrayList<>());
                catalogList.getItems().clear();
                for( Map.Entry<Button,ArrayList<String>> entry : defaultMap.entrySet() ){
                    catalogList.getItems().add(entry.getKey());
                    entry.getKey().setOnAction(this);

                    catalogList.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

                }
            }
        });

        btnCancel.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                dialog.close();
            }
        });

        Scene dialogScene = new Scene(dialogVbox, 400, 200);
        dialog.setScene(dialogScene);
        dialog.show();



      //  AnchorPane pane = FXMLLoader.load(getClass().getResource("NewButtonPage.fxml"));
     //   rootpane.getChildren().setAll(pane);
    }



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        //selectedBtnPage = new Label();
        for( Map.Entry<Button,ArrayList<String>> entry : defaultMap.entrySet() ){
            catalogList.getItems().add(entry.getKey());
            entry.getKey().setOnAction(this);

            catalogList.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        }
    }

    public void handle(ActionEvent actionEvent) {
        innerList.getItems().clear();
        Button btn = (Button) actionEvent.getSource();
        if(defaultMap.containsKey(btn)){
            selectedBtnPage.setText(btn.getText());
        defaultMap.get(btn).forEach(name  -> innerList.getItems().add(name));

        }
    }
}
