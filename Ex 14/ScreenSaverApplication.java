// Package javax.swing contains a class called Timer that is capable of calling method actionPerformed of interface ActionListener at a fixed time interval (specified in milliseconds). Modify your solution to Exercise 15.18 to remove the call to repaint from
// method paintComponent. Declare your class to implement ActionListener. (The actionPerformed method should simply call repaint.) Declare an instance variable of type Timer called timer in your
// class. In the constructor for your class, write the following statements:
// timer = new Timer( 1000, this );
// timer.start();
// This creates an instance of class Timer that will call this object’s actionPerformed method every
// 1000 milliseconds (i.e., every second)

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class ScreenSaverApplication extends JFrame implements ActionListener {

    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;
    private static final int MAX_LINES = 100;

    private Random random;
    private Timer timer;

    public ScreenSaverApplication() {
        setTitle("Screen Saver Application");
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        random = new Random();
        timer = new Timer(1000, this);
        timer.start();
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
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            ScreenSaverApplication screenSaver = new ScreenSaverApplication();
            screenSaver.setVisible(true);
        });
    }
}