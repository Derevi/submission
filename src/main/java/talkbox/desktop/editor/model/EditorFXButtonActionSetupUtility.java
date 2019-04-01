package talkbox.desktop.editor.model;

import javafx.scene.control.Button;
import javafx.scene.control.ToggleButton;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import talkbox.common.dataobject.TalkButton;
import talkbox.common.dataobject.TalkButtonCatalog;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

//ALL METHODS IN THIS CLASS SHOULD BE STATIC, ITS PURPOSE IS TO SETUP ACTIONS FOR ALL UTILITY BUTTONS IN THE EDITOR

public class EditorFXButtonActionSetupUtility {



    public static void setupDrapAction(LinkedHashMap<String, ArrayList<ArrayList<Button>>> pageFXButtonMap){
        pageFXButtonMap.entrySet().stream()
                .map(Map.Entry::getValue)
                .flatMap(ArrayList::stream)
                .flatMap(ArrayList::stream)
                .forEach(button -> {
                    button.setOnAction(e->{
                        TalkButton talkButton = (TalkButton)button.getUserData();
                        System.out.println(talkButton.getName());
                    });
                });
    }

    public static void setupDrapAction(){

    }

    public static void setupRenderPageViewAction(ToggleButton toggleButton, LinkedHashMap<String, ArrayList<HBox>> hBoxArrayListMap, VBox baseVbox){

        toggleButton.setOnAction(e->{
                String pageName = (String)toggleButton.getUserData();
                DynamicFXElementsRenderer.renderTalkButonsToView(hBoxArrayListMap.get(pageName),baseVbox);


            });
    }

    public static void setAddNewButtonAction(Button addButton, Text pointer, HBox row, VBox container){
        container.setOnDragDetected(e->{


            System.out.println(row.getChildren().indexOf(container));
            Dragboard db = container.startDragAndDrop(TransferMode.COPY_OR_MOVE);
            ClipboardContent content = new ClipboardContent();
            content.putString(String.valueOf(row.getChildren().indexOf(container)));
           db.setContent(content);


        });

        container.setOnDragEntered(e->{
            pointer.setText("\u25BC");
            pointer.setFont(Font.font("Arial", FontWeight.BOLD, 20));
            pointer.setFill(Color.BLUE);


            String cssLayout = "-fx-border-color: skyblue;\n" +
                    "-fx-border-insets: 2;\n" +
                    "-fx-border-width: 2;\n" +
                    "-fx-border-style: dashed;\n";

            container.setStyle(cssLayout);

            System.out.println(row.getChildren().indexOf(container));
        });



        container.setOnDragExited(e->{
            pointer.setText("");
            container.setStyle("-fx-border-color: transparent;");

        });
        container.setOnDragOver(e->{
            e.acceptTransferModes(TransferMode.COPY);
        });



        container.setOnDragDropped(e->{
            Dragboard db = e.getDragboard();
            System.out.println("dropeed"+db.getString());
           // row.getChildren().remove(Integer.parseInt(db.getString()));



        });

/*
        container.setOnDragDetected(e->{
          // Dragboard db = e.getDragboard();

            container.setOnDragDropped(e2->{
                //System.out.println(db.getString());
               // row.getChildren().remove(Integer.parseInt(db.getString()));
                //System.out.println(buttonList.indexOf(b));


            });
        });

*/

    }






}
