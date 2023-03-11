package eecs2311gui;

import java.io.FileNotFoundException;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;

import java.awt.*;
import java.awt.event.*;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.*;

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

//class UserProfileGUI extends Application {
//
//	@Override
//	public void start(Stage primaryStage) {
//		// Create the user profile GUI
//		VBox root = new VBox(20);
//		Button backButton = new Button("Back");
//
//		TextField field = new TextField("name");
//
//		backButton.setOnAction(e -> {
//			// Create a new window for the user profile GUI
//			Stage userProfileStage = new Stage();
//			MainGUI mainGUI = new MainGUI();
//			mainGUI.start(userProfileStage);
//			primaryStage.close();
//		});
//
//		root.setAlignment(Pos.CENTER);
//		root.getChildren().addAll(field, backButton);
//
//		// Create a scene and set the root node
//		Scene scene = new Scene(root, 600, 400);
//
//		// Set the stage's title and scene, and show the stage
//		primaryStage.setTitle("User Profile");
//		primaryStage.setScene(scene);
//		primaryStage.show();
//	}
//}


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
                System.out.println(user.toString());
                System.out.println(user.BMR);
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
			testGUI.image = "https://raw.githubusercontent.com/JordiNakahara/EECS-2311-Group-Project/main/Workout%20Icons/CHEST.png";
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
			testGUI.image = "https://raw.githubusercontent.com/JordiNakahara/EECS-2311-Group-Project/main/Workout%20Icons/ARMS%20.png";
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
			testGUI.image = "https://raw.githubusercontent.com/JordiNakahara/EECS-2311-Group-Project/main/Workout%20Icons/ABS.png";
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
			testGUI.image = "https://raw.githubusercontent.com/JordiNakahara/EECS-2311-Group-Project/main/Workout%20Icons/LEGS.png";
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
			testGUI.image = "https://raw.githubusercontent.com/JordiNakahara/EECS-2311-Group-Project/main/Workout%20Icons/CARDIO.png";
			try {
				testGUI.start(cardioStage);
			} catch (FileNotFoundException fileNotFoundException) {
				fileNotFoundException.printStackTrace();
			}
			primaryStage.close();
		});

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
		ComboBox combobox1 = new ComboBox();
		ComboBox combobox2 = new ComboBox();
		combobox.setPromptText("Exercise 1");
		combobox1.setPromptText("Exercise 2");
		combobox2.setPromptText("Exercise 3");

		if (this.type.equals("Arms")) {

			combobox.getItems().add("Tricep Dips");
			combobox.getItems().add("Inch Worms");
			combobox.getItems().add("Plank Push Up");
			combobox.getItems().add("Plank Walk");
			combobox.getItems().add("Extended Plank Hold");

			combobox1.getItems().add("Tricep Dips");
			combobox1.getItems().add("Inch Worms");
			combobox1.getItems().add("Plank Push Up");
			combobox1.getItems().add("Plank Walk");
			combobox1.getItems().add("Extended Plank Hold");

			combobox2.getItems().add("Tricep Dips");
			combobox2.getItems().add("Inch Worms");
			combobox2.getItems().add("Plank Push Up");
			combobox2.getItems().add("Plank Walk");
			combobox2.getItems().add("Extended Plank Hold");
		} else if (this.type.equals("Abs")) {

			combobox.getItems().add("Plank");
			combobox.getItems().add("Russian Twists");
			combobox.getItems().add("V Sitt");
			combobox.getItems().add("Bicycle Crunch");
			combobox.getItems().add("Squats");

			combobox1.getItems().add("Plank");
			combobox1.getItems().add("Russian Twists");
			combobox1.getItems().add("V Sitt");
			combobox1.getItems().add("Bicycle Crunch");
			combobox1.getItems().add("Squats");

			combobox2.getItems().add("Plank");
			combobox2.getItems().add("Russian Twists");
			combobox2.getItems().add("V Sitt");
			combobox2.getItems().add("Bicycle Crunch");
			combobox2.getItems().add("Squats");
		}

		else if (this.type.equals("Legs")) {
			combobox.getItems().add("Lunges");
			combobox.getItems().add("Flutter Kicks");
			combobox.getItems().add("Calf Raises");
			combobox.getItems().add("Run on the Spot");
			combobox.getItems().add("Squats");

			combobox1.getItems().add("Lunges");
			combobox1.getItems().add("Flutter Kicks");
			combobox1.getItems().add("Calf Raises");
			combobox1.getItems().add("Run on the Spot");
			combobox1.getItems().add("Squats");

			combobox2.getItems().add("Lunges");
			combobox2.getItems().add("Flutter Kicks");
			combobox2.getItems().add("Calf Raises");
			combobox2.getItems().add("Run on the Spot");
			combobox2.getItems().add("Squats");
		}

		else if (this.type.equals("Chest")) {
			combobox.getItems().add("Dive-Bomber Push-Up");
			combobox.getItems().add("Shoulder Taps");
			combobox.getItems().add("Wide Grip Pushup");
			combobox.getItems().add("Elevated Pushup");
			combobox.getItems().add("Pike Push-Up");

			combobox1.getItems().add("Dive-Bomber Push-Up");
			combobox1.getItems().add("Shoulder Taps");
			combobox1.getItems().add("Wide Grip Pushup");
			combobox1.getItems().add("Elevated Pushup");
			combobox1.getItems().add("Pike Push-Up");

			combobox2.getItems().add("Dive-Bomber Push-Up");
			combobox2.getItems().add("Shoulder Taps");
			combobox2.getItems().add("Wide Grip Pushup");
			combobox2.getItems().add("Elevated Pushup");
			combobox2.getItems().add("Pike Push-Up");
		}

		else if (this.type.equals("Cardio")) {
			combobox.getItems().add("Jumping Jacks");
			combobox.getItems().add("Mountain Climbers");
			combobox.getItems().add("High Knees");
			combobox.getItems().add("Reverse Kick Lunge");
			combobox.getItems().add("Burpees");

			combobox1.getItems().add("Jumping Jacks");
			combobox1.getItems().add("Mountain Climbers");
			combobox1.getItems().add("High Knees");
			combobox1.getItems().add("Reverse Kick Lunge");
			combobox1.getItems().add("Burpees");

			combobox2.getItems().add("Jumping Jacks");
			combobox2.getItems().add("Mountain Climbers");
			combobox2.getItems().add("High Knees");
			combobox2.getItems().add("Reverse Kick Lunge");
			combobox2.getItems().add("Burpees");
		}

		// InputStream stream = new FileInputStream(this.image);
		Image image = new Image(this.image);
		ImageView view = new ImageView(image);
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
			if (choice.equals("Exercise 1") || choice1.equals("Exercise 2") || choice2.equals("Exercise 3")) {
				// Do nothing
			} else {
				// Create a new window for the user profile GUI
				Stage difficultyStage = new Stage();
				DurDiff durDiffSet = new DurDiff();
				durDiffSet.type = this.type;
				durDiffSet.choice = choice;
				durDiffSet.choice1 = choice1;
				durDiffSet.choice2 = choice2;

				durDiffSet.start(difficultyStage);
				primaryStage.close();
			}
			// insert stage creation here to lead to the workouts page
		});

		root.getChildren().add(backButton);
		root.getChildren().addAll(combobox, combobox1, combobox2, nextButton);

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
		// Scene scene1 = new Scene(group, 600, 400);

		primaryStage.setTitle(this.type);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
}

