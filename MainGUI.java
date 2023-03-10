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
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class MainGUI extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Create the buttons
        Button userProfileBtn = new Button("User Profile");
        Button workoutsBtn = new Button("Workouts"); 

        // Attach event handlers to the buttons
        userProfileBtn.setOnAction(e -> {
            // Create a new window for the user profile GUI
            Stage userProfileStage = new Stage();
            UserProfileGUI userProfileGUI = new UserProfileGUI();
            userProfileGUI.start(userProfileStage);
            primaryStage.close();
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

class UserProfileGUI extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Create the user profile GUI
        VBox root = new VBox(20);
        Button backButton = new Button("Back");

        TextField field = new TextField("name");

        backButton.setOnAction(e -> {
            // Create a new window for the user profile GUI
            Stage userProfileStage = new Stage();
            MainGUI mainGUI = new MainGUI();
            mainGUI.start(userProfileStage);
            primaryStage.close();
        });

        root.setAlignment(Pos.CENTER);
        root.getChildren().addAll(field, backButton);

        // Create a scene and set the root node
        Scene scene = new Scene(root, 600, 400);

        // Set the stage's title and scene, and show the stage
        primaryStage.setTitle("User Profile");
        primaryStage.setScene(scene);
        primaryStage.show();

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
        
        VBox root1 = new VBox(20);
    	ComboBox<String> comboboxArm = new ComboBox<String>();
    	comboboxArm.setPromptText("Arms exercise 1");
    	comboboxArm.getItems().add("Tricep Dips");
    	comboboxArm.getItems().add("Inch Worms");
    	comboboxArm.getItems().add("Plank Push Up");
    	comboboxArm.getItems().add("Plank Walk");
    	comboboxArm.getItems().add("Extended Plank Hold");
    	
    	VBox root11 = new VBox(20);
    	ComboBox<String> comboboxArm1 = new ComboBox<String>();
    	comboboxArm1.setPromptText("Arms exercise 2");
    	comboboxArm1.getItems().add("Tricep Dips");
    	comboboxArm1.getItems().add("Inch Worms");
    	comboboxArm1.getItems().add("Plank Push Up");
    	comboboxArm1.getItems().add("Plank Walk");
    	comboboxArm1.getItems().add("Extended Plank Hold");
    	
    	VBox root111 = new VBox(20);
    	ComboBox<String> comboboxArm2 = new ComboBox<String>();
    	comboboxArm2.setPromptText("Arms exercise 2");
    	comboboxArm2.getItems().add("Tricep Dips");
    	comboboxArm2.getItems().add("Inch Worms");
    	comboboxArm2.getItems().add("Plank Push Up");
    	comboboxArm2.getItems().add("Plank Walk");
    	comboboxArm2.getItems().add("Extended Plank Hold");
    	
    	VBox root2 = new VBox(20);
    	ComboBox<String> comboboxAbs = new ComboBox<String>();
    	comboboxAbs.setPromptText("Abs exercise 1");
    	comboboxAbs.getItems().add("Plank");
    	comboboxAbs.getItems().add("Russian Twists");
    	comboboxAbs.getItems().add("V Sitt");
    	comboboxAbs.getItems().add("Bicycle Crunch");
    	comboboxAbs.getItems().add("Squats");
    	
    	VBox root22 = new VBox(20);
    	ComboBox<String> comboboxAbs1 = new ComboBox<String>();
    	comboboxAbs1.setPromptText("Abs exercise 1");
    	comboboxAbs1.getItems().add("Plank");
    	comboboxAbs1.getItems().add("Russian Twists");
    	comboboxAbs1.getItems().add("V Sitt");
    	comboboxAbs1.getItems().add("Bicycle Crunch");
    	comboboxAbs1.getItems().add("Squats");
    	
    	VBox root222 = new VBox(20);
    	ComboBox<String> comboboxAbs2 = new ComboBox<String>();
    	comboboxAbs2.setPromptText("Abs exercise 1");
    	comboboxAbs2.getItems().add("Plank");
    	comboboxAbs2.getItems().add("Russian Twists");
    	comboboxAbs2.getItems().add("V Sitt");
    	comboboxAbs2.getItems().add("Bicycle Crunch");
    	comboboxAbs2.getItems().add("Squats");

    	VBox root3 = new VBox(20);
    	ComboBox<String> comboboxLegs = new ComboBox<String>();
    	comboboxLegs.setPromptText("Legs exercise 1");
    	comboboxLegs.getItems().add("Lunges");
    	comboboxLegs.getItems().add("Flutter Kicks");
    	comboboxLegs.getItems().add("Calf Raises");
    	comboboxLegs.getItems().add("Run on the Spot");
    	comboboxLegs.getItems().add("Squats");
    	
    	VBox root33 = new VBox(20);
    	ComboBox<String> comboboxLegs1 = new ComboBox<String>();
    	comboboxLegs1.setPromptText("Legs exercise 2");
    	comboboxLegs1.getItems().add("Lunges");
    	comboboxLegs1.getItems().add("Flutter Kicks");
    	comboboxLegs1.getItems().add("Calf Raises");
    	comboboxLegs1.getItems().add("Run on the Spot");
    	comboboxLegs1.getItems().add("Squats");
    	
    	VBox root333 = new VBox(20);
    	ComboBox<String> comboboxLegs2 = new ComboBox<String>();
    	comboboxLegs2.setPromptText("Legs exercise 3");
    	comboboxLegs2.getItems().add("Lunges");
    	comboboxLegs2.getItems().add("Flutter Kicks");
    	comboboxLegs2.getItems().add("Calf Raises");
    	comboboxLegs2.getItems().add("Run on the Spot");
    	comboboxLegs2.getItems().add("Squats");

    	VBox root4 = new VBox(20);
    	ComboBox<String> comboboxChest = new ComboBox<String>();
    	comboboxChest.setPromptText("Chest exercise 1");
    	comboboxChest.getItems().add("Dive-Bomber Push-Up");
    	comboboxChest.getItems().add("Shoulder Taps");
    	comboboxChest.getItems().add("Wide Grip Pushup");
    	comboboxChest.getItems().add("Elevated Pushup");
    	comboboxChest.getItems().add("Pike Push-Up");
    	
    	VBox root44 = new VBox(20);
    	ComboBox<String> comboboxChest1 = new ComboBox<String>();
    	comboboxChest1.setPromptText("Chest exercise 2");
    	comboboxChest1.getItems().add("Dive-Bomber Push-Up");
    	comboboxChest1.getItems().add("Shoulder Taps");
    	comboboxChest1.getItems().add("Wide Grip Pushup");
    	comboboxChest1.getItems().add("Elevated Pushup");
    	comboboxChest1.getItems().add("Pike Push-Up");
    	
    	VBox root444 = new VBox(20);
    	ComboBox<String> comboboxChest2 = new ComboBox<String>();
    	comboboxChest2.setPromptText("Chest exercise 3");
    	comboboxChest2.getItems().add("Dive-Bomber Push-Up");
    	comboboxChest2.getItems().add("Shoulder Taps");
    	comboboxChest2.getItems().add("Wide Grip Pushup");
    	comboboxChest2.getItems().add("Elevated Pushup");
    	comboboxChest2.getItems().add("Pike Push-Up");
    	
    	

    	VBox root5 = new VBox(20);
    	ComboBox<String> comboboxCardio = new ComboBox<String>();
    	comboboxCardio.setPromptText("Cardio exercise 1");
    	comboboxCardio.getItems().add("Jumping Jacks");
    	comboboxCardio.getItems().add("Mountain Climbers");
    	comboboxCardio.getItems().add("High Knees");
    	comboboxCardio.getItems().add("Reverse Kick Lunge");
    	comboboxCardio.getItems().add("Burpees");
    	
    	VBox root55 = new VBox(20);
    	ComboBox<String> comboboxCardio1 = new ComboBox<String>();
    	comboboxCardio1.setPromptText("Cardio exercise 1");
    	comboboxCardio1.getItems().add("Jumping Jacks");
    	comboboxCardio1.getItems().add("Mountain Climbers");
    	comboboxCardio1.getItems().add("High Knees");
    	comboboxCardio1.getItems().add("Reverse Kick Lunge");
    	comboboxCardio1.getItems().add("Burpees");

    	VBox root555 = new VBox(20);
    	ComboBox<String> comboboxCardio2 = new ComboBox<String>();
    	comboboxCardio2.setPromptText("Cardio exercise 1");
    	comboboxCardio2.getItems().add("Jumping Jacks");
    	comboboxCardio2.getItems().add("Mountain Climbers");
    	comboboxCardio2.getItems().add("High Knees");
    	comboboxCardio2.getItems().add("Reverse Kick Lunge");
    	comboboxCardio2.getItems().add("Burpees");

        
    	comboboxArm.setVisible(false);
    	comboboxArm1.setVisible(false);
    	comboboxArm2.setVisible(false);

        comboboxAbs.setVisible(false);
        comboboxAbs1.setVisible(false);
        comboboxAbs2.setVisible(false);

        comboboxLegs.setVisible(false);
        comboboxLegs1.setVisible(false);
        comboboxLegs2.setVisible(false);

        comboboxChest.setVisible(false);
        comboboxChest1.setVisible(false);
        comboboxChest2.setVisible(false);
      
        comboboxCardio.setVisible(false);
        comboboxCardio1.setVisible(false);
        comboboxCardio2.setVisible(false);


      
       


        chestButton.setOnAction(e -> {
            // Create a new window for the user profile GUI
            Stage chestStage = new Stage();
            WorkoutStartGUI testGUI = new WorkoutStartGUI();
            testGUI.type = "Chest";
            testGUI.image = "https://raw.githubusercontent.com/JordiNakahara/EECS-2311-Group-Project/main/Workout%20Icons/CHEST.png";
        	comboboxChest.setVisible(true);
        	comboboxChest1.setVisible(true);
        	comboboxChest2.setVisible(true);
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
        	comboboxArm.setVisible(true);
        	comboboxArm1.setVisible(true);
        	comboboxArm2.setVisible(true);
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
        	comboboxAbs.setVisible(true);
        	comboboxAbs1.setVisible(true);
        	comboboxAbs2.setVisible(true);
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
        	comboboxLegs.setVisible(true);
        	comboboxLegs1.setVisible(true);
        	comboboxLegs2.setVisible(true);
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
        	comboboxCardio.setVisible(true);
        	comboboxCardio1.setVisible(true);
        	comboboxCardio2.setVisible(true);
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

        root1.getChildren().add(backButton);
        root1.getChildren().addAll(chestButton, armsButton, absButton, legsButton, cardioButton);
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
        Scene scene = new Scene(root1, 600, 400);

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
    	
//        VBox root = new VBox(20);
//        ComboBox<String> combobox = new ComboBox<String>();
//        combobox.setPromptText("Exercise 1");
//        combobox.getItems().add("Choice 1");
//        combobox.getItems().add("Choice 2");
//        combobox.getItems().add("Choice 3");
//
//
//        ComboBox<String> comboboxAbs = new ComboBox<String>();
//        comboboxAbs.setPromptText("Exercise 2");
//        comboboxAbs.getItems().add("Choice 1");
//        comboboxAbs.getItems().add("Choice 2");
//        comboboxAbs.getItems().add("Choice 3");
//
//
//        ComboBox<String> comboboxLegs = new ComboBox<String>();
//        comboboxLegs.setPromptText("Exercise 3");
//        comboboxLegs.getItems().add("Choice 1");
//        comboboxLegs.getItems().add("Choice 2");
//        comboboxLegs.getItems().add("Choice 3");
    	
    	VBox root1 = new VBox(20);
    	ComboBox<String> comboboxArm = new ComboBox<String>();
    	comboboxArm.setPromptText("Arms exercise 1");
    	comboboxArm.getItems().add("Tricep Dips");
    	comboboxArm.getItems().add("Inch Worms");
    	comboboxArm.getItems().add("Plank Push Up");
    	comboboxArm.getItems().add("Plank Walk");
    	comboboxArm.getItems().add("Extended Plank Hold");
    	
    	VBox root11 = new VBox(20);
    	ComboBox<String> comboboxArm1 = new ComboBox<String>();
    	comboboxArm1.setPromptText("Arms exercise 2");
    	comboboxArm1.getItems().add("Tricep Dips");
    	comboboxArm1.getItems().add("Inch Worms");
    	comboboxArm1.getItems().add("Plank Push Up");
    	comboboxArm1.getItems().add("Plank Walk");
    	comboboxArm1.getItems().add("Extended Plank Hold");
    	
    	VBox root111 = new VBox(20);
    	ComboBox<String> comboboxArm2 = new ComboBox<String>();
    	comboboxArm2.setPromptText("Arms exercise 2");
    	comboboxArm2.getItems().add("Tricep Dips");
    	comboboxArm2.getItems().add("Inch Worms");
    	comboboxArm2.getItems().add("Plank Push Up");
    	comboboxArm2.getItems().add("Plank Walk");
    	comboboxArm2.getItems().add("Extended Plank Hold");
    	
    	VBox root2 = new VBox(20);
    	ComboBox<String> comboboxAbs = new ComboBox<String>();
    	comboboxAbs.setPromptText("Abs exercise 1");
    	comboboxAbs.getItems().add("Plank");
    	comboboxAbs.getItems().add("Russian Twists");
    	comboboxAbs.getItems().add("V Sitt");
    	comboboxAbs.getItems().add("Bicycle Crunch");
    	comboboxAbs.getItems().add("Squats");
    	
    	VBox root22 = new VBox(20);
    	ComboBox<String> comboboxAbs1 = new ComboBox<String>();
    	comboboxAbs1.setPromptText("Abs exercise 1");
    	comboboxAbs1.getItems().add("Plank");
    	comboboxAbs1.getItems().add("Russian Twists");
    	comboboxAbs1.getItems().add("V Sitt");
    	comboboxAbs1.getItems().add("Bicycle Crunch");
    	comboboxAbs1.getItems().add("Squats");
    	
    	VBox root222 = new VBox(20);
    	ComboBox<String> comboboxAbs2 = new ComboBox<String>();
    	comboboxAbs2.setPromptText("Abs exercise 1");
    	comboboxAbs2.getItems().add("Plank");
    	comboboxAbs2.getItems().add("Russian Twists");
    	comboboxAbs2.getItems().add("V Sitt");
    	comboboxAbs2.getItems().add("Bicycle Crunch");
    	comboboxAbs2.getItems().add("Squats");

    	VBox root3 = new VBox(20);
    	ComboBox<String> comboboxLegs = new ComboBox<String>();
    	comboboxLegs.setPromptText("Legs exercise 1");
    	comboboxLegs.getItems().add("Lunges");
    	comboboxLegs.getItems().add("Flutter Kicks");
    	comboboxLegs.getItems().add("Calf Raises");
    	comboboxLegs.getItems().add("Run on the Spot");
    	comboboxLegs.getItems().add("Squats");
    	
    	VBox root33 = new VBox(20);
    	ComboBox<String> comboboxLegs1 = new ComboBox<String>();
    	comboboxLegs1.setPromptText("Legs exercise 2");
    	comboboxLegs1.getItems().add("Lunges");
    	comboboxLegs1.getItems().add("Flutter Kicks");
    	comboboxLegs1.getItems().add("Calf Raises");
    	comboboxLegs1.getItems().add("Run on the Spot");
    	comboboxLegs1.getItems().add("Squats");
    	
    	VBox root333 = new VBox(20);
    	ComboBox<String> comboboxLegs2 = new ComboBox<String>();
    	comboboxLegs2.setPromptText("Legs exercise 3");
    	comboboxLegs2.getItems().add("Lunges");
    	comboboxLegs2.getItems().add("Flutter Kicks");
    	comboboxLegs2.getItems().add("Calf Raises");
    	comboboxLegs2.getItems().add("Run on the Spot");
    	comboboxLegs2.getItems().add("Squats");

    	VBox root4 = new VBox(20);
    	ComboBox<String> comboboxChest = new ComboBox<String>();
    	comboboxChest.setPromptText("Chest exercise 1");
    	comboboxChest.getItems().add("Dive-Bomber Push-Up");
    	comboboxChest.getItems().add("Shoulder Taps");
    	comboboxChest.getItems().add("Wide Grip Pushup");
    	comboboxChest.getItems().add("Elevated Pushup");
    	comboboxChest.getItems().add("Pike Push-Up");
    	
    	VBox root44 = new VBox(20);
    	ComboBox<String> comboboxChest1 = new ComboBox<String>();
    	comboboxChest1.setPromptText("Chest exercise 2");
    	comboboxChest1.getItems().add("Dive-Bomber Push-Up");
    	comboboxChest1.getItems().add("Shoulder Taps");
    	comboboxChest1.getItems().add("Wide Grip Pushup");
    	comboboxChest1.getItems().add("Elevated Pushup");
    	comboboxChest1.getItems().add("Pike Push-Up");
    	
    	VBox root444 = new VBox(20);
    	ComboBox<String> comboboxChest2 = new ComboBox<String>();
    	comboboxChest2.setPromptText("Chest exercise 3");
    	comboboxChest2.getItems().add("Dive-Bomber Push-Up");
    	comboboxChest2.getItems().add("Shoulder Taps");
    	comboboxChest2.getItems().add("Wide Grip Pushup");
    	comboboxChest2.getItems().add("Elevated Pushup");
    	comboboxChest2.getItems().add("Pike Push-Up");
    	

    	VBox root5 = new VBox(20);
    	ComboBox<String> comboboxCardio = new ComboBox<String>();
    	comboboxCardio.setPromptText("Cardio exercise 1");
    	comboboxCardio.getItems().add("Jumping Jacks");
    	comboboxCardio.getItems().add("Mountain Climbers");
    	comboboxCardio.getItems().add("High Knees");
    	comboboxCardio.getItems().add("Reverse Kick Lunge");
    	comboboxCardio.getItems().add("Burpees");
    	
    	VBox root55 = new VBox(20);
    	ComboBox<String> comboboxCardio1 = new ComboBox<String>();
    	comboboxCardio1.setPromptText("Cardio exercise 1");
    	comboboxCardio1.getItems().add("Jumping Jacks");
    	comboboxCardio1.getItems().add("Mountain Climbers");
    	comboboxCardio1.getItems().add("High Knees");
    	comboboxCardio1.getItems().add("Reverse Kick Lunge");
    	comboboxCardio1.getItems().add("Burpees");

    	VBox root555 = new VBox(20);
    	ComboBox<String> comboboxCardio2 = new ComboBox<String>();
    	comboboxCardio2.setPromptText("Cardio exercise 1");
    	comboboxCardio2.getItems().add("Jumping Jacks");
    	comboboxCardio2.getItems().add("Mountain Climbers");
    	comboboxCardio2.getItems().add("High Knees");
    	comboboxCardio2.getItems().add("Reverse Kick Lunge");
    	comboboxCardio2.getItems().add("Burpees");


        //InputStream stream = new FileInputStream(this.image);
        Image image = new Image(this.image);
        ImageView view = new ImageView(image);
        view.setImage(image);
        view.setX(400);
        view.setY(100);
        view.setFitWidth(150);
        view.setPreserveRatio(true);
        Group group = new Group();
        group.getChildren().add(view);
        group.getChildren().add(root1);

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
            String choice = (String) comboboxArm.getValue();
            String choice1 = (String) comboboxAbs.getValue();
            String choice2 = (String) comboboxLegs.getValue();
            String choice3 = (String) comboboxChest.getValue();
            String choice4 = (String) comboboxCardio.getValue();

            
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

        root1.getChildren().add(backButton);
        root1.getChildren().addAll(comboboxArm, comboboxAbs, comboboxLegs, comboboxChest, comboboxCardio,nextButton);

        backButton.setTranslateX(0);
        backButton.setTranslateY(0);
        comboboxArm.setTranslateX(260);
        comboboxArm.setTranslateY(50);
        comboboxAbs.setTranslateX(260);
        comboboxAbs.setTranslateY(50);
        comboboxLegs.setTranslateX(260);
        comboboxLegs.setTranslateY(50);
        comboboxChest.setTranslateX(260);
        comboboxChest.setTranslateY(50);
        comboboxCardio.setTranslateX(260);
        comboboxCardio.setTranslateY(50);
        nextButton.setTranslateX(275);
        nextButton.setTranslateY(50);

        Scene scene = new Scene(group, 600, 400);
        //Scene scene1 = new Scene(group, 600, 400);

        primaryStage.setTitle(this.type);
        primaryStage.setScene(scene);
        primaryStage.show();

    }
}

class workoutInProgress extends Application {

	public void start(Stage workoutInProgress) {
	      Stage primnaryStage = null;
		primnaryStage.setTitle("Workout In Progress");
	      StackPane Layout = new StackPane();
	      Layout.getChildren();
	      Scene scene = new Scene(Layout, 300, 200);
	      workoutInProgress.setScene(scene);
	      workoutInProgress.show();
		}
	
	}

class DurDiff extends Application {

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
            if (choice.equals("Easy - 3 Min")) {
       
                System.out.println("Easy");

                //  primaryStage.close();
            } else if (choice.equals("Medium - 6 Min")) {
                // Do something for the medium option
                System.out.println("Medium");


                // primaryStage.close();
            } else if (choice.equals("Hard - 9 Min")) {
                // Do something for the hard option
                System.out.println("Hard");


                //  primaryStage.close();
            } else {
                // Do Nothing

            }
        });
    }
}
