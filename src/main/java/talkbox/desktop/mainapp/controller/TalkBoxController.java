package talkbox.desktop.mainapp.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import talkbox.common.dataobject.TalkButtonCatalog;
import talkbox.common.dataobject.TalkButtonPage;
import talkbox.common.service.AudioPlayer;
import talkbox.common.service.StringToAudioGenerator;
import talkbox.common.service.TalkButtonCatalogLoader;
import talkbox.common.service.TalkButtonCatalogSaver;
import TOBEREMOVED.TalkButtonInterpretor;

import java.net.URL;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.ResourceBundle;

public class TalkBoxController implements Initializable {
    VBox box;
    TalkButtonCatalog talkButtonCatalog;
    private FXMLLoader fXMLLoader = new FXMLLoader();
    private LinkedHashMap<String, ArrayList<ArrayList<Button>>> catalogFxButtons;


    @FXML
    AnchorPane root;

    @FXML
    private VBox baseVBox;
    @FXML
    private HBox toggleBox;

    public Button talkButton;


    //TODO delete this mVar after as it was only for testing
    @FXML
    private String line;

    public void setTalkButtonCatalog(TalkButtonCatalog talkButtonCatalog) {
        /*

*/
    }

    public LinkedHashMap<String, ArrayList<ArrayList<Button>>> convertTalkButtonCatalogToFxButtons(){
        //TODO replace intialization with call to conversion method
        LinkedHashMap<String, ArrayList<ArrayList<Button>>> catalogFxButtons = new LinkedHashMap<>();
        return catalogFxButtons;
    }

    //TODO delete this method after as it was only for testing
    @FXML
    public void setprint(String line){
        this.line = line;
        System.out.println(line);
        //System.out.println(fileName.getPath());
        //System.out.println(selectedFile.getName());
    }

    public void talk() {
        //make this pull from list
        String userInput = "hello";
        AudioPlayer.talk(userInput);

    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


        this.catalogFxButtons = TalkButtonInterpretor.getFxButtonCatalog(TalkButtonCatalogLoader.load("test"));
        compileAudio();

        baseVBox.setAlignment(Pos.CENTER);
        baseVBox.setSpacing(10);
        toggleBox.setSpacing(10);
        this.baseVBox.prefWidthProperty().bind(root.widthProperty());
        this.toggleBox.prefWidthProperty().bind(root.widthProperty());

        HBox keyBox = new HBox();
        keyBox.setAlignment(Pos.CENTER);
        keyBox.setSpacing(10);
        for(String s:catalogFxButtons.keySet()){
            Button button = new Button(s);
            button.setMaxSize(160,160);
            button.setMinSize(160,160);
            button.setOnAction(e->{
                render(button.getText());
            });
            toggleBox.getChildren().add(button);
        }




    }

    private void render(String pageName){
        baseVBox.getChildren().clear();
        for(ArrayList<Button> list: catalogFxButtons.get(pageName)){
            HBox hbox  = new HBox();
            hbox.setAlignment(Pos.CENTER);
            hbox.setSpacing(10);
            for(Button b: list){
                hbox.getChildren().add(b);
                b.setOnAction(e->{
                    AudioPlayer.talk(b.getText());
                });
            }
            baseVBox.getChildren().add(hbox);

        }
    }

    private void compileAudio(){
        catalogFxButtons.entrySet()
                .stream()
                .map(b ->b.getValue())
                .flatMap(m->m.stream())
                .flatMap(d->d.stream())
                .forEach(button ->{
                    StringToAudioGenerator.generateAudio(button.getText());
                });
    }


    @FXML
    public void loadOtherCatalog(){
        //TODO allow for loading of a different catalog via menu bar (deser)
    }


}