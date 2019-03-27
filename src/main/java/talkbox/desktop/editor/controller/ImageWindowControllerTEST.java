package talkbox.desktop.editor.controller;

import javafx.collections.FXCollections;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

public class ImageWindowControllerTEST implements Initializable {

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
        HBox buttonHbox = new HBox();
        buttonHbox.setMaxSize(100,100);

        Button test = new Button("TESTOMG",buttonHbox);
        test.setMinSize(130,130);
        test.setMaxSize(130,130);
        imageWindowRoot.getChildren().add(test);

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
                            ArrayList<ImageView> imageViewArrayList = fileList.stream().map(f -> f.toURI().toString())
                                    .map(ImageView::new)
                                    .collect(Collectors.toCollection(ArrayList::new));
                            imageViewArrayList.stream().forEach(v -> {
                                v.setFitWidth(80);
                                v.setFitHeight(80);
                                //IMAGE ICONS ARE HERE SET METHODS
                                v.setOnDragDetected(e->{
                                    Dragboard db = v.startDragAndDrop(TransferMode.ANY);
                                    Image cloneImage = new Image(fileList.get(imageViewArrayList.indexOf(v)).toURI().toString(),50,50,false,false);


                                    System.out.println(fileList.get(imageViewArrayList.indexOf(v)));
                                   // buttonHbox.getChildren().add(clone);

                                   db.setDragView(v.getImage());


                                    ClipboardContent content = new ClipboardContent();
                                    content.putImage(cloneImage);
                                    db.setContent(content);
                                    e.consume();
                                });

                                test.setOnDragDropped(new EventHandler<DragEvent>() {
                                    public void handle(DragEvent event) {
                                        /* data dropped */
                                        /* if there is a string data on dragboard, read it and use it */
                                        Dragboard db = event.getDragboard();
                                        boolean success = false;
                                        if (db.hasImage()) {
                                            test.setText(db.getString());
                                            success = true;
                                            System.out.println("WORKKEEEDD");
                                        }
                                        /* let the source know whether the string was successfully
                                         * transferred and used */
                                        System.out.println("WORKKEEEDD");

                                        event.setDropCompleted(success);

                                        event.consume();
                                    }
                                });

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
        for(int i =0; i<categoryImageFileMap.get(category).size()/7;i++){
            for(int j = 0; j<7;j++){
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
