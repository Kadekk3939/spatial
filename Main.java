import java.awt.geom.Point2D;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    //data input
    Scanner reader = new Scanner(System.in);
    System.out.println("Enter a number: 1,2,3");
    int poly1 = reader.nextInt();
    switch(poly1) {
      case 1:
        //point 
        break;
      case 2:
        //line 
        break;
      case 3:
        //rect 
        break;
      default:
        //error
        System.exit(1);
    }
    Object test = new Point2D.Double(1.0, 2.0);
    //int poly2 = reader.nextInt();

    reader.close();
    Point2D p = new Point2D.Double(0.0, 0.0);
    Rectangle2D r = new Rectangle2D.Double(0.0, 0.0, 10, 10);
    System.out.println(r.toString());
    System.out.println(poly1);
    //System.out.println(poly2);
    System.out.println(test.getX().toString());

  }

  
}
