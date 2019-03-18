package talkbox.catalogedit;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Map;
import java.util.ResourceBundle;

public class FXMLController implements Initializable {

    @FXML
    private Label label;

    @FXML
    AnchorPane rootpane;

    @FXML
    private ListView<Button> crntList;
    @FXML EditCatalogController editCatalogController = new EditCatalogController();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
       // System.out.println("ASffsa");

       for( Map.Entry<Button, ArrayList<String>> entry : editCatalogController.defaultMap.entrySet() ){
              System.out.println(entry);
              crntList.getItems().add(entry.getKey());
        }
    }

    @FXML
    public void handleButtonAction(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("EditCatalog.fxml"));
        rootpane.getChildren().setAll(pane);
        EditCatalogController e = new EditCatalogController();
        //Map<Button, ArrayList<Button>> temp = e.getMap();
        //System.out.println(temp.size());
    }



}
