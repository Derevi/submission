package talkbox.desktop.editor;

import javafx.scene.control.Button;

import java.io.Serializable;

public class SerButton extends Button implements Serializable {
    private static final long serialVersionUID = 1L;

    public SerButton(String name){
        super(name);
    }
}
