import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class MainGUI extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Create the buttons
        Button userProfileBtn = new Button("User Profile");
        Button workoutsBtn = new Button("Workouts");

        // Attach event handlers to the buttons
        userProfileBtn.setOnAction(e -> {
            // Create a new window for the user profile GUI
            new UserInputGUI();
        });

        workoutsBtn.setOnAction(e -> {
            // Create a new window for the workouts GUI
            Stage workoutsStage = new Stage();
            WorkoutsGUI workoutsGUI = new WorkoutsGUI();
            workoutsGUI.start(workoutsStage);
            primaryStage.close();
        });

        // Create a vertical box and add the buttons to it
        VBox root = new VBox(20);
        root.setAlignment(Pos.CENTER);
        root.getChildren().addAll(userProfileBtn, workoutsBtn);

        // Create a scene and set the root node
        Scene scene = new Scene(root, 600, 400);

        // Set the stage's title and scene, and show the stage
        primaryStage.setTitle("Main GUI");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

class UserInputGUI extends JFrame {
    // Declare components
    private JLabel ageLabel, heightLabel, weightLabel, firstLabel, lastLabel, genderLabel;
    private JTextField ageBox, heightBox, weightBox, firstBox, lastBox;
    private JComboBox genderBox;
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

        firstLabel = new JLabel("First Name");
        lastLabel = new JLabel("Last Name");
        genderLabel = new JLabel("Gender");
        firstBox = new JTextField(10);
        lastBox = new JTextField(10);
        genderBox = new JComboBox();
        genderBox.addItem('M');
        genderBox.addItem('F');

        // Adding parts to the window
        inputPanel.add(firstLabel);
        inputPanel.add(firstBox);
        inputPanel.add(lastLabel);
        inputPanel.add(lastBox);
        inputPanel.add(genderLabel);
        inputPanel.add(genderBox);
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
                String first = firstBox.getText().trim();
                String last = lastBox.getText().trim();
                char gender = (char) genderBox.getSelectedItem();
                String age = ageBox.getText().trim();
                String height = heightBox.getText().trim();
                String weight = weightBox.getText().trim();

                // Checks values given by user
                if (age.isEmpty() || height.isEmpty() || weight.isEmpty() || first.isEmpty() || last.isEmpty() || gender == ' ') {
                    JOptionPane.showMessageDialog(UserInputGUI.this, "Please enter values for all the boxes.");
                    return;
                }

                // Paste values on the next window
                try {
                    PrintWriter out = new PrintWriter(new FileWriter("user_data.txt", true));
                    out.println(first + " " + last + "," + gender + ","+ age + "," + height + "," + weight);
                    out.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }

                // Display values in the textbox
                JOptionPane.showMessageDialog(UserInputGUI.this, "Thank you for your input!\n\nAge: " + age + "\nHeight: " + height + "\nWeight: " + weight);

                // Clear inputted info
                User user = new User(first, last, gender, Double.parseDouble(weight), Double.parseDouble(height), Integer.parseInt(age));
                

            }
        });

        // Set frame
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
}

