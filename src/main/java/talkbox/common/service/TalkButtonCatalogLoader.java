package talkbox.common.service;

import talkbox.common.dataobject.TalkButton;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.LinkedHashMap;

public class TalkButtonCatalogLoader {


    public static  LinkedHashMap<String, ArrayList<ArrayList<TalkButton>>> load(String fileName) {
        LinkedHashMap<String, ArrayList<ArrayList<TalkButton>>> catalog = new LinkedHashMap<>();
        try (
                FileInputStream fis = new FileInputStream("test.ser");
                ObjectInputStream ois = new ObjectInputStream(fis);
        ) {
            catalog = ( LinkedHashMap<String, ArrayList<ArrayList<TalkButton>>>) ois.readObject();
        } catch (IOException ioe) {
            System.out.println("Error reading button catalog file");
            ioe.printStackTrace();
        } catch (ClassNotFoundException cnfe) {
            System.out.println("Error reading button catalog file");
            cnfe.printStackTrace();
        }
        return catalog;
    }

}
