file://<WORKSPACE>/src/main/java/org/example/App.java
### java.util.NoSuchElementException: next on empty iterator

occurred in the presentation compiler.

presentation compiler configuration:
Scala version: 3.3.3
Classpath:
<HOME>/.cache/coursier/v1/https/repo1.maven.org/maven2/org/scala-lang/scala3-library_3/3.3.3/scala3-library_3-3.3.3.jar [exists ], <HOME>/.cache/coursier/v1/https/repo1.maven.org/maven2/org/scala-lang/scala-library/2.13.12/scala-library-2.13.12.jar [exists ]
Options:



action parameters:
offset: 961
uri: file://<WORKSPACE>/src/main/java/org/example/App.java
text:
```scala
import java.io.IOException;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Parent;
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
        //TODO 5 A @@Label will act as the notice board, displaying the next arriving train.
        noticeBoard = new Label(trainDetails[currentIndex]);
        //TODO 6 A VBox (Vertical Box) will stack the Label vertically within the window. You’ll want to add some vertical spacing between the components.
        VBox vbox = new VBox(20); // spacing = 20
        vbox.getChildren().add(noticeBoard);
        vbox.setStyle("-fx-padding: 20; -fx-alignment: center;");
        //TODO 7 Create a Scene using the VBox layout and set it on the primary Stage.
        Scene scene = new Scene(vbox, 640, 480);
        primaryStage.setTitle("Train Notice Board");
        primaryStage.setScene(scene);
        primaryStage.show();
        
        /* TODO 8: Use JavaFX’s Timeline or AnimationTimer to create a repeating task. This task will update the Label with the next train’s details every 5 seconds. */
        Timeline timeline = new Timeline(5);
        /* TODO 9: In the repeating task, you’ll update the Label with the next train’s details from the array.
            After displaying the last train, cycle back to the first one.
        */
    }
    static void setRoot(String fxml) throws IOExeption {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        /* TODO 10: call the launch method */
        primaryStage.launch();
    }
}

```



#### Error stacktrace:

```
scala.collection.Iterator$$anon$19.next(Iterator.scala:973)
	scala.collection.Iterator$$anon$19.next(Iterator.scala:971)
	scala.collection.mutable.MutationTracker$CheckedIterator.next(MutationTracker.scala:76)
	scala.collection.IterableOps.head(Iterable.scala:222)
	scala.collection.IterableOps.head$(Iterable.scala:222)
	scala.collection.AbstractIterable.head(Iterable.scala:933)
	dotty.tools.dotc.interactive.InteractiveDriver.run(InteractiveDriver.scala:168)
	scala.meta.internal.pc.MetalsDriver.run(MetalsDriver.scala:45)
	scala.meta.internal.pc.HoverProvider$.hover(HoverProvider.scala:36)
	scala.meta.internal.pc.ScalaPresentationCompiler.hover$$anonfun$1(ScalaPresentationCompiler.scala:389)
```
#### Short summary: 

java.util.NoSuchElementException: next on empty iterator