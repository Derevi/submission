package talkbox.configurator;

import javafx.scene.control.Button;

import java.io.Serializable;

public class ButtonData implements Serializable {
    private static final long serialVersionUID = 1L;
    public String name;


    public ButtonData(Button button){
        name = button.getText();
    }

}
