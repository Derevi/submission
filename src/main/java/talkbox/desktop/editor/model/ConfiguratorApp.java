package talkbox.desktop.editor.model;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import talkbox.common.dataobject.TalkButton;
import talkbox.common.dataobject.TalkButtonCatalog;
import talkbox.common.dataobject.TalkButtonPage;

import java.util.ArrayList;

public class ConfiguratorApp extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception{

        Parent root = FXMLLoader.load(getClass().getResource("/talkbox/desktop/editor/view/starteditor.fxml"));
        primaryStage.setTitle("TalkBox Button Editor");

        Scene scene = new Scene(root, 1366, 768);
        scene.getStylesheets().add(getClass().getResource("/talkbox/desktop/styles.css").toExternalForm());
/*
        primaryStage.setMaxWidth(1366);
        primaryStage.setMinWidth(1366);
        primaryStage.setMaxHeight(768);
        primaryStage.setMinHeight(768);
        */


        primaryStage.setScene(scene);

        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }

}
