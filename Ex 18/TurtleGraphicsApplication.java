// Modify your solution to Exercise 7.21—Turtle Graphics—to add a
// graphical user interface using JTextFields and JButtons. Draw lines rather than asterisks (*). When
// the turtle graphics program specifies a move, translate the number of positions into a number of
// pixels on the screen by multiplying the number of positions by 10 (or any value you choose). Implement the drawing with Java 2D API features

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TurtleGraphicsGUI extends JFrame {
    private static final int PANEL_WIDTH = 600;
    private static final int PANEL_HEIGHT = 600;

    private TurtlePanel turtlePanel;
    private JTextField commandTextField;
    private JButton executeButton;

    public TurtleGraphicsGUI() {
        setTitle("Turtle Graphics");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        turtlePanel = new TurtlePanel();
        add(turtlePanel, BorderLayout.CENTER);

        JPanel controlPanel = new JPanel();
        commandTextField = new JTextField(20);
        executeButton = new JButton("Execute");
        executeButton.addActionListener(new ExecuteButtonListener());

        controlPanel.add(commandTextField);
        controlPanel.add(executeButton);

        add(controlPanel, BorderLayout.SOUTH);

        setSize(PANEL_WIDTH, PANEL_HEIGHT);
        setVisible(true);
    }

    private class ExecuteButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String command = commandTextField.getText();
            turtlePanel.executeCommand(command);
        }
    }

    private class TurtlePanel extends JPanel {
        private static final int TURTLE_SIZE = 10;

        private int currentX;
        private int currentY;
        private double angle;

        public TurtlePanel() {
            setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
            setBackground(Color.WHITE);

            currentX = PANEL_WIDTH / 2;
            currentY = PANEL_HEIGHT / 2;
            angle = 0;
        }

        public void executeCommand(String command) {
            Graphics2D g2d = (Graphics2D) getGraphics();
            g2d.setStroke(new BasicStroke(2));

            String[] commands = command.split("\\s+");
            for (String cmd : commands) {
                if (cmd.equalsIgnoreCase("FD")) {
                    int distance = Integer.parseInt(commands[1]);
                    int newX = currentX + (int) (Math.cos(Math.toRadians(angle)) * distance * 10);
                    int newY = currentY - (int) (Math.sin(Math.toRadians(angle)) * distance * 10);
                    g2d.drawLine(currentX, currentY, newX, newY);
                    currentX = newX;
                    currentY = newY;
                } else if (cmd.equalsIgnoreCase("RT")) {
                    int degrees = Integer.parseInt(commands[1]);
                    angle += degrees;
                } else if (cmd.equalsIgnoreCase("LT")) {
                    int degrees = Integer.parseInt(commands[1]);
                    angle -= degrees;
                }
            }

            g2d.dispose();
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g;
            g2d.setColor(Color.BLACK);
            g2d.fillRect(currentX - TURTLE_SIZE / 2, currentY - TURTLE_SIZE / 2, TURTLE_SIZE, TURTLE_SIZE);
            g2d.dispose();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new TurtleGraphicsGUI();
            }
        });
    }
}
