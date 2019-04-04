package talkbox.desktop.editor.controller;

import javafx.beans.binding.Bindings;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;
import talkbox.desktop.editor.model.EditorFXButtonActionSetupUtility;
import talkbox.desktop.editor.model.PageFXToggles;

import javax.swing.*;
import java.awt.*;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.ResourceBundle;


public class NewPageController implements Initializable, EventHandler<ActionEvent> {


    public LinkedHashMap<Button, ArrayList<Label>> defaultMap = new LinkedHashMap<>();

    public ArrayList<String> defaultArr;
    @FXML
    public ListView<Button> catalogList = new ListView<>();
    @FXML
    private ListView<Label> innerList = new ListView<>();
    @FXML
    AnchorPane rootpane;


    @FXML
    public Button backBtn, addBtnPage;
    @FXML
    private Label selectedBtnPage;

    @FXML
    private TextField txtPageName;

    private static Stage stage;
    public TextField txtName = new TextField(), txtNumBtns = new TextField(), txtMaxRows = new TextField(), txtMaxCols = new TextField();
    private Button btnAddPage = new Button(), btnCancel = new Button();

    public String innerListAddName;


    public static void setStage(Stage oldstage){
        stage = oldstage;
    }




    @FXML
    public void loadCatalog(ActionEvent event) {
        Stage stage = new Stage();
        FileChooser file = new FileChooser();
        file.setTitle("Open Resource File");
        file.showOpenDialog(stage);
        stage.show();

    }

    @FXML
    public void addBtnPage(ActionEvent actionEvent) {
        if(defaultMap.size()!=0 && !txtPageName.getText().isEmpty()) {
            LinkedHashMap<String, Integer> subList = new LinkedHashMap<>();

            for (Map.Entry<Button, ArrayList<Label>> entry : defaultMap.entrySet()) {
                subList.put(entry.getKey().getText(), entry.getValue().size());
            }
            EditorFXButtonActionSetupUtility.setElements(txtPageName.getText(), subList);

            this.stage.close();
        }else{
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setTitle("ERROR!");
            a.setHeaderText("Must create a new catalog or must enter the name of the catalog");
            a.show();
        }
    }

    @FXML
    public void handlebtnPage(ActionEvent event) throws IOException {

        final Stage dialog = new Stage();
        dialog.initModality(Modality.APPLICATION_MODAL);
        GridPane dialogVbox = new GridPane();
        dialogVbox.add(new Text("Create a new Button Page"), 2, 1);
        dialogVbox.add(new Text("Name: "), 2, 3);
        dialogVbox.add(txtName, 3, 3);

        dialogVbox.add(new Text("Number of Buttons: "), 2, 4);
        dialogVbox.add(txtNumBtns, 3, 4);

        btnAddPage.setText("Add Button Page");
        btnCancel.setText("Cancel");
        dialogVbox.add(btnAddPage, 2, 7);
        dialogVbox.add(btnCancel, 3, 7);


        btnAddPage.setOnAction(e-> {
            if(!txtName.getText().isEmpty() && !txtNumBtns.getText().isEmpty()) {
                dialog.close();
                Button tempBtn = new Button(txtName.getText());
                tempBtn.setOnAction(NewPageController.this::handle);
                defaultMap.put(tempBtn, new ArrayList<Label>());
                catalogList.getItems().clear();

                for (Map.Entry<Button, ArrayList<Label>> entry : defaultMap.entrySet()) {
                    catalogList.getItems().add(entry.getKey());

                }
                numOfItemsToAdd(Integer.parseInt(txtNumBtns.getText()), tempBtn);
                catalogList.getSelectionModel().select(tempBtn);
                refresh(defaultMap.get(catalogList.getSelectionModel().getSelectedItem()));
            }else{
                Alert a = new Alert(Alert.AlertType.ERROR);
                a.setTitle("ERROR!");
                a.setHeaderText("Must enter something in the text field above!");
                a.show();
            }
        });


        btnCancel.setOnAction(e -> {
            dialog.close();

        });

        Scene dialogScene = new Scene(dialogVbox, 400, 200);
        dialog.setScene(dialogScene);
        dialog.show();


    }

    public void numOfItemsToAdd(int n, Button btnKey){
        for(int i=0;i<n;i++){
            defaultMap.get(btnKey).add(new Label("EMPTY"));
        }
    }



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        backBtn = new Button();

        for (Map.Entry<Button, ArrayList<Label>> entry : defaultMap.entrySet()) {
            catalogList.getItems().add(entry.getKey());
            entry.getKey().setOnAction(this);
            AnchorPane pane = this.rootpane;



            catalogList.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        }


    }


    public void refresh(ArrayList<Label> lbl) {
        innerList.getItems().clear();
        if (!lbl.isEmpty()) {
            lbl.forEach(name -> innerList.getItems().add(name));
        }

    }


    public void backBtn() throws Exception{
        AnchorPane pane = FXMLLoader.load(getClass().getResource("scene.fxml"));
        rootpane.getChildren().setAll(pane);

    }

    public void handle(ActionEvent actionEvent) {


        innerList.getItems().clear();
        Button btn = (Button) actionEvent.getSource();
        if (defaultMap.containsKey(btn)) {
            selectedBtnPage.setText(btn.getText());

            catalogList.getSelectionModel().clearSelection();
            catalogList.getSelectionModel().select(btn);
            defaultMap.get(btn).forEach(name -> innerList.getItems().add(name));

        }

    }


}