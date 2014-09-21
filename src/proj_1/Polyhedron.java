/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proj_1;

import school_res.Plane;
import javax.media.opengl.GL;

/**
 *
 * @author mk-17
 */
public class Polyhedron {

    public Plane[] planes;
    
    public Polyhedron(){
    
    }
    
    public void drawPolyhedron(GL gl) {
        gl.glBegin(GL.GL_LINES);
        gl.glColor3f(1.0f, 0.0f, 0.0f);    // Set the current drawing color to red
//            gl.glVertex3f(0.0f, 0.0f, 0.0f);   // Top
//            gl.glColor3f(0.0f, 1.0f, 0.0f);    // Set the current drawing color to green
        //front
        gl.glVertex3f(-1.0f, -1.0f, 0.0f); // Front bottom left
        gl.glVertex3f(-1.0f, 1.0f, 0.0f);
        gl.glVertex3f(-1.0f, 1.0f, 0.0f); // Front top left
        gl.glVertex3f(1.0f, 1.0f, 0.0f);
        gl.glVertex3f(1.0f, 1.0f, 0.0f); // front top right
        gl.glVertex3f(1.0f, -1.0f, 0.0f);
        gl.glVertex3f(1.0f, -1.0f, 0.0f); // front bottom right
        gl.glVertex3f(-1.0f, -1.0f, 0.0f);
        //left
        gl.glVertex3f(-1.0f, -1.0f, 0.0f);
        gl.glVertex3f(-1.0f, -1.0f, -2.0f); //left bottom

        gl.glVertex3f(-1.0f, -1.0f, -2.0f);
        gl.glVertex3f(-1.0f, 1.0f, -2.0f);  //left top

        gl.glVertex3f(-1.0f, 1.0f, -2.0f);
        gl.glVertex3f(-1.0f, 1.0f, 0.0f);

        //bottom
        gl.glVertex3f(-1.0f, -1.0f, -2.0f);
        gl.glVertex3f(1.0f, -1.0f, -2.0f);

        gl.glVertex3f(1.0f, -1.0f, -2.0f);
        gl.glVertex3f(1.0f, -1.0f, 0.0f);
        //top
        gl.glVertex3f(-1.0f, 1.0f, -2.0f); // Front Top
        gl.glVertex3f(1.0f, 1.0f, -2.0f); // Front Top

        gl.glVertex3f(1.0f, 1.0f, -2.0f); // Front Top
        gl.glVertex3f(1.0f, -1.0f, -2.0f); // Front Top

        gl.glVertex3f(1.0f, 1.0f, -2.0f); // Front Top
        gl.glVertex3f(1.0f, 1.0f, 0.0f); // Front Top

//            gl.glColor3f(0.0f, 0.0f, 1.0f);    // Set the current drawing color to blue
//            gl.glVertex3f(1.0f, -1.0f, 0.0f);  // Bottom Right
        // Finished Drawing The Triangle
        gl.glEnd();
    }
}
