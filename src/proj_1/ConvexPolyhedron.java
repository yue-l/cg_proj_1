package proj_1;
/**
   A utility class that represents a convex polyhedron specified as
   the intersection of the inner half spaces of a collection of planes
   @author Andrew Ensor
*/
import school_res.Plane;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class ConvexPolyhedron
{
   private Collection<Plane> planes;

   public ConvexPolyhedron()
   {  this.planes = new ArrayList<Plane>();
   }
   
   public ConvexPolyhedron(Collection<Plane> planes)
   {  this.planes = planes;
   }
   
   public void addPlane(Plane plane)
   {  this.planes.add(plane);
   }
   
   public Iterator<Plane> getPlanes()
   {  return planes.iterator();
   }
   
   public String toString()
   {  String output = "Polyhedron:";
      for (Plane plane : planes)
         output += " " + plane;
      return output;
   }
}
   
