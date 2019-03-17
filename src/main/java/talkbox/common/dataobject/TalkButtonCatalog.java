package talkbox.common.dataobject;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedHashMap;

public class TalkButtonCatalog implements Serializable {

   LinkedHashMap<String, TalkButtonPage> catalog;
    private static final long serialVersionUID = 1L;

    public TalkButtonCatalog() {
        this.catalog = new LinkedHashMap<>();

    }

    public TalkButtonCatalog(LinkedHashMap<String, TalkButtonPage> catalog) {
        this.catalog = catalog;
    }

    public void addPage(String pageName, TalkButtonPage page){
        //TODO add max limit for page
        catalog.put(pageName,page);
    }

    public TalkButtonPage getPage(String pageName){
        return this.getCatalog().get(pageName);
    }

    public void addPage(String pageName, int buttonSize){
        //TODO add max limit for page
        catalog.put(pageName,new TalkButtonPage(pageName,buttonSize));
    }


    public void addPage(String pageName){
        //TODO add max limit for page
        catalog.put(pageName,new TalkButtonPage(pageName));
    }
    public void addPage(TalkButtonPage talkButtonPage){
        //TODO add max limit for page
        catalog.put(talkButtonPage.getPageName(),talkButtonPage);
    }

    public TalkButtonPage getTalkButtonPage(String pageName){
        return catalog.get(pageName);
    }

    public LinkedHashMap<String, TalkButtonPage> getCatalog(){
        return  ( LinkedHashMap<String, TalkButtonPage>) catalog.clone();
    }

    public void setTalkButtonPageButtonSize(String pageName, int size){
        this.catalog.get(pageName).setButtonSizeForPage(size);
    }

    public void setPageImageRootDirectory(String pageName, File imageDirectory){
        //TODO set directory from where images are pulled
    }

    public void setPageAudioFileRootDirectory(String pageName, File audioFileDirectory){
        //TODO set directory from where audio are pulled
    }

}

/*
    LinkedHashMap<String, ArrayList<String>> catalogLabels;
    LinkedHashMap<String, ArrayList<TalkButton>> catalog;
    private Button button;
    private TextField textField;
    private final int texFieldHeight = 30;
    private final int textFieldWidth = 130;
    private final int buttonSize = 150;
    private static final long serialVersionUID = 1L;
    String name;

    public TalkButtonCatalog() {
        this.catalogLabels = new LinkedHashMap<>();

    }

    public TalkButtonCatalog(LinkedHashMap<String, ArrayList<String>> catalogLabels) {
        this.catalogLabels = catalogLabels;
    }


    public LinkedHashMap<String, ArrayList<String>> getCatalogLabels(){
        return catalogLabels;
    }

    public ArrayList<TalkButton> getTalkButtonInventory(String listKeyName){
        ArrayList<TalkButton> talkButtons = new ArrayList<>();

        for(String name:catalogLabels.get(listKeyName)){
            talkButtons.add(new TalkButton(name));
        }
        return talkButtons;
    }

    public void replace(String key, String newName, TalkButton talkButton){
        int index = catalog.get(key).indexOf(talkButton);
        catalog.get(key).set(index,new TalkButton(newName));
    }

    public void delete(String key, TalkButton talkButton){
        catalog.get(key).remove(talkButton);
    }

    public void add(String key, String name){
        catalog.get(key).add(new TalkButton(name));
    }



    public ArrayList<TalkButton> getKeySetButtons(){
        ArrayList<TalkButton> talkButtons = new ArrayList<>();
        for(String name:catalogLabels.keySet()){
            talkButtons.add(new TalkButton(name));
        }
        return talkButtons;
    }

*/