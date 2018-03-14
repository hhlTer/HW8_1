package sample;

public class Point {

    private static final Point ZERO;
    static {
        ZERO = new Point();
        ZERO.x = 0;
        ZERO.y = 0;
    }
    private double x, y;

    public void setX(double x) {
        this.x = x;
    }
    public void setY(double y) {
        this.y = y;
    }
    public double getX() {
        return x;
    }
    public double getY() {
        return y;
    }

}
