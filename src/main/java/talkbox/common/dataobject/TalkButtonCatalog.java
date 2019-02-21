package talkbox.common.dataobject;

import talkbox.common.service.TalkButtonCatalogSaver;

import java.io.Serializable;
import java.util.*;

public class TalkButtonCatalog implements Serializable {
    //ArrayList<ButtonInventory> catalog;
    String name;
    private LinkedHashMap<String, TalkButtonInventory> catalog;
    private static final long serialVersionUID = 1L;

    public TalkButtonCatalog(String name){
        catalog = new LinkedHashMap<>();
        this.name = name;
        TalkButtonCatalogSaver.save(catalog, name);

    }
    public TalkButtonCatalog(LinkedHashMap<String, TalkButtonInventory> catalog){
      //  catalog = TalkButtons.load();
    }

    LinkedHashMap<String, TalkButtonInventory> getButtonInventoryMap(){
        LinkedHashMap<String, TalkButtonInventory> mapClone = (LinkedHashMap<String, TalkButtonInventory>) catalog.clone();
        return mapClone;
    }


    public void addButtonInventory(TalkButtonInventory buttonInventory){
        catalog.put(buttonInventory.getName(), buttonInventory);
    }

    public void removeButtonInventory(TalkButtonInventory buttonInventory){
        if(!catalog.containsKey(buttonInventory.getName())){throw new IllegalArgumentException();}
        catalog.remove(buttonInventory.getName());
    }

    //replace button inventory
    //swap button inventory


    public TalkButtonInventory getButtonInventory(int index){
        return  catalog.get(index);
    }
    public TalkButtonInventory getButtonInventory(String name){
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