class WorkoutsGUI extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Create the workouts GUI
        VBox root = new VBox(20);
        Button backButton = new Button("Back");
        Button chestButton = new Button("Chest");
        Button armsButton = new Button("Arms");
        Button absButton = new Button("Abs");
        Button legsButton = new Button("Legs");
        Button cardioButton = new Button("Cardio");
        // Button comboButton = new Button("Combo");

        backButton.setOnAction(e -> {
            // Create a new window for the user profile GUI
            Stage welcomeStage = new Stage();
            MainGUI mainGUI = new MainGUI();
            mainGUI.start(welcomeStage);
            primaryStage.close();
        });

        chestButton.setOnAction(e -> {
            // Create a new window for the user profile GUI
            Stage chestStage = new Stage();
            WorkoutStartGUI testGUI = new WorkoutStartGUI();
            testGUI.type = "Chest";
            testGUI.image = "C:\\Users\\light\\Documents\\CHEST.png";
            try {
                testGUI.start(chestStage);
            } catch (FileNotFoundException fileNotFoundException) {
                fileNotFoundException.printStackTrace();
            }
            primaryStage.close();
        });

        armsButton.setOnAction(e -> {
            // Create a new window for the user profile GUI
            Stage armStage = new Stage();
            WorkoutStartGUI testGUI = new WorkoutStartGUI();
            testGUI.type = "Arms";
            testGUI.image = "C:\\Users\\light\\Documents\\ARMS.png";
            try {
                testGUI.start(armStage);
            } catch (FileNotFoundException fileNotFoundException) {
                fileNotFoundException.printStackTrace();
            }
            primaryStage.close();
        });

        absButton.setOnAction(e -> {
            // Create a new window for the user profile GUI
            Stage abStage = new Stage();
            WorkoutStartGUI testGUI = new WorkoutStartGUI();
            testGUI.type = "Abs";
            testGUI.image = "C:\\Users\\light\\Documents\\ABS.png";
            try {
                testGUI.start(abStage);
            } catch (FileNotFoundException fileNotFoundException) {
                fileNotFoundException.printStackTrace();
            }
            primaryStage.close();
        });

        legsButton.setOnAction(e -> {
            // Create a new window for the user profile GUI
            Stage legStage = new Stage();
            WorkoutStartGUI testGUI = new WorkoutStartGUI();
            testGUI.type = "Legs";
            testGUI.image = "C:\\Users\\light\\Documents\\LEGS.png";
            try {
                testGUI.start(legStage);
            } catch (FileNotFoundException fileNotFoundException) {
                fileNotFoundException.printStackTrace();
            }
            primaryStage.close();
        });

        cardioButton.setOnAction(e -> {
            // Create a new window for the user profile GUI
            Stage cardioStage = new Stage();
            WorkoutStartGUI testGUI = new WorkoutStartGUI();
            testGUI.type = "Cardio";
            testGUI.image = "C:\\Users\\light\\Documents\\CARDIO.png";
            try {
                testGUI.start(cardioStage);
            } catch (FileNotFoundException fileNotFoundException) {
                fileNotFoundException.printStackTrace();
            }
            primaryStage.close();
        });

        /*comboButton.setOnAction(e -> {
            // Create a new window for the user profile GUI
            Stage welcomeStage = new Stage();
            MainGUI mainGUI = new MainGUI();
            mainGUI.start(welcomeStage);
            primaryStage.close();
        }); */

        root.getChildren().add(backButton);
        root.getChildren().addAll(chestButton, armsButton, absButton, legsButton, cardioButton);
        backButton.setTranslateX(0);
        backButton.setTranslateY(0);
        chestButton.setTranslateX(265);
        chestButton.setTranslateY(50);
        armsButton.setTranslateX(267.5);
        armsButton.setTranslateY(50);
        absButton.setTranslateX(270);
        absButton.setTranslateY(50);
        legsButton.setTranslateX(267.5);
        legsButton.setTranslateY(50);
        cardioButton.setTranslateX(265);
        cardioButton.setTranslateY(50);



        // Create a scene and set the root node
        Scene scene = new Scene(root, 600, 400);

        // Set the stage's title and scene, and show the stage
        primaryStage.setTitle("Workouts");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}

class WorkoutStartGUI extends Application {

    public String type;
    public String image;

