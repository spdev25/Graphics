// Write an application that draws a 10-by-10 grid. Use the
// Graphics method drawRect.

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

        int gridSize = 10;
        int cellSize = getWidth() / gridSize;

        for (int row = 0; row < gridSize; row++) {
            for (int col = 0; col < gridSize; col++) {
                int x = col * cellSize;
                int y = row * cellSize;

                g2d.drawRect(x, y, cellSize, cellSize);
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