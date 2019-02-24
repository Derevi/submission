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
        Scene scene = new Scene(root, 1366, 768);
        scene.getStylesheets().add(getClass().getResource("../../styles.css").toExternalForm());
        primaryStage.setScene(scene);



        primaryStage.setTitle("Talk Box");
        //primaryStage.setScene(scene);

        primaryStage.setMaxWidth(1366);
        primaryStage.setMinWidth(1366);
        primaryStage.setMaxHeight(768);
        primaryStage.setMinHeight(768);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }


}
