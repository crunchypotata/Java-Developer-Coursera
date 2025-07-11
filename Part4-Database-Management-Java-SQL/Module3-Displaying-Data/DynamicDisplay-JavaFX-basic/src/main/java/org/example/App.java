package org.example;
import java.io.IOException;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;

public class App extends Application {

private String[] trainDetails = {"Train 101: City Express - Platform 2",
        "Train 202: Coastal Line - Platform 4",
        "Train 303: Mountain Express - Platform 1",
        "Train 404: Night Owl - Platform 5",
        "Train 505: Sunrise Special - Platform 3" /*TODO 1 intialize 5 unique train names*/ };
private int currentIndex = 0; //TODO 2 To track which train is currently displayed

private Label noticeBoard;

    @Override
    public void start(Stage primaryStage) throws IOException {
        //TODO 4 Clear all the code from the start method
        //TODO 5 A Label will act as the notice board, displaying the next arriving train.
        noticeBoard = new Label(trainDetails[currentIndex]);

        //TODO 6 A VBox (Vertical Box) will stack the Label vertically within the window. You’ll want to add some vertical spacing between the components.
        VBox vbox = new VBox(20); // spacing = 20
        vbox.getChildren().add(noticeBoard);
        vbox.setStyle("-fx-padding: 20; -fx-alignment: center;");

        //TODO 7 Create a Scene using the VBox layout and set it on the primary Stage.
        Scene scene = new Scene(vbox, 400, 200);
        primaryStage.setTitle("Train Notice Board");
        primaryStage.setScene(scene);
        primaryStage.show();
        
        /* TODO 8: Use JavaFX’s Timeline or AnimationTimer to create a repeating task. This task will update the Label with the next train’s details every 5 seconds. */
        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(5), e -> updateTrainDetails()));
        timeline.setCycleCount(Timeline.INDEFINITE); // Repeat forever
        timeline.play(); 
    }

        /* TODO 9: In the repeating task, you’ll update the Label with the next train’s details from the array.
            After displaying the last train, cycle back to the first one.
        */
    private void updateTrainDetails() {
        currentIndex = (currentIndex + 1) % trainDetails.length;
        noticeBoard.setText(trainDetails[currentIndex]);
    }
   

    public static void main(String[] args) {
        /* TODO 10: call the launch method */
        launch(args);
    }
}
