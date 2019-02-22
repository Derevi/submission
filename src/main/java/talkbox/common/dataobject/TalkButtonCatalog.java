package talkbox.common.dataobject;

import talkbox.common.service.TalkButtonCatalogLoader;
import talkbox.common.service.TalkButtonCatalogSaver;

import java.io.Serializable;
import java.util.*;

public class TalkButtonCatalog implements Serializable {
    //ArrayList<ButtonInventory> catalog;
    String name;
    private LinkedHashMap<String, TalkButtonInventory> catalog;
    private static final long serialVersionUID = 1L;

    public TalkButtonCatalog(){
        catalog = new LinkedHashMap<>();
    }

    public void TalkButtonCatalogLoad(String catalogName){
        catalog = TalkButtonCatalogLoader.load(catalogName);
        this.name = catalogName;
    }

    public void TalkButtonCatalogSave(String catalogName){
        this.name = catalogName;
        TalkButtonCatalogSaver.save(catalog, catalogName);
    }


    public LinkedHashMap<String, TalkButtonInventory> getTalkButtonCatalogMap(){
        LinkedHashMap<String, TalkButtonInventory> mapClone = (LinkedHashMap<String, TalkButtonInventory>) catalog.clone();
        return mapClone;
    }


    public void addTalkButtonInventory(TalkButtonInventory talkButtonInventory){
        catalog.put(talkButtonInventory.getName(), talkButtonInventory);
    }

    public void removeTalkButtonInventory(String buttonInventoryName){
        if(!catalog.containsKey(buttonInventoryName)){throw new IllegalArgumentException();}
        catalog.remove(buttonInventoryName);
    }

    public TalkButtonInventory getTalkButtonInventory(int index){
        return  catalog.get(index);
    }
    public TalkButtonInventory getTalkButtonInventory(String name){
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

    public Set<String> getTalkButtonCatalogKeys(){
       return getTalkButtonCatalogMap().keySet();
    }

    public int totalButtons(){
        return totalAudioButtons() + catalog.size();
    }
}