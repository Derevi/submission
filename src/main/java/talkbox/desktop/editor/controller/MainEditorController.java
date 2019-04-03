package talkbox.desktop.editor.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import talkbox.common.dataobject.TalkButtonCatalog;
import talkbox.common.dataobject.TalkButtonPage;
import talkbox.common.service.*;
import talkbox.desktop.editor.model.*;

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

    @FXML
    private HBox toggleBox;

    private VBox box;
    private TalkButtonCatalog talkButtonCatalog;
    private FXMLLoader fXMLLoader = new FXMLLoader();
    private LinkedHashMap<String, ArrayList<ArrayList<Button>>> catalogFxButtons;
    private LinkedHashMap<String, ArrayList<HBox>> hBoxArrayListMap;

    @FXML
    private VBox baseVBox;

    @FXML
    private Button removeButton;

    @FXML
    private HBox keyBox;

    public void setTalkButtonCatalog(TalkButtonCatalog talkButtonCatalog) {
        //TODO link this to start screen controller
        //this.talkButtonCatalog = talkButtonCatalog;
       // this.catalogFxButtons = TalkButtonInterpretor.getFxButtonCatalog(talkButtonCatalog);
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        intializeUIComponents();
        renderGUI();

        //THIS LINE HERE LOADS A NEW WINDOW
        ImageWindowController imageWindowController = new ImageWindowController();
        SceneViewLoader.loadNewWindow(imageWindowController,"/talkbox/desktop/editor/view/imagewindow.fxml");

    }

    @FXML
    public void removeButtons(){
        EditorFXButtonActionSetupUtility.deleteButtons(removeButton, hBoxArrayListMap);
    }


    private void intializeUIComponents(){
        bindNodeContainerSize();
        loadCatalog();
        initializeMaps(new EditorAppTalkButtonInterpretor(this.talkButtonCatalog));
    }

    private void bindNodeContainerSize(){
        this.baseVBox.prefWidthProperty().bind(root.widthProperty());
        this.toggleBox.prefWidthProperty().bind(root.widthProperty());
    }

    private void loadCatalog(){
        this.talkButtonCatalog = TalkButtonCatalogLoader.load("test");
    }

    private void initializeMaps(EditorAppTalkButtonInterpretor editorAppTalkButtonInterpretor){
        this.catalogFxButtons = editorAppTalkButtonInterpretor.getMapOfFxButtonCatalog();
        this.hBoxArrayListMap = editorAppTalkButtonInterpretor.getMapOfHBoxArrayList();
        EditorUtilityFXButtons.setupMapWithUtilities(this.hBoxArrayListMap, baseVBox);
    }

    private void renderGUI() {
        DynamicFXElementsRenderer.render(hBoxArrayListMap, baseVBox, toggleBox);
    }


/*

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

    void drawAddRowElements(){
        HBox hBox = new HBox();
        hBox.setAlignment(Pos.CENTER);
        hBox.setSpacing(20);
        Button addRowButton = new Button("++add row++");
        hBox.getChildren().add(horizontalSeparator());
        hBox.getChildren().add(addRowButton);
        hBox.getChildren().add(horizontalSeparator());
        baseVBox.getChildren().add(hBox);
        int rowb = baseVBox.getChildren().indexOf(hBox);
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
    void printCatalogElementTest(){

        this.talkButtonCatalog.getPage("pokemon").getPage()
                .stream()
                .flatMap(t -> t.stream())
                .map(t-> t.getName())
                .forEach(System.out::println);

        System.out.println();

        this.talkButtonCatalog.getPage("animals")
                .getPage()
                .stream()
                .flatMap(t -> t.stream())
                .map(t-> t.getName())
                .forEach(System.out::println);

    }
    void drawButtons(){

        //SETUP FOR BUTTON THAT LOADS EMOJI WINDOW
        SceneViewLoader sceneViewLoader = new SceneViewLoader("/talkbox/desktop/editor/view/imagewindow.fxml");
        Button imageDialog = new Button("IMAGE DIALOG");
        imageDialog.setOnAction(e->{
            sceneViewLoader.createNewSceneWindow();
        });
        baseVBox.getChildren().add(imageDialog);
        //END OF SETUP FOR BUTTON THAT LOADS EMOJI WINDOW



        //SETUP FOR TOGGLE GROUP OF CATEGORY BUTTONS
       // PageFXToggles pageFXToggles = new PageFXToggles(catalogFxButtons.keySet());
       // HBox keyBox = pageFXToggles.getButtonPageToggleBox();
        //baseVBox.getChildren().add(1, keyBox);




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
    //TODO @ Rachel finish add button functionality
    //TODO @ Rachel finish add row functionality
    //TODO @ Rachel create delete button functionality
    //TODO @ Rachel Each time there is a change in the talkbuttons it updates the catalog page
    //TODO @ Rachel fix issues that happens when too many buttons or rows are added
    //TODO @ Rachel add functionality that refreshes view and loads a different page when a key button at the top is clicked


    //TODO send initializers all to service
    //TODO add roww creates new row with new button, same size and style
    //TODO add button, make '+' button be smaller than minimum so it can be filtered out
    */

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




