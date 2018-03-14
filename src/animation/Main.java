package animation;

import com.sun.org.apache.regexp.internal.RE;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.stage.Stage;


public class Main extends Application{

    private final double width = 960;
    private final double height = 720;

    public static void main(String[] args) {
        launch(args);
    }

    private void setParam(Stage stage){
        stage.setMaxHeight(height);
        stage.setMaxWidth(width);
        stage.setMinWidth(width);
        stage.setMinHeight(height);
        stage.setX(50);
        stage.centerOnScreen();
    }

    private BorderPane mainPane = new BorderPane();
    private VBox left = new VBox();
    private Pane center = new Pane();
    @Override
    public void start(Stage primaryStage) throws Exception {
        setParam(primaryStage);

        //left
        Button startButton = new Button("Start");

        left.getChildren().add(startButton);
        left.setPadding(new Insets(15, 15, 10, 10));
        left.setSpacing(10);
        mainPane.setLeft(left);
        mainPane.setCenter(center);
        center.setMaxWidth(width);
        center.setMaxHeight(height);

        //center
//        center.setStyle("-fx-background-color: black");



        Scene scene = new Scene(mainPane);
        primaryStage.setScene(scene);
        primaryStage.show();

        startButton.setOnMouseClicked(e -> {
            center.getChildren().clear();
            Animation animation = new Animation(center);
            animation.generateShapes((int)(Math.random()*12));
            animation.start();
        });
    }


    private void addButton(){

    }


}
