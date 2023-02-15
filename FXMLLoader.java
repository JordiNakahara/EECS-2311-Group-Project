import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainGUI extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("MainGUI.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root, 300, 200);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Main GUI");
        primaryStage.show();

        MainGUIController controller = loader.getController();
        controller.setUserProfileBtn(userProfileBtn);
        controller.setWorkoutsBtn(workoutsBtn);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
