package talkbox.common.dataobject;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.media.AudioClip;
import talkbox.common.service.AudioPlayer;


import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;

public class TalkButton implements Serializable {

    String name;
    AudioClip audioClip;
    String imageFilePath;
    String audioFilePath;

    private int buttonSize;



    private static final long serialVersionUID = 1L;

    protected TalkButton(){
        this.name = " ";
        this.buttonSize = 150;
    }


    protected TalkButton(String name){
        this.name = name;
        this.buttonSize = 130;
    }


    protected TalkButton(String name, int buttonSize){
        this(name);
        this.buttonSize = buttonSize;
    }

    protected TalkButton(String name, int buttonSize, File imageFilePath){
        this(name, buttonSize);
        this.imageFilePath = imageFilePath.getPath();
    }

    protected void setButtonSize(int buttonSize){
        this.buttonSize = buttonSize;
    }

    protected int getButtonSize(){
        return this.buttonSize;
    }


    protected String getName(){
        return this.name;
    }

    protected void setImage(File file){
        this.imageFilePath = file.getPath();
    }

    protected void generateAudio(){

    }

    protected void speak(){
        AudioPlayer.talk(name);
    }





}
