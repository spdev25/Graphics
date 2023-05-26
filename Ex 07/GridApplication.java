// Modify your solution to Exercise 15.11 to draw the
// grid using instances of class Line2D.Double and method draw of class Graphics2D.

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Line2D;

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

        int gridSize = 8;
        int cellSize = getWidth() / gridSize;

        for (int row = 0; row < gridSize; row++) {
            for (int col = 0; col < gridSize; col++) {
                int x = col * cellSize;
                int y = row * cellSize;

                Line2D.Double verticalLine = new Line2D.Double(x, y, x, y + cellSize);
                Line2D.Double horizontalLine = new Line2D.Double(x, y, x + cellSize, y);

                g2d.draw(verticalLine);
                g2d.draw(horizontalLine);
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