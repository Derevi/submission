package talkbox.configurator;

import java.io.*;
import java.util.ArrayList;

public class ButtonSaver {
    public static ArrayList<ButtonData>  load() {
        ArrayList<ButtonData>  talkButtons = new ArrayList<>();
        try (
                FileInputStream fis = new FileInputStream("serbutton.ser");
                ObjectInputStream ois = new ObjectInputStream(fis)
        ) {
            talkButtons = (ArrayList<ButtonData>) ois.readObject();
        } catch (IOException ioe) {
            System.out.println("Error reading talkbuttons.ser file");
            ioe.printStackTrace();
        } catch (ClassNotFoundException cnfe) {
            System.out.println("Error loading the talkbuttons.ser file");
            cnfe.printStackTrace();
        }
        return talkButtons;
    }

    public static void save(ArrayList<ButtonData> talkButtons) {
        //TODO allow user to specify .ser filename
        try (
                FileOutputStream fos = new FileOutputStream("serbutton.ser");
                ObjectOutputStream oos = new ObjectOutputStream(fos)
        ) {
            oos.writeObject(talkButtons);
        } catch (IOException ioe) {
            System.out.println("Error saving TalkButtons");
            ioe.printStackTrace();
        }

    }
}
