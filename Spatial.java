import java.awt.geom.Point2D;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;

public final class Spatial {
  private Spatial() {
    //empty - 'math' class inspired
  }
  
  //rect&rect
  public static Result relate(Rectangle2D Rect1, Rectangle2D Rect2) {
    Result result = Result.NONE;


    return result;
  }

  //rect&line
  public static Result relate(Rectangle2D Rect, Line2D Line) {
    Result result = Result.NONE;


    return result;
  }


  //rect&point
  public static Result relate(Rectangle2D Rect, Point2D Point) {
    Result result = Result.NONE;


    return result;
  }


  //line&line
  public static Result relate(Line2D Line1, Line2D Line2) {
    Result result = Result.NONE;
    if (Line1.intersectsLine(Line2)) return result;
    else return result;

  }


  //line&point
  public static Result relate(Line2D Line, Point2D Point) {
    Result result = Result.NONE;
    if (Line.contains(Point)) result = COVERS; //there isn't ANYINTERSECT nor CONTAINS relation
    else result = DISJOINT;
    return result;
  }

  //point&point
  public static Result relate(Point2D Point1, Point2D Point2) {
    Result result = Result.NONE;
    if (Point1.equals(Point2)) {
      result = EQUAL; //there isn't ANYINTERSECT, CONTAINS nor COVERS relation
    } else result = DISJOINT;

    return result;
  }
}
