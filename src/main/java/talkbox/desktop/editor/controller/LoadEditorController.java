package talkbox.desktop.editor.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import talkbox.common.service.FileBrowser;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LoadEditorController implements Initializable {
    @FXML
    AnchorPane root;

    @FXML
    String selectedFileName;

    @FXML
    ListView<String> filesInDirectory;

    @FXML
    GridPane parentDirectoryGridPane;

    @FXML
    GridPane selectedFileGridPane;

    @FXML
    Label selectedDirectory;

    private File SelectedDirectory;

    @FXML
    public void loadTalkBox(ActionEvent event){

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/maineditor.fxml"));

            AnchorPane anchorPane = loader.load();
            MainEditorController controller = loader.getController();
            root.getChildren().setAll(anchorPane);
           // controller.initialSetup(selectedDirectory.getText(),selectedDirectory);

        } catch (IOException e) {
            e.printStackTrace();
        }




        //TalkButtonCatalog talkButtonCatalog = new TalkButtonCatalog(TalkButtonCatalogLoader.load(fileName));


    }

    @FXML
    private void back(ActionEvent event){
        try {
            AnchorPane anchorPane = FXMLLoader.load(getClass().getResource("../view/starteditor.fxml"));
            root.getChildren().setAll(anchorPane);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void browse(ActionEvent event){

        //TODO File reader and writer not working


        selectedFileGridPane.getChildren().clear();
        File selectedFile = FileBrowser.selectFile(event);
        updateListView(selectedFile.getAbsoluteFile());
        Label label = new Label("Selected File :  " +selectedFile.getName());
        selectedFileGridPane.add(label,0,0);

    }

    private void updateListView(File selectedFile){
        parentDirectoryGridPane.getChildren().clear();
        FileBrowser.generateList(selectedFile,filesInDirectory);
        Label label = new Label("Selected Directory:  "+selectedFile.getParentFile().getAbsolutePath());
        parentDirectoryGridPane.setAlignment(Pos.CENTER_LEFT);
        parentDirectoryGridPane.add(label,0,0);


    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


        try (BufferedReader reader = new BufferedReader(new FileReader("directoryHistory.txt"))) {
            String currentLine;
            while ((currentLine = reader.readLine()) != null) {
                File loadPreviousDirectory = new File(currentLine);
                updateListView(loadPreviousDirectory);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void listClick(MouseEvent event){
       selectedFileGridPane.getChildren().clear();
       String fileName =filesInDirectory.getSelectionModel().getSelectedItem();
       Label label = new Label("Selected File :  " + fileName);
       selectedFileGridPane.add(label,0,0);
    }
}
