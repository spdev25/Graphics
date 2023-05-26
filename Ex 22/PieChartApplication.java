// Write a program that inputs four numbers and graphs them as a pie chart. Use
// class Arc2D.Double and method fill of class Graphics2D to perform the drawing. Draw each piece
// of the pie in a separate color

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Arc2D;

public class PieChartApplication extends JFrame {

    private static final int WIDTH = 500;
    private static final int HEIGHT = 500;

    private double[] data;

    public PieChartApplication() {
        setTitle("Pie Chart");
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        data = new double[4];

        // Prompt for input
        for (int i = 0; i < 4; i++) {
            String input = JOptionPane.showInputDialog("Enter value " + (i + 1) + ":");
            data[i] = Double.parseDouble(input);
        }
    }

    public void paint(Graphics g) {
        super.paint(g);

        Graphics2D g2d = (Graphics2D) g;

        double sum = 0.0;
        for (double value : data) {
            sum += value;
        }

        double startAngle = 0.0;
        for (double value : data) {
            double arcAngle = (value / sum) * 360.0;

            Arc2D.Double arc = new Arc2D.Double(50, 50, 400, 400, startAngle, arcAngle, Arc2D.PIE);
            g2d.setColor(generateRandomColor());
            g2d.fill(arc);

            startAngle += arcAngle;
        }
    }

    private Color generateRandomColor() {
        int r = (int) (Math.random() * 256);
        int g = (int) (Math.random() * 256);
        int b = (int) (Math.random() * 256);

        return new Color(r, g, b);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            PieChartApplication pieChart = new PieChartApplication();
            pieChart.setVisible(true);
        });
    }
}