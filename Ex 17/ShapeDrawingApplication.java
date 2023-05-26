// Modify your solution to Exercise 15.21 to use classes
// and drawing capabilities of the Java 2D API. Draw shapes like rectangles and ellipses, with randomly
// generated gradients. Use class GradientPaint to generate the gradient

import java.awt.*;
import javax.swing.*;
import java.util.Random;
import java.awt.geom.Ellipse2D;

public class RandomShapesGradient extends JPanel {

    private static final int PANEL_WIDTH = 400;
    private static final int PANEL_HEIGHT = 400;

    private Random random;

    public RandomShapesGradient() {
        random = new Random();
        setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        for (int i = 0; i < 10; i++) {  // Draw 10 random shapes with gradients
            int x = random.nextInt(PANEL_WIDTH);
            int y = random.nextInt(PANEL_HEIGHT);
            int width = random.nextInt(100) + 50;  // Random width between 50 and 149
            int height = random.nextInt(100) + 50; // Random height between 50 and 149

            float x1 = random.nextInt(PANEL_WIDTH);
            float y1 = random.nextInt(PANEL_HEIGHT);
            float x2 = random.nextInt(PANEL_WIDTH);
            float y2 = random.nextInt(PANEL_HEIGHT);

            Color color1 = new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256));
            Color color2 = new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256));
            GradientPaint gradient = new GradientPaint(x1, y1, color1, x2, y2, color2);

            g2d.setPaint(gradient);

            switch (random.nextInt(2)) {
                case 0:
                    g2d.fill(new Rectangle(x, y, width, height));
                    break;
                case 1:
                    g2d.fill(new Ellipse2D.Double(x, y, width, height));
                    break;
            }
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Random Shapes with Gradient");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new RandomShapesGradient());
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
