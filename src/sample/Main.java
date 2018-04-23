package sample;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.Random;

public class Main extends Application {

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

/*        Rectangle r = new Rectangle();
        r.setX(180);
        r.setY(130);
        r.setWidth(40);
        r.setHeight(40);

        r.setFill(Color.GREEN);
        r.setStroke(Color.BLACK);
        r.setStrokeWidth(5);
        r.setRotate(45);
        r.setScaleX(2);
        r.setScaleY(2);*/


//        root.getChildren().add(r);
        root.getChildren().add(new Text(50, 50, "LOLZ IM GAY"));
        primaryStage.setScene(scene);

        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
