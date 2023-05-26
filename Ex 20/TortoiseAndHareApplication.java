// Produce a graphical version of the Tortoise and Hare simulation
// (Exercise 7.28). Simulate the mountain by drawing an arc that extends from the bottom-left corner
// of the window to the top-right corner. The tortoise and the hare should race up the mountain. Implement the graphical output to actually print the tortoise and the hare on the arc for every move.
// [Hint: Extend the length of the race from 70 to 300 to allow yourself a larger graphics area.]

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TortoiseAndHareApplication extends JFrame {

    private static final int RACE_LENGTH = 300;
    private static final int TORTOISE_SPEED = 10;
    private static final int HARE_SPEED = 20;
    private static final int DELAY = 100;

    private int tortoisePosition;
    private int harePosition;
    private Timer timer;

    public TortoiseAndHareApplication() {
        setTitle("Tortoise and Hare");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        tortoisePosition = 0;
        harePosition = 0;

        timer = new Timer(DELAY, new TimerActionListener());
    }

    private void startRace() {
        tortoisePosition = 0;
        harePosition = 0;
        timer.start();
    }

    private void moveTortoise() {
        int randomMove = (int) (Math.random() * 10) + 1;

        if (tortoisePosition + randomMove <= RACE_LENGTH) {
            tortoisePosition += randomMove;
        }
    }

    private void moveHare() {
        int randomMove = (int) (Math.random() * 10) + 1;

        if (harePosition + randomMove <= RACE_LENGTH) {
            harePosition += randomMove;
        }
    }

    private void checkRaceResult() {
        if (tortoisePosition >= RACE_LENGTH && harePosition >= RACE_LENGTH) {
            JOptionPane.showMessageDialog(this, "It's a tie!");
            timer.stop();
        } else if (tortoisePosition >= RACE_LENGTH) {
            JOptionPane.showMessageDialog(this, "Tortoise wins!");
            timer.stop();
        } else if (harePosition >= RACE_LENGTH) {
            JOptionPane.showMessageDialog(this, "Hare wins!");
            timer.stop();
        }
    }

    private class TimerActionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            moveTortoise();
            moveHare();
            checkRaceResult();
            repaint();
        }
    }

    public void paint(Graphics g) {
        super.paint(g);

        g.setColor(Color.GRAY);
        g.drawLine(50, 550, 750, 50);

        g.setColor(Color.GREEN);
        g.drawArc(50, 50, 700, 700, 0, 90);

        g.setColor(Color.RED);
        g.setFont(new Font("Arial", Font.BOLD, 16));
        g.drawString("T", tortoisePosition, 530);

        g.setColor(Color.BLUE);
        g.setFont(new Font("Arial", Font.BOLD, 16));
        g.drawString("H", harePosition, 530);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            TortoiseAndHareApplication application = new TortoiseAndHareApplication();
            application.setVisible(true);

            JButton startButton = new JButton("Start Race");
            startButton.addActionListener(e -> application.startRace());

            JPanel controlPanel = new JPanel();
            controlPanel.add(startButton);

            application.getContentPane().add(controlPanel, BorderLayout.SOUTH);
        });
    }
}