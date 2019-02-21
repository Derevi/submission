package talkbox.common.service;

import talkbox.common.dataobject.TalkButtons;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.LinkedHashMap;

public class TalkButtonCatalogSaver {

    public static void save(LinkedHashMap<String, TalkButtons> talkButtonCatalog, String fileName) {
        //TODO allow user to specify .ser filename
        try (
                FileOutputStream fos = new FileOutputStream("serbutton.ser");
                ObjectOutputStream oos = new ObjectOutputStream(fos)
        ) {
            oos.writeObject(talkButtonCatalog);
        } catch (IOException ioe) {
            System.out.println("Error saving TalkButtons");
            ioe.printStackTrace();
        }

    }
}