class DurDiff extends Application {

	public String type;
	public String choice;
	public String choice1;
	public String choice2;

	public void start(Stage primaryStage) {

		VBox root = new VBox(20);
		ComboBox<String> combobox = new ComboBox<String>();
		combobox.setPromptText("Choose Difficulty/Duration");
		combobox.getItems().add("Easy - 3 Min");
		combobox.getItems().add("Medium - 6 Min");
		combobox.getItems().add("Hard - 9 Min");

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
		root.getChildren().addAll(combobox, nextButton);
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
			if (choice.equals("Easy - 3 Min")) {

				System.out.println("Easy");

				Stage stage = new Stage();
				workoutInProgress workoutsGUI = new workoutInProgress();
				workoutsGUI.choice = this.choice;
				workoutsGUI.choice1 = this.choice1;
				workoutsGUI.choice2 = this.choice2;
				workoutsGUI.start(stage);
				primaryStage.close();

				// primaryStage.close();
			} else if (choice.equals("Medium - 6 Min")) {
				// Do something for the medium option
				System.out.println("Medium");

				Stage stage = new Stage();
				workoutInProgress workoutsGUI = new workoutInProgress();
				workoutsGUI.choice = this.choice;
				workoutsGUI.choice1 = this.choice1;
				workoutsGUI.choice2 = this.choice2;
				workoutsGUI.start(stage);
				primaryStage.close();

				// primaryStage.close();
			} else if (choice.equals("Hard - 9 Min")) {
				// Do something for the hard option
				System.out.println("Hard");

				Stage stage = new Stage();
				workoutInProgress workoutsGUI = new workoutInProgress();
				workoutsGUI.choice = this.choice;
				workoutsGUI.choice1 = this.choice1;
				workoutsGUI.choice2 = this.choice2;
				workoutsGUI.start(stage);
				primaryStage.close();

				// primaryStage.close();
			} else {
				// Do Nothing
			}
		});
	}
}

