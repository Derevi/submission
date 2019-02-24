package talkbox.common.service;

import talkbox.common.dataobject.TalkButtonInventory;
import talkbox.common.dataobject.TalkButtons;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.LinkedHashMap;

public class TalkButtonCatalogSaver {

    public static void save(LinkedHashMap<String, TalkButtonInventory> talkButtonCatalog, File selectedDirectory, String fileName) {
        //TODO allow user to specify .ser filename
        try (
                FileOutputStream fos = new FileOutputStream(selectedDirectory.getAbsolutePath()+File.separator+"serbutton.ser");
                ObjectOutputStream oos = new ObjectOutputStream(fos)
        ) {
            oos.writeObject(talkButtonCatalog);
        } catch (IOException ioe) {
            System.out.println("Error saving TalkButtons");
            ioe.printStackTrace();
        }

    }
}
