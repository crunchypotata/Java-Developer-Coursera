package com.example;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        /** TODO 10: replace Replace "primary" with "vboxscene" below **/
        scene = new Scene(loadFXML("vboxscene"), 640, 480);
        stage.setScene(scene);
        stage.show();
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("/com/example/" + fxml + ".fxml"));
        return fxmlLoader.load();
    }
 
    public static void main(String[] args)  {
        try {
    /* TODO 13: Open App.java code. 
    Call Database.getConnection() method 
    before calling launch() */
            Database.getConnection();
            System.out.println("connected");
        } catch (SQLException e) {
            System.out.println("not connected");
            e.printStackTrace();
        }
        launch();
    }

}