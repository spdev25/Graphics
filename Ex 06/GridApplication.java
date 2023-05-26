// Write an application that draws an 8-by-8 grid. Use
// Graphics method drawLine.

import javax.swing.*;
import java.awt.*;

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

                // Draw vertical line
                g2d.drawLine(x, y, x, y + cellSize);

                // Draw horizontal line
                g2d.drawLine(x, y, x + cellSize, y);
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