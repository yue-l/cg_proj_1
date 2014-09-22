/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package james;

import java.util.ArrayList;
import javax.media.opengl.GL;
import school_res.CyrusBeckClipper;
import school_res.Plane;
import school_res.Point3D;
import school_res.Vector3D;

/**
 *
 * @author James Gilliland ID:1311022
 * @version 15-09 modified by Yue: changed to a convex cube
 */
public class Cube {

    float[] p1;
    float[] p2;
    float[] p3;
    float[] p4;
    float[] p5;
    float[] p6;
    float[] p7;
    float[] p8;
    float cenX;
    float cenY;
    float cenZ;
    float size;
    //
    CyrusBeckClipper cbc;

    //added
    public Cube(float size, float cenX, float cenY, float cenZ) {
        this.size = size / 2;
        p1 = new float[]{-size, -size, -size};
        p2 = new float[]{+size, -size, -size};
        p3 = new float[]{-size, -size, +size};
        p4 = new float[]{+size, +size, +size};
        p5 = new float[]{+size, -size, +size};
        p6 = new float[]{-size, +size, -size};
        p7 = new float[]{-size, +size, +size};
        p8 = new float[]{+size, +size, -size};
        this.cenX = cenX;
        this.cenY = cenY;
        this.cenZ = cenZ;
        //
        setPlanes();
    }

