package talkbox.desktop.editor.model;

import javafx.event.Event;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.control.TextField;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import talkbox.common.dataobject.TalkButton;
import talkbox.common.dataobject.TalkButtonCatalog;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class EditorUtilityFXButtons {
    TalkButton talkButton;
    Button fxButton;
    VBox vBox;
    TextField textField;
    HBox hBox;
    EditorAppTalkButtonInterpretor editorAppTalkButtonInterpretor;
    TalkButtonCatalog talkButtonCatalog;
    LinkedHashMap<String, ArrayList<ArrayList<Button>>> pageFXButtonMap;
    EditorFXButtonActionSetupUtility editorFXButtonActionSetupUtility;
    LinkedHashMap<String, ArrayList<HBox>> hBoxArrayListMap;
/*
    EditorUtilityFXButtons(LinkedHashMap<String, ArrayList<ArrayList<Button>>> pageFXButtonMap){
        this.talkButtonCatalog = talkButtonCatalog;
        this.editorAppTalkButtonInterpretor = new EditorAppTalkButtonInterpretor(this.talkButtonCatalog);
        this.pageFXButtonMap = editorAppTalkButtonInterpretor.getMapOfFxButtonCatalog();
        this.hBoxArrayListMap = editorAppTalkButtonInterpretor.getMapOfHBoxArrayList();
        setupMapWithUtilities(this.hBoxArrayListMap);
    }
*/
    public  static void setupMapWithUtilities( LinkedHashMap<String, ArrayList<HBox>> hBoxArrayListMap ){
       // hBoxArrayListMap.entrySet().stream().forEach(v->setupAddNewButtonUtility(v.getValue()));
        hBoxArrayListMap.entrySet().stream().forEach(s-> setupAllUtilityButtonsToView(s.getValue()));
    }


    private static void setupAllUtilityButtonsToView(ArrayList<HBox> editorTalkBoxButtons){
        setupAddNewButtonUtility(editorTalkBoxButtons);
        setupAddNewButtonRowUtility(editorTalkBoxButtons);
    }





    private static void  setupAddNewButtonRowUtility(ArrayList<HBox> editorTalkBoxButtons){

        int initialLength = editorTalkBoxButtons.size();

        for(int i =0; i<= editorTalkBoxButtons.size();i=i+2){
            editorTalkBoxButtons.add(i,createAddRowUtility());
        }

    }






    private static void setupAddNewButtonUtility(ArrayList<HBox> editorTalkBoxButtons){
        editorTalkBoxButtons.forEach(
                row->{
                    for(int i=0; i<=row.getChildren().size();i=i+2){
                        row.getChildren().add(i,createAddNewButtonUtility(row));
                    }
                }

        );

    }


    public static HBox createAddRowUtility(){
        HBox addRowUtility = new HBox();
        Text pointer = new Text();
        addRowUtility.getChildren().addAll(horizontalSeparator(), createAddRowButton(), horizontalSeparator(),pointer);
        addRowUtility.setAlignment(Pos.CENTER);
        addRowUtility.setOnDragOver(e->{

            pointer.setText("\u25BC");
            pointer.setFont(Font.font("Arial", FontWeight.BOLD, 20));
            pointer.setFill(Color.BLACK);
            //System.out.println(.getChildren().indexOf(container));
           // Dragboard db = addButton.startDragAndDrop(TransferMode.COPY_OR_MOVE);
            //ClipboardContent content = new ClipboardContent();
           // content.putString(String.valueOf(row.getChildren().indexOf(container)));


            //label.setFont(Font.font ("Arial", 20), Color.BLUE);
            //label.setFill(Color.RED);
            String cssLayout = "-fx-border-color: skyblue;\n" +
                    "-fx-border-insets: 2;\n" +
                    "-fx-border-width: 2;\n" +
                    "-fx-border-style: dashed;\n";

            addRowUtility.setStyle(cssLayout);
           // db.setContent(content);


        });

        addRowUtility.setOnDragExited(e->{

            pointer.setText("");
            addRowUtility.setStyle("-fx-border-color: transparent;");

        });
        return addRowUtility;
    }

    private static Button createAddRowButton(){
        Button addRowButton = new Button("++ ADD ROW ++");
        setupAddRowButtonAction(addRowButton);
        return addRowButton;
    }

    private static void setupAddRowButtonAction(Button button){
        button.setOnAction(e->{
            createAddRowUtility(); //add this to the bottom of the current row
            //TODO set action to create new row and also add another utility button
        });

    }



    public static VBox createAddNewButtonUtility(HBox row){
        Button addButton = new Button("+");
        setButtonSize(addButton,60,60);
        Text pointer = new Text();
        VBox container = new VBox(pointer,verticalSeparator(),addButton,verticalSeparator());
        container.setAlignment(Pos.CENTER);
        EditorFXButtonActionSetupUtility.setAddNewButtonAction(addButton,pointer,row,container);


        return container;
    }




    public static void setButtonSize(Button button, int width, int height){
        button.setMaxSize(width,height);
        button.setMinSize(width,height);
    }



    public static Separator verticalSeparator(){
        Separator verticalSeparatorComponent = new Separator();
        verticalSeparatorComponent.setOrientation(Orientation.VERTICAL);
        verticalSeparatorComponent.setMaxSize(3,10);
        verticalSeparatorComponent.setMinSize(3,10);
        return verticalSeparatorComponent;
    }

    public static Separator horizontalSeparator(){
        Separator horizontalSeparatorComponent =new Separator();
        horizontalSeparatorComponent.setOrientation(Orientation.HORIZONTAL);
        horizontalSeparatorComponent.setMinSize(300,1);
        horizontalSeparatorComponent.setMaxSize(300,1);
        return horizontalSeparatorComponent;

    }







}
