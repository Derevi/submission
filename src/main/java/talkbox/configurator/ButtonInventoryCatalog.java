package talkbox.configurator;

import talkbox.gui.TalkButton;

import java.io.Serializable;
import java.util.*;

public class ButtonInventoryCatalog implements Serializable {
    //ArrayList<ButtonInventory> catalog;
    String name;
    private LinkedHashMap<String, ButtonInventory> catalog;
    private static final long serialVersionUID = 1L;

    public ButtonInventoryCatalog(){
     //catalog = new ArrayList<>();
     catalog = new LinkedHashMap<>();
     ButtonInventory greets = new ButtonInventory("greets");
     TalkButton hello = new TalkButton("hello"); greets.addTalkButton(hello);
     TalkButton greetings = new TalkButton("greetings"); greets.addTalkButton(greetings);
     TalkButton salutations = new TalkButton("salutations"); greets.addTalkButton(salutations);
     TalkButton yo = new TalkButton("yo");greets.addTalkButton(yo);
     TalkButton sup = new TalkButton("sup");greets.addTalkButton(sup);
        catalog.put(greets.getName(), greets);


        ButtonInventory animals = new ButtonInventory("animals");
        TalkButton cow = new TalkButton("cow");animals.addTalkButton(cow);
        TalkButton chicken = new TalkButton("chicken");animals.addTalkButton(chicken);
        TalkButton turtle = new TalkButton("turtle");animals.addTalkButton(turtle);
        TalkButton bear = new TalkButton("bear");animals.addTalkButton(bear);
        TalkButton hawk = new TalkButton("hawk");animals.addTalkButton(hawk);
        catalog.put(animals.getName(), animals);

        ButtonInventory colors = new ButtonInventory("colors");
        TalkButton blue = new TalkButton("blue");colors.addTalkButton(blue);
        TalkButton green = new TalkButton("green");colors.addTalkButton(green);
        TalkButton yellow = new TalkButton("yellow");colors.addTalkButton(yellow);
        TalkButton black = new TalkButton("black");colors.addTalkButton(black);
        TalkButton red = new TalkButton("red");colors.addTalkButton(red);
        catalog.put(colors.getName(), colors);

    }
    public ButtonInventoryCatalog(LinkedHashMap<String, ButtonInventory> catalog){
      //  catalog = TalkButtons.load();
    }

    LinkedHashMap<String, ButtonInventory> getButtonInventoryMap(){
        LinkedHashMap<String, ButtonInventory> mapClone = (LinkedHashMap<String, ButtonInventory>) catalog.clone();
        return mapClone;
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
