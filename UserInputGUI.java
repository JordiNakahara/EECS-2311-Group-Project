import java.awt.*;
import java.awt.event.*;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.*;

public class UserInputGUI extends JFrame {
    // Declare components
    private JLabel ageLabel, heightLabel, weightLabel;
    private JTextField ageBox, heightBox, weightBox;
    private JButton submitButton;
    private JPanel inputPanel, buttonPanel;

    public UserInputGUI() {
        // Title for the window being opened
        super("User Input Form");

        // Initializing everything first
        ageLabel = new JLabel("Age:");
        heightLabel = new JLabel("Height(Cm):");
        weightLabel = new JLabel("Weight(Kg):");
        ageBox = new JTextField(10);
        heightBox = new JTextField(10);
        weightBox = new JTextField(10);
        submitButton = new JButton("Submit");
        inputPanel = new JPanel(new GridLayout(3, 2));
        buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));

        // Adding parts to the window
        inputPanel.add(ageLabel);
        inputPanel.add(ageBox);
        inputPanel.add(heightLabel);
        inputPanel.add(heightBox);
        inputPanel.add(weightLabel);
        inputPanel.add(weightBox);

        // Adding buttons to window
        buttonPanel.add(submitButton);

        // Add panels to the frame
        add(inputPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        // Checks to see is submit button was pressed
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Retrieve input values
                String age = ageBox.getText().trim();
                String height = heightBox.getText().trim();
                String weight = weightBox.getText().trim();

                // Checks values given by user
                if (age.isEmpty() || height.isEmpty() || weight.isEmpty()) {
                    JOptionPane.showMessageDialog(UserInputGUI.this, "Please enter values for all the boxs.");
                    return;
                }

                // Paste values on the next window
                try {
                    PrintWriter out = new PrintWriter(new FileWriter("user_data.txt", true));
                    out.println(age + "," + height + "," + weight);
                    out.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }

                // Display values in the textbox
                JOptionPane.showMessageDialog(UserInputGUI.this, "Thank you for your input!\n\nAge: " + age + "\nHeight: " + height + "\nWeight: " + weight);

                // Clear inputted info
                ageBox.setText("");
                heightBox.setText("");
                weightBox.setText("");
            }
        });

        // Set frame
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        // Creates a new UserInputGUI every iteration
        new UserInputGUI();
    }
}