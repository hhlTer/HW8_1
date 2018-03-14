package animation;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class RandomGenerateRec extends Rectangle{
    private VectorType vectorType;
    private Vector vector;

//    LU----------RU
//    |           |
//    |           |
//    LD----------RD

    private Point pointLU, pointRU, pointLD, pointRD;
    private double width, heigth;


    Vector.Slide slide;
    RandomGenerateRec(VectorType vectorType){
        super((Math.random() * 790), (Math.random() * 630), (Math.random()*50 + 90), (Math.random()*30 + 110));
        double subscribeX = 790 - this.getX();
        double subscribeY = 630 - this.getY();
        if (subscribeX < this.getWidth()) this.setX(this.getX() - this.getWidth());
        if (subscribeY < this.getHeight()) this.setY(this.getY() - this.getHeight());
        this.setFill(Color.rgb((int)(Math.random()*255),
                (int)(Math.random()*255),
                (int)(Math.random()*255),
                Math.random()));
        this.vectorType = vectorType;
        vectorInitialization();

        width = this.getWidth();
        heigth = this.getHeight();

        pointLU = new Point(this.getX(), this.getY());
        pointRU = new Point(pointLU.x + width, pointLU.y);
        pointLD = new Point(pointLU.x, pointLU.y + heigth);
        pointRD = new Point(pointRU.x, pointLD.y);
    }

    Point getRevertPoint(double weight, double heigth){
        //size to left/up/right/down from rectangle to end of window;
        final double toLeftBorder = pointLU.x;
        final double toUpBorder = pointLU.y;
        final double toRightBorder = weight - pointRU.x;
        final double toDownBorder = heigth - pointRD.y;

        Point point = new Point();

        if (vectorType.name().startsWith("Left")) {
            if (vectorType.name().endsWith("Up")) {
                System.out.println(vectorType.name());
                point.x = toLeftBorder < toUpBorder ? 0 : toLeftBorder - toUpBorder;
                point.y = toLeftBorder < toUpBorder ? toUpBorder - toLeftBorder: 0;
            } else { //Left_Down
                System.out.println(vectorType.name());
                point.x = toLeftBorder < toDownBorder ? 0 : toLeftBorder - toDownBorder;
                point.y = toLeftBorder < toDownBorder ? toUpBorder + toLeftBorder : pointLU.y + toDownBorder;
            }
        } else {
            System.out.println(vectorType.name());
            if (vectorType.name().endsWith("Up")) {//Right_Up
                point.x = toRightBorder < toUpBorder ? pointLU.x + toRightBorder : pointLU.x + toUpBorder;
                point.y = toRightBorder < toUpBorder ? pointLU.y - toRightBorder : 0;
            } else { //Right_Down
                System.out.println(vectorType.name());
                point.x = toRightBorder < toDownBorder ? pointLU.x + toRightBorder : pointLU.x + toDownBorder;
                point.y = toRightBorder < toDownBorder ? pointLU.y + toRightBorder : pointLU.y + toDownBorder;
            }
        }
        return point;
    }

    private void vectorInitialization(){
        vector = new Vector(vectorType);
    }

    class Point{
        Point(){}
        Point(double x, double y){
            this.x = x;
            this.y = y;
        }
        double x, y;
    }
    public Vector getVector() {
        return vector;
    }

    class Vector{
        Slide slide;
        Vector(VectorType vectorType){
            slide = new Slide();
            slide.slideX = (vectorType.toString().startsWith("Left")) ? -1 : 1;
            slide.slideY = (vectorType.toString().endsWith("Up")) ? -1 : 1;
        }



        public Slide getSlide() {
            return slide;
        }

        class Slide {
            int slideX, slideY;
            public void setSlideX(int slideX) {
                this.slideX = slideX;
            }
            public void setSlideY(int slideY) {
                this.slideY = slideY;
            }
        }
    }
}
