package talkbox.desktop.app.model;

import javafx.scene.layout.GridPane;
import talkbox.common.dataobject.TalkButton;
import talkbox.common.dataobject.TalkButtonCatalog;
import talkbox.common.dataobject.TalkButtonInventory;

import java.util.ArrayList;

public class PopulateTalkButtonToUI {
    TalkButtonCatalog talkButtonCatalog;
    int numberOfColumns;
    int numberOfRows;

    public PopulateTalkButtonToUI(TalkButtonCatalog talkButtonCatalog){
        this.talkButtonCatalog = talkButtonCatalog;
    }



    public void printTalkButtons(GridPane gridPane, String talkButtonInventoryName){

        ArrayList<TalkButton> talkButtons = talkButtonCatalog.getTalkButtonInventory(talkButtonInventoryName).getTalkButtons();
        numberOfRows = talkButtonCatalog.getTalkButtonInventory(talkButtonInventoryName).getNumberOfRows();
        numberOfColumns = talkButtonCatalog.getTalkButtonInventory(talkButtonInventoryName).getNumberOfColumns();

        int index = 0;
        for(int row = 0; row<numberOfRows;row++){
            for(int column = 0; row<numberOfRows;row++) {
                if(talkButtons.size()-1<index){return;};
                gridPane.add(talkButtons.get(index).getButton(), row, column);
                index++;
            }
        }

    }

}
