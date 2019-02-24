package talkbox.desktop.editor.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import talkbox.common.dataobject.TalkButton;
import talkbox.common.dataobject.TalkButtonCatalog;
import talkbox.common.dataobject.TalkButtonInventory;
import talkbox.common.service.GenerateTalkButtonsToView;

import java.net.URL;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.ResourceBundle;
import java.util.Set;

public class TestController implements Initializable {

    @FXML
    GridPane gridPane;

    @FXML
    GridPane gridPaneList;

    TalkButtonCatalog talkButtonCatalog;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
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
        //TalkButton talkButton = new TalkButton("tester");

      // gridPane.add(talkButtonInventory.getTalkButtons().get(0).getButton(),0,0);

        GenerateTalkButtonsToView.generateButtons(gridPane,talkButtonCatalog.getTalkButtonInventory("Animals"));


/*
        Button button = new Button("PRINT");
        button.setOnAction(e->{
            System.out.println(talkButtonInventory.getTalkButtons().get(0).getName());
            System.out.println(talkButtonInventory.getTalkButtons().get(1).getName());
            System.out.println(talkButtonInventory.getTalkButtons().get(2).getName());
        });

        //gridPane.add(button,4,4);
        Button button2 = new Button("PRINT");
        button2.setOnAction(e->{
            for(TalkButton talkButton: talkButtonInventory.getTalkButtons()){
                if(talkButton.getName().isEmpty()){
                    System.out.println("this is empty");
                    talkButtonInventory.removeTalkButton(talkButton);
                    generateButtons(talkButtonInventory);
                }
            }
        });

 */
        GenerateTalkButtonsToView.generateButtons(gridPane,gridPaneList,talkButtonCatalog);



    }

    private void generateButtons(TalkButtonInventory talkButtonInventory){
        gridPane.getChildren().clear();
        int row = 0;
        int column =0;
        for(TalkButton talkButton: talkButtonInventory.getTalkButtons()){
            if(row>6){column++; continue;}
            //gridPane.add(talkButton.getButton(),row,column);
            gridPane.add(talkButton.getTextFieldButton(),row,column);
            talkButton.getTextField().textProperty().addListener((input, previousText,newText)->{
                talkButton.setName(newText);
            });
            row++;
        }
    }

    private void generateButtons(LinkedHashSet<TalkButton> list){
        gridPaneList.getChildren().clear();
        int row = 5;
        int column =0;
        for(TalkButton talkButton: list){

            gridPaneList.add(talkButton.getButton(),row,column);
            talkButton.getButton().setOnAction(e->{
                generateButtons(talkButtonCatalog.getTalkButtonInventory(talkButton.getButton().getText()));
                System.out.println(talkButton.getButton().getText());
            });

            column++;
        }
    }

    private void cleanEmpty(){

    }
}
