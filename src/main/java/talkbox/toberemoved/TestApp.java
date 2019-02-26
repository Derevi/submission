package talkbox.toberemoved;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class TestApp extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception{

        Parent root = FXMLLoader.load(getClass().getResource("../../../toberemoved/newlayoutsimple.fxml"));
        primaryStage.setTitle("TalkBox Button Editor");
        primaryStage.setScene(new Scene(root,  1366, 768));
        //primaryStage.setMaxWidth(1366);
        //primaryStage.setMinWidth(1366);
        //primaryStage.setMaxHeight(768);
        //primaryStage.setMinHeight(768);

        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }


}
