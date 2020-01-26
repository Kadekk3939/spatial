import java.awt.geom.Point2D;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;

public final class Spatial {
  private Spatial() {
    //empty - 'math' class inspired
  }
  
  //rect&rect
  public static Result relate(Rectangle2D.Double Rect1, Rectangle2D.Double Rect2) {
    Result result = Result.NONE;
    if (Rect1.contains(Rect2.getX(),Rect2.getY(),Rect2.getWidth(),Rect2.getHeight()) || Rect2.contains(Rect1.getX(),Rect1.getY(),Rect1.getWidth(),Rect1.getHeight())) {
      if (Rect1.getX() == Rect2.getX() || Rect1.getY() == Rect2.getY() || Rect1.getX() + Rect1.getWidth() == Rect2.getX() + Rect2.getWidth() || Rect1.getY() + Rect2.getHeight() == Rect2.getY() + Rect2.getHeight()) result = Result.COVERS;
    }
    else result = Result.NONE; //there shoul be more 'if's'

    return result;
  }

  //rect&line
  public static Result relate(Rectangle2D.Double Rect, Line2D.Double Line) {
    Result result = Result.NONE;
    Point2D.Double P1 = new Point2D.Double(Line.getP1().getX(), Line.getP1().getY());
    Point2D.Double P2 = new Point2D.Double(Line.getP2().getX(), Line.getP2().getY());

    if ((relate(Rect, P1) == Result.COVERS && (relate(Rect, P2) == Result.COVERS || relate(Rect, P2) == Result.CONTAINS)) || (relate(Rect, P2) == Result.COVERS && relate(Rect, P1) == Result.CONTAINS)) result = Result.COVERS;
    else result = Result.NONE; //there shoul be more 'if's'

    return result;
  }


  //rect&point
  public static Result relate(Rectangle2D.Double Rect, Point2D.Double Point) {
    Result result = Result.NONE;
    double px = Point.getX(), py = Point.getY();
    double rx = Rect.getX(), ry = Rect.getY();
    double rw = Rect.getWidth(), rh = Rect.getHeight();

    if (((px == rx || px == rx+rw) && (py <= ry && py >= ry+rh)) || ((py == ry || py == ry+rh) && (px <= rx+rw && px >= rx))) { 
      result = Result.COVERS; //lies on border
    } else if (Rect.contains(px,py)) result = Result.CONTAINS; //is inside
    else result = Result.DISJOINT;
    return result;
  }

  //line&line
  public static Result relate(Line2D.Double Line1, Line2D.Double Line2) {
    Result result = Result.NONE;
    Point2D.Double Pa1 = new Point2D.Double(Line1.getP1().getX(), Line1.getP1().getY());
    Point2D.Double Pa2 = new Point2D.Double(Line1.getP2().getX(), Line1.getP2().getY());
    Point2D.Double Pb1 = new Point2D.Double(Line2.getP1().getX(), Line2.getP1().getY()); 
    Point2D.Double Pb2 = new Point2D.Double(Line2.getP2().getX(), Line2.getP2().getY());

    if ((relate(Line1, Pb1) == Result.COVERS && relate(Line1, Pb2) == Result.COVERS) || (relate(Line2, Pa1) == Result.COVERS && relate(Line2, Pa2) == Result.COVERS)) result = Result.COVERS;
    else result = Result.NONE; //there shoul be more 'if's'
    return result;
  }

  //line&point
  public static Result relate(Line2D.Double Line, Point2D.Double Point) {
    Result result = Result.NONE;
    System.out.println(Line.ptLineDist(Point.getX(), Point.getY()));
    //if (Line.contains(Point)) result = Result.COVERS; 
    if (Line.ptSegDist(Point.getX(), Point.getY()) == 0.0) result = Result.COVERS;//there isn't ANYINTERSECT nor CONTAINS relation
    else result = Result.DISJOINT;
    return result;
  }

  //point&point
  public static Result relate(Point2D.Double Point1, Point2D.Double Point2) {
    Result result = Result.NONE;
    if (Point1.equals(Point2)) {
      result = Result.EQUAL; //there isn't ANYINTERSECT, CONTAINS nor COVERS relation
    } else result = Result.DISJOINT;

    return result;
  }
}
