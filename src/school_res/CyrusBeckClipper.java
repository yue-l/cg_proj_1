package school_res;

/**
 * A class that uses the Cyrus-Beck clipper to clip the portion of a line that
 * lies outside the specified convex polyhedron
 */
import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner; // Java 1.5 equivalent of cs1.Keyboard

public class CyrusBeckClipper {

    private Collection<Plane> planes;
    public Point3D in;
    public Point3D out;

    // convex polyhedron specified to constructor as planes
    public CyrusBeckClipper(Collection<Plane> planes) {
        this.planes = planes;
    }

    // modifies the points p1 and p2 so that the line segment joining
    // p1 and p2 is clipped to lie inside the convex polyhedron
    // returns whether any of line remaining to draw after clipping
    // note that p1 and/or p2 might be given infinite coordinates
    // if planes did not give a closed surface
    public boolean clip(Point3D p1, Point3D p2) {
        Vector3D v = p2.subtract(p1); // direction vector for line
        double tIn = Double.NEGATIVE_INFINITY;
        double tOut = Double.POSITIVE_INFINITY;
        // iterate through each plane in turn
        for (Plane plane : planes) {
            Vector3D pDifference = plane.getPoint().subtract(p1);
            Vector3D n = plane.getNormal(); // normal vector to plane
            double nDotDifference = n.dotProduct(pDifference);
            double nDotV = n.dotProduct(v);
            // check n.v
            if (nDotV == 0.0) // line is exactly parallel to plane
            {
                if (nDotDifference < 0) {
                    return false; // line on outside half space of plane
                }
            } else {
                double tHit = nDotDifference / nDotV;
                if (nDotV < 0) // tHit is candidate value for tIn
                {
                    tIn = Math.max(tIn, tHit);
                } else // nDotV > 0 so tHit is candidate value for tOut
                {
                    tOut = Math.min(tOut, tHit);
                }
                if (tIn > tOut) {
                    return false;
                }
            }
        }
        // clip the points p1 and p2
        double p1x = p1.getX(), p1y = p1.getY(), p1z = p1.getZ();
        double vx = v.getX(), vy = v.getY(), vz = v.getZ();
        if (tIn > 0.0) // clip past p1
        {
//            p1.set(p1x + tIn * vx, p1y + tIn * vy, p1z + tIn * vz);
            in = new Point3D(p1x + tIn * vx, p1y + tIn * vy, p1z + tIn * vz);
            System.out.println("in set");
        }
        if (tOut < 1.0) // clip before p2
        {
//            p2.set(p1x + tOut * vx, p1y + tOut * vy, p1z + tOut * vz);
            out = new Point3D(p1x + tOut * vx, p1y + tOut * vy, p1z + tOut * vz);
            System.out.println("out set");
        }
        return true;
    }
    
    public static void main(String[] args) {  // create the four planes to represent surface of a tetrahedron
//        Plane xyPlane = new Plane(new Point3D(0, 0, 0),
//                new Vector3D(0, 0, -1));
//        Plane xzPlane = new Plane(new Point3D(0, 0, 0),
//                new Vector3D(0, -1, 0));
//        Plane yzPlane = new Plane(new Point3D(0, 0, 0),
//                new Vector3D(-1, 0, 0));
//        Plane plane = new Plane(new Point3D(0, 0, 1),
//                new Vector3D(1, 1, 1));
//        Plane xyPlane = new Plane(new Point3D(-1.0, -1.0,), new Vector3D());
        Collection<Plane> planes = new ArrayList<Plane>();
//        planes.add(xyPlane);
//        planes.add(xzPlane);
//        planes.add(yzPlane);
//        planes.add(plane);
        CyrusBeckClipper clipper = new CyrusBeckClipper(planes);
        System.out.println("Clip to tetrahedron with vertices at "
                + "(0,0,0), (1,0,0), (0,1,0), (0,0,1)");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter point 1 with space between 3 coords:");
        double x1 = scanner.nextDouble();
        double y1 = scanner.nextDouble();
        double z1 = scanner.nextDouble();
        Point3D p1 = new Point3D(x1, y1, z1);
        System.out.print("Enter point 2 with space between 3 coords:");
        double x2 = scanner.nextDouble();
        double y2 = scanner.nextDouble();
        double z2 = scanner.nextDouble();
        Point3D p2 = new Point3D(x2, y2, z2);
        if (clipper.clip(p1, p2)) {
            System.out.println("Draw from " + p1 + " to " + p2);
        } else {
            System.out.println("Don't draw");
        }
    }
}
