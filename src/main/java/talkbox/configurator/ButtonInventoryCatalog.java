package talkbox.configurator;

import java.io.Serializable;
import java.util.*;

public class ButtonInventoryCatalog implements Serializable {
    //ArrayList<ButtonInventory> catalog;
    String name;
    LinkedHashMap<String, ButtonInventory> catalog;
    private static final long serialVersionUID = 1L;

    public ButtonInventoryCatalog(){
     //catalog = new ArrayList<>();
     catalog = new LinkedHashMap<>();
    }
    public ButtonInventoryCatalog(LinkedHashMap<String, ButtonInventory> catalog){
        catalog = TalkButtons.load();
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
