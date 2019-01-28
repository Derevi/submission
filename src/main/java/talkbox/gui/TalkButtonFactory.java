package talkbox.gui;
import talkbox.configurator.ButtonInventoryCatalog;

//creates buttons attached to audio playing events
public class TalkButtonFactory {
    ButtonInventoryCatalog buttonInventoryCatalog;

    public TalkButtonFactory(){
        buttonInventoryCatalog = new ButtonInventoryCatalog();
    }
    public TalkButton createTalkButton(ButtonInventory buttonInventory, String buttonName){
        TalkButton talkButton = new TalkButton(buttonName);

        return talkButton;
    }

    public ButtonInventory createButtonInventory(ButtonInventory buttonInventory, String name){
        buttonInventory = new ButtonInventory(name);
        buttonInventoryCatalog.addButtonInventory(buttonInventory);
        return buttonInventory;

    }

    //add button to current inventory
}
