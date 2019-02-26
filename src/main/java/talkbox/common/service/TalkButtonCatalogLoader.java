package talkbox.common.service;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.LinkedHashMap;

public class TalkButtonCatalogLoader {


    public static LinkedHashMap<String, ArrayList<String>> load(String fileName) {
        LinkedHashMap<String, ArrayList<String>>  talkButtonCatalog = new LinkedHashMap<>();
        try (
                FileInputStream fis = new FileInputStream("serbutton.ser");
                ObjectInputStream ois = new ObjectInputStream(fis);
        ) {
            talkButtonCatalog = (LinkedHashMap<String, ArrayList<String>>) ois.readObject();
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