    public void drawCube(GL gl) {
        gl.glBegin(GL.GL_LINES);
        gl.glColor3f(1.0f, 0.5f, 0.0f);    // Set the current drawing color to red
        //top
        gl.glVertex3f(2.0f, 2.0f, 0.0f);
        gl.glVertex3f(0.0f, 2.0f, 0.0f);

        gl.glVertex3f(0.0f, 2.0f, 0.0f);
        gl.glVertex3f(0.0f, 2.0f, 2.0f);

        gl.glVertex3f(0.0f, 2.0f, 2.0f);
        gl.glVertex3f(2.0f, 2.0f, 2.0f);

        gl.glVertex3f(2.0f, 2.0f, 2.0f);
        gl.glVertex3f(2.0f, 2.0f, 0.0f);

        //bottom
        gl.glVertex3f(2.0f, 0.0f, 0.0f);
        gl.glVertex3f(0.0f, 0.0f, 0.0f);

        gl.glVertex3f(0.0f, 0.0f, 0.0f);
        gl.glVertex3f(0.0f, 0.0f, 2.0f);

        gl.glVertex3f(0.0f, 0.0f, 2.0f);
        gl.glVertex3f(2.0f, 0.0f, 2.0f);

        gl.glVertex3f(2.0f, 0.0f, 2.0f);
        gl.glVertex3f(2.0f, 0.0f, 0.0f);

        //4 vertical lines
        gl.glVertex3f(2.0f, 2.0f, 0.0f);
        gl.glVertex3f(2.0f, 0.0f, 0.0f);

        gl.glVertex3f(0.0f, 2.0f, 0.0f);
        gl.glVertex3f(0.0f, 0.0f, 0.0f);

        gl.glVertex3f(0.0f, 2.0f, 2.0f);
        gl.glVertex3f(0.0f, 0.0f, 2.0f);

        gl.glVertex3f(2.0f, 2.0f, 2.0f);
        gl.glVertex3f(2.0f, 0.0f, 2.0f);
        gl.glEnd();

//            gl.glColor3f(0.0f, 0.0f, 1.0f);    // Set the current drawing color to blue
//            gl.glVertex3f(1.0f, -1.0f, 0.0f);  // Bottom Right
//        //convex
//        gl.glVertex3f(-1.0f, -1.0f, 0.0f); // Front bottom left
//        gl.glVertex3f(-1.0f, 1.0f, 0.0f);
//        gl.glVertex3f(-1.0f, 1.0f, 0.0f); // Front top left
//        gl.glVertex3f(1.0f, 1.0f, 0.0f);
//        gl.glVertex3f(1.0f, 1.0f, 0.0f); // front top right
//        gl.glVertex3f(1.0f, -1.0f, 0.0f);
//        gl.glVertex3f(1.0f, -1.0f, 0.0f); // front bottom right
//        gl.glVertex3f(-1.0f, -1.0f, 0.0f);
//        //left
//        gl.glVertex3f(-1.0f, -1.0f, 0.0f);
//        gl.glVertex3f(-1.0f, -1.0f, -2.0f); //left bottom
//
//        gl.glVertex3f(-1.0f, -1.0f, -2.0f);
//        gl.glVertex3f(-1.0f, 1.0f, -2.0f);  //left top
//
//        gl.glVertex3f(-1.0f, 1.0f, -2.0f);
//        gl.glVertex3f(-1.0f, 1.0f, 0.0f);
//
//        //bottom
//        gl.glVertex3f(-1.0f, -1.0f, -2.0f);
//        gl.glVertex3f(1.0f, -1.0f, -2.0f);
//
//        gl.glVertex3f(1.0f, -1.0f, -2.0f);
//        gl.glVertex3f(1.0f, -1.0f, 0.0f);
//        //top
//        gl.glVertex3f(-1.0f, 1.0f, -2.0f); // Front Top
//        gl.glVertex3f(1.0f, 1.0f, -2.0f); // Front Top
//
//        gl.glVertex3f(1.0f, 1.0f, -2.0f); // Front Top
//        gl.glVertex3f(1.0f, -1.0f, -2.0f); // Front Top
//
//        gl.glVertex3f(1.0f, 1.0f, -2.0f); // Front Top
//        gl.glVertex3f(1.0f, 1.0f, 0.0f); // Front Top
//
////            gl.glColor3f(0.0f, 0.0f, 1.0f);    // Set the current drawing color to blue
////            gl.glVertex3f(1.0f, -1.0f, 0.0f);  // Bottom Right
//        gl.glEnd();
//        //end
//        gl.glBegin(GL.GL_POLYGON);
//        gl.glColor3f(0, 0, 0);
//        gl.glVertex3f(p1[0]+cenX, p1[1]+cenY, p1[2]+cenZ);
//        gl.glColor3f(1, 0, 0);
//        gl.glVertex3f(p2[0]+cenX, p2[1]+cenY, p2[2]+cenZ);
//        gl.glColor3f(1, 0, 1);
//        gl.glVertex3f(p5[0]+cenX, p5[1]+cenY, p5[2]+cenZ);
//        gl.glColor3f(0, 0, 1);
//        gl.glVertex3f(p3[0]+cenX, p3[1]+cenY, p3[2]+cenZ);
//        gl.glEnd();
//
//        gl.glBegin(GL.GL_POLYGON);
//        gl.glColor3f(0, 0, 0);
//        gl.glVertex3f(p1[0]+cenX, p1[1]+cenY, p1[2]+cenZ);
//        gl.glColor3f(0, 1, 0);
//        gl.glVertex3f(p6[0]+cenX, p6[1]+cenY, p6[2]+cenZ);
//        gl.glColor3f(0, 1, 1);
//        gl.glVertex3f(p7[0]+cenX, p7[1]+cenY, p7[2]+cenZ);
//        gl.glColor3f(0, 0, 1);
//        gl.glVertex3f(p3[0]+cenX, p3[1]+cenY, p3[2]+cenZ);
//        gl.glEnd();
//
//        gl.glBegin(GL.GL_POLYGON);
//        gl.glColor3f(0, 0, 0);
//        gl.glVertex3f(p1[0]+cenX, p1[1]+cenY, p1[2]+cenZ);
//        gl.glColor3f(0, 1, 0);
//        gl.glVertex3f(p6[0]+cenX, p6[1]+cenY, p6[2]+cenZ);
//        gl.glColor3f(1, 1, 0);
//        gl.glVertex3f(p8[0]+cenX, p8[1]+cenY, p8[2]+cenZ);
//        gl.glColor3f(1, 0, 0);
//        gl.glVertex3f(p2[0]+cenX, p2[1]+cenY, p2[2]+cenZ);
//        gl.glEnd();
//
//        gl.glBegin(GL.GL_POLYGON);
//        gl.glColor3f(0, 0, 1);
//        gl.glVertex3f(p3[0]+cenX, p3[1]+cenY, p3[2]+cenZ);
//        gl.glColor3f(0, 1, 1);
//        gl.glVertex3f(p7[0]+cenX, p7[1]+cenY, p7[2]+cenZ);
//        gl.glColor3f(1, 1, 1);
//        gl.glVertex3f(p4[0]+cenX, p4[1]+cenY, p4[2]+cenZ);
//        gl.glColor3f(1, 0, 1);
//        gl.glVertex3f(p5[0]+cenX, p5[1]+cenY, p5[2]+cenZ);
//        gl.glEnd();
//
//        gl.glBegin(GL.GL_POLYGON);
//        gl.glColor3f(0, 1, 0);
//        gl.glVertex3f(p6[0]+cenX, p6[1]+cenY, p6[2]+cenZ);
//        gl.glColor3f(1, 1, 0);
//        gl.glVertex3f(p8[0]+cenX, p8[1]+cenY, p8[2]+cenZ);
//        gl.glColor3f(1, 1, 1);
//        gl.glVertex3f(p4[0]+cenX, p4[1]+cenY, p4[2]+cenZ);
//        gl.glColor3f(0, 1, 1);
//        gl.glVertex3f(p7[0]+cenX, p7[1]+cenY, p7[2]+cenZ);
//        gl.glEnd();
//
//        gl.glBegin(GL.GL_POLYGON);
//        gl.glColor3f(1, 0, 0);
//        gl.glVertex3f(p2[0]+cenX, p2[1]+cenY, p2[2]+cenZ);
//        gl.glColor3f(1, 1, 0);
//        gl.glVertex3f(p8[0]+cenX, p8[1]+cenY, p8[2]+cenZ);
//        gl.glColor3f(1, 1, 1);
//        gl.glVertex3f(p4[0]+cenX, p4[1]+cenY, p4[2]+cenZ);
//        gl.glColor3f(1, 0, 1);
//        gl.glVertex3f(p5[0]+cenX, p5[1]+cenY, p5[2]+cenZ);
//        gl.glEnd();
    }

