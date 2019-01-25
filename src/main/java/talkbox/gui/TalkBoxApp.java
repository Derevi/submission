package talkbox.gui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class TalkBoxApp extends Application{
    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("talkbox/gui/talkbox.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 480, 600));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }


}