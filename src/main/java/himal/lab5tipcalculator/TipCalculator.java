package himal.lab5tipcalculator;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Himal Shrestha
 * CSC 325 - SOftware Engineering
 * LAB5 TIP CALCULATOR
 */
public class TipCalculator extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        Parent root =
                FXMLLoader.load(getClass().getResource("TipCalculator.fxml"));

        Scene scene = new Scene(root); // attach scene graph to scene
        stage.setTitle("Himal's Tip Calculator"); // displayed in window's title bar
        stage.setScene(scene); // attach scene to stage
        stage.show(); // display the stage
    }

    public static void main(String[] args) {
        // create a TipCalculator object and call its start method
        launch(args);
    }
}
