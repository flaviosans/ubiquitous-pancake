public class Rectangle {

    private final Point bottomLeft;
    private final Point bottomRight;
    private final Point topLeft;
    private final Point topRight;

    public Point getBottomLeft(){
        return this.bottomLeft;
    }

    public Point getBottomRight(){
        return this.bottomRight;
    }

    public Point getTopLeft(){
        return this.topLeft;
    }

    public Point getTopRight(){
        return this.topRight;
    }

    public int getArea(){
        int width = this.topLeft.y - this.bottomLeft.y;
        int height = this.bottomRight.x - this.bottomLeft.x;
        return width * height;
    }

    public Rectangle(Point bottomLeft, Point topRight){
        this.bottomLeft = bottomLeft;
        this.bottomRight = new Point(topRight.x, bottomLeft.y);
        this.topLeft = new Point(bottomLeft.x, topRight.y);
        this.topRight = topRight;
    }

    public boolean intersects(Rectangle rectangle){
        return this.bottomLeft.lessThanOrEqual(rectangle.topRight) &&
            this.topRight.greaterThanOrEqual(rectangle.bottomLeft);
    }

    public int areaOfIntersection(Rectangle rectangle){
        int area = 0;
        if (this.intersects(rectangle)){
            if(this.bottomLeft.greaterThanOrEqual(rectangle.bottomLeft)){
                area = new Rectangle(this.topRight, rectangle.bottomLeft).getArea();
            }
            else{
                area = new Rectangle(
                        new Point(this.bottomLeft.y,rectangle.bottomLeft.y),
                        new Point(rectangle.topRight.y,this.topRight.x)
                    ).getArea();
            }
        }

        return area;
    }
}