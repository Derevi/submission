package talkbox.catalogedit;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class EditNewButtonPageController implements Initializable {

    @FXML
    private Button btnPage;

    @FXML
    AnchorPane rootpane = new AnchorPane();

    @FXML
    private TextField txtName;

    @FXML
    private TextField txtNumBtns;

    @FXML
    private TextField txtMaxRows;

    @FXML
    private TextField txtMaxCol;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }


    public void AddBtnPage(javafx.event.ActionEvent actionEvent) throws IOException{
        AnchorPane pane = FXMLLoader.load(getClass().getResource("scene.fxml"));
        rootpane.getChildren().setAll(pane);
    }


    public void back(javafx.event.ActionEvent actionEvent) throws IOException{
        AnchorPane pane = FXMLLoader.load(getClass().getResource("EditCatalog.fxml"));
        rootpane.getChildren().setAll(pane);
    }
}
