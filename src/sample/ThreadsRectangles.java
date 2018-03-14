package sample;

import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;

import java.util.Random;

public class ThreadsRectangles {

    private final int step = 5;

    ThreadsRectangles(Pane pane){
        setPane(pane);
    }
    private Pane pane;
    Rectangle[] rectangles;
    private Rectangle rectangle;

    private double x = 220,y = 330;

    private void setPane(Pane pane) {
        this.pane = pane;
    }
    public void generateRectangles(){
        rectangle = new Rectangle(x,y,40,30);
        action(rectangle);
//        pane.getChildren().add(rectangle);
    }

    private void action(Rectangle rectangle){
        x = rectangle.getX();
        y = rectangle.getY();
        int count = 0;
        Direction direction = Direction.values()[new Random().nextInt(4)];
        do {
            x += direction.name().endsWith("Right") ? step : -step;
            y += direction.name().startsWith("Up") ? step : -step;
            rectangle.setVisible(false);
            pane.getChildren().remove(rectangle);
            rectangle.setTranslateX(x);
            rectangle.setTranslateY(y);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            rectangle.setVisible(true);
            pane.getChildren().add(rectangle);
            count++;
        } while (count < 20);
    }

    public Pane getPane() {
        return pane;
    }
}

enum Direction{
    UpRight, DownRight, DownLeft, UpLeft
}
