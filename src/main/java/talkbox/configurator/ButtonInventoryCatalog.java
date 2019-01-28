package talkbox.configurator;

import talkbox.gui.ButtonInventory;
import talkbox.gui.TalkButton;

import java.util.*;

public class ButtonInventoryCatalog {
    //ArrayList<ButtonInventory> catalog;
    String name;
    LinkedHashMap<String, ButtonInventory> catalog;

    public ButtonInventoryCatalog(){
     //catalog = new ArrayList<>();
     catalog = new LinkedHashMap<>();
    }


    public void addButtonInventory(ButtonInventory buttonInventory){
        catalog.put(buttonInventory.getName(), buttonInventory);
    }

    public void removeButtonInventory(ButtonInventory buttonInventory){
        if(!catalog.containsKey(buttonInventory.getName())){throw new IllegalArgumentException();}
        catalog.remove(buttonInventory.getName());
    }

    //replace button inventory
    //swap button inventory


    public ButtonInventory getButtonInventory(int index){
        return  catalog.get(index);
    }
    public ButtonInventory getButtonInventory(String name){
        return  catalog.get(name);
    }

    public int size(){
        return catalog.size();
    }

    public int totalAudioButtons(){
        int sum = 0;
        for(String name:catalog.keySet()){
            sum = sum + catalog.get(name).size();

        }
        return sum;
    }

    public Set<String> getKeys(){
        return catalog.keySet();
    }

    public int totalButtons(){
        return totalAudioButtons() + catalog.size();
    }
}
