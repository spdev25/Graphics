// Modify your solution to Exercise 15.6
// to draw the ovals by using class Ellipse2D.Double and method draw of class Graphics2D.

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;

public class ConcentricOvals extends JFrame {

    public ConcentricOvals() {
        setTitle("Concentric Ovals");
        setSize(300, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        int centerX = getWidth() / 2;
        int centerY = getHeight() / 2;
        int width = 10;
        int height = 10;

        for (int i = 0; i < 8; i++) {
            Ellipse2D.Double oval = new Ellipse2D.Double(centerX - width / 2, centerY - height / 2, width, height);
            g2d.draw(oval);
            width += 40;
            height += 20;
        }
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            ConcentricOvals ovals = new ConcentricOvals();
            ovals.setVisible(true);
        });
    }
}