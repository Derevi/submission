package talkbox.desktop.editor.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.InputEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import talkbox.common.dataobject.TalkButton;
import talkbox.common.dataobject.TalkButtonCatalog;
import talkbox.common.dataobject.TalkButtonPage;
import talkbox.common.service.AudioPlayer;
import talkbox.common.service.TalkButtonCatalogLoader;
import talkbox.common.service.TalkButtonCatalogSaver;
import talkbox.common.service.TalkButtonInterpretor;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.ResourceBundle;

public class MainEditorController implements Initializable {


    @FXML
    private AnchorPane root;

    @FXML
    private GridPane imageGrid;

    @FXML
    private AnchorPane imageWindowRoot;

    private VBox box;
    private TalkButtonCatalog talkButtonCatalog;
    private FXMLLoader fXMLLoader = new FXMLLoader();
    private LinkedHashMap<String, ArrayList<ArrayList<Button>>> catalogFxButtons;




    @FXML
    private VBox baseVBox;


    //TODO send initializers all to service
    //TODO add roww creates new row with new button, same size and style
    //TODO add button, make '+' button be smaller than minimum so it can be filtered out
    public void setTalkButtonCatalog(TalkButtonCatalog talkButtonCatalog) {

        //TODO link this to start screen controller
        //this.talkButtonCatalog = talkButtonCatalog;
       // this.catalogFxButtons = TalkButtonInterpretor.getFxButtonCatalog(talkButtonCatalog);



    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ///START OF SETUP CODE///THIS IS SET UP CODE ONLY IT WILL BE DELETED after//
        TalkButtonCatalog catalog = new TalkButtonCatalog();
        catalog.addPage("animals", 150);

        TalkButtonPage talkButtonPage = new TalkButtonPage("animals",150);
         Button imageDialog = new Button("IMAGE DIALOG");
         imageDialog.setOnAction(e->{
                try{
                    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/talkbox/desktop/editor/view/imagewindow.fxml"));
                    Parent imgWindowRoot =  fxmlLoader.load();
                    Stage stage = new Stage();
                    stage.setTitle("My New Stage Title");
                    stage.setScene(new Scene(imgWindowRoot));
                   /*
                    File imageFile = new File("objects/balloon.png");
                    Image img = new Image(imageFile.toURI().toURL().toString());
                    HBox imgBox = new HBox();
                    //for adding image:
                    ImageView imgView = new ImageView(img);
                    imgBox.getChildren().add(imgView);
                    Button imgs = new Button("image ",imgBox);
                    imageGrid.add(imgView,1 ,1);

                    //
                    */

                    stage.show();
                    // Hide this current window (if this is what you want)
                    // ((Node)(event.getSource())).getScene().getWindow().hide();
                }catch (IOException ioe){
                    ioe.printStackTrace();
                }

         });
         baseVBox.getChildren().add(imageDialog);


        talkButtonPage.addRow();
        talkButtonPage.addRow();
        talkButtonPage.addRow();
        System.out.println(talkButtonPage.getPage().size());


        talkButtonPage.addButtonToRow(0,"dog");
        talkButtonPage.addButtonToRow(0,"cat");
        talkButtonPage.addButtonToRow(0,"bird");
        talkButtonPage.addButtonToRow(0,"cat");

        talkButtonPage.addButtonToRow(1,"Fish");
        talkButtonPage.addButtonToRow(1,"Whale");
        talkButtonPage.addButtonToRow(1,"Dolphin");
        talkButtonPage.addButtonToRow(1,"Crab");

        talkButtonPage.addButtonToRow(2,"Monkey");
        talkButtonPage.addButtonToRow(2,"Ape");
        talkButtonPage.addButtonToRow(2,"gorilla");

        catalog.addPage(talkButtonPage);


        talkButtonPage.getPage()
                .stream()
                .flatMap(t -> t.stream())
                .map(t-> t.getName())
                .forEach(System.out::println);
        System.out.println();

        catalog.getTalkButtonPage("animals")
                .getPage()
                .stream()
                .flatMap(t -> t.stream())
                .map(t-> t.getName())
                .forEach(System.out::println);

        System.out.println();

        TalkButtonCatalogSaver.save(catalog);


      this.catalogFxButtons = TalkButtonInterpretor.getFxButtonCatalog(TalkButtonCatalogLoader.load("test"));

        baseVBox.setAlignment(Pos.CENTER);
        baseVBox.setSpacing(10);

        ///END OF SETUP CODE///THIS IS SET UP CODE ONLY IT WILL BE DELETED after//


        //START OF CODE THAT DRAWS BUTTON ON UI ..IT is basically one big for loop//
        HBox keyBox = new HBox();
        keyBox.setAlignment(Pos.CENTER);
        keyBox.setSpacing(10);
        for(String s:catalogFxButtons.keySet()){
            keyBox.getChildren().add(new Button(s));
        }
        keyBox.getChildren().add(new Button("+PAGE+"));
        baseVBox.getChildren().add(1,keyBox);

        HBox initialHBoxAboveButtons = new HBox();
        initialHBoxAboveButtons.setAlignment(Pos.CENTER);
        initialHBoxAboveButtons.setSpacing(20);
        Button addIntialRowButton = new Button("++add row++");

        Separator separatorL1 =new Separator();
        separatorL1.setOrientation(Orientation.HORIZONTAL);
        separatorL1.prefWidth(200);
        separatorL1.setMinSize(300,1);
        separatorL1.setMaxSize(300,1);

        Separator separatorR1 =new Separator();
        separatorR1.setOrientation(Orientation.HORIZONTAL);
        separatorR1.setMinSize(300,1);
        separatorR1.setMaxSize(300,1);
        initialHBoxAboveButtons.getChildren().add(separatorL1);
        initialHBoxAboveButtons.getChildren().add(addIntialRowButton);
        initialHBoxAboveButtons.getChildren().add(separatorR1);
        baseVBox.getChildren().add(initialHBoxAboveButtons);


        for(ArrayList<Button> list: catalogFxButtons.get("animals")){
            HBox hbox  = new HBox();
            hbox.setAlignment(Pos.CENTER);
            hbox.setSpacing(10);
            for(Button b: list){
                hbox.getChildren().add(b);
                if(b.getText().isEmpty()){

                }
                hbox.getChildren().add(addFxButton(hbox,b));
            }

            //TODO separate in to its own method and refactor
            //ADD BUTTON METHOD
            Button newb = new Button("++button++");
            newb.setOnAction(e-> {
                Button newt = new Button("test");
                hbox.getChildren().add(hbox.getChildren().size()-1, new Button());
            });
            hbox.getChildren().add(newb);
            baseVBox.getChildren().add(hbox);

            //TODO separate in to its own method and refactor
            //ADD NEW ROW METHOD
            Button addRowButton = new Button("++add row++");

            HBox hBoxBelowButtons = new HBox();
            hBoxBelowButtons.setAlignment(Pos.CENTER);
            hBoxBelowButtons.setSpacing(20);

            Separator separatorL =new Separator();
            separatorL.setOrientation(Orientation.HORIZONTAL);
            separatorL.prefWidth(200);
            separatorL.setMinSize(300,1);
            separatorL.setMaxSize(300,1);

            Separator separatorR =new Separator();
            separatorR.setOrientation(Orientation.HORIZONTAL);
            separatorR.setMinSize(300,1);
            separatorR.setMaxSize(300,1);


            hBoxBelowButtons.getChildren().add(separatorL);
            hBoxBelowButtons.getChildren().add(addRowButton);
            hBoxBelowButtons.getChildren().add(separatorR);

            baseVBox.getChildren().add(hBoxBelowButtons);
            int rowb = baseVBox.getChildren().indexOf(hBoxBelowButtons);
            //System.out.println(rowb);
            addRowButton.setOnAction(e->{
                        HBox newh = new HBox();
                        newh.setAlignment(Pos.CENTER);
                        Button newbut= new Button("tesst");
                        newbut.setMinSize(100,100);
                        newh.getChildren().add(newbut);
                        System.out.println();
                        baseVBox.getChildren().add(rowb,newh);
                        baseVBox.getChildren().add(rowb+1,new Button("++add row++"));
                    }
            );
        }
        //END OF CODE THAT DRAWS BUTTON ON UI//
    }

