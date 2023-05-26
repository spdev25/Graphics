// Write an application that draws a series of eight
// concentric circles. The circles should be separated by 10 pixels. Use Graphics method drawArc.

import javax.swing.*;
import java.awt.*;

public class ConcentricCircles extends JFrame {

    public ConcentricCircles() {
        setTitle("Concentric Circles");
        setSize(300, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        int centerX = getWidth() / 2;
        int centerY = getHeight() / 2;
        int radius = 10;

        for (int i = 0; i < 8; i++) {
            g2d.drawArc(centerX - radius, centerY - radius, 2 * radius, 2 * radius, 0, 360);
            radius += 10;
        }
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            ConcentricCircles circles = new ConcentricCircles();
            circles.setVisible(true);
        });
    }
}