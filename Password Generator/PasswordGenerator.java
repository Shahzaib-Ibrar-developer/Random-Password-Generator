import java.util.Random;

import javax.swing.*;
import java.awt.*;

public class PasswordGenerator extends JFrame {
    private JTextField passwordField; 
    public void createWindow() {
        setTitle("Password Generator");
        setVisible(true);
        setSize(300, 250);
        setLocationRelativeTo(null);
        setResizable(false);
        JPanel mainPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.insets = new Insets(10, 10, 10, 10); 
        JButton clickButton = new JButton("Generate Password");
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = GridBagConstraints.CENTER;
        mainPanel.add(clickButton, gridBagConstraints);
         
          passwordField = new JTextField(20);
          passwordField.setEditable(false); 
          gridBagConstraints.gridy = 1;
          gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
          mainPanel.add(passwordField, gridBagConstraints);
  
        add(mainPanel);
        clickButton.addActionListener(e -> {
         
            String generatedPassword = generatePassword();
            passwordField.setText(generatedPassword);
            JOptionPane.showMessageDialog(null, "Generated Password: " + generatedPassword);
        });

    }

    public String generatePassword() {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

        int length = 10;

        Random random = new Random();

        StringBuilder randomString = new StringBuilder(length);

        for (int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(characters.length());

            randomString.append(characters.charAt(randomIndex));
        }
        String finalRandomString = randomString.toString();

        return finalRandomString;

    }

    public static void main(String[] args) {
        PasswordGenerator passwordGenerator = new PasswordGenerator();
        passwordGenerator.createWindow();
        passwordGenerator.generatePassword();
    }
}
