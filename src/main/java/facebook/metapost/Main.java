package facebook.metapost;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Alert;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Main application class for launching the Facebook post reaction app.
 */
public class Main extends Application {

    // Create a logger for this class
    private static final Logger LOGGER = Logger.getLogger(Main.class.getName());

    @Override
    public void start(Stage stage) {
        try {
            // Load the FXML file for the user interface
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("post.fxml"));
            Scene scene = new Scene(fxmlLoader.load());

            // Set up the primary stage
            stage.setTitle("Facebook");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            // Log the exception
            LOGGER.log(Level.SEVERE, "Failed to load FXML file", e);
            // Show an error alert to the user
            showErrorAlert();
        }
    }

    public static void main(String[] args) {
        // Launch the JavaFX application
        launch();
    }

    /**
     * Show an error alert to the user in case of an IOException.
     */
    private void showErrorAlert() {
        // Use JavaFX dialogs to show the error to the user
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText("Failed to load application");
        alert.setContentText("An error occurred while loading the application. Please try again later.");
        alert.showAndWait();
    }
}
