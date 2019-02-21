package talkbox.desktop.app.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;
import talkbox.common.dataobject.TalkButton;
import talkbox.common.dataobject.TalkButtonCatalog;
import talkbox.common.service.AudioPlayer;
import talkbox.desktop.app.model.PopulateTalkButtonToUI;

import java.awt.*;
import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

public class TalkBoxController implements Initializable {
    VBox box;
    TalkButtonCatalog talkButtonCatalog;

    @FXML
    GridPane gridPane;


    public Button talkButton;

    public void talk() {
        //make this pull from list
        String userInput = "hello";
        AudioPlayer.talk(userInput);

    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {



       // PopulateTalkButtonToUI populateTalkButtonToUI = new PopulateTalkButtonToUI(talkButtonCatalog);
        Button createNewButton = new Button("Create New");
        Button loadButton = new Button("Load");



        //populateTalkButtonToUI.printTalkButtons(gridPane,"test");
        TalkButton talkButton = new TalkButton("text");
        HBox hBox = new HBox(createNewButton);



        HBox hBox1 = new HBox();
        gridPane.add(hBox,0,0);
        Text text = new Text("Enter new Name: ");
        ComboBox<String> comboBox = new ComboBox<>();
        comboBox.getItems().add("first");
        comboBox.getItems().add("second");
        comboBox.getItems().add("third");
        gridPane.add(comboBox,2,2);
        TextField textField = new TextField();
        gridPane.add(text,2,3);
        gridPane.add(textField,3,3);

        Button browseButton=new Button("Browse");

        browseButton.setOnAction(e->{
            DirectoryChooser directoryChooser = new DirectoryChooser();
            Stage stage = (Stage) gridPane.getScene().getWindow();
            File file = directoryChooser.showDialog(stage);
            System.out.println(file.getAbsoluteFile());
            for (File fileName:file.listFiles()){
                comboBox.getItems().add(fileName.getName());
            }


        });
        gridPane.add(browseButton,5,5);

    }


}