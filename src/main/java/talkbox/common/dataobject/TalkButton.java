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

    public static class Builder{
        private String name;
        private File image;
        private File audio;



        public Builder withName(String name) {
            this.name = name;
            return this;
        }

        public Builder withImage(File image){
            //TODO IF FILE IS NOT OF TYPE AUDIO THROW ERROR
            this.image = image;
            return this;
        }

        public Builder withAudio(File audio){
            //TODO IF FILE IS NOT OF TYPE AUDIO THROW ERROR
            this.audio = audio;
            return this;
        }

        public TalkButton build(){
            TalkButton talkButton = new TalkButton();
            talkButton.name = this.name;
            talkButton.image= this.image;
            talkButton.audio=this.audio;
            return talkButton;
        }



    }


    String name;
    AudioClip audioClip;
    String imageFilePath;
    String audioFilePath;
    private File image;
    private File audio;

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

    protected TalkButton(TalkButton talkButton){
        this.name = talkButton.getName();
        this.buttonSize=talkButton.getButtonSize();
    }


    protected TalkButton(String name, int buttonSize){
        this(name);
        this.buttonSize = buttonSize;
    }

    protected TalkButton(String name, int buttonSize, File imageFilePath){
        this(name, buttonSize);
        this.imageFilePath = imageFilePath.getPath();
    }

    public int getButtonSize(){
        return this.buttonSize;
    }


    public String getName(){
        String clone = new String(this.name);
        return clone;
    }

    protected void setButtonSize(int buttonSize){
        this.buttonSize = buttonSize;
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
