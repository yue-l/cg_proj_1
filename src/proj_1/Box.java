package proj_1;

/**
   A utility class that represents a box polyhedron specified by 
   six intersecting planes
   @author Andrew Ensor
*/
import school_res.Point3D;
import school_res.Vector3D;
import school_res.Plane;
import java.util.Collection;

public class Box extends ConvexPolyhedron
{
   private Collection<Plane> planes;
   
   public Box(Point3D corner, Vector3D side1, Vector3D side2,
      Vector3D side3)
   {  super();
      // determine whether side1, side2, side3 follow right hand rule
      if (side1.crossProduct(side2).dotProduct(side3)<0)
      {  // swap side1 with side2 so follow right hand rule
         Vector3D temp = side1;
         side1 = side2;
         side2 = temp;
      }
      Point3D oppositeCorner = corner.add(side1).add(side2).add(side3);
      addPlane(new Plane(corner, side2.crossProduct(side1)));
      addPlane(new Plane(corner, side1.crossProduct(side3)));
      addPlane(new Plane(corner, side3.crossProduct(side2)));
      addPlane(new Plane(oppositeCorner, side1.crossProduct(side2)));
      addPlane(new Plane(oppositeCorner, side3.crossProduct(side1)));
      addPlane(new Plane(oppositeCorner, side2.crossProduct(side3)));
   }
}
