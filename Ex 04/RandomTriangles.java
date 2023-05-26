// write an application that displays randomly generated triangles 
// in different colors. Each triangle should be filled with a different color. 
// Use class GeneralPath and method fill of class Graphics2D to draw the triangles

import javax.swing.*;
import java.awt.*;
import java.awt.geom.GeneralPath;
import java.util.Random;

public class RandomTriangles extends JFrame {

    private Random random;

    public RandomTriangles() {
        setTitle("Random Triangles");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        random = new Random();
    }

    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;

        for (int i = 0; i < 20; i++) {
            int[] xPoints = generateRandomPoints();
            int[] yPoints = generateRandomPoints();

            GeneralPath triangle = new GeneralPath();
            triangle.moveTo(xPoints[0], yPoints[0]);
            triangle.lineTo(xPoints[1], yPoints[1]);
            triangle.lineTo(xPoints[2], yPoints[2]);
            triangle.closePath();

            g2d.setColor(getRandomColor());
            g2d.fill(triangle);
        }
    }

    private int[] generateRandomPoints() {
        int[] points = new int[3];
        for (int i = 0; i < points.length; i++) {
            points[i] = random.nextInt(getWidth());
        }
        return points;
    }

    private Color getRandomColor() {
        int r = random.nextInt(256);
        int g = random.nextInt(256);
        int b = random.nextInt(256);

        return new Color(r, g, b);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            RandomTriangles triangles = new RandomTriangles();
            triangles.setVisible(true);
        });
    }
}