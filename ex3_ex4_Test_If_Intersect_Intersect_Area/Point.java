public class Point {

    public int x;
    public int y;

    public Point(int x, int y){
        this.x = x;
        this.y = y;
    }

    public boolean greaterThanOrEqual(Point point){
        return this.x >= point.x && this.y >= point.y;
    }

    public boolean lessThanOrEqual(Point point){
        return this.x <= point.x && this.y <= point.y;
    }
}