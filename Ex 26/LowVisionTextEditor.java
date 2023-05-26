// (Large-Type Displays for People with Low Vision) The accessibility of computers and the
// Internet to all people, regardless of disabilities, is becoming more important as these tools play increasing roles in our personal and business lives. According to a recent estimate by the World Health
// Organization (www.who.int/mediacentre/factsheets/fs282/en/), 124 million people worldwide
// have low vision. To learn more about low vision, check out the GUI-based low-vision simulation at
// www.webaim.org/simulations/lowvision.php. People with low vision might prefer to choose a font
// and/or a larger font size when reading electronic documents and web pages. Java has five built-in
// “logical” fonts that are guaranteed to be available in any Java implementation, including Serif,
// Sans-serif and Monospaced. Write a GUI application that provides a JTextArea in which the user
// can type text. Allow the user to select Serif, Sans-serif or Monospaced from a JComboBox. Provide
// a Bold JCheckBox, which, if checked, makes the text bold. Include Increase Font Size and Decrease
// Font Size JButtons that allow the user to scale the size of the font up or down, respectively, by one
// point at a time. Start with a font size of 18 points. For the purposes of this exercise, set the font size
// on the JComboBox, JButtons and JCheckBox to 20 points so that a person with low vision will be able
// to read the text on them.


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LowVisionTextEditor extends JFrame {

    private JTextArea textArea;
    private JComboBox<String> fontComboBox;
    private JCheckBox boldCheckBox;
    private JButton increaseFontSizeButton;
    private JButton decreaseFontSizeButton;

    private Font currentFont;

    public LowVisionTextEditor() {
        setTitle("Low Vision Text Editor");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Create the JTextArea
        textArea = new JTextArea();
        textArea.setFont(new Font("Serif", Font.PLAIN, 18));

        // Create the JComboBox for font selection
        fontComboBox = new JComboBox<>(new String[]{"Serif", "Sans-serif", "Monospaced"});
        fontComboBox.setFont(new Font("Serif", Font.PLAIN, 20));
        fontComboBox.addActionListener(new FontComboBoxListener());

        // Create the JCheckBox for bold text
        boldCheckBox = new JCheckBox("Bold");
        boldCheckBox.setFont(new Font("Serif", Font.PLAIN, 20));
        boldCheckBox.addActionListener(new BoldCheckBoxListener());

        // Create the JButton to increase font size
        increaseFontSizeButton = new JButton("+");
        increaseFontSizeButton.setFont(new Font("Serif", Font.PLAIN, 20));
        increaseFontSizeButton.addActionListener(new IncreaseFontSizeButtonListener());

        // Create the JButton to decrease font size
        decreaseFontSizeButton = new JButton("-");
        decreaseFontSizeButton.setFont(new Font("Serif", Font.PLAIN, 20));
        decreaseFontSizeButton.addActionListener(new DecreaseFontSizeButtonListener());

        // Create the layout
        JPanel controlsPanel = new JPanel();
        controlsPanel.add(fontComboBox);
        controlsPanel.add(boldCheckBox);
        controlsPanel.add(increaseFontSizeButton);
        controlsPanel.add(decreaseFontSizeButton);

        // Add components to the content pane
        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());
        contentPane.add(new JScrollPane(textArea), BorderLayout.CENTER);
        contentPane.add(controlsPanel, BorderLayout.NORTH);
    }

    private void updateFont() {
        String selectedFontFamily = (String) fontComboBox.getSelectedItem();
        int fontStyle = boldCheckBox.isSelected() ? Font.BOLD : Font.PLAIN;
        int fontSize = currentFont.getSize();
        currentFont = new Font(selectedFontFamily, fontStyle, fontSize);
        textArea.setFont(currentFont);
    }

    private void increaseFontSize() {
        int currentSize = currentFont.getSize();
        currentSize++;
        currentFont = currentFont.deriveFont((float) currentSize);
        textArea.setFont(currentFont);
    }

    private void decreaseFontSize() {
        int currentSize = currentFont.getSize();
        currentSize--;
        currentFont = currentFont.deriveFont((float) currentSize);
        textArea.setFont(currentFont);
    }

    private class FontComboBoxListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            updateFont();
        }
    }

    private class BoldCheckBoxListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            updateFont();
        }
    }

    private class IncreaseFontSizeButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            increaseFontSize();
        }
    }

    private class DecreaseFontSizeButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            decreaseFontSize();
        }
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            LowVisionTextEditor textEditor = new LowVisionTextEditor();
            textEditor.setVisible(true);
        });
    }
}
