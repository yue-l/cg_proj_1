/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package james;

import javax.media.opengl.GL;
import school_res.Point3D;
import school_res.Vector3D;

/**
 *
 * @author mk-17
 */
public class Line {

    public final float[] INIT_START;
    public final float[] INIT_END;
    public float[] startPts;
    public float[] endPts;
    public float[] rgb;
    public boolean reversed;
    public Cube cube;

    public float[] vec;

    // -3, 0, -1
    // -5, 0, -1
    public Line(float[] start, float[] end) {
        this.startPts = start;
        this.endPts = end;
        rgb = new float[]{0.0f, 0.1f, 0.0f};
        INIT_START = start;
        INIT_END = end;
        updateVector();
    }

    public void drawLine(GL gl) {
        gl.glBegin(GL.GL_LINES);
        if (cube.cbc.clip(new Point3D(startPts[0], startPts[1], startPts[2]), new Point3D(endPts[0], endPts[1], endPts[2]))) {
            if (cube.cbc.out != null && cube.cbc.in != null && endPts[1] > (float) cube.cbc.in.py) {
                gl.glColor3f(1, 0, 0);
                gl.glVertex3f(endPts[0], endPts[1], endPts[2]);
                gl.glVertex3f(startPts[0], startPts[1], startPts[2]);
            } else if (cube.cbc.out != null && cube.cbc.in != null && endPts[1] > (float) cube.cbc.out.py) {
                gl.glColor3f(0, 1, 0);
                gl.glVertex3f(endPts[0], endPts[1], endPts[2]);
                gl.glVertex3f((float) cube.cbc.in.px, (float) cube.cbc.in.py, (float) cube.cbc.in.pz);
                gl.glColor3f(1, 0, 0);
                gl.glVertex3f((float) cube.cbc.in.px, (float) cube.cbc.in.py, (float) cube.cbc.in.pz);
                gl.glVertex3f(startPts[0], startPts[1], startPts[2]);
            } else if (cube.cbc.out != null && cube.cbc.in != null) {
                gl.glColor3f(1, 0, 0);
                gl.glVertex3f(startPts[0], startPts[1], startPts[2]);
                gl.glVertex3f((float) cube.cbc.in.px, (float) cube.cbc.in.py, (float) cube.cbc.in.pz);

                gl.glColor3f(0, 1, 0);
                gl.glVertex3f((float) cube.cbc.out.px, (float) cube.cbc.out.py, (float) cube.cbc.out.pz);
                gl.glVertex3f((float) cube.cbc.in.px, (float) cube.cbc.in.py, (float) cube.cbc.in.pz);

                gl.glColor3f(1, 0, 0);
                gl.glVertex3f((float) cube.cbc.out.px, (float) cube.cbc.out.py, (float) cube.cbc.out.pz);
                gl.glVertex3f(endPts[0], endPts[1], endPts[2]);

            } else if (cube.cbc.out != null && (float) cube.cbc.out.py < startPts[1]) {
                gl.glColor3f(0, 1, 0);
                gl.glVertex3f((float) cube.cbc.out.px, (float) cube.cbc.out.py, (float) cube.cbc.out.pz);
                gl.glVertex3f(startPts[0], startPts[1], startPts[2]);
                gl.glColor3f(1, 0, 0);
                gl.glVertex3f(startPts[0], startPts[1], startPts[2]);
                gl.glVertex3f(endPts[0], endPts[1], endPts[2]);
            } else if (cube.cbc.out != null) {
                gl.glColor3f(1, 0, 0);
                gl.glVertex3f(endPts[0], endPts[1], endPts[2]);
                gl.glVertex3f(startPts[0], startPts[1], startPts[2]);
            } else if (cube.cbc.in != null) {
                gl.glColor3f(0, 1, 0);
                gl.glVertex3f((float) cube.cbc.in.px, (float) cube.cbc.in.py, (float) cube.cbc.in.pz);
                gl.glVertex3f(endPts[0], endPts[1], endPts[2]);
                gl.glColor3f(1, 0, 0);
                gl.glVertex3f((float) cube.cbc.in.px, (float) cube.cbc.in.py, (float) cube.cbc.in.pz);
                gl.glVertex3f(startPts[0], startPts[1], startPts[2]);
            }
        }
        gl.glEnd();
    }

    public void moveLine(GL gl) {
        if (endPts[1] < 3.0f) {
            startPts[1] += vec[1];
            endPts[1] += vec[1];
        }
    }

    public void updateVector() {
        vec = new float[]{(endPts[0] - startPts[0]) / 10f, Math.abs((endPts[1] - startPts[1]) / 500f), (endPts[2] - startPts[2]) / 10f};
    }

}
