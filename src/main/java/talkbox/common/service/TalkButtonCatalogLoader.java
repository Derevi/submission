package talkbox.common.service;

import talkbox.common.dataobject.TalkButtonInventory;
import talkbox.common.dataobject.TalkButtons;

import java.awt.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.LinkedHashMap;

public class TalkButtonCatalogLoader {

    void createLoadButton(){

    }

    public static LinkedHashMap<String, TalkButtonInventory> load(String fileName) {
        LinkedHashMap<String, TalkButtonInventory>  talkButtonCatalog = new LinkedHashMap<>();
        try (
                FileInputStream fis = new FileInputStream("serbutton.ser");
                ObjectInputStream ois = new ObjectInputStream(fis);
        ) {
            talkButtonCatalog = (LinkedHashMap<String, TalkButtonInventory>) ois.readObject();
        } catch (IOException ioe) {
            System.out.println("Error reading button catalog file");
            ioe.printStackTrace();
        } catch (ClassNotFoundException cnfe) {
            System.out.println("Error reading button catalog file");
            cnfe.printStackTrace();
        }
        return talkButtonCatalog;
    }

}