class workoutInProgress extends Application {

	public String type;
	public String choice;
	public String choice1;
	public String choice2;
	String gif1;
	String gif2;
	String gif3;
	String Altgif1;
	String Altgif2;
	String Altgif3;
	public Timeline timeline;
    public int currentGifIndex = 0;
    public String[] gifs = new String[4];
    public String[] Altgifs = new String[4];

	public void start(Stage workoutInProgress) {
		VBox root = new VBox(20);
		HBox hbox = new HBox(20);

		Text Space = new Text();
		String text0 = "";
		Text WorkoutText = new Text();
		String text = "Workout";
		Text WorkoutText1 = new Text();
		String text1 = "Alternate Workout";

		Button quitButton = new Button("Quit");
		Button testButton = new Button("Test");

		quitButton.setOnAction(e -> {
			// Create a new window for the user profile GUI
			Stage workoutsStage = new Stage();
			WorkoutsGUI workoutsGUI = new WorkoutsGUI();
			workoutsGUI.start(workoutsStage);
			workoutInProgress.close();
		});

		testButton.setOnAction(e -> {
			// Create a new window for the user profile GUI
			System.out.println(this.choice);
			System.out.println(this.choice1);
			System.out.println(this.choice2);
		});

		root.getChildren().add(quitButton);

		root.getChildren().add(testButton);

		quitButton.setTranslateX(0);
		quitButton.setTranslateY(0);

		testButton.setTranslateX(15);
		testButton.setTranslateY(15);

		Space.setText(text0);
		Space.setTranslateX(100);
		Space.setTranslateY(0);

		WorkoutText.setText(text);
		WorkoutText.setTranslateX(150);
		WorkoutText.setTranslateY(0);

		WorkoutText1.setText(text1);
		WorkoutText1.setTranslateX(275);
		WorkoutText1.setTranslateY(0);

		if (choice.equals("Dive-Bomber Push-Up")) {
			gif1 = "https://raw.githubusercontent.com/JordiNakahara/EECS-2311-Group-Project/main/GIFS/Chest/DIVE-BOMBER%20PUSH-UP.gif";
			Altgif1 = "https://raw.githubusercontent.com/JordiNakahara/EECS-2311-Group-Project/main/GIFS/altgifs/testgif1.gif";
		} else if (choice.equals("Shoulder Taps")) {
			gif1 = "https://raw.githubusercontent.com/JordiNakahara/EECS-2311-Group-Project/main/GIFS/Chest/Shoulder%20taps.gif";
			Altgif1 = "https://raw.githubusercontent.com/JordiNakahara/EECS-2311-Group-Project/main/GIFS/altgifs/testgif1.gif";
		} else if (choice.equals("Wide Grip Pushup")) {
			gif1 = "https://raw.githubusercontent.com/JordiNakahara/EECS-2311-Group-Project/main/GIFS/Chest/wide%20grip%20pushup.gif";
			Altgif1 = "https://raw.githubusercontent.com/JordiNakahara/EECS-2311-Group-Project/main/GIFS/altgifs/testgif1.gif";
		} else if (choice.equals("Elevated Pushup")) {
			gif1 = "https://raw.githubusercontent.com/JordiNakahara/EECS-2311-Group-Project/main/GIFS/Chest/WIde%20grip%20pushup.gif";
			Altgif1 = "https://raw.githubusercontent.com/JordiNakahara/EECS-2311-Group-Project/main/GIFS/altgifs/testgif1.gif";
		} else if (choice.equals("Pike Push-Up")) {
			gif1 = "https://raw.githubusercontent.com/JordiNakahara/EECS-2311-Group-Project/main/GIFS/Chest/PIKE%20PUSH-UP.gif";
			Altgif1 = "https://raw.githubusercontent.com/JordiNakahara/EECS-2311-Group-Project/main/GIFS/altgifs/testgif1.gif";
		}   
		
		if (choice1.equals("Dive-Bomber Push-Up")) {
			gif2 = "https://raw.githubusercontent.com/JordiNakahara/EECS-2311-Group-Project/main/GIFS/Chest/DIVE-BOMBER%20PUSH-UP.gif";
			Altgif2 = "https://raw.githubusercontent.com/JordiNakahara/EECS-2311-Group-Project/main/GIFS/altgifs/testgif2.gif";
		} else if (choice1.equals("Shoulder Taps")) {
			gif2 = "https://raw.githubusercontent.com/JordiNakahara/EECS-2311-Group-Project/main/GIFS/Chest/Shoulder%20taps.gif";
			Altgif2 = "https://raw.githubusercontent.com/JordiNakahara/EECS-2311-Group-Project/main/GIFS/altgifs/testgif2.gif";
		} else if (choice1.equals("Wide Grip Pushup")) {
			gif2 = "https://raw.githubusercontent.com/JordiNakahara/EECS-2311-Group-Project/main/GIFS/Chest/wide%20grip%20pushup.gif";
			Altgif2 = "https://raw.githubusercontent.com/JordiNakahara/EECS-2311-Group-Project/main/GIFS/altgifs/testgif2.gif";
		} else if (choice1.equals("Elevated Pushup")) {
			gif2 = "https://raw.githubusercontent.com/JordiNakahara/EECS-2311-Group-Project/main/GIFS/Chest/WIde%20grip%20pushup.gif";
			Altgif2 = "https://raw.githubusercontent.com/JordiNakahara/EECS-2311-Group-Project/main/GIFS/altgifs/testgif2.gif";
		} else if (choice1.equals("Pike Push-Up")) {
			gif2 = "https://raw.githubusercontent.com/JordiNakahara/EECS-2311-Group-Project/main/GIFS/Chest/PIKE%20PUSH-UP.gif";
			Altgif2 = "https://raw.githubusercontent.com/JordiNakahara/EECS-2311-Group-Project/main/GIFS/altgifs/testgif2.gif";
		}		
		
		if (choice2.equals("Dive-Bomber Push-Up")) {
			gif3 = "https://raw.githubusercontent.com/JordiNakahara/EECS-2311-Group-Project/main/GIFS/Chest/DIVE-BOMBER%20PUSH-UP.gif";
			Altgif3 = "https://raw.githubusercontent.com/JordiNakahara/EECS-2311-Group-Project/main/GIFS/altgifs/testgif3.gif";
		} else if (choice2.equals("Shoulder Taps")) {
			gif3 = "https://raw.githubusercontent.com/JordiNakahara/EECS-2311-Group-Project/main/GIFS/Chest/Shoulder%20taps.gif";
			Altgif3 = "https://raw.githubusercontent.com/JordiNakahara/EECS-2311-Group-Project/main/GIFS/altgifs/testgif3.gif";
		} else if (choice2.equals("Wide Grip Pushup")) {
			gif3 = "https://raw.githubusercontent.com/JordiNakahara/EECS-2311-Group-Project/main/GIFS/Chest/wide%20grip%20pushup.gif";
			Altgif3 = "https://raw.githubusercontent.com/JordiNakahara/EECS-2311-Group-Project/main/GIFS/altgifs/testgif3.gif";
		} else if (choice2.equals("Elevated Pushup")) {
			gif3 = "https://raw.githubusercontent.com/JordiNakahara/EECS-2311-Group-Project/main/GIFS/Chest/WIde%20grip%20pushup.gif";
			Altgif3 = "https://raw.githubusercontent.com/JordiNakahara/EECS-2311-Group-Project/main/GIFS/altgifs/testgif3.gif";
		} else if (choice2.equals("Pike Push-Up")) {
			gif3 = "https://raw.githubusercontent.com/JordiNakahara/EECS-2311-Group-Project/main/GIFS/Chest/PIKE%20PUSH-UP.gif";
			Altgif3 = "https://raw.githubusercontent.com/JordiNakahara/EECS-2311-Group-Project/main/GIFS/altgifs/testgif3.gif";
		}
		
		this.gifs[0] = "https://raw.githubusercontent.com/JordiNakahara/EECS-2311-Group-Project/main/Workout%20Icons/blank.png";
		this.Altgifs[0] = "https://raw.githubusercontent.com/JordiNakahara/EECS-2311-Group-Project/main/Workout%20Icons/blank.png";
		this.gifs[1] = this.gif1;
		this.Altgifs[1] = this.Altgif1;
		this.gifs[2] = this.gif2;
		this.Altgifs[2] = this.Altgif2;
		this.gifs[3] = this.gif3;
		this.Altgifs[3] = this.Altgif3;
		
		Image image = new Image(gifs[currentGifIndex]);
		ImageView imageView = new ImageView(image);
		Image Aimage = new Image(Altgifs[currentGifIndex]);
		ImageView AimageView = new ImageView(Aimage);

        root.getChildren().add(imageView);
        root.getChildren().add(AimageView);
        
        timeline = new Timeline(new KeyFrame(Duration.seconds(3), event -> {
            // Cycle to the next GIF
            currentGifIndex = (currentGifIndex + 1) % gifs.length;
            Image newImage = new Image(gifs[currentGifIndex]);
            imageView.setImage(newImage);
            Image AnewImage = new Image(Altgifs[currentGifIndex]);
            AimageView.setImage(AnewImage);
            imageView.setTranslateX(150);
    		imageView.setTranslateY(75);
    		imageView.setFitWidth(150);
    		imageView.setPreserveRatio(true);
    		AimageView.setTranslateX(350);
    		AimageView.setTranslateY(75);
    		AimageView.setFitWidth(150);
    		AimageView.setFitHeight(100);
    		AimageView.setPreserveRatio(true);
            
        }));
        int numGifs = gifs.length;
        timeline.setCycleCount(numGifs);
        timeline.play();
		
		hbox.getChildren().addAll(Space, WorkoutText, WorkoutText1);
		Group group = new Group();
		
		Scene scene = new Scene(group, 600, 400);
		workoutInProgress.setTitle("Workout In Progress");
		workoutInProgress.setScene(scene);
		workoutInProgress.show();
		
		group.getChildren().add(root);
		group.getChildren().add(hbox);
		group.getChildren().add(imageView);
		group.getChildren().add(AimageView);
	}
}
