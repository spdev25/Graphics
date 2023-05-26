// Write an application that uses Graphics method drawPolyline to draw
// a spiral similar to the one shown in Fig. 15.33.

import javax.swing.*;
import java.awt.*;

public class SpiralApplication extends JFrame {

    private static final int WIDTH = 800;
    private static final int HEIGHT = 800;

    public SpiralApplication() {
        setTitle("Spiral");
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    public void paint(Graphics g) {
        super.paint(g);

        int centerX = WIDTH / 2;
        int centerY = HEIGHT / 2;

        int[] xPoints = new int[200];
        int[] yPoints = new int[200];

        int angle = 0;
        int radius = 0;

        for (int i = 0; i < 200; i++) {
            xPoints[i] = centerX + (int) (radius * Math.cos(Math.toRadians(angle)));
            yPoints[i] = centerY + (int) (radius * Math.sin(Math.toRadians(angle)));

            angle += 5;
            radius += 2;
        }

        g.drawPolyline(xPoints, yPoints, 200);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            SpiralApplication spiral = new SpiralApplication();
            spiral.setVisible(true);
        });
    }
}