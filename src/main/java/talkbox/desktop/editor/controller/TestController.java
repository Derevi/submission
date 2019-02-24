package talkbox.desktop.editor.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import talkbox.common.dataobject.TalkButton;
import talkbox.common.dataobject.TalkButtonCatalog;
import talkbox.common.dataobject.TalkButtonInventory;

import java.net.URL;
import java.util.ResourceBundle;

public class TestController implements Initializable {

    @FXML
    GridPane gridPane;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        TalkButtonCatalog talkButtonCatalog = new TalkButtonCatalog();

        TalkButtonInventory talkButtonInventory = new TalkButtonInventory("Animals");
        talkButtonInventory.addTalkButton("Turkey");
        talkButtonInventory.addTalkButton("Cat");
        talkButtonInventory.addTalkButton("Dog");

        talkButtonCatalog.addTalkButtonInventory(talkButtonInventory);
        int row = 0;
        int column =0;
        //TalkButton talkButton = new TalkButton("tester");

      // gridPane.add(talkButtonInventory.getTalkButtons().get(0).getButton(),0,0);


        for(TalkButton talkButton: talkButtonInventory.getTalkButtons()){
            if(row>6){column++; continue;}
            //gridPane.add(talkButton.getButton(),row,column);
            gridPane.add(talkButton.getTextFieldButton(),row,column);
            talkButton.getTextField().textProperty().addListener((input, previousText,newText)->{
                talkButton.setName(newText);
            });
            row++;

        }

        Button button = new Button("PRINT");
        button.setOnAction(e->{
            System.out.println(talkButtonInventory.getTalkButtons().get(0).getName());
            System.out.println(talkButtonInventory.getTalkButtons().get(1).getName());
            System.out.println(talkButtonInventory.getTalkButtons().get(2).getName());
        });
        gridPane.add(button,4,4);



    }
}
