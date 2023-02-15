import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
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
        });

        workoutsBtn.setOnAction(e -> {
            // Create a new window for the workouts GUI
            Stage workoutsStage = new Stage();
            WorkoutsGUI workoutsGUI = new WorkoutsGUI();
            workoutsGUI.start(workoutsStage);
        });

        // Create a vertical box and add the buttons to it
        VBox root = new VBox(20);
        root.setAlignment(Pos.CENTER);
        root.getChildren().addAll(userProfileBtn, workoutsBtn);

        // Create a scene and set the root node
        Scene scene = new Scene(root, 300, 200);

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
        VBox root = new VBox();

        // Create a scene and set the root node
        Scene scene = new Scene(root, 300, 200);

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
        VBox root = new VBox();

        // Create a scene and set the root node
        Scene scene = new Scene(root, 300, 200);

        // Set the stage's title and scene, and show the stage
        primaryStage.setTitle("Workouts");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
