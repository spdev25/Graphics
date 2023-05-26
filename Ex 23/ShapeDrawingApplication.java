// Write an application that allows the user to select a shape from a JComboBox and draws it 20 times with random locations and dimensions in method paintComponent. The
// first item in the JComboBox should be the default shape that is displayed the first time paintComponent is called.

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class ShapeDrawingApplication extends JFrame {

    private static final int WIDTH = 500;
    private static final int HEIGHT = 500;

    private JComboBox<String> shapeComboBox;
    private String[] shapeOptions = {"Rectangle", "Circle", "Triangle"};
    private String selectedShape;

    public ShapeDrawingApplication() {
        setTitle("Shape Drawing");
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Create and configure the shape combo box
        shapeComboBox = new JComboBox<>(shapeOptions);
        shapeComboBox.addActionListener(new ShapeComboBoxListener());
        selectedShape = shapeOptions[0];

        // Add the shape combo box to the content pane
        getContentPane().add(shapeComboBox, BorderLayout.NORTH);
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

            if (selectedShape.equals("Rectangle")) {
                g2d.drawRect(x, y, width, height);
            } else if (selectedShape.equals("Circle")) {
                g2d.drawOval(x, y, width, height);
            } else if (selectedShape.equals("Triangle")) {
                int[] xPoints = {x, x + width / 2, x + width};
                int[] yPoints = {y + height, y, y + height};
                g2d.drawPolygon(xPoints, yPoints, 3);
            }
        }
    }

    private class ShapeComboBoxListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            JComboBox<String> comboBox = (JComboBox<String>) e.getSource();
            selectedShape = (String) comboBox.getSelectedItem();
            repaint();
        }
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            ShapeDrawingApplication shapeDrawing = new ShapeDrawingApplication();
            shapeDrawing.setVisible(true);
        });
    }
}