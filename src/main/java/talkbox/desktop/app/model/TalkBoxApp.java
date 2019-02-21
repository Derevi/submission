package talkbox.desktop.app.model;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class TalkBoxApp extends Application{
    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("../view/talkbox.fxml"));
        primaryStage.setTitle("Talk Box");
        primaryStage.setScene(new Scene(root, 480, 600));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }


}
