// Modify Exercise 15.28 to allow the user to select the color in
// which shapes should be drawn from a JColorChooser dialog.

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Rectangle2D;
import java.util.Random;

public class RandomShapesApplication extends JFrame {

    private static final int WIDTH = 500;
    private static final int HEIGHT = 500;

    private JButton colorButton;

    public RandomShapesApplication() {
        setTitle("Random Shapes");
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Create the color button
        colorButton = new JButton("Select Color");
        colorButton.addActionListener(new ColorButtonListener());

        // Add the color button to the content pane
        getContentPane().add(colorButton, BorderLayout.NORTH);
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

            Color shapeColor = colorButton.getForeground();

            g2d.setColor(shapeColor);

            Rectangle2D.Double shape = new Rectangle2D.Double(x, y, width, height);
            g2d.fill(shape);
        }
    }

    private class ColorButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            Color selectedColor = JColorChooser.showDialog(RandomShapesApplication.this, "Select Color", colorButton.getForeground());
            if (selectedColor != null) {
                colorButton.setForeground(selectedColor);
                repaint();
            }
        }
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            RandomShapesApplication randomShapes = new RandomShapesApplication();
            randomShapes.setVisible(true);
        });
    }
}
