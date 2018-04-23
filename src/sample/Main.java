package sample;

import javafx.animation.*;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.Random;
import javafx.util.Duration;


public class Main extends Application {

    private Integer frameCount = 0;
    private AnimationTimer timer;

    @Override
    public void start(Stage primaryStage) {
        Group root = new Group();
        Scene scene = new Scene(root, 320, 320);

        Random rand = new Random();
        for (int i = 0; i < scene.getWidth(); i += 10) {
            for (int j = 0; j < scene.getHeight(); j += 10) {

                // random color for each rectangle
                Color c = Color.rgb(rand.nextInt(255), rand.nextInt(255), rand.nextInt(255));

                Rectangle r = new Rectangle(i, j, 10, 10);
                r.setFill(c);
                r.setStroke(Color.BLACK); // all rectangles have border
//                r.setStrokeWidth(5);

                root.getChildren().add(r);
            }

        }

        Text gay = new Text(80, 160, "I'M GAY");
        gay.setFont(Font.font("Verdana", 40));
        gay.setFill(Color.BLACK);
        gay.setStroke(Color.WHITE);

        root.getChildren().add(gay);

/*
        Rectangle r = new Rectangle();
        r.setX(180);
        r.setY(130);
        r.setWidth(40);
        r.setHeight(40);

        r.setFill(Color.GREEN);
        r.setStroke(Color.BLACK);
        r.setStrokeWidth(5);
        r.setRotate(45);
        r.setScaleX(2);
        r.setScaleY(2);


        root.getChildren().add(r);
*/
        primaryStage.setScene(scene);

        primaryStage.show();

        Timeline timeline = new Timeline();
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.setAutoReverse(true);

        timer = new AnimationTimer() {
            @Override
            public void handle(long l) {
                frameCount++;
            }
        };

        KeyValue keyValueX = new KeyValue(root.scaleXProperty(), 2);
        KeyValue keyValueY = new KeyValue(root.scaleYProperty(), 2);
        
        Duration duration = Duration.millis(200);
        //one can add a specific action when the keyframe is reached
        EventHandler onFinished = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent t) {
                //root.setTranslateX(Math.random()*200-100);
                //reset counter
                frameCount = 0;
            }
        };

        KeyFrame keyFrame = new KeyFrame(duration, onFinished , keyValueX, keyValueY);

        //add the keyframe to the timeline
        timeline.getKeyFrames().add(keyFrame);

        timeline.play();
        timer.start();

    }


    public static void main(String[] args) {
        launch(args);
    }
}
