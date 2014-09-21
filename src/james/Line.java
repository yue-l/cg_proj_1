/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package james;

import javax.media.opengl.GL;
import school_res.Vector3D;

/**
 *
 * @author mk-17
 */
public class Line {

    public float[] startPts;
    public float[] endPts;
    public float[] rgb;
    public boolean reversed;
    
    public Vector3D vec;
    // -3, 0, -1
    // -5, 0, -1
    public Line(float[] start, float[] end) {
        this.startPts = start;
        this.endPts = end;
        rgb = new float[]{0.0f, 0.1f, 0.0f};
    }

    public void drawLine(GL gl) {
//        gl.glColor3f(0.0f, 1.0f, 0.0f);
        gl.glColor3f(rgb[0], rgb[1], rgb[2]);
        gl.glBegin(GL.GL_LINES);
        gl.glVertex3f(startPts[0], 0.0f, -1.0f);
        gl.glVertex3f(endPts[0], 0.0f, -1.0f);
//        gl.glVertex3f(-3.0f, 0.0f, -1.0f);
//        gl.glVertex3f(-5.0f, 0.0f, -1.0f);

        gl.glEnd();
    }

    public void moveLine(GL gl) {
        if (rgb[1] < 255) {
            rgb[1] += 1f;
        } else if (rgb[0] < 255) {
            rgb[0] += 1f;
        } else if (rgb[2] < 255) {
            rgb[2] += 1f;
        } else {
            rgb[0] = 0.1f;
            rgb[1] = 0.0f;
            rgb[2] = 0.0f;
        }
        if (startPts[0] < 6 && !reversed) {
            startPts[0] += 0.01f;
            endPts[0] += 0.01f;
            if (startPts[0] == 6) {
                reversed = true;
            }
        } else {
            startPts[0] = -3.0f;
            endPts[0] = -5.0f;
        }
    }
    
    public void updateVector(){
        vec = new Vector3D(endPts[0]-startPts[0], endPts[1]-startPts[1], endPts[2]-startPts[2]);
    }
    
}
