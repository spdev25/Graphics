// Modify your solution to Exercise 15.19 to
// enable the user to enter the number of random lines that should be drawn before the application
// clears itself and starts drawing lines again. Use a JTextField to obtain the value. The user should be
// able to type a new number into the JTextField at any time during the program’s execution. Use an
// inner class to perform event handling for the JTextField.

import java.awt.*;
import javax.swing.*;
import java.util.Random;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RandomLines extends JPanel {

    private static final int PANEL_WIDTH = 400;
    private static final int PANEL_HEIGHT = 400;

    private Random random;
    private JTextField lineCountTextField;

    public RandomLines() {
        random = new Random();
        setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));

        JLabel lineCountLabel = new JLabel("Number of Lines:");
        lineCountTextField = new JTextField(10);
        JButton startButton = new JButton("Start");

        startButton.addActionListener(new StartButtonListener());

        setLayout(new FlowLayout());
        add(lineCountLabel);
        add(lineCountTextField);
        add(startButton);
    }

    private void drawRandomLines(int lineCount) {
        Graphics g = getGraphics();
        g.setColor(Color.BLACK);

        for (int i = 0; i < lineCount; i++) {
            int x1 = random.nextInt(PANEL_WIDTH);
            int y1 = random.nextInt(PANEL_HEIGHT);
            int x2 = random.nextInt(PANEL_WIDTH);
            int y2 = random.nextInt(PANEL_HEIGHT);

            g.drawLine(x1, y1, x2, y2);
        }

        g.dispose();
    }

    private class StartButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String lineCountStr = lineCountTextField.getText();
            int lineCount = Integer.parseInt(lineCountStr);

            Graphics g = getGraphics();
            g.setColor(Color.WHITE);
            g.fillRect(0, 0, PANEL_WIDTH, PANEL_HEIGHT);
            g.dispose();

            drawRandomLines(lineCount);
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Random Lines");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new RandomLines());
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
