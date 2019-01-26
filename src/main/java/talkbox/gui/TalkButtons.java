package talkbox.gui;

import javafx.scene.control.Button;

import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;

public class TalkButtons {

    public static ArrayList<TalkButton> load() {
        ArrayList<TalkButton> talkButtons = new ArrayList<>();
        try (
                FileInputStream fis = new FileInputStream("buttonLister.ser");
                ObjectInputStream ois = new ObjectInputStream(fis)
        ) {
            talkButtons = (ArrayList<TalkButton>) ois.readObject();
        } catch (IOException ioe) {
            System.out.println("Error reading talkbuttons.ser file");
            ioe.printStackTrace();
        } catch (ClassNotFoundException cnfe) {
            System.out.println("Error loading the talkbuttons.ser file");
            cnfe.printStackTrace();
        }
        return talkButtons;
    }

    public static void save(ArrayList<TalkButton> talkButtons) {
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
