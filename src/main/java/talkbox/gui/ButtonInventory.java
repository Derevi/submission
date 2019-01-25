package talkbox.gui;

import javafx.scene.control.Button;

import java.util.ArrayList;

public class ButtonInventory {


    ArrayList<Button> buttonList;

    ButtonInventory(){
        buttonList = new ArrayList<>();
    }


    public ArrayList<Button> getArrayList() {
        return buttonList;
    }
}
