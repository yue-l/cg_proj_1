package school_res;

/**
   A utility class that represents a plane in point-normal form
   @author Andrew Ensor
*/
public class Plane
{
   private Point3D point; // point on the plane
   private Vector3D normal; // normal to the plane
   
   public Plane(Point3D point, Vector3D normal)
   {  this.point = point;
      this.normal = normal;
   }
   
   public Point3D getPoint()
   {  return point;
   }
   
   public Vector3D getNormal()
   {  return normal;
   }
   
   public String toString()
   {  return "Plane through " + point + " with normal " + normal;
   }
}
   
