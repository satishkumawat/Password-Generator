import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PasswordGeneratorGUI extends JFrame {

    private final JTextField lengthField;
    private final JCheckBox upperCaseCheckBox;
    private final JCheckBox lowerCaseCheckBox;
    private final JCheckBox numbersCheckBox;
    private final JCheckBox symbolsCheckBox;
    private final JTextArea passwordArea;

    public PasswordGeneratorGUI() {
        setTitle("Password Generator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(0, 2, 10, 10));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JLabel lengthLabel = new JLabel("Password Length:");
        lengthField = new JTextField();
        mainPanel.add(lengthLabel);
        mainPanel.add(lengthField);

        upperCaseCheckBox = new JCheckBox("Include Uppercase Letters");
        lowerCaseCheckBox = new JCheckBox("Include Lowercase Letters");
        numbersCheckBox = new JCheckBox("Include Numbers");
        symbolsCheckBox = new JCheckBox("Include Symbols");

        mainPanel.add(upperCaseCheckBox);
        mainPanel.add(lowerCaseCheckBox);
        mainPanel.add(numbersCheckBox);
        mainPanel.add(symbolsCheckBox);

        JButton generateButton = new JButton("Generate Password");
        generateButton.addActionListener(new GenerateButtonListener());
        mainPanel.add(generateButton);

        passwordArea = new JTextArea();
        passwordArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(passwordArea);
        mainPanel.add(scrollPane);

        add(mainPanel);
    }

    private class GenerateButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            int length = Integer.parseInt(lengthField.getText());
            boolean includeUpper = upperCaseCheckBox.isSelected();
            boolean includeLower = lowerCaseCheckBox.isSelected();
            boolean includeNum = numbersCheckBox.isSelected();
            boolean includeSym = symbolsCheckBox.isSelected();

            Generator generator = new Generator(includeUpper, includeLower, includeNum, includeSym);
            Password password = generator.GeneratePassword(length);

            passwordArea.setText(password.toString());
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            PasswordGeneratorGUI gui = new PasswordGeneratorGUI();
            gui.setVisible(true);
        });
    }
}

/*This GUI class creates a window with text fields for password length and checkboxes for selecting character types. When the "Generate Password" button is clicked, it generates a password based on the selected options and displays it in a text area.

You can integrate this GUI class with your existing classes by instantiating the necessary objects and calling methods accordingly. */