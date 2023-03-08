import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
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
        HBox foot = new HBox();
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
            testGUI.start(chestStage);
            primaryStage.close();
        });

        armsButton.setOnAction(e -> {
            // Create a new window for the user profile GUI
            Stage armStage = new Stage();
            WorkoutStartGUI testGUI = new WorkoutStartGUI();
            testGUI.type = "Arms";
            testGUI.start(armStage);
            primaryStage.close();
        });

        absButton.setOnAction(e -> {
            // Create a new window for the user profile GUI
            Stage abStage = new Stage();
            WorkoutStartGUI testGUI = new WorkoutStartGUI();
            testGUI.type = "Abs";
            testGUI.start(abStage);
            primaryStage.close();
        });

        legsButton.setOnAction(e -> {
            // Create a new window for the user profile GUI
            Stage legStage = new Stage();
            WorkoutStartGUI testGUI = new WorkoutStartGUI();
            testGUI.type = "Legs";
            testGUI.start(legStage);
            primaryStage.close();
        });

        cardioButton.setOnAction(e -> {
            // Create a new window for the user profile GUI
            Stage cardioStage = new Stage();
            WorkoutStartGUI testGUI = new WorkoutStartGUI();
            testGUI.type = "Cardio";
            testGUI.start(cardioStage);
            primaryStage.close();
        });

        /*comboButton.setOnAction(e -> {
            // Create a new window for the user profile GUI
            Stage welcomeStage = new Stage();
            MainGUI mainGUI = new MainGUI();
            mainGUI.start(welcomeStage);
            primaryStage.close();
        }); */



        root.setAlignment(Pos.CENTER);
        root.getChildren().addAll(chestButton, armsButton, absButton, legsButton, cardioButton);
        //foot.setAlignment(Pos.TOP_LEFT);
        root.getChildren().add(backButton);

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

    public void start(Stage primaryStage) {

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
            // Create a new window for the user profile GUI
            Stage difficultyStage = new Stage();
            DurDiff durDiffSet = new DurDiff();
            durDiffSet.start(difficultyStage);

            //insert stage creation here to lead to the workouts page


            primaryStage.close();
        });


        root.getChildren().addAll(combobox, combobox1, combobox2,nextButton, backButton);
        root.setAlignment(Pos.CENTER);

        Scene scene = new Scene(root, 600, 400);

        primaryStage.setTitle(this.type);
        primaryStage.setScene(scene);
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

            root.getChildren().addAll(combobox,nextButton,backButton);
            root.setAlignment(Pos.CENTER);

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
