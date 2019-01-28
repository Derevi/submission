package talkbox.configurator;


import com.sun.javafx.UnmodifiableArrayList;
import javafx.scene.control.Button;
import talkbox.gui.TalkButton;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;


public class ButtonInventory implements Serializable {


    String name;
    private Button selectButton;
    private ArrayList<TalkButton> talkButtons;
    private static final long serialVersionUID = 1L;

    public ButtonInventory(String name){
        this.name = name;
        selectButton = new Button("name");
        talkButtons = new ArrayList<>();
    }

    public List<TalkButton> getTalkButtons() {
        List<TalkButton> copy = new ArrayList<TalkButton>(talkButtons);
        return Collections.unmodifiableList(copy);
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



