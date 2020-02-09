public class RectangleIntersect {
    public static void main(String[] args){
        Rectangle a = new Rectangle(
            new Point(3,5), new Point(11,11));
        Rectangle b = new Rectangle(
            new Point(7,2), new Point(13,7));
        Rectangle c = new Rectangle(
            new Point(10,10), new Point(14,13));

        System.out.println("A intersects B? " + a.intersects(b));
        System.out.println("A intersects C? " + a.intersects(c));
        System.out.println("B intersects C? " + b.intersects(c));

        System.out.println("Area of Intersection (A,B): " + a.areaOfIntersection(b));
        System.out.println("Area of Intersection (A,C): " + a.areaOfIntersection(c));
        System.out.println("Area of Intersection (B,C): " + b.areaOfIntersection(c));
    }
}