    public void translate(float moveX, float moveY, float moveZ) {
        cenX += moveX;
        cenY += moveY;
        cenZ += moveZ;
    }

    public void setPosition(float cenX, float cenY, float cenZ) {
        this.cenX = cenX;
        this.cenY = cenY;
        this.cenZ = cenZ;
    }

    public void rotate(float rotX, float rotY, float rotZ) {
        p1 = rotatePoint(p1[0], p1[1], p1[2], rotX, rotY, rotZ);
        p2 = rotatePoint(p2[0], p2[1], p2[2], rotX, rotY, rotZ);
        p3 = rotatePoint(p3[0], p3[1], p3[2], rotX, rotY, rotZ);
        p4 = rotatePoint(p4[0], p4[1], p4[2], rotX, rotY, rotZ);
        p5 = rotatePoint(p5[0], p5[1], p5[2], rotX, rotY, rotZ);
        p6 = rotatePoint(p6[0], p6[1], p6[2], rotX, rotY, rotZ);
        p7 = rotatePoint(p7[0], p7[1], p7[2], rotX, rotY, rotZ);
        p8 = rotatePoint(p8[0], p8[1], p8[2], rotX, rotY, rotZ);
    }

    private float[] rotatePoint(float x, float y, float z, float thetaX, float thetaY, float thetaZ) {
        float[] point = new float[3];
        float cosX = (float) Math.cos(thetaX);
        float sinX = (float) Math.sin(thetaX);
        float cosY = (float) Math.cos(thetaY);
        float sinY = (float) Math.sin(thetaY);
        float cosZ = (float) Math.cos(thetaZ);
        float sinZ = (float) Math.sin(thetaZ);
        point[0] = (float) (cosY * cosZ * x + (cosZ * sinY - cosX * sinZ) * y + (cosX * cosZ * sinY + sinX * sinZ) * z);
        point[1] = (float) (cosY * sinZ * x + (cosX * cosZ + sinX * sinY * sinZ) * y + (-cosZ * sinX + cosX * sinY * sinZ) * z);
        point[2] = (float) (-sinY * x + cosY * sinX * y + cosX * cosY * z);
        return point;
    }

    public void setPlanes() {
        ArrayList<Plane> planes = new ArrayList<Plane>();
        //set planes
        //point 2 2 0
        Plane topPlane = new Plane(new Point3D(2, 2, 0), new Vector3D(0, 1, 0));
        Plane leftPlane = new Plane(new Point3D(2, 2, 0), new Vector3D(1, 0, 0));
        Plane backPlane = new Plane(new Point3D(2, 2, 0), new Vector3D(0, 0, -1));
        //point 0 0 2
        Plane bottomPlane = new Plane(new Point3D(0, 0, 2), new Vector3D(0, -1, 0));
        Plane rightPlane = new Plane(new Point3D(0, 0, 2), new Vector3D(-1, 0, 0));
        Plane frontPlane = new Plane(new Point3D(0, 0, 2), new Vector3D(0, 0, 1));
        planes.add(topPlane);
        planes.add(leftPlane);
        planes.add(backPlane);
        planes.add(bottomPlane);
        planes.add(rightPlane);
        planes.add(frontPlane);
        cbc = new CyrusBeckClipper(planes);
    }

}
