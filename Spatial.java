import java.awt.geom.Point2D;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;

public final class Spatial {
  private Spatial() {

  }
  
  //rect&rect
  public static Result relate(Rectangle2D.Double Rect1, Rectangle2D.Double Rect2) {
    Result result = Result.NONE;


    return result;
  }

  //rect&line



  //rect&point



  //line&line



  //line&point
  public static Result relate(Line2D.Double Line, Point2D.Double Point) {
    if (Line.contains(Point)) result = COVERS; //there isn't ANYINTERSECT nor CONTAINS relation
    else result = DISJOINT;
    return result;
  }

  //point&point
  public static Result relate(Point2D.Double Point1, Point2D.Double Point2) {
    Result result = Result.NONE;
    if (Point1.equals(Point2)) {
      result = EQUAL; //there isn't ANYINTERSECT, CONTAINS nor COVERS relation
    } else result = DISJOINT;

    return result;
  }


  
}
