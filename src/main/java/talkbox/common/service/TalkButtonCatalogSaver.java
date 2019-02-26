package talkbox.common.service;

import talkbox.common.dataobject.TalkButton;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.LinkedHashMap;

public class TalkButtonCatalogSaver {

    public static void save(LinkedHashMap<String, ArrayList<String>> talkButtonCatalog, File selectedDirectory, String fileName) {
        //TODO allow user to specify .ser filename
        try (
                FileOutputStream fos = new FileOutputStream(selectedDirectory.getAbsolutePath()+fileName+".ser");
                ObjectOutputStream oos = new ObjectOutputStream(fos)
        ) {
            oos.writeObject(talkButtonCatalog);
        } catch (IOException ioe) {
            System.out.println("Error saving TalkButtons");
            ioe.printStackTrace();
        }

    }

    public static void save(LinkedHashMap<TalkButton, ArrayList<TalkButton>> talkButtonCatalog, String fileName) {
        //TODO allow user to specify .ser filename
        try (
                FileOutputStream fos = new FileOutputStream(fileName+".ser");
                ObjectOutputStream oos = new ObjectOutputStream(fos)
        ) {
            oos.writeObject(talkButtonCatalog);
        } catch (IOException ioe) {
            System.out.println("Error saving TalkButtons");
            ioe.printStackTrace();
        }

    }
}
