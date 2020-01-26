import java.awt.geom.Point2D;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.util.Scanner;
import java.util.ArrayList;

class Main {
  public static void main(String[] args) {

    //init
    Scanner reader = new Scanner(System.in);
    ArrayList<Point2D> point2DList = new ArrayList<>();
    ArrayList<Line2D> line2DList = new ArrayList<>();
    ArrayList<Rectangle2D> rect2DList = new ArrayList<>();
    ArrayList<String> titles = new ArrayList<>();
    titles.add("First polygon");
    titles.add("Second polygon");
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
          System.out.println("point");
          x = reader.nextDouble();
          y = reader.nextDouble();
          point2DList.add(new Point2D.Double(x, y));
          break;
        case 2:
          //line 
          System.out.println("line");
          x = reader.nextDouble();
          y = reader.nextDouble();
          x2 = reader.nextDouble();
          y2 = reader.nextDouble();
          line2DList.add(new Line2D.Double(x, x2, y, y2));
          break;
        case 3:
          //rect 
          System.out.println("rect");
          x = reader.nextDouble();
          y = reader.nextDouble();
          w = reader.nextDouble();
          h = reader.nextDouble();
          rect2DList.add(new Rectangle2D.Double(x, y, w, h));
          break;
        default:
          System.out.println("error");
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
        res = relate(point2DList.get(0),point2DList.get(0));
      } else if (lCount == 2 && line2DList != null) {
        //line&line 
        res = relate(line2DList.get(0), line2DList.get(1));
      } else if (rCount == 2 && rect2DList != null) {
        //rect&rect
        res = relate(rect2DList.get(0), rect2DList.get(1));
      }
      //diffrent polygons
    } else if (pCount == 0) {
      //rect&line
      res = relate(rect2DList.get(0), line2DList.get(0));
    } else if (lCount == 0) {
      //rect&point
      res = relate(rect2DList.get(0), point2DList.get(0));
    } else { //(rCount == 0)
      //line&point
      res = relate(line2DList.get(0), point2DList.get(0));
    } 
    System.out.println(res);
  }
}
