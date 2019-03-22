package talkbox.catalogedit;

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

import javax.swing.*;
import java.awt.*;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.ResourceBundle;

//import javafx.scene.control.Button;

public class EditCatalogController implements Initializable, EventHandler<ActionEvent> {


    public LinkedHashMap<Button, ArrayList<Label>> defaultMap = new LinkedHashMap<>();
    public ArrayList<String> defaultArr;
    @FXML
    public ListView<Button> catalogList = new ListView<>();
    @FXML
    private ListView<Label> innerList = new ListView<>();
    @FXML
    AnchorPane rootpane;
    FXMLController controller;

    @FXML
    private Button backBtn;
    @FXML
    private Label selectedBtnPage;

    private TextField txtName = new TextField(), txtNumBtns = new TextField(), txtMaxRows = new TextField(), txtMaxCols = new TextField();
    private Button btnAddPage = new Button(), btnCancel = new Button();

    public String innerListAddName;

    private MenuItem add = new MenuItem("Add");
    private MenuItem add2 = new MenuItem("Add");
    private MenuItem remove = new MenuItem("Remove");

    public EditCatalogController() {
        defaultInit();
    }

    public void init(FXMLController controller) {
        this.controller = controller;
    }

    @FXML
    public void loadCatalog(ActionEvent event) {
        Stage stage = new Stage();
        FileChooser file = new FileChooser();
        file.setTitle("Open Resource File");
        file.showOpenDialog(stage);
        stage.show();

    }


    public void defaultInit() {
        ArrayList<Label> animals = new ArrayList<>();
        animals.add(new Label("Dog"));
        animals.add(new Label("Cat"));

        ArrayList<Label> Emojis = new ArrayList<>();
        Emojis.add(new Label("Smile"));
        Emojis.add(new Label("Happy face"));
        ArrayList<Label> Sounds = new ArrayList<>();
        Sounds.add(new Label("Waves"));
        Sounds.add(new Label("Engine"));
        ArrayList<Label> Music = new ArrayList<>();
        Music.add(new Label("Hip-hop"));
        Music.add(new Label("Rock"));
        ArrayList<Label> Fruits = new ArrayList<>();
        Fruits.add(new Label("Apple"));
        Fruits.add(new Label("Orange"));

        defaultMap.put(new Button("Animals"), animals);
        defaultMap.put(new Button("Emojis"), Emojis);
        defaultMap.put(new Button("Sounds"), Sounds);
        defaultMap.put(new Button("Music"), Music);
        defaultMap.put(new Button("Fruits"), Fruits);
        innerList.setEditable(false);
    }


