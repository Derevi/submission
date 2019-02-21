package talkbox.common.dataobject;


import javafx.scene.control.Button;

import java.io.Serializable;
import java.util.ArrayList;


public class TalkButtonInventory implements Serializable {


    String name;
    private Button selectButton;
    private ArrayList<TalkButton> talkButtons;
    private static final long serialVersionUID = 1L;
    private int numberOfColumns;
    private int numberOfRows;
    public TalkButtonInventory(String name){
        this.name = name;
        selectButton = new Button("name");
        talkButtons = new ArrayList<>();
    }

    public ArrayList<TalkButton> getTalkButtons() {
        ArrayList<TalkButton> copy = (ArrayList<TalkButton>)talkButtons.clone();
        return copy;
    }

    public void setNumberOfRowsAndColumns(int numberOfRows, int numberOfColumns){
        if(numberOfColumns*numberOfRows>getTalkButtons().size()){throw new IllegalArgumentException();}
        this.numberOfRows =numberOfRows;
        this.numberOfColumns = numberOfColumns;
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

    public void removeTalkButton(TalkButton talkButton){
        talkButtons.remove(talkButton);
    }

    public void removeTalkButton(int index){
        talkButtons.remove(index);
    }

    public void replaceTalkButton(){

    }

    public int size(){
       return talkButtons.size();
    }


}



