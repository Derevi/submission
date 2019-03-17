package talkbox.common.service;

import talkbox.common.dataobject.TalkButton;
import talkbox.common.dataobject.TalkButtonCatalog;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.LinkedHashMap;

public class TalkButtonCatalogSaver {

    public static void save( TalkButtonCatalog catalog) {
        try (
                FileOutputStream fos = new FileOutputStream("test.ser");
                ObjectOutputStream oos = new ObjectOutputStream(fos)
        ) {
            oos.writeObject(catalog);
        } catch (IOException ioe) {
            System.out.println("Error saving TalkButtons");
            ioe.printStackTrace();
        }

    }

}
