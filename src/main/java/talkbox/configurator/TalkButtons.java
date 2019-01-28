package talkbox.configurator;

import javafx.scene.control.Button;
import talkbox.gui.TalkButton;

import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashMap;

public class TalkButtons {

    public static LinkedHashMap<String, ButtonInventory> load() {
        LinkedHashMap<String, ButtonInventory> talkButtons = new LinkedHashMap<>();
        try (
                FileInputStream fis = new FileInputStream("buttonLister.ser");
                ObjectInputStream ois = new ObjectInputStream(fis)
        ) {
            talkButtons = (LinkedHashMap<String, ButtonInventory>) ois.readObject();
        } catch (IOException ioe) {
            System.out.println("Error reading talkbuttons.ser file");
            ioe.printStackTrace();
        } catch (ClassNotFoundException cnfe) {
            System.out.println("Error loading the talkbuttons.ser file");
            cnfe.printStackTrace();
        }
        return talkButtons;
    }

    public static void save(LinkedHashMap<String, ButtonInventory> talkButtons) {
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
