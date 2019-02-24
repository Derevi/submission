package talkbox.common.service;

import javafx.scene.layout.GridPane;
import talkbox.common.dataobject.TalkButton;
import talkbox.common.dataobject.TalkButtonCatalog;
import talkbox.common.dataobject.TalkButtonInventory;

import java.util.LinkedHashSet;

public class GenerateTalkButtonsToView {

    public static void generateButtons(GridPane gridPaneTalkButtons, TalkButtonInventory talkButtonInventory){
        gridPaneTalkButtons.getChildren().clear();
        int row = 0;
        int column =0;
        for(TalkButton talkButton: talkButtonInventory.getTalkButtons()){
            if(row>6){column++; continue;}
            gridPaneTalkButtons.add(talkButton.getTextFieldButton(),row,column);
            talkButton.getTextField().textProperty().addListener((input, previousText,newText)->{
                talkButton.setName(newText);
            });
            row++;
        }
    }

    public static void generateButtons(GridPane gridPaneTalkButtons, GridPane gridPaneTalkButtonInvetories, TalkButtonCatalog talkButtonCatalog){
        gridPaneTalkButtons.getChildren().clear();
        int row = 5;
        int column =0;
        for(TalkButton talkButton: talkButtonCatalog.getKeysAsButtons()){
            gridPaneTalkButtons.add(talkButton.getButton(),column,row);
            talkButton.getButton().setOnAction(e->{
                generateButtons(gridPaneTalkButtonInvetories, talkButtonCatalog.getTalkButtonInventory(talkButton.getButton().getText()));
                System.out.println(talkButton.getButton().getText());
            });
            column++;
        }
    }

    private void cleanEmpty(){

    }
}
