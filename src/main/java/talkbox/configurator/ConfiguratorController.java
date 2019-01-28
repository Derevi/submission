package talkbox.configurator;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import talkbox.gui.AudioPlayer;

import java.net.URL;
import java.util.ResourceBundle;

public class ConfiguratorController implements Initializable {
//public class ConfiguratorController{
    VBox box;

    @FXML
    GridPane gridPane;

    @FXML
    Button SaveAndCompile;


    public void load(){

    }

    public void saveAndCompile(){

    }

    public void save(){

    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        System.out.println("help");


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
        gridPane.add(button1,0,0); gridPane.add(textField1,1,0);
        gridPane.add(button2,0,1); gridPane.add(textField2,1,1);
        gridPane.add(button3,0,2); gridPane.add(textField3,1,2);
        gridPane.add(button4,0,3); gridPane.add(textField4,1,3);
        gridPane.add(button5,0,4); gridPane.add(textField5,1,4);

        }

    }


