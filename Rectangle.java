public class Rectangle {

    public Point bottomLeft;
    public Point bottomRight;
    public Point topLeft;
    public Point topRight;

    public Rectangle(Point bottomLeft, Point topRight){
        this.bottomLeft = bottomLeft;
        this.bottomRight = new Point(bottomLeft.y, topRight.x);
        this.topLeft = new Point(bottomLeft.x, topRight.y);
        this.topRight = topRight;
    }

    public boolean intersects(Rectangle r){
        return this.bottomLeft.lessThanOrEqual(r.topRight) &&
            this.topRight.greaterThanOrEqual(r.bottomLeft);
    }
}