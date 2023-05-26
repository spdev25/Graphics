// Write an application that simulates a screen saver. The application should
// randomly draw lines using method drawLine of class Graphics. After drawing 100 lines, the application should clear itself and start drawing lines again. To allow the program to draw continuously,
// place a call to repaint as the last line in method paintComponent. Do you notice any problems with
// this on your system?

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class ScreenSaverApplication extends JFrame {

    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;
    private static final int MAX_LINES = 100;

    private Random random;

    public ScreenSaverApplication() {
        setTitle("Screen Saver Application");
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        random = new Random();
    }

    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;

        for (int i = 0; i < MAX_LINES; i++) {
            int x1 = random.nextInt(WIDTH);
            int y1 = random.nextInt(HEIGHT);
            int x2 = random.nextInt(WIDTH);
            int y2 = random.nextInt(HEIGHT);

            g2d.drawLine(x1, y1, x2, y2);
        }

        repaint();
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            ScreenSaverApplication screenSaver = new ScreenSaverApplication();
            screenSaver.setVisible(true);
        });
    }
}