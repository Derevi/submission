package talkbox.common.service;

import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.*;

public class FileBrowser {


    public static File selectFile(ActionEvent e){
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Select File");
        File file=fileChooser.showOpenDialog(new Stage());
        createDirectoryHistory(file);
        return file;
    }

    private static void createDirectoryHistory(File selectedFile){
        File file = new File("directoryHistory.txt");
        try (Writer writer = new BufferedWriter(new FileWriter(selectedFile))) {
            String contents = selectedFile.getParentFile().getAbsolutePath();
            writer.write(contents);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }




    public static void generateList(File file,ListView<String> listView){
        listView.getItems().clear();
        for (File fileName:file.getParentFile().listFiles()){
            if(fileName.getName().contains(".ser")) {
                listView.getItems().add(fileName.getName());
            }
            if(listView.getItems().isEmpty()){
                listView.getItems().add("No loadable TalkBox files found in selected directory files must have the '.ser' extension to load");
            }

        }
    }

    public static void generateDirectoryLabel(File selectedFile, GridPane gridPane){
        Label label = new Label("Selected Directory:  "+selectedFile.getParentFile().getAbsolutePath());
        gridPane.setAlignment(Pos.CENTER_LEFT);
        gridPane.add(label,0,0);

    }
}
