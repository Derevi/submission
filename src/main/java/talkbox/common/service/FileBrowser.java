package talkbox.common.service;

import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;

import java.io.File;

public class FileBrowser {
    public File selectDirectory(ActionEvent e){
            DirectoryChooser directoryChooser = new DirectoryChooser();
            //Stage stage = (Stage) root.getScene().getWindow();
            File file = directoryChooser.showDialog(new Stage());
            return file;
    }

    public void generateList(File file,ListView<String> listView){
        listView.getItems().clear();
        for (File fileName:file.listFiles()){
            if(fileName.getName().contains(".ser")) {
                listView.getItems().add(fileName.getName());
            }
            if(listView.getItems().isEmpty()){
                listView.getItems().add("No loadable TalkBox files found in selected directory files must have 'ser' extension to load");
            }

        }
    }

    public void generateDirectoryLabel(File selectedDirectory, GridPane gridPane){
        Label label = new Label("Selected Directory: "+selectedDirectory.getAbsolutePath());
        gridPane.setAlignment(Pos.CENTER_LEFT);
        gridPane.add(label,0,0);

    }
}
