package talkbox.gui;


import java.util.ArrayList;
import java.util.HashSet;


public class ButtonInventory {


    private ArrayList<TalkButton> talkButtons;
    ButtonInventory(ArrayList<TalkButton> talkButtons) {
       this.talkButtons= talkButtons;
    }

    public ArrayList<TalkButton> talkButtons() {
        return talkButtons;
    }




}



