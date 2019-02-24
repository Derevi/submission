package talkbox.common.dataobject;


import javafx.scene.control.Button;

import java.io.Serializable;
import java.util.ArrayList;


public class TalkButtonInventory implements Serializable {


    String name;
    private Button selectButton;
    private ArrayList<TalkButton> talkButtons;
    private static final long serialVersionUID = 1L;
    private final int numberOfColumns = 6;
    private final int numberOfRows = 4;
    public TalkButtonInventory(String name){
        this.name = name;
        selectButton = new Button("name");
        talkButtons = new ArrayList<>();
    }

    public ArrayList<TalkButton> getTalkButtons() {
        ArrayList<TalkButton> copy = (ArrayList<TalkButton>)talkButtons.clone();
        return copy;
    }



    public int getNumberOfRows() {
        return numberOfRows;
    }

    public int getNumberOfColumns() {
        return numberOfColumns;
    }



    public String getName(){
        return new String(name);
    }

    public void addTalkButton(TalkButton talkButton){
        talkButtons.add(talkButton);
    }

    public void addTalkButton(String name){
        TalkButton talkButton = new TalkButton(name);
        talkButtons.add(talkButton);
    }

    public void removeTalkButton(TalkButton talkButton){
        talkButtons.remove(talkButton);
    }

    public void removeTalkButton(int index){
        talkButtons.remove(index);
    }

    public void replaceTalkButton(String name, TalkButton talkButton ){
        talkButtons.set(talkButtons.indexOf(talkButton), new TalkButton(name));
    }

    public void getTalkButton(int index){
        talkButtons.get(index);

    }


    public int size(){
       return talkButtons.size();
    }


}



