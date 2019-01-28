package talkbox.gui;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import talkbox.configurator.ButtonData;
import talkbox.configurator.ButtonSaver;
import talkbox.configurator.SerButton;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class TalkBoxController implements Initializable {
    VBox box;

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

        ArrayList<ButtonData> buttonsData = ButtonSaver.load();
        ArrayList<SerButton> buttons = new ArrayList<>();
        int row = 4;
        int i = 0;
        for (ButtonData data : buttonsData) {
            buttons.add(new SerButton(data.name));
            gridPane.add(buttons.get(i), 0, row);

            row++;
            buttons.get(i).setOnAction(e -> {
                AudioPlayer.talk(data.name);
                System.out.println("Playing:  " + data.name);

            });
            i++;
/*
        /*
        ButtonInventory buttonCollection = new ButtonInventory();
        int i=0;
        for(Button b: buttonCollection.getArrayList()){
            gridPane.add(b,i,i);
            i=i+5;
        }
    */
        }

    }
}