    public void start(Stage primaryStage) throws FileNotFoundException {

        VBox root = new VBox(20);
        ComboBox combobox = new ComboBox();
        combobox.setPromptText("Exercise 1");
        combobox.getItems().add("Choice 1");
        combobox.getItems().add("Choice 2");
        combobox.getItems().add("Choice 3");


        ComboBox combobox1 = new ComboBox();
        combobox1.setPromptText("Exercise 2");
        combobox1.getItems().add("Choice 1");
        combobox1.getItems().add("Choice 2");
        combobox1.getItems().add("Choice 3");


        ComboBox combobox2 = new ComboBox();
        combobox2.setPromptText("Exercise 3");
        combobox2.getItems().add("Choice 1");
        combobox2.getItems().add("Choice 2");
        combobox2.getItems().add("Choice 3");

        InputStream stream = new FileInputStream(this.image);
        Image image = new Image(stream);
        ImageView view = new ImageView();
        view.setImage(image);
        view.setX(400);
        view.setY(100);
        view.setFitWidth(150);
        view.setPreserveRatio(true);
        Group group = new Group();
        group.getChildren().add(view);
        group.getChildren().add(root);

        Button nextButton = new Button("Continue");

        Button backButton = new Button("Back");

        backButton.setOnAction(e -> {
            // Create a new window for the user profile GUI
            Stage workoutsStage = new Stage();
            WorkoutsGUI workoutsGUI = new WorkoutsGUI();
            workoutsGUI.start(workoutsStage);
            primaryStage.close();
        });

        nextButton.setOnAction(e -> {
            String choice = (String) combobox.getValue();
            String choice1 = (String) combobox1.getValue();
            String choice2 = (String) combobox2.getValue();
            if (choice.equals("Exercise 1") || choice1.equals("Exercise 2") || choice2.equals("Exercise 3")){
                //Do nothing
            }
            else {
                // Create a new window for the user profile GUI
                Stage difficultyStage = new Stage();
                DurDiff durDiffSet = new DurDiff();
                durDiffSet.start(difficultyStage);
                primaryStage.close();
            }
            //insert stage creation here to lead to the workouts page
        });

        root.getChildren().add(backButton);
        root.getChildren().addAll(combobox, combobox1, combobox2,nextButton);

        backButton.setTranslateX(0);
        backButton.setTranslateY(0);
        combobox.setTranslateX(260);
        combobox.setTranslateY(50);
        combobox1.setTranslateX(260);
        combobox1.setTranslateY(50);
        combobox2.setTranslateX(260);
        combobox2.setTranslateY(50);
        nextButton.setTranslateX(275);
        nextButton.setTranslateY(50);

        Scene scene = new Scene(group, 600, 400);
        //Scene scene1 = new Scene(group, 600, 400);

        primaryStage.setTitle(this.type);
        primaryStage.setScene(scene);
        //primaryStage.setScene(scene1);
        primaryStage.show();

    }
}

class DurDiff extends Application {

    public void start(Stage primaryStage) {

        VBox root = new VBox(20);
        ComboBox combobox = new ComboBox();
        combobox.setPromptText("Choose Difficulty/Duration");
        combobox.getItems().add("Easy - 5 Min");
        combobox.getItems().add("Medium - 10 Min");
        combobox.getItems().add("Hard - 15 Min");

        Button nextButton = new Button("Continue");
        Button backButton = new Button("Back");

        backButton.setOnAction(e -> {
            // Create a new window for the user profile GUI
            Stage workoutsStage = new Stage();
            WorkoutsGUI workoutsGUI = new WorkoutsGUI();
            workoutsGUI.start(workoutsStage);
            primaryStage.close();
        });

        root.getChildren().add(backButton);
        root.getChildren().addAll(combobox,nextButton);
        backButton.setTranslateX(0);
        backButton.setTranslateY(0);
        combobox.setTranslateX(215);
        combobox.setTranslateY(100);
        nextButton.setTranslateX(275);
        nextButton.setTranslateY(100);

        Scene scene = new Scene(root, 600, 400);

        primaryStage.setTitle("Duration/Difficulty");
        primaryStage.setScene(scene);
        primaryStage.show();

        nextButton.setOnAction(e -> {
            String choice = (String) combobox.getValue();
            if (choice.equals("Easy - 5 Min")) {
                // Do something for the easy option
                System.out.println("Easy");

                //  primaryStage.close();
            } else if (choice.equals("Medium - 10 Min")) {
                // Do something for the medium option
                System.out.println("Medium");


                // primaryStage.close();
            } else if (choice.equals("Hard - 15 Min")) {
                // Do something for the hard option
                System.out.println("Hard");


                //  primaryStage.close();
            } else {
                // Do Nothing

            }
        });
    }
}


// to get this to work, you need to have the javafx libraries included and make sure that you set up the VM options to use those libraries
