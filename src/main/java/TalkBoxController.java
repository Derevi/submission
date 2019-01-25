import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.ResourceBundle;

public class TalkBoxController implements Initializable {
    VBox box;

    @FXML
    GridPane gridPane;



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ButtonInventory buttonCollection = new ButtonInventory();
        int i=0;
        for(Button b: buttonCollection.getArrayList()){
            gridPane.add(b,i,i);
            i=i+5;
        }
    }

}
