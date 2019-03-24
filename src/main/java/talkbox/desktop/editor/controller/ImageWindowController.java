package talkbox.desktop.editor.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.ResourceBundle;

public class ImageWindowController implements Initializable {

    @FXML
    GridPane imageGrid;

    @FXML
    ListView<String> imageCategories;
    @FXML
    private AnchorPane imageWindowRoot;

    private ArrayList<File> imageFileList;

    private LinkedHashMap<String, ArrayList<ImageView>> categoryImageFileMap;




    @Override
    public void initialize(URL location, ResourceBundle resources) {
        File imageDirectory = new File("Icon Images");
        for(File f : imageDirectory.listFiles()){
            System.out.println(f.getName());
        }
        //imageFileList = (ArrayList<File>)Arrays.asList(imageDirectory.listFiles());
        //ArrayList<String> filesInImageDirectory = new ArrayList<>();
        //filesInImageDirectory.stream().collect(imageDirectory.getName())
        //categoryImageFileMap.entrySet().stream().collect(File)

        try{
            File imageFile = new File("objects/balloon.png");
            Image img = new Image(imageFile.toURI().toURL().toString());
            ImageView imgView = new ImageView(img);
            imgView.setFitHeight(100);
            imgView.setFitWidth(100);
            Button imgButton = new Button("test", imgView);
            imgView.setOnMouseClicked(event -> {
                System.out.println("CLICKED THE IMAGE");

            });

            imageGrid.add(imgView,0 ,0);
          //  imageGrid.add(imgButton,1 ,1);
        }catch (IOException ioe){
            ioe.printStackTrace();
        }

    }


}
