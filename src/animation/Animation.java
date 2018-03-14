package animation;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Shape;
import javafx.util.Duration;

import java.util.Random;

class Animation {
    private Pane pane;
    Animation(Pane pane){
        this.pane = pane;
    }

    private Shape shape;
    void setShape(Shape shape){
        this.shape = shape;
    }

    private RandomGenerateRec[] rectangles;
    void generateShapes(int count){
        rectangles = new RandomGenerateRec[count];
        for (int i = 0; i < count; i++) {
            VectorType vectorType = VectorType.values()[new Random().nextInt(VectorType.values().length)];
            rectangles[i] = new RandomGenerateRec(vectorType);
        }
        pane.getChildren().addAll(rectangles);
    }
    void start(){
        Timeline timeline = new Timeline();
        timeline.setCycleCount(Timeline.INDEFINITE);
        double dx, dy;
        for (int i = 0; i < rectangles.length; i++) {
            rectangles[i].setX(rectangles[i].getX());
            rectangles[i].setY(rectangles[i].getY());
//            dx = rectangles[i].vector.slide.slideX*rectangles[i].getX() + rectangles[i].getX();
//            dx = Math.random()*rectangles[i].getX()*rectangles[i].vector.slide.slideX *6;// + rectangles[i].getX();
//            dy = rectangles[i].vector.slide.slideY*rectangles[i].getY() + rectangles[i].getY();
//            dy = Math.random()*rectangles[i].getY()*rectangles[i].vector.slide.slideY *6;// + rectangles[i].getY();
            RandomGenerateRec.Point point = rectangles[i].getRevertPoint(790, 630);
            dx = point.x;
            dy = point.y;

            KeyValue kvX = new KeyValue(rectangles[i].xProperty(), dx);
            KeyFrame kfX = new KeyFrame(Duration.millis(3000), kvX);
            timeline.getKeyFrames().add(kfX);

            KeyValue kvY = new KeyValue(rectangles[i].yProperty(), dy);
            KeyFrame kfY = new KeyFrame(Duration.millis(3000), kvY);
            timeline.getKeyFrames().add(kfY);
        }
        timeline.play();
    }
}
