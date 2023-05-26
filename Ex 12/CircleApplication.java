// Write an application that asks the user to input
// the radius of a circle as a floating-point number and draws the circle, as well as the values of the
// circle’s diameter, circumference and area. Use the value 3.14159 for π. [Note: You may also use the
// predefined constant Math.PI for the value of π. This constant is more precise than the value
// 3.14159. Class Math is declared in the java.lang package, so you need not import it.] Use the following formulas (r is the radius):
// diameter = 2r circumference = 2πr area = πr2
// The user should also be prompted for a set of coordinates in addition to the radius. Then draw the
// circle and display its diameter, circumference and area, using an Ellipse2D.Double object to represent the circle and method draw of class Graphics2D to display it.

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;

public class CircleApplication extends JFrame {

    private double radius;
    private double x;
    private double y;

    public CircleApplication() {
        setTitle("Circle Application");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        radius = promptForRadius();
        promptForCoordinates();
    }

    private double promptForRadius() {
        String input = JOptionPane.showInputDialog("Enter the radius of the circle:");
        return Double.parseDouble(input);
    }

    private void promptForCoordinates() {
        String inputX = JOptionPane.showInputDialog("Enter the x-coordinate of the circle's center:");
        String inputY = JOptionPane.showInputDialog("Enter the y-coordinate of the circle's center:");
        x = Double.parseDouble(inputX);
        y = Double.parseDouble(inputY);
    }

    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;

        double diameter = 2 * radius;
        double circumference = 2 * Math.PI * radius;
        double area = Math.PI * Math.pow(radius, 2);

        Ellipse2D.Double circle = new Ellipse2D.Double(x - radius, y - radius, diameter, diameter);
        g2d.draw(circle);

        g2d.drawString("Diameter: " + diameter, 10, 20);
        g2d.drawString("Circumference: " + circumference, 10, 40);
        g2d.drawString("Area: " + area, 10, 60);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            CircleApplication circleApp = new CircleApplication();
            circleApp.setVisible(true);
        });
    }
}