package eecs2311gui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class DurDiff extends Application {

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
            String difficulty = choice.split(" ")[0].toLowerCase(); // Extract difficulty from choice string
            if (choice.equals("Easy - 3 Min")) {
                System.out.println("Easy");
                launchWorkoutInProgress(60, primaryStage); //  time in seconds for easy difficulty
            } else if (choice.equals("Medium - 6 Min")) {
                System.out.println("Medium");
                launchWorkoutInProgress(120, primaryStage); //  time in seconds for medium difficulty
            } else if (choice.equals("Hard - 9 Min")) {
                System.out.println("Hard");
                launchWorkoutInProgress(180, primaryStage); //  time in seconds for hard difficulty
            } else {
                // Do Nothing
            }
        });
    }
    
    private void launchWorkoutInProgress(int switchTime, Stage previousStage) {
        Stage stage = new Stage();
        workoutInProgress workoutsGUI = new workoutInProgress(switchTime);
        workoutsGUI.choice = this.choice;
        workoutsGUI.choice1 = this.choice1;
        workoutsGUI.choice2 = this.choice2;
        workoutsGUI.start(stage);
        previousStage.close();
    }

}
