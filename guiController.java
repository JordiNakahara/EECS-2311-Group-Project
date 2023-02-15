import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class MainGUIController {

    @FXML
    private Button userProfileBtn;

    @FXML
    private Button workoutsBtn;

    @FXML
    void handleUserProfileBtn(ActionEvent event) {
        // Create a new window for the user profile GUI
        Stage userProfileStage = new Stage();
        UserProfileGUI userProfileGUI = new UserProfileGUI();
        userProfileGUI.start(userProfileStage);
    }

    @FXML
    void handleWorkoutsBtn(ActionEvent event) {
        // Create a new window for the workouts GUI
        Stage workoutsStage = new Stage();
        WorkoutsGUI workoutsGUI = new WorkoutsGUI();
        workoutsGUI.start(workoutsStage);
    }
}
