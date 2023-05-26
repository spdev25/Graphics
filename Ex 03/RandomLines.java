// Modify your solution to Exercise 15.7 to
// draw random lines in random colors and random line thicknesses. Use class Line2D.Double and
// method draw of class Graphics2D to draw the lines.

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Line2D;
import java.util.Random;

public class RandomLines extends JFrame {

    private Random random;

    public RandomLines() {
        setTitle("Random Lines");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        random = new Random();
    }

    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;

        for (int i = 0; i < 20; i++) {
            int x1 = random.nextInt(getWidth());
            int y1 = random.nextInt(getHeight());
            int x2 = random.nextInt(getWidth());
            int y2 = random.nextInt(getHeight());

            Line2D.Double line = new Line2D.Double(x1, y1, x2, y2);

            g2d.setColor(getRandomColor());
            g2d.setStroke(new BasicStroke(getRandomLineWidth()));

            g2d.draw(line);
        }
    }

    private Color getRandomColor() {
        int r = random.nextInt(256);
        int g = random.nextInt(256);
        int b = random.nextInt(256);

        return new Color(r, g, b);
    }

    private float getRandomLineWidth() {
        return random.nextFloat() * 5 + 1;
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            RandomLines lines = new RandomLines();
            lines.setVisible(true);
        });
    }
}