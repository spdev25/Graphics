// write an application that draws a tetrahedron 
// (a three-dimensional shape with four triangular faces). 
// Use class GeneralPath and method draw of class Graphics2D.

import javax.swing.*;
import java.awt.*;
import java.awt.geom.GeneralPath;

public class TetrahedronDrawing extends JFrame {

    public TetrahedronDrawing() {
        setTitle("Tetrahedron Drawing");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        Graphics2D g2d = (Graphics2D) g;

        // Create the GeneralPath for the tetrahedron
        GeneralPath tetrahedronPath = new GeneralPath();

        // Set the starting point for the path
        tetrahedronPath.moveTo(100, 300);

        // Draw the four faces of the tetrahedron
        tetrahedronPath.lineTo(300, 300); // Base - Side 1
        tetrahedronPath.lineTo(200, 100); // Base - Side 2
        tetrahedronPath.closePath(); // Base - Side 3
        tetrahedronPath.lineTo(100, 300); // Side 4

        // Set the color for the tetrahedron
        g2d.setColor(Color.BLUE);

        // Draw the tetrahedron
        g2d.draw(tetrahedronPath);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            TetrahedronDrawing tetrahedron = new TetrahedronDrawing();
            tetrahedron.setVisible(true);
        });
    }
}