// Write an application that randomly draws characters in different
// fonts, sizes and colors.

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class RandomCharacters extends JFrame {

    private Random random;
    private Font[] fonts;
    private Color[] colors;
    private String characters;

    public RandomCharacters() {
        setTitle("Random Characters");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        random = new Random();

        // Define available fonts
        fonts = new Font[]{
                new Font("Arial", Font.PLAIN, 12),
                new Font("Courier New", Font.BOLD, 14),
                new Font("Times New Roman", Font.ITALIC, 16),
                new Font("Verdana", Font.BOLD | Font.ITALIC, 18)
        };

        // Define available colors
        colors = new Color[]{
                Color.RED,
                Color.GREEN,
                Color.BLUE,
                Color.ORANGE
        };

        // Define available characters
        characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    }

    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;

        int x = 50;
        int y = 50;

        for (int i = 0; i < 200; i++) {
            // Generate random font, size, and color
            Font font = fonts[random.nextInt(fonts.length)];
            int size = random.nextInt(20) + 12;
            Color color = colors[random.nextInt(colors.length)];

            // Set font, size, and color
            g2d.setFont(font.deriveFont((float) size));
            g2d.setColor(color);

            // Generate random character
            char ch = characters.charAt(random.nextInt(characters.length()));

            // Draw character
            g2d.drawString(String.valueOf(ch), x, y);

            // Update coordinates for next character
            x += 20;
            if (x > getWidth() - 50) {
                x = 50;
                y += 30;
            }
        }
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            RandomCharacters characters = new RandomCharacters();
            characters.setVisible(true);
        });
    }
}