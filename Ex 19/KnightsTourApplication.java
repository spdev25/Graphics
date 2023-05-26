// Produce a graphical version of the Knight’s Tour problem (Exercise 7.22,
// Exercise 7.23 and Exercise 7.26). As each move is made, the appropriate cell of the chessboard
// should be updated with the proper move number. If the result of the program is a full tour or a closed
// tour, the program should display an appropriate message. If you like, use class Timer (see
// Exercise 15.19) to help animate the Knight’s Tour

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class KnightsTourApplication extends JFrame {

    private static final int BOARD_SIZE = 8;
    private static final int CELL_SIZE = 80;
    private static final int DELAY = 500;

    private int[][] chessboard;
    private int moveCount;
    private Timer timer;

    public KnightsTourApplication() {
        setTitle("Knight's Tour");
        setSize(BOARD_SIZE * CELL_SIZE, BOARD_SIZE * CELL_SIZE);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        chessboard = new int[BOARD_SIZE][BOARD_SIZE];
        moveCount = 0;

        JPanel chessboardPanel = new JPanel() {
            public void paintComponent(Graphics g) {
                super.paintComponent(g);

                for (int i = 0; i < BOARD_SIZE; i++) {
                    for (int j = 0; j < BOARD_SIZE; j++) {
                        int x = i * CELL_SIZE;
                        int y = j * CELL_SIZE;

                        if ((i + j) % 2 == 0) {
                            g.setColor(Color.WHITE);
                        } else {
                            g.setColor(Color.LIGHT_GRAY);
                        }

                        g.fillRect(x, y, CELL_SIZE, CELL_SIZE);
                        g.setColor(Color.BLACK);
                        g.drawRect(x, y, CELL_SIZE, CELL_SIZE);

                        if (chessboard[i][j] != 0) {
                            g.drawString(String.valueOf(chessboard[i][j]), x + 30, y + 50);
                        }
                    }
                }
            }
        };

        chessboardPanel.addMouseListener(new ChessboardMouseListener());

        getContentPane().add(chessboardPanel);

        timer = new Timer(DELAY, new TimerActionListener());
    }

    private void resetChessboard() {
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                chessboard[i][j] = 0;
            }
        }
        moveCount = 0;
    }

    private void startKnightsTour(int startX, int startY) {
        resetChessboard();
        timer.start();

        if (solveKnightsTour(startX, startY, 1)) {
            JOptionPane.showMessageDialog(this, "Full Tour!");
        } else {
            JOptionPane.showMessageDialog(this, "Closed Tour!");
        }
    }

    private boolean solveKnightsTour(int x, int y, int move) {
        if (x < 0 || x >= BOARD_SIZE || y < 0 || y >= BOARD_SIZE || chessboard[x][y] != 0) {
            return false;
        }

        chessboard[x][y] = move;
        moveCount++;
        repaint();

        if (moveCount == BOARD_SIZE * BOARD_SIZE) {
            timer.stop();
            return true;
        }

        int[] possibleMovesX = {-2, -1, 1, 2, -2, -1, 1, 2};
        int[] possibleMovesY = {-1, -2, -2, -1, 1, 2, 2, 1};

        for (int i = 0; i < possibleMovesX.length; i++) {
            int nextX = x + possibleMovesX[i];
            int nextY = y + possibleMovesY[i];

            if (solveKnightsTour(nextX, nextY, move + 1)) {
                return true;
            }
        }

        chessboard[x][y] = 0;
        moveCount--;
        repaint();

        return false;
    }

    private class ChessboardMouseListener extends MouseAdapter {
        public void mousePressed(MouseEvent e) {
            int x = e.getX() / CELL_SIZE;
            int y = e.getY() / CELL_SIZE;

            if (x >= 0 && x < BOARD_SIZE && y >= 0 && y < BOARD_SIZE) {
                startKnightsTour(x, y);
            }
        }
    }

    private class TimerActionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            repaint();
        }
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            KnightsTourApplication knightsTour = new KnightsTourApplication();
            knightsTour.setVisible(true);
        });
    }
}