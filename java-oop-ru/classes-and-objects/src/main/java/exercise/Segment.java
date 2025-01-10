package exercise;

// BEGIN
public class Segment {
    Point pointA;
    Point pointB;

    Segment(Point pointA, Point pointB) {
        this.pointA = pointA;
        this.pointB = pointB;
    }

    public Point getBeginPoint() {
        return pointA;
    }

    public Point getEndPoint() {
        return pointB;
    }

    public Point getMidPoint() {
        int x = (pointA.getX() + pointB.getX()) / 2;
        int y = (pointA.getY() + pointB.getY()) / 2;

        return new Point(x, y);
    }

}
// END
