package eecs2311gui;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class MainGUI extends Application {

   
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
	Button backButton = new Button("Back");

	backButton.setOnAction(e -> {
	    // Create a new window for the user profile GUI
	    Stage userProfileStage = new Stage();
	    MainGUI mainGUI = new MainGUI();
	    mainGUI.start(userProfileStage);
	    primaryStage.close();
	});

	root.setAlignment(Pos.TOP_LEFT);
	root.getChildren().addAll(backButton);

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
	// Making the workouts GUI primnary page
	BorderPane root = new BorderPane();
	root.setPadding(new Insets(20));
	
	// making the top HBox for the title and buttons
	HBox topBox = new HBox(10);
	topBox.setAlignment(Pos.CENTER);
	topBox.setPadding(new Insets(10));
	
	// Creating the title label
	Label titleLabel = new Label("Workouts");
	titleLabel.setFont(Font.font("Arial", 24));
	
	// making the buttons for add, edit and delete workout.
	Button addBtn = new Button("Add Workout");
	Button editBtn = new Button("Edit Workout");
	Button deleteBtn = new Button("Delete Workout");
	
	// Add the buttons to the top HBox
	topBox.getChildren().addAll(titleLabel, addBtn, editBtn, deleteBtn);
	
	// Create the center VBox for the list of workouts
	VBox centerBox = new VBox(10);
	centerBox.setAlignment(Pos.CENTER);
	centerBox.setPadding(new Insets(10));
	
	// Still need to add list of workouts to the center VBox
	
	// Connecting the top HBox and center VBox to the root BorderPane
	root.setTop(topBox);
	root.setCenter(centerBox);
	
	// Making a scene and set the root node
	Scene scene = new Scene(root, 600, 600);
	
	// Setting the stage's title and scene, and showing the stage
	primaryStage.setTitle("Workouts");
	primaryStage.setScene(scene);
	primaryStage.show();
    }
}
// Work in progress, using JavaFx to attempt to make GUI
// Works using IntelliJ Idea, ensure the "Modules Info is updated"
