package talkbox.configurator;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import talkbox.gui.AudioPlayer;
import talkbox.gui.TalkButton;

import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ConfiguratorController implements Initializable, EventHandler {
    //public class ConfiguratorController{
    ButtonInventoryCatalog catalog;
    ArrayList<Button> genBtns = new ArrayList<Button>();
    ArrayList<TextField> genTxts = new ArrayList<TextField>();
    ArrayList<Button> genCat = new ArrayList<Button>();
    Button cat = new Button();
    @FXML
    Button button;
    Button okay;

    private int countAdd = 0;
    @FXML
    GridPane gridPane;

    @FXML
    Button SaveAndCompile;


    public void load() {

    }

    public void saveAndCompile() {

    }

    public void speak(String word) {
        AudioPlayer.talk(word);
    }

    public void save() {
        TalkButtons.save(catalog.getButtonInventoryMap());

    }

    public void compileAudio() {
        for (TalkButton talkButton : catalog.getButtonInventoryMap().get("animals").getTalkButtons())
            StringToAudioGenerator.generateAudio(talkButton.getName());

    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        System.out.println("help");
        // catalog = new ButtonInventoryCatalog();


        ArrayList<SerButton> buttonsA = new ArrayList<>();
        ArrayList<Button> buttonsB = new ArrayList<>();
        ArrayList<TextField> textFieldsA = new ArrayList<>();
        ArrayList<TextField> textFieldsB = new ArrayList<>();
        SerButton button1a = new SerButton("one");
        Button button1b = new Button("one");
        buttonsA.add(button1a);
        buttonsB.add(button1b);
        SerButton button2a = new SerButton("two");
        Button button2b = new Button("two");
        buttonsA.add(button2a);
        buttonsB.add(button2b);
        SerButton button3a = new SerButton("three");
        Button button3b = new Button("three");
        buttonsA.add(button3a);
        buttonsB.add(button3b);
        SerButton button4a = new SerButton("four");
        Button button4b = new Button("four");
        buttonsA.add(button4a);
        buttonsB.add(button4b);
        SerButton button5a = new SerButton("five");
        Button button5b = new Button("five");
        buttonsA.add(button5a);
        buttonsB.add(button5b);
        SerButton button6a = new SerButton("six");
        Button button6b = new Button("six");
        buttonsA.add(button6a);
        buttonsB.add(button6b);
        SerButton button7a = new SerButton("seven");
        Button button7b = new Button("seven");
        buttonsA.add(button7a);
        buttonsB.add(button7b);
        SerButton button8a = new SerButton("eight");
        Button button8b = new Button("eight");
        buttonsA.add(button8a);
        buttonsB.add(button8b);
        SerButton button9a = new SerButton("nine");
        Button button9b = new Button("nine");
        buttonsA.add(button9a);
        buttonsB.add(button9b);
        TextField textField1a = new TextField();
        TextField textField1b = new TextField();
        textFieldsA.add(textField1a);
        textFieldsB.add(textField1b);
        TextField textField2a = new TextField();
        TextField textField2b = new TextField();
        textFieldsA.add(textField2a);
        textFieldsB.add(textField2b);
        TextField textField3a = new TextField();
        TextField textField3b = new TextField();
        textFieldsA.add(textField3a);
        textFieldsB.add(textField3b);
        TextField textField4a = new TextField();
        TextField textField4b = new TextField();
        textFieldsA.add(textField4a);
        textFieldsB.add(textField4b);
        TextField textField5a = new TextField();
        TextField textField5b = new TextField();
        textFieldsA.add(textField5a);
        textFieldsB.add(textField5b);
        TextField textField6a = new TextField();
        TextField textField6b = new TextField();
        textFieldsA.add(textField6a);
        textFieldsB.add(textField6b);
        TextField textField7a = new TextField();
        TextField textField7b = new TextField();
        textFieldsA.add(textField7a);
        textFieldsB.add(textField7b);
        TextField textField8a = new TextField();
        TextField textField8b = new TextField();
        textFieldsA.add(textField8a);
        textFieldsB.add(textField8b);
        TextField textField9a = new TextField();
        TextField textField9b = new TextField();
        textFieldsA.add(textField9a);
        textFieldsB.add(textField9b);
        ArrayList<ButtonData> buttonData = new ArrayList<>();


        //Opening a new window when clicked on btn

        cat.setText("Change Catalog");
        gridPane.add(cat, 1, 1);
        cat.setOnAction(this);


        int row = 4;
        gridPane.setHgap(5);
        gridPane.setVgap(10);
        for (SerButton b : buttonsA) {
            gridPane.add(b, 0, row);
            buttonData.add(new ButtonData(b));
            row++;
            b.setOnAction(e -> {
                AudioPlayer.talk(b.getText());
                System.out.println("Playing:  " + b.getText());
            });


        }
/*
         row = 4;
        for(Button b:buttonsB){
            gridPane.add(b,2,row);
            row++;
            b.setOnAction(e -> {
                System.out.println("Clicked");});

        }
        */
        row = 4;
        for (TextField t : textFieldsA) {
            gridPane.add(t, 3, row);
            row++;
            t.setOnMouseClicked(e -> {

                buttonsA.get(textFieldsA.indexOf(t)).setText(t.getText());
                buttonData.get(textFieldsA.indexOf(t)).name = t.getText();
            });

        }

        Button compile = new Button("compile audio");
        gridPane.add(compile, 1, 15);
        compile.setOnAction(e -> {
            for (Button b : buttonsA) {
                StringToAudioGenerator.generateAudio(b.getText());
            }
        });

        Button save = new Button("Save");
        gridPane.add(save, 2, 15);
        save.setOnAction(e -> {
            ButtonSaver.save(buttonData);
        });

        Button load = new Button("load");
        gridPane.add(load, 3, 15);
        load.setOnAction(e -> {
            System.out.println("loading");
        });


        //generate top row bottons

        //generate

/*
        Button button1 = new Button("one");
        Button button2 = new Button("two");
        Button button3 = new Button("three");
        Button button4 = new Button("four");
        Button button5 = new Button("five");
        TextField textField1 = new TextField();
        TextField textField2 = new TextField();
        TextField textField3 = new TextField();
        TextField textField4 = new TextField();
        TextField textField5 = new TextField();
        gridPane.setHgap(5);
        gridPane.setVgap(10);
        ArrayList<Button> buttons=new ArrayList<>();
        buttons.add(button1);buttons.add(button2);buttons.add(button3);buttons.add(button4);buttons.add(button5);
        for(Button button:buttons){
            button.setOnAction(e -> {
                        System.out.println("Clicked");});
        }
        gridPane.add(button1,0,0); gridPane.add(textField1,1,0);
        gridPane.add(button2,0,1); gridPane.add(textField2,1,1);
        gridPane.add(button3,0,2); gridPane.add(textField3,1,2);
        gridPane.add(button4,0,3); gridPane.add(textField4,1,3);
        gridPane.add(button5,0,4); gridPane.add(textField5,1,4);
*/

/*

        int col = 0; int row = 0;

        gridPane.setHgap(5);
        gridPane.setVgap(10);

        for(String name: catalog.getButtonInventoryMap().keySet()){
            gridPane.add(new Button(name),col,0);
            gridPane.add(new TextField(),col,1);
            col++;
        }
        row = 4;
        for(TalkButton talkButton: catalog.getButtonInventoryMap().get("animals").getTalkButtons()){
            gridPane.add(new Button(talkButton.getName()),0,row);
            talkButton.getButton().setOnMouseClicked(actionEvent -> {
                System.out.println("CLCIEK");
            });
            gridPane.add(new TextField(),1,row);

            row++;
        }
        TextField textField = new TextField();
        textField.setOnMouseClicked(e -> {
            System.out.println("Clicked");
        });
*/

    }

    private void handleButtonAction(ActionEvent event) {
        // Button was clicked, do something…
        System.out.println("test");
    }

    private void save(ActionEvent event) {

    }


    @Override
    public void handle(Event event) {


        gridPane.getChildren().clear();
        gridPane.setHgap(5);
        gridPane.setVgap(20);

        Text lblTitle = new Text("Configure Categories");
        gridPane.add(lblTitle, 2, 0);
        Button add = new Button("Add Category");
        gridPane.add(add, 4, 1);
        Button remove = new Button("Remove Category");
        gridPane.add(remove, 6, 1);

        if (genCat.size() < 1) {
            remove.setDisable(true);
        } else {
            remove.setDisable(false);
        }


        add.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                genCat.add(new Button("Edit Name"));
                gridPane.add(genCat.get(countAdd), 1, countAdd);
                countAdd++;
                remove.setDisable(false);

            }
        });


        remove.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {

                remove.setDisable(false);
                genCat.remove(genCat.get(genCat.size() - 1));
                System.out.println("Size of arr: " + genCat.size());
                gridPane.getChildren().remove(gridPane.getChildren().size() - 1);
                countAdd--;
                if (genCat.size() > 0) {
                    remove.setDisable(false);
                } else {
                    remove.setDisable(true);
                }

            }
        });

        if (genCat.size() > 0) {
            genCat.get(0).setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    gridPane.getChildren().clear();

                    TextField field = new TextField("Enter number of buttons");
                    okay = new Button("Okay");
                    gridPane.add(okay, 2, 1);
                    gridPane.add(field, 1, 1);
                    okay.setOnAction(new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent actionEvent) {
                            gridPane.getChildren().clear();

                            for (int i = 0; i < Integer.parseInt(field.getText()); i++) {

                                genBtns.add(new Button("Button " + i));
                                gridPane.add(genBtns.get(i), 0, i);
                                genTxts.add(new TextField());
                                gridPane.add(genTxts.get(i), 1, i);


                            }

                        }
                    });
                }
            });


        }
    }


    }



