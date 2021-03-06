import java.awt.geom.Point2D;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.util.Scanner;
import java.util.ArrayList;

class Main {
  public static void main(String[] args) {

    //init
    Scanner reader = new Scanner(System.in);
    ArrayList<Point2D.Double> point2DList = new ArrayList<>();
    ArrayList<Line2D.Double> line2DList = new ArrayList<>();
    ArrayList<Rectangle2D.Double> rect2DList = new ArrayList<>();
    ArrayList<String> titles = new ArrayList<>();
    titles.add("\nFirst polygon");
    titles.add("\nSecond polygon");
    int poly = 0;
    double x,y,x2,y2,w,h;

    //user input
    for(int i = 0; i<2; i++) {
      System.out.println(titles.get(i));
      System.out.println("Enter a number (1 - point, 2 - line, 3 - rectangle):");
      poly = reader.nextInt();
      switch(poly) {
        case 1:
          //point 
          System.out.println("You've chosen point.");
          System.out.println("Enter coordinates: x y ");
          x = reader.nextDouble();
          y = reader.nextDouble();
          point2DList.add(new Point2D.Double(x, y));
          break;
        case 2:
          //line 
          System.out.println("You've chosen line.");
          System.out.println("Enter coordinates: x1 y1 x2 y2");
          x = reader.nextDouble();
          y = reader.nextDouble();
          x2 = reader.nextDouble();
          y2 = reader.nextDouble();
          if (x > x2 || (x == x2 && y > y2)) {
            double tmpX = x;
            x = x2;
            x2 = tmpX;
            double tmpY = y;
            y = y2;
            y2 = tmpY;
          }
          line2DList.add(new Line2D.Double(x, y, x2, y2));
          break;
        case 3:
          //rect 
          System.out.println("You've chosen rectangle.");
          System.out.println("Enter coordinates: x y width height"); //x,y of lower-left corner
          x = reader.nextDouble();
          y = reader.nextDouble();
          w = reader.nextDouble();
          h = reader.nextDouble();
          if (w < 0) {
            w *= -1;
            x -= w;
          }
          if (h < 0) {
            h *= -1;
            y -= w;
          }
          rect2DList.add(new Rectangle2D.Double(x, y, w, h));
          break;
        default:
          System.out.println("Error: wrong shape number.");
          System.exit(1);
      }
    }
    reader.close();

    //output
    int pCount = point2DList.size();
    int lCount = line2DList.size();
    int rCount = rect2DList.size();
    Result res = Result.NONE;
    //same polygons
    if (pCount == 2 || lCount ==2 || rCount == 2) {
      if (pCount == 2 && point2DList != null) {
        //point&point
        res = Spatial.relate(point2DList.get(0),point2DList.get(0));
      } else if (lCount == 2 && line2DList != null) {
        //line&line 
        res = Spatial.relate(line2DList.get(0), line2DList.get(1));
      } else if (rCount == 2 && rect2DList != null) {
        //rect&rect
        res = Spatial.relate(rect2DList.get(0), rect2DList.get(1));
      }
      //diffrent polygons
    } else if (pCount == 0) {
      //rect&line
      res = Spatial.relate(rect2DList.get(0), line2DList.get(0));
    } else if (lCount == 0) {
      //rect&point
      res = Spatial.relate(rect2DList.get(0), point2DList.get(0));
    } else { //(rCount == 0)
      //line&point
      res = Spatial.relate(line2DList.get(0), point2DList.get(0));
    } 

    System.out.println("\nRelation:");
    System.out.println(res);
  }

}