    @FXML
    public void handlebtnPage(ActionEvent event) throws IOException {

        final Stage dialog = new Stage();
        dialog.initModality(Modality.APPLICATION_MODAL);
        //dialog.initOwner(primaryStage);
        GridPane dialogVbox = new GridPane();
        dialogVbox.add(new Text("Create a new Button Page"), 2, 1);
        dialogVbox.add(new Text("Name: "), 2, 3);
        dialogVbox.add(txtName, 3, 3);

        dialogVbox.add(new Text("Number of Buttons: "), 2, 4);
        dialogVbox.add(txtNumBtns, 3, 4);

        dialogVbox.add(new Text("Max number of Buttons per Rows: "), 2, 5);
        dialogVbox.add(txtMaxRows, 3, 5);

        dialogVbox.add(new Text("Max number of Buttons per Columns: "), 2, 6);
        dialogVbox.add(txtMaxCols, 3, 6);
        btnAddPage.setText("Add Button Page");
        btnCancel.setText("Cancel");
        dialogVbox.add(btnAddPage, 2, 7);
        dialogVbox.add(btnCancel, 3, 7);

        btnAddPage.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent actionEvent) {
                dialog.close();
                Button tempBtn = new Button(txtName.getText());
                tempBtn.setOnAction(EditCatalogController.this::handle);
                defaultMap.put(tempBtn, new ArrayList<>());
                catalogList.getItems().clear();
                for (Map.Entry<Button, ArrayList<Label>> entry : defaultMap.entrySet()) {
                    catalogList.getItems().add(entry.getKey());
                    //defaultMap.get(entry.getKey()).add(new Label("HELLO"));


                    //catalogList.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);

                }
                catalogList.getSelectionModel().select(tempBtn);
                refresh(defaultMap.get(catalogList.getSelectionModel().getSelectedItem()));
            }
        });


        btnCancel.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                dialog.close();
            }
        });

        Scene dialogScene = new Scene(dialogVbox, 400, 200);
        dialog.setScene(dialogScene);
        dialog.show();


        //  AnchorPane pane = FXMLLoader.load(getClass().getResource("NewButtonPage.fxml"));
        //   rootpane.getChildren().setAll(pane);
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        backBtn = new Button();

        //selectedBtnPage = new Label();
        for (Map.Entry<Button, ArrayList<Label>> entry : defaultMap.entrySet()) {
            catalogList.getItems().add(entry.getKey());
            entry.getKey().setOnAction(this);
            AnchorPane pane = this.rootpane;

            innerList.setOnMousePressed(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent mouseEvent) {
                    if (mouseEvent.isSecondaryButtonDown()) {
                        ContextMenu contextMenu = new ContextMenu();
                        ContextMenu contextMenu2 = new ContextMenu();


                        contextMenu2.getItems().add(add2);
                        contextMenu.getItems().addAll(add, remove);
                        if (innerList.getItems().isEmpty()) {
                            System.out.println("empty");
                            contextMenu2.show(innerList, mouseEvent.getScreenX(), mouseEvent.getScreenY());
                        } else {
                            contextMenu.show(innerList.getSelectionModel().getSelectedItem(), mouseEvent.getScreenX(), mouseEvent.getScreenY());
                        }

                        add2.setOnAction(new EventHandler<ActionEvent>() {
                            @Override
                            public void handle(ActionEvent actionEvent) {
                                addMenuBtns();
                            }
                        });
                        add.setOnAction(new EventHandler<ActionEvent>() {
                            @Override
                            public void handle(ActionEvent actionEvent) {
                                addMenuBtns();
                            }
                        });

                        remove.setOnAction(new EventHandler<ActionEvent>() {
                            @Override
                            public void handle(ActionEvent actionEvent) {
                                defaultMap.get(catalogList.getSelectionModel().getSelectedItem()).remove(innerList.getSelectionModel().getSelectedItem());
                                refresh(defaultMap.get(catalogList.getSelectionModel().getSelectedItem()));

                            }
                        });
                    }
                }
            });


            catalogList.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        }


    }

    public void addMenuBtns() {

        final Stage stage = new Stage();
        VBox vbox = new VBox();
        stage.initModality(Modality.APPLICATION_MODAL);
        Label name = new Label("Enter name: ");
        vbox.getChildren().add(name);
        TextField nameTxt = new TextField();
        vbox.getChildren().add(nameTxt);
        Button okay = new Button("Okay");
        vbox.getChildren().add(okay);
        Scene dialogScene = new Scene(vbox, 200, 200);
        stage.setScene(dialogScene);
        stage.show();

        okay.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                stage.close();
                innerListAddName = nameTxt.getText();
                defaultMap.get(catalogList.getSelectionModel().getSelectedItem()).add(new Label(innerListAddName));
                System.out.println("The Entry added to the array: " + defaultMap.get(catalogList.getSelectionModel().getSelectedItem()).toString());
                System.out.print("Before sending the ArrayList is" + defaultMap.get(catalogList.getSelectionModel().getSelectedItem()).toString());
                refresh(defaultMap.get(catalogList.getSelectionModel().getSelectedItem()));
            }
        });

    }

    public void refresh(ArrayList<Label> lbl) {
        innerList.getItems().clear();
        // System.out.println("The ArrayList after recieveing " +lbl.toString());
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

