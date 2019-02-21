package talkbox.common.dataobject;

import java.io.*;
import java.util.LinkedHashMap;

public class TalkButtons {

    public static LinkedHashMap<String, TalkButtonInventory> load() {
        LinkedHashMap<String, TalkButtonInventory> talkButtons = new LinkedHashMap<>();
        try (
                FileInputStream fis = new FileInputStream("buttonLister.ser");
                ObjectInputStream ois = new ObjectInputStream(fis)
        ) {
            talkButtons = (LinkedHashMap<String, TalkButtonInventory>) ois.readObject();
        } catch (IOException ioe) {
            System.out.println("Error reading talkbuttons.ser file");
            ioe.printStackTrace();
        } catch (ClassNotFoundException cnfe) {
            System.out.println("Error loading the talkbuttons.ser file");
            cnfe.printStackTrace();
        }
        return talkButtons;
    }

    public static void save(LinkedHashMap<String, TalkButtonInventory> talkButtons) {
        //TODO allow user to specify .ser filename
        try (
                FileOutputStream fos = new FileOutputStream("talkbuttons.ser");
                ObjectOutputStream oos = new ObjectOutputStream(fos)
        ) {
            oos.writeObject(talkButtons);
        } catch (IOException ioe) {
            System.out.println("Error saving TalkButtons");
            ioe.printStackTrace();
        }

    }
}
