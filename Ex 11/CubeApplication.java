// Write an application that draws a cube. 
// Use class GeneralPath and method draw of class Graphics2D

import javax.swing.*;
import java.awt.*;
import java.awt.geom.GeneralPath;

public class CubeApplication extends JFrame {

    public CubeApplication() {
        setTitle("Cube Application");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;

        int centerX = getWidth() / 2;
        int centerY = getHeight() / 2;
        int size = 200;

        int[] xPoints = {centerX - size/2, centerX + size/2, centerX + size/2, centerX - size/2};
        int[] yPoints = {centerY - size/2, centerY - size/2, centerY + size/2, centerY + size/2};

        GeneralPath cube = new GeneralPath();
        cube.moveTo(xPoints[0], yPoints[0]);
        for (int i = 1; i < xPoints.length; i++) {
            cube.lineTo(xPoints[i], yPoints[i]);
        }
        cube.closePath();

        g2d.draw(cube);

        int[] topXPoints = {xPoints[0], xPoints[1], xPoints[1] - size/2, xPoints[0] - size/2};
        int[] topYPoints = {yPoints[0], yPoints[1], yPoints[1] - size/2, yPoints[0] - size/2};
        GeneralPath topFace = new GeneralPath();
        topFace.moveTo(topXPoints[0], topYPoints[0]);
        for (int i = 1; i < topXPoints.length; i++) {
            topFace.lineTo(topXPoints[i], topYPoints[i]);
        }
        topFace.closePath();
        g2d.draw(topFace);

        int[] bottomXPoints = {xPoints[2], xPoints[3], xPoints[3] - size/2, xPoints[2] - size/2};
        int[] bottomYPoints = {yPoints[2], yPoints[3], yPoints[3] - size/2, yPoints[2] - size/2};
        GeneralPath bottomFace = new GeneralPath();
        bottomFace.moveTo(bottomXPoints[0], bottomYPoints[0]);
        for (int i = 1; i < bottomXPoints.length; i++) {
            bottomFace.lineTo(bottomXPoints[i], bottomYPoints[i]);
        }
        bottomFace.closePath();
        g2d.draw(bottomFace);

        for (int i = 0; i < xPoints.length; i++) {
            g2d.drawLine(xPoints[i], yPoints[i], topXPoints[i], topYPoints[i]);
            g2d.drawLine(xPoints[i], yPoints[i], bottomXPoints[i], bottomYPoints[i]);
        }
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            CubeApplication cube = new CubeApplication();
            cube.setVisible(true);
        });
    }
}
