package talkbox.gui;


import com.sun.javafx.UnmodifiableArrayList;
import javafx.scene.control.Button;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;


public class ButtonInventory {

    String name;
    private Button selectButton;
    private ArrayList<TalkButton> talkButtons;

    public ButtonInventory(String name){
        this.name = name;
        selectButton = new Button("name");
        talkButtons = new ArrayList<>();
    }

    public List<TalkButton> talkButtons() {
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


}



