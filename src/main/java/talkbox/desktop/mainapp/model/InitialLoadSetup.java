package talkbox.desktop.mainapp.model;

import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;

import java.io.File;

public class InitialLoadSetup {
    GridPane gridPane;
    public InitialLoadSetup(GridPane gridPane){
        this.gridPane = gridPane;
    }

    public void generateLoadingScreen(GridPane gridPane){
        Button load = new Button("Load");
        load.setPrefSize(50,50);
        gridPane.add(load,3,4);
        load.setOnAction(e->{
            loadButtonToUI(gridPane);
        });

        Button createNew = new Button("Create New");
        createNew.setPrefSize(50,50);
        gridPane.add(createNew,4,4);
        createNew.setOnAction(e->{
            createNewTalkBoxCatalog(gridPane);
        });
    }

    public void loadButtonToUI(GridPane gridPane){
        gridPane.getChildren().clear();
        Text textAboveListView = new Text("Files in the directory:  ");
        gridPane.add(textAboveListView,6,5);

        Button browseButton=new Button("Browse");

        gridPane.add(browseButton,6,6);
        ListView<String> listView = new ListView<>();

        gridPane.add(listView,6,7);
        browseButton.setOnAction(e->{
            DirectoryChooser directoryChooser = new DirectoryChooser();
            Stage stage = (Stage) gridPane.getScene().getWindow();
            File file = directoryChooser.showDialog(stage);
            Text text = new Text("Loaded directory : "+file.getAbsoluteFile());
            gridPane.add(text,6,8);


            for (File fileName:file.listFiles()){
                if(fileName.getName().contains(".ser")) {
                    listView.getItems().add(fileName.getName());
                }
            }

        });

    }

    public void createNewTalkBoxCatalog(GridPane gridPane){

    }

    /*
        // LoadTalkButtonToUI populateTalkButtonToUI = new LoadTalkButtonToUI(talkButtonCatalog);
        Button createNewButton = new Button("Create New");
        Button loadButton = new Button("Load");



        //populateTalkButtonToUI.printTalkButtons(gridPane,"test");
        TalkButton talkButton = new TalkButton("text");
        HBox hBox = new HBox(createNewButton);



        HBox hBox1 = new HBox();
        gridPane.add(hBox,0,0);
        Text text = new Text("Enter new Name: ");
        ComboBox<String> comboBox = new ComboBox<>();
        comboBox.getItems().add("first");
        comboBox.getItems().add("second");
        comboBox.getItems().add("third");
        gridPane.add(comboBox,2,2);
        TextField textField = new TextField();
        textField.setPromptText("enter new filename");
        gridPane.add(text,2,3);
        gridPane.add(textField,3,3);

        Button browseButton=new Button("Browse");
        ListView<String> listView = new ListView<>();

        gridPane.add(listView,6,6);
        browseButton.setOnAction(e->{
            DirectoryChooser directoryChooser = new DirectoryChooser();
            Stage stage = (Stage) gridPane.getScene().getWindow();
            File file = directoryChooser.showDialog(stage);
            System.out.println(file.getAbsoluteFile());
            for (File fileName:file.listFiles()){
                if(fileName.getName().contains(".ser")) {

                    comboBox.getItems().add(fileName.getName());
                    listView.getItems().add(fileName.getName());
                }
            }

        });
        gridPane.add(browseButton,5,5);
        gridPane.setAlignment(Pos.CENTER);*/
}
