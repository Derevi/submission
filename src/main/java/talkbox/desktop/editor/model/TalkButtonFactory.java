package talkbox.desktop.editor.model;
import talkbox.common.dataobject.TalkButtonInventory;
import talkbox.common.dataobject.TalkButtonCatalog;
import talkbox.common.dataobject.TalkButton;

public class TalkButtonFactory {
    TalkButtonCatalog talkButtonCatalog;

    public TalkButtonFactory(){
        talkButtonCatalog = new TalkButtonCatalog();
    }
    public void createTalkButton(TalkButtonInventory buttonInventory, String buttonName){
        TalkButton talkButton = new TalkButton(buttonName);
        buttonInventory.addTalkButton(talkButton);

    }

    public void createButtonInventory(TalkButtonInventory buttonInventory, String name){
        buttonInventory = new TalkButtonInventory(name);
        talkButtonCatalog.addButtonInventory(buttonInventory);
    }

    public TalkButtonInventory getButtonInventory(String name){
        return talkButtonCatalog.getButtonInventory(name);
    }


        //add button to current inventory
}