    //TODO @ Rachel finish add button functionality
    //TODO @ Rachel finish add row functionality
    //TODO @ Rachel create delete button functionality
    //TODO @ Rachel Each time there is a change in the talkbuttons it updates the catalog page
    //TODO @ Rachel fix issues that happens when too many buttons or rows are added
    //TODO @ Rachel add functionality that refreshes view and loads a different page when a key button at the top is clicked


    public VBox addFxButton(HBox hBox, Button addClick){
        Button add = new Button("+");
        VBox addButton = new VBox();
        addButton.setAlignment(Pos.CENTER);
        addButton.setSpacing(10);

        int index = hBox.getChildren().indexOf(addClick);
        add.setOnAction(e-> {
            Button another = new Button();
            hBox.getChildren().add(index+2,another);
            hBox.getChildren().add(index+3,addFxButton(hBox,another));
        });
        addButton.getChildren().add(verticalSeparator());
        addButton.getChildren().add(add);
        addButton.getChildren().add(verticalSeparator());
        return addButton;
    }

    public Separator verticalSeparator(){
        Separator verticalSeparatorComponent = new Separator();
        verticalSeparatorComponent.setOrientation(Orientation.VERTICAL);
        verticalSeparatorComponent.setMaxSize(3,10);
        verticalSeparatorComponent.setMinSize(3,10);
        return verticalSeparatorComponent;
    }

