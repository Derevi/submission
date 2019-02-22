package talkbox.desktop.editor.model;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ConfiguratorApp extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception{

       Parent root = FXMLLoader.load(getClass().getResource("../view/starteditor.fxml"));
        primaryStage.setTitle("TalkBox Button Editor");

        primaryStage.setScene(new Scene(root, 480, 600));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }

}