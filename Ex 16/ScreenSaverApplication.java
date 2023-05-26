// Modify your solution to Exercise 15.19 such that 
// it uses random-number generation to choose different shapes to display. 
// Use methods of class Graphics.

import java.awt.*;
import javax.swing.*;
import java.util.Random;

public class RandomShapes extends JPanel {

    private static final int PANEL_WIDTH = 400;
    private static final int PANEL_HEIGHT = 400;

    private Random random;

    public RandomShapes() {
        random = new Random();
        setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        for (int i = 0; i < 10; i++) {  // Draw 10 random shapes
            int x = random.nextInt(PANEL_WIDTH);
            int y = random.nextInt(PANEL_HEIGHT);
            int width = random.nextInt(100) + 50;  // Random width between 50 and 149
            int height = random.nextInt(100) + 50; // Random height between 50 and 149

            switch (random.nextInt(3)) {
                case 0:
                    g.setColor(Color.RED);
                    g.fillRect(x, y, width, height);
                    break;
                case 1:
                    g.setColor(Color.GREEN);
                    g.fillOval(x, y, width, height);
                    break;
                case 2:
                    g.setColor(Color.BLUE);
                    g.fillRoundRect(x, y, width, height, 20, 20);
                    break;
            }
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Random Shapes");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new RandomShapes());
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
