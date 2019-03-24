package talkbox.desktop.editor.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ImageWindowController implements Initializable {

    @FXML
    GridPane imageGrid;

    @FXML
    ListView<String> imageCategories;

    @FXML
    private AnchorPane imageWindowRoot;

    private ArrayList<File> imageFileList;
    private ArrayList<File> images;
    private ArrayList<String> categories;

    private LinkedHashMap<String, ArrayList<ImageView>> categoryImageFileMap;
    private LinkedHashMap<String, ArrayList<File>> categoryFileMap;




    @Override
    public void initialize(URL location, ResourceBundle resources) {
        File imageDirectory = new File("Icon Images");
      imageFileList = new ArrayList<>(Arrays.asList(imageDirectory.listFiles()));
       // categories = imageFileList.stream().map(File::getName).collect(Collectors.toCollection(ArrayList::new));

        categoryFileMap = imageFileList.stream()
                .collect(Collectors.toMap(
                        File::getName,
                        file ->{
                            return new ArrayList<>(Arrays.asList(file.listFiles()));
                        },
                        (key, value) -> key,
                        LinkedHashMap::new));

        categoryImageFileMap = imageFileList.stream()
                .collect(Collectors.toMap(
                        File::getName,
                        file ->{
                            ArrayList<File> fileList = new ArrayList<>(Arrays.asList(file.listFiles()));

                            ArrayList<ImageView> imageViewArrayList = fileList.stream().map(f -> f.toURI().toString()).map(ImageView::new).collect(Collectors.toCollection(ArrayList::new));

                            imageViewArrayList.stream().forEach(v -> {
                                v.setFitWidth(80);
                                v.setFitHeight(80);
                            });

                            return imageViewArrayList;
                            },
                        (key, value) -> key,
                        LinkedHashMap::new));



        imageCategories.setItems(FXCollections.observableList(new ArrayList<>(Arrays.asList(imageDirectory.listFiles())).stream()
                .map(File::getName)
                .collect(Collectors.toCollection(ArrayList::new))));

        imageCategories.setOnMouseClicked(e->{
            imageGrid.getChildren().clear();
            System.out.println(imageCategories.getSelectionModel().getSelectedItem());
            generateImageGrid(imageCategories.getSelectionModel().getSelectedItem());

        });



        //ArrayList<String> filesInImageDirectory = new ArrayList<>();
        //filesInImageDirectory.stream().collect(imageDirectory.getName())
        //categoryImageFileMap.entrySet().stream().collect(File)
/*
        try{
            File imageFile = new File("objects/balloon.png");
            Image img = new Image(imageFile.toURI().toString());
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
        */

    }

    //TODO add scroll pane for images on gridpane
    public void generateImageGrid(String category){
        //categoryFileMap.get(category).stream().map(s-> new ImageView(s.toURI().toString())).filter( j->)
        int counter =0;
        for(int i =0; i<categoryImageFileMap.get(category).size()/5;i++){
            for(int j = 0; j<5;j++){
                imageGrid.add(categoryImageFileMap.get(category).get(counter),j,i);
                counter++;
            }
        }
       /* IntStream.range(0,categoryFileMap.get(category).size())
                .forEach(i -> {
                    IntStream.range(0,5).forEach(j -> {
                        imageGrid.add(categoryImageFileMap.get(category).get(i+j),i,j)
                    });
                    i++;
                });
*/
    }




}
