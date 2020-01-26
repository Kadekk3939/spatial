import java.awt.geom.Point2D;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;

public final class Spatial {
  //math class inspired
  private Spatial(){
  }

  public enum Result {
    DISJOINT,
    ANYINTERSECT,
    CONTAINS,
    COVERS,
    EQUALS;
  }

  //rect&rect
  public static Result relate(Rectangle2D.Double Rect1, Rectangle2D.Double Rect2) {
    Result result = Result.DISJOINT;
    return result;
  }

  //rect&line



  //rect&point



  //line&line



  //line&point




  //point&point

}

