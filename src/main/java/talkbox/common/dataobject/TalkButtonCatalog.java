package talkbox.common.dataobject;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedHashMap;

public class TalkButtonCatalog implements Serializable {

    LinkedHashMap<String, ArrayList<ArrayList<TalkButton>>> catalog; //Consider converting this to a page
    private static final long serialVersionUID = 1L;

    public TalkButtonCatalog() {
        this.catalog = new LinkedHashMap<>();
    }

    public TalkButtonCatalog(LinkedHashMap<String, ArrayList<ArrayList<TalkButton>>> catalog) {
        this.catalog = catalog;
    }

    public void addPage(String pageName, ArrayList<ArrayList<TalkButton>> page){
        //TODO add max limit for page
        catalog.put(pageName,page);
    }

    public void addPage(String pageName){
        //TODO add max limit for page
        catalog.put(pageName,new ArrayList<ArrayList<TalkButton>>());
    }

    public ArrayList<ArrayList<TalkButton>> getTalkButtonPage(String pageName){
        return catalog.get(pageName);
    }

    public LinkedHashMap<String, ArrayList<ArrayList<TalkButton>>> getCatalog(){
        LinkedHashMap<String, ArrayList<ArrayList<TalkButton>>> clone = (LinkedHashMap<String, ArrayList<ArrayList<TalkButton>>>) catalog.clone();
        return  clone;
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