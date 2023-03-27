package timerapp.timerappstop;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;

public class TimerApp extends Application {
    private int secondsRemaining;
    private Timeline timeline;
    private Label timerLabel;

    @Override
    public void start(Stage primaryStage) {
        // Create the GUI components
        TextField timeInput = new TextField();
        timeInput.setPromptText("Enter time in seconds");
        timeInput.setFocusTraversable(false);
        Button startButton = new Button("Start");
        Button stopButton = new Button("Increase");
        stopButton.setDisable(true);
        timerLabel = new Label("00:00");
        timerLabel.setStyle("-fx-font-size: 92px");

        // Set up the event handlers for the buttons
        startButton.setOnAction(event -> {
            // Parse the user input and start the timer
try {
                secondsRemaining = Integer.parseInt(timeInput.getText()); // right here where we set the time
                //will need to carry a variable over which determines the time
                // depending on the difficulty chosen - this should be fairly straight forward
                startButton.setDisable(true);
                startTimer();
                stopButton.setDisable(false);
            }catch (NumberFormatException numberFormatException){
                System.out.println("Enter Number Of Seconds In Integer Value");
            }


        });
        stopButton.setOnAction(event -> {
            // Stop the timer
            breakIncrease();
            startButton.setDisable(true);
            stopButton.setDisable(false);
        });

        // Add the components to the layout
        HBox inputBox = new HBox(10, timeInput, startButton, stopButton);
        inputBox.setAlignment(Pos.CENTER);
        VBox layout = new VBox(40, inputBox, timerLabel);
        layout.setPadding(new Insets(40));
        layout.setAlignment(Pos.CENTER);

        // Create the scene and show the window
        Scene scene = new Scene(layout, 600, 400);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Timer App");
        primaryStage.show();
    }
private void startTimer() {
        timeline = new Timeline(new KeyFrame(Duration.seconds(1), event -> {
            // Decrement the remaining time and update the display
            secondsRemaining--;
            int minutes = secondsRemaining / 60;
            int seconds = secondsRemaining % 60;
            timerLabel.setText(String.format("%02d:%02d", minutes, seconds));

            // Stop the timer when the count-down reaches zero
            if (secondsRemaining == 0) {
                stopTimer();
            }
        }));
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
    }

    private void stopTimer() {
        timeline.stop();
    }
    
    /*
     * Ignore this for now as this will be used for the break timer that we will have in- between
     * */
    private void breakIncrease() {
    	secondsRemaining = secondsRemaining + 30;
    } 
    

    public static void main(String[] args) {
        launch(args);
    }
}
