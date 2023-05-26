// Modify Exercise 15.28 to draw each of the 20 randomly sized shapes in a
// randomly selected color. Use all 13 predefined Color objects in an array of Colors

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.util.Random;

public class RandomShapesApplication extends JFrame {

    private static final int WIDTH = 500;
    private static final int HEIGHT = 500;

    private Color[] colors = {Color.BLACK, Color.BLUE, Color.CYAN, Color.DARK_GRAY, Color.GRAY, Color.GREEN,
            Color.LIGHT_GRAY, Color.MAGENTA, Color.ORANGE, Color.PINK, Color.RED, Color.WHITE, Color.YELLOW};

    public RandomShapesApplication() {
        setTitle("Random Shapes");
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    public void paint(Graphics g) {
        super.paint(g);

        Graphics2D g2d = (Graphics2D) g;

        Random random = new Random();

        for (int i = 0; i < 20; i++) {
            int x = random.nextInt(WIDTH);
            int y = random.nextInt(HEIGHT);
            int width = random.nextInt(100) + 50;
            int height = random.nextInt(100) + 50;

            int colorIndex = random.nextInt(colors.length);
            Color shapeColor = colors[colorIndex];

            g2d.setColor(shapeColor);

            Rectangle2D.Double shape = new Rectangle2D.Double(x, y, width, height);
            g2d.fill(shape);
        }
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            RandomShapesApplication randomShapes = new RandomShapesApplication();
            randomShapes.setVisible(true);
        });
    }
}