    public Separator horizontalSeparator(){
        Separator horizontalSeparatorComponent =new Separator();
        horizontalSeparatorComponent.setOrientation(Orientation.HORIZONTAL);
        horizontalSeparatorComponent.setMinSize(300,1);
        horizontalSeparatorComponent.setMaxSize(300,1);
        return horizontalSeparatorComponent;

    }



    //TODO FILTER METHOD: reads entire ui and gets string and image from button stores to talkbutton,
    // stops at size-1 (since the last button is an add button)
    // & does not add first row since that is the keylist
    // & does not add row with separator


    @FXML
    public void addTalkButton(int row){
        //TODO get row and add button to end of row first on talkbutton
        //TODO update FxButton catalog and refresh view
    }

    @FXML
    public void removeTalkButton(int row){
        //TODO get row and col to delected specified talkbutton
        //TODO update FxButton catalog and refresh view
    }

    @FXML
    public void addRow(int row){
        //TODO insert new row with an empty button
        //TODO Hbox with position set to right so it is in right bottom corner
    }

    private void refreshView(){
        //TODO to be done anytime there is an update to the catalog
    }

    @FXML
    public void addNewPage(){
        //TODO @ Dhruv
    }

    @FXML
    public void addPageFromAnotherCatalog(){
        //TODO @ Dhruv
    }

    @FXML
    public void loadOtherCatalog(){
        //TODO allow for loading of a different catalog via menu bar (deser)
    }

    @FXML
    public void saveCatalog(){
        //TODO saving of current catalog file (ser)
    }

    @FXML
    public void saveAsCatalog(){
        //TODO allow uses to save current selected catalog as another file (ser)
    }

    public void imageAdder(ActionEvent event){
        try {
            FXMLLoader window = FXMLLoader.load(getClass().getClassLoader().getResource("/talkbox/desktop/editor/view/imagewindow.fxml"));
            Parent newWindow = (Parent) window.load();
            Stage stage = new Stage();
            stage.setTitle("My New Stage Title");
            stage.setScene(new Scene(newWindow));
            stage.show();
            // Hide this current window (if this is what you want)
           // ((Node)(event.getSource())).getScene().getWindow().hide();
        }
        catch (IOException e) {
            e.printStackTrace();
        }

    }


    //TODO @ Rachel DRAG AND DROP ACTIONS
    //TODO @ Rachel added images



    }

    /*
            this.talkButtonCatalog = talkButtonCatalog;
        System.out.println("Printing all Keys from loaded:");
        for(String s : talkButtonCatalog.getCatalog().keySet()){
            System.out.println(s);
            for(ArrayList<TalkButton> row: talkButtonCatalog.getCatalog().get(s)){
                for(TalkButton talkButton: row){
                    System.out.println(talkButton.getName() + talkButton.getButtonSize());
                }

            }
        }
        System.out.println("PROPERLY LOADED FILE!!!!");
     */




