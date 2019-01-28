package talkbox.configurator;
import talkbox.gui.TalkButton;

public class TalkButtonFactory {
    ButtonInventoryCatalog buttonInventoryCatalog;

    public TalkButtonFactory(){
        buttonInventoryCatalog = new ButtonInventoryCatalog();
    }
    public void createTalkButton(ButtonInventory buttonInventory, String buttonName){
        TalkButton talkButton = new TalkButton(buttonName);
        buttonInventory.addTalkButton(talkButton);

    }

    public void createButtonInventory(ButtonInventory buttonInventory, String name){
        buttonInventory = new ButtonInventory(name);
        buttonInventoryCatalog.addButtonInventory(buttonInventory);
    }

    public ButtonInventory getButtonInventory(String name){
        return buttonInventoryCatalog.getButtonInventory(name);
    }


        //add button to current inventory
}
