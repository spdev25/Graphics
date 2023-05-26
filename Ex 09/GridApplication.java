// Modify your solution to Exercise 15.13 to draw
// the grid by using class Rectangle2D.Double and method draw of class Graphics2D.

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Rectangle2D;

public class GridApplication extends JFrame {

    public GridApplication() {
        setTitle("Grid Application");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;

        int gridSize = 10;
        int cellSize = getWidth() / gridSize;

        for (int row = 0; row < gridSize; row++) {
            for (int col = 0; col < gridSize; col++) {
                int x = col * cellSize;
                int y = row * cellSize;

                Rectangle2D.Double cell = new Rectangle2D.Double(x, y, cellSize, cellSize);

                g2d.draw(cell);
            }
        }
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            GridApplication grid = new GridApplication();
            grid.setVisible(true);
        });
    }
}