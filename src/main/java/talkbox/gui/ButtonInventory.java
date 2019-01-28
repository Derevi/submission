package talkbox.gui;


import javafx.scene.control.Button;

import java.util.ArrayList;
import java.util.HashSet;


public class ButtonInventory {

    String name;
    private Button selectButton;

    public ButtonInventory(String name){
        this.name = name;
        selectButton = new Button("name");
    }


    private ArrayList<TalkButton> talkButtons;
    ButtonInventory(ArrayList<TalkButton> talkButtons) {
       this.talkButtons= talkButtons;
    }

    public ArrayList<TalkButton> talkButtons() {
        return talkButtons;
    }

    public void compileAudio(){

    }




}



