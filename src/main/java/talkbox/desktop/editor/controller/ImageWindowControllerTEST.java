package talkbox.desktop.editor.controller;

import javafx.collections.FXCollections;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.SnapshotParameters;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import talkbox.common.dataobject.TalkButton;
import talkbox.common.dataobject.TalkButtonPage;

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

//TODO Refactor ALL METHODS for Drag and drop


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        int counter=0;
        for(int i = 1; i<=3;i++){
            for(int j = 1; j<=5;j++){
                System.out.printf("Button b%d = new Button(\" NUMBER: %s\"); gridPane.add(b%d,%d,%d);buttonList.add(b%d);\n",counter,String.valueOf(counter).toUpperCase(),counter,j,i,counter);
                counter++;
            }

         }
        ArrayList<Button> buttonList = new ArrayList<>();

        imageWindowRoot.getChildren().clear();
        GridPane gridPane = new GridPane();
        Button b0 = new Button(" NUMBER: 0"); gridPane.add(b0,1,1);buttonList.add(b0);
        Button b1 = new Button(" NUMBER: 1"); gridPane.add(b1,2,1);buttonList.add(b1);
        Button b2 = new Button(" NUMBER: 2"); gridPane.add(b2,3,1);buttonList.add(b2);
        Button b3 = new Button(" NUMBER: 3"); gridPane.add(b3,4,1);buttonList.add(b3);
        Button b4 = new Button(" NUMBER: 4"); gridPane.add(b4,5,1);buttonList.add(b4);
        Button b5 = new Button(" NUMBER: 5"); gridPane.add(b5,1,2);buttonList.add(b5);
        Button b6 = new Button(" NUMBER: 6"); gridPane.add(b6,2,2);buttonList.add(b6);
        Button b7 = new Button(" NUMBER: 7"); gridPane.add(b7,3,2);buttonList.add(b7);
        Button b8 = new Button(" NUMBER: 8"); gridPane.add(b8,4,2);buttonList.add(b8);
        Button b9 = new Button(" NUMBER: 9"); gridPane.add(b9,5,2);buttonList.add(b9);
        Button b10 = new Button(" NUMBER: 10"); gridPane.add(b10,1,3);buttonList.add(b10);
        Button b11 = new Button(" NUMBER: 11"); gridPane.add(b11,2,3);buttonList.add(b11);
        Button b12 = new Button(" NUMBER: 12"); gridPane.add(b12,3,3);buttonList.add(b12);
        Button b13 = new Button(" NUMBER: 13"); gridPane.add(b13,4,3);buttonList.add(b13);
        Button b14 = new Button(" NUMBER: 14"); gridPane.add(b14,5,3);buttonList.add(b14);
        imageWindowRoot.getChildren().add(gridPane);

        buttonList.forEach(b->{
           // DataFormat buttonFormat = new DataFormat("talkbox.common.dataobject.TalkButtonPage");
            TalkButtonPage talkButtonPage = new TalkButtonPage("test");
            b.setUserData(talkButtonPage);
            b.setOnDragDetected(e->{
                Dragboard db = b.startDragAndDrop(TransferMode.COPY_OR_MOVE);
                ClipboardContent content = new ClipboardContent();
                TalkButtonPage tp = (TalkButtonPage) b.getUserData();
                content.putString(Integer.toString(buttonList.indexOf(b)));
                //File imageFile = new File("buttondragimage.PNG");
                //Image dragIcon= new Image(imageFile.toURI().toString(),50,50,false,false);

                db.setDragView(b.snapshot(new SnapshotParameters(),null),0,0);


                db.setContent(content);
            });

            b.setOnDragOver(e->{
                e.acceptTransferModes(TransferMode.COPY);
            });

            b.setOnDragDropped(e->{
                Dragboard db = e.getDragboard();
                System.out.println(db.getString());
                gridPane.getChildren().remove(Integer.parseInt(db.getString()));
                System.out.println(buttonList.indexOf(b));


            });

            b.setOnMouseDragged(event -> {
                Button clone = new Button(b.getText());
                clone.setTranslateX(event.getSceneX());
                clone.setTranslateY(event.getSceneY());
                clone.setOnMouseReleased(event1 -> {

                });
            });


        });


        Button dragger = new Button("DRAG ME");

        double initialX = dragger.getTranslateX();
        double initialY = dragger.getTranslateY();

        dragger.setOnDragDetected(e->{
            Dragboard db =dragger.startDragAndDrop(TransferMode.COPY);
            db.setDragView(dragger.snapshot(null, null), e.getX(), e.getY());
        });



/*
        dragger.setOnMouseDragged(event -> {

            dragger.setTranslateX(event.getSceneX());
            dragger.setTranslateY(event.getSceneY());

            dragger.setOnMouseReleased(e->{
                System.out.println("INITIAL X AND Y IS: "+initialX +" "+initialY);
                dragger.setTranslateX(initialX);
                dragger.setTranslateY(initialY);
                imageWindowRoot.setOnDragDropped(event1 -> {
                    System.out.println("dropped");
                });
            });

            //dragger.getTranslateX();
            //dragger.getTranslateY();
        });
*/

        //imageWindowRoot.getChildren().add(dragger);
        HBox buttonHbox = new HBox();

        buttonHbox.setMaxSize(100,100);
        buttonHbox.setMinSize(100,100);
        buttonHbox.setAlignment(Pos.CENTER);

        Button test = new Button("TESTOMG",buttonHbox);
        test.setAlignment(Pos.CENTER);
        test.setMinSize(130,130);
        test.setMaxSize(130,130);
        //imageWindowRoot.getChildren().add(test);

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
                                    Image cloneImage = new Image(fileList.get(imageViewArrayList.indexOf(v)).toURI().toString(),70,70,false,false);


                                    System.out.println(fileList.get(imageViewArrayList.indexOf(v)));
                                   // buttonHbox.getChildren().add(clone);




                                    ClipboardContent content = new ClipboardContent();
                                    content.putString(fileList.get(imageViewArrayList.indexOf(v)).toString());
                                    content.putImage(cloneImage);
                                    //CHANGE OFFSET HERE
                                    db.setDragView(cloneImage,-10,-10);
                                    db.setContent(content);
                                    e.consume();
                                });

                                test.setOnDragOver(event-> {

                                        /* data dropped */
                                        /* if there is a string data on dragboard, read it and use it */

                                        Dragboard db = event.getDragboard();
                                        System.out.println("STRING WORKED:  "+db.getString());
                                        File imageFile = new File(db.getString());
                                        System.out.println("FILE TRANS WORKED:  "+imageFile.getPath());
                                        boolean success = false;
                                        if (db.hasImage()) {
                                            test.setText(db.getString());
                                            success = true;
                                            System.out.println("WORKKEEEDD");
                                        }
                                        /* let the source know whether the string was successfully
                                         * transferred and used */

                                        test.setOnDragDropped(e->{
                                            buttonHbox.getChildren().clear();
                                            ImageView imageView = new ImageView(db.getImage());
                                            imageView.maxWidth(100);
                                            imageView.minWidth(100);
                                            imageView.minHeight(100);
                                            imageView.maxHeight(100);

                                            buttonHbox.getChildren().add(imageView);
                                        });

                                        event.acceptTransferModes(TransferMode.ANY);

                                        System.out.println("DROPPED");

                                        event.consume();

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
