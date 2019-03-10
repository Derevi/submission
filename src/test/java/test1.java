import javafx.scene.control.Button;
import talkbox.common.dataobject.TalkButton;
import talkbox.common.dataobject.TalkButtonCatalog;
import talkbox.common.dataobject.TalkButtonPage;
import talkbox.common.service.TalkButtonCatalogLoader;
import talkbox.common.service.TalkButtonCatalogSaver;
import talkbox.common.service.TalkButtonInterpretor;

import java.util.ArrayList;

public class test1 {
    public static void main(String[] args) {
        TalkButtonPage talkButtonPage = new TalkButtonPage("animal",150);
        Button button = new Button("test");

        ArrayList<TalkButton> rowOne = new ArrayList<>();
        ArrayList<TalkButton> rowTwo = new ArrayList<>();
        ArrayList<TalkButton> rowThree = new ArrayList<>();
        talkButtonPage.addRow(rowOne);
        talkButtonPage.addRow(rowTwo);
        talkButtonPage.addRow(rowThree);

        talkButtonPage.addButtonToRow(0,"cat");
        talkButtonPage.addButtonToRow(0,"dog");
        talkButtonPage.addButtonToRow(0,"bird");
        talkButtonPage.addButtonToRow(0,"cat");

        talkButtonPage.addButtonToRow(1,"Fish");
        talkButtonPage.addButtonToRow(1,"Whale");
        talkButtonPage.addButtonToRow(1,"Dolphin");
        talkButtonPage.addButtonToRow(1,"Crab");

        talkButtonPage.addButtonToRow(2,"Monkey");
        talkButtonPage.addButtonToRow(2,"Ape");
        talkButtonPage.addButtonToRow(2,"gorilla");


        TalkButtonCatalog catalog = new TalkButtonCatalog();
        catalog.addPage(talkButtonPage.getPageName(), talkButtonPage.getPage());

        System.out.println("Printing all Keys original:");
        for(String s : catalog.getCatalog().keySet()){
            System.out.println(s);
            for(ArrayList<TalkButton> row: catalog.getCatalog().get(s)){
                for(TalkButton talkButton: row){
                    System.out.println(talkButton.getName());
                }

            }
        }
        //  root.getChildren().add(new Button("TESTETSTSETSETSEt"));
        Button converted = TalkButtonInterpretor.mainAppButton(catalog.getCatalog().get("animal").get(1).get(2));
       //uncomment once there is a root pane// root.getChildren().add(converted);

        System.out.println();
        System.out.println();

        TalkButtonCatalogSaver.save(catalog);

        TalkButtonCatalog loaded = TalkButtonCatalogLoader.load("test.ser");

        System.out.println("Printing all Keys from loaded:");
        for(String s : loaded.getCatalog().keySet()){
            System.out.println(s);
            for(ArrayList<TalkButton> row: loaded.getCatalog().get(s)){
                for(TalkButton talkButton: row){
                    System.out.println(talkButton.getName());
                }

            }
        }
    }